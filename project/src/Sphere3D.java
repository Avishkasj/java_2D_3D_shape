import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sphere3D extends JFrame {
    private int size;
    private Color color;
    private boolean hasShadow;
    private Color shadowColor;
    private JButton downloadButton;
    private JFileChooser fileChooser;

    public Sphere3D(int size, Color color, boolean hasShadow, Color shadowColor) {
        this.size = size;
        this.color = color;
        this.hasShadow = hasShadow;
        this.shadowColor = shadowColor;

        setTitle("3D Sphere Generator");
        setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new CustomPanel();
        add(panel);

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

    public static void main(String[] args) {
        Sphere3D sphere = new Sphere3D(20, Color.RED, true, Color.GRAY);
        sphere.setVisible(true);
    }
}
