import javax.swing.*;
import java.awt.*;

public class CircleView2D extends JFrame {
    private JPanel panel6;
    private int diameter;
    private Color color;

    public CircleView2D(int diameter, Color color) {
        this.diameter = diameter;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel6);
        this.pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        int x = (getWidth() - diameter) / 2; // Center the circle horizontally
        int y = (getHeight() - diameter) / 2; // Center the circle vertically
        g.fillOval(x, y, diameter, diameter);
    }
}
