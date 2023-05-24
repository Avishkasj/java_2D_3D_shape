import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.stb.STBImage;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Cube3D {
    private long window;
    private int width = 500;
    private int height = 500;
    private int cubeSize;
    private int vao;
    private int vbo;
    private int vertexCount;
    private int shaderProgram;

    public Cube3D(int size, Color color, boolean hasShadow, Color shadowColor) {
        this.cubeSize = size;
    }

    public void run() {
        init();
        loop();

        glfwDestroyWindow(window);
        glfwTerminate();
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(width, height, "3D Cube Generator", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        glfwSetFramebufferSizeCallback(window, (window, width, height) -> {
            this.width = width;
            this.height = height;
            glViewport(0, 0, width, height);
        });

        try {
            createCube();
            createShaders();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        glfwShowWindow(window);
    }

    private void loop() {
        glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glUseProgram(shaderProgram);

            glBindVertexArray(vao);
            glDrawArrays(GL_TRIANGLES, 0, vertexCount);

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    private void createCube() {
        float[] vertices = {
                // Front face
                -cubeSize / 2.0f, -cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, -cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                -cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                -cubeSize / 2.0f, -cubeSize / 2.0f, cubeSize / 2.0f,
                // Top face
                -cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, -cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, -cubeSize / 2.0f,
                -cubeSize / 2.0f, cubeSize / 2.0f, -cubeSize / 2.0f,
                -cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                // Right face
                cubeSize / 2.0f, -cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, -cubeSize / 2.0f, -cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, -cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, -cubeSize / 2.0f,
                cubeSize / 2.0f, cubeSize / 2.0f, cubeSize / 2.0f,
                cubeSize / 2.0f, -cubeSize / 2.0f, cubeSize / 2.0f
        };

        try (MemoryStack stack = stackPush()) {
            IntBuffer vaoBuffer = stack.mallocInt(1);
            IntBuffer vboBuffer = stack.mallocInt(1);

            glGenVertexArrays(vaoBuffer);
            glGenBuffers(vboBuffer);

            vao = vaoBuffer.get(0);
            vbo = vboBuffer.get(0);

            glBindVertexArray(vao);

            glBindBuffer(GL_ARRAY_BUFFER, vbo);
            glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
            glEnableVertexAttribArray(0);

            glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindVertexArray(0);

            vertexCount = vertices.length / 3;
        }
    }

    private void createShaders() throws Exception {
        int vertexShader = compileShader("vertex.glsl", GL_VERTEX_SHADER);
        int fragmentShader = compileShader("fragment.glsl", GL_FRAGMENT_SHADER);

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);
        glLinkProgram(shaderProgram);

        int success = glGetProgrami(shaderProgram, GL_LINK_STATUS);
        if (success != GL_TRUE) {
            throw new RuntimeException("Failed to link shader program: " + glGetProgramInfoLog(shaderProgram));
        }

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);
    }

    private int compileShader(String resourcePath, int shaderType) throws Exception {
        String shaderSource = readResource(resourcePath);
        int shader = glCreateShader(shaderType);

        glShaderSource(shader, shaderSource);
        glCompileShader(shader);

        int success = glGetShaderi(shader, GL_COMPILE_STATUS);
        if (success != GL_TRUE) {
            throw new RuntimeException("Failed to compile shader: " + glGetShaderInfoLog(shader));
        }

        return shader;
    }

    private String readResource(String resourcePath) throws Exception {
        ByteBuffer buffer;
        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            STBImage.stbi_set_flip_vertically_on_load(true);
            buffer = STBImage.stbi_load(resourcePath, w, h, comp, 4);
        }

        if (buffer == null) {
            throw new IOException("Failed to load resource: " + resourcePath);
        }

        String shaderSource = memUTF8(buffer);
        STBImage.stbi_image_free(buffer);

        return shaderSource;
    }

    public static void main(String[] args) {
        Cube3D cube = new Cube3D(20, color, hasShadow, shadowColor);
        cube.run();
    }
}
