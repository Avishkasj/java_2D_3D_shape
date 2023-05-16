import javax.swing.*;
import java.awt.*;

public class RectangleView2D extends JFrame {
    private JPanel panel6;
    private int width;
    private int height;
    private Color color;

    public RectangleView2D(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel6);
        this.pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.fillRect(50, 50, width, height); // Adjust the position and size as needed
    }
}
