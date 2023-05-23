import javax.swing.*;
import java.awt.*;

public class Sphere3D extends JFrame {
    private int size;
    private Color color;
    private boolean hasShadow;
    private Color shadowColor;

    public Sphere3D(int size, Color color, boolean hasShadow, Color shadowColor) {
        this.size = size;
        this.color = color;
        this.hasShadow = hasShadow;
        this.shadowColor = shadowColor;

        setTitle("3D Sphere Generator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new CustomPanel();
        add(panel);
    }

    private class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            int sphereRadius = size * 10; // Adjust the scaling factor as needed

            int topLeftX = centerX - sphereRadius;
            int topLeftY = centerY - sphereRadius;

            // Draw the shadow
            if (hasShadow) {
                int shadowOffset = size * 8; // Adjust the shadow offset as needed
                int shadowRadius = sphereRadius / 2;
                int shadowTopLeftX = topLeftX + shadowOffset;
                int shadowTopLeftY = topLeftY + shadowOffset;

                g2d.setColor(shadowColor);
                g2d.fillOval(shadowTopLeftX, shadowTopLeftY, 2 * shadowRadius, 2 * shadowRadius);
            }

            // Draw the sphere
            g2d.setColor(color);
            g2d.fillOval(topLeftX, topLeftY, 2 * sphereRadius, 2 * sphereRadius);

            g2d.dispose();
        }
    }
}

