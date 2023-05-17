import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class LineView2D extends JFrame {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Color color;

    public LineView2D(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
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
        g2d.setStroke(new BasicStroke(5)); // Set the line thickness

        // Create a Line2D.Double object representing the line
        Line2D.Double line = new Line2D.Double(startX, startY, endX, endY);

        // Draw the line
        g2d.draw(line);
    }
}
