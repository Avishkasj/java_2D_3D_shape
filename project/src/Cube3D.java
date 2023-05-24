import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cube3D extends JFrame {
    private int size;
    private Color color;
    private boolean hasShadow;
    private Color shadowColor;
    private JButton downloadButton;
    private JFileChooser fileChooser;

    public Cube3D(int size, Color color, boolean hasShadow, Color shadowColor) {
        this.size = size;
        this.color = color;
        this.hasShadow = hasShadow;
        this.shadowColor = shadowColor;

        setTitle("3D Cube Generator");
        setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setupDownloadButton();
    }

    private void setupDownloadButton() {
        downloadButton = new JButton("Download");
        downloadButton.addActionListener(e -> saveAsImage());
        add(downloadButton, BorderLayout.SOUTH);
    }

    private void saveAsImage() {
        fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                paint(g2d);
                ImageIO.write(image, "png", file);
                g2d.dispose();
                JOptionPane.showMessageDialog(this, "Image saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage());
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int cubeSize = size * 20; // Adjust the scaling factor as needed

        int topLeftX = centerX - cubeSize / 2;
        int topLeftY = centerY - cubeSize / 2;

        // Draw the shadow
        if (hasShadow) {
            int shadowOffset = size * 10; // Adjust the shadow offset as needed

            g2d.setColor(shadowColor);
            g2d.fillRect(topLeftX + shadowOffset, topLeftY + shadowOffset, cubeSize, cubeSize);
        }

        // Draw the front face
        g2d.setColor(color);
        g2d.fillRect(topLeftX, topLeftY, cubeSize, cubeSize);

        // Draw the top face
        g2d.setColor(color.brighter());
        g2d.fillPolygon(new int[]{topLeftX, topLeftX + cubeSize, topLeftX + cubeSize, topLeftX},
                new int[]{topLeftY, topLeftY, topLeftY - cubeSize / 2, topLeftY - cubeSize / 2}, 4);

        // Draw the right face
        g2d.setColor(color.darker());
        g2d.fillPolygon(new int[]{topLeftX + cubeSize, topLeftX + cubeSize, topLeftX + cubeSize, topLeftX + cubeSize},
                new int[]{topLeftY, topLeftY - cubeSize / 2, topLeftY - cubeSize / 2 + cubeSize, topLeftY + cubeSize}, 4);

        g2d.dispose();
    }

    public static void main(String[] args) {
        Cube3D cube = new Cube3D(20, Color.BLUE, true, Color.GRAY);
        cube.setVisible(true);
    }
}
