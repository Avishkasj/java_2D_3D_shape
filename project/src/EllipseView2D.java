import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EllipseView2D extends JFrame {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private JButton editButton;
    private JButton downloadButton;

    public EllipseView2D(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
//
            }
        });

        downloadButton = new JButton("Download");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    downloadAsImage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(downloadButton);
        this.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        // Calculate the center coordinates
        int centerX = (getWidth() - width) / 2;
        int centerY = (getHeight() - height) / 2;

        // Draw the ellipse
        g2d.fillOval(centerX, centerY, width, height);
    }

    private void downloadAsImage() throws IOException {
        int width = this.getWidth();
        int height = this.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        this.paint(g2d);
        g2d.dispose();

        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageIO.write(image, "png", file);
        }
    }
}
