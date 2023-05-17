import javax.swing.*;
import java.awt.*;

public class EllipseView2D extends JFrame {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public EllipseView2D(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        // Draw the ellipse
        g2d.fillOval(x, y, width, height);
    }
}
