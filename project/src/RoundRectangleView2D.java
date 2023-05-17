import javax.swing.*;
import java.awt.*;

public class RoundRectangleView2D extends JFrame {
    private JPanel panel6;
    private int width;
    private int height;
    private int arcWidth;
    private int arcHeight;
    private Color color;

    public RoundRectangleView2D(int width, int height, int arcWidth, int arcHeight, Color color) {
        this.width = width;
        this.height = height;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel6);
        this.pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.fillRoundRect(50, 50, width, height, arcWidth, arcHeight); // Adjust the position and size as needed
    }
}
