import javax.swing.*;
import java.awt.*;

public class ArcView2D extends JFrame {
    private JPanel panel7;
    private int startAngle;
    private int arcAngle;
    private int diameter;
    private Color color;

    public ArcView2D(int startAngle, int arcAngle, int diameter, Color color) {
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
        this.diameter = diameter;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel7);
        this.pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        int x = (getWidth() - diameter) / 2; // Center the arc horizontally
        int y = (getHeight() - diameter) / 2; // Center the arc vertically
        g.fillArc(x, y, diameter, diameter, startAngle, arcAngle); // Draw the specified arc
    }

}
