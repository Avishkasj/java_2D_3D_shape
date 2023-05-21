import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RoundRectangleView2D extends JFrame {
    private JPanel panel6;
    private JButton downloadButton;
    private JButton editButton;
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

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D graphics2D = image.createGraphics();
                    paint(graphics2D);
                    graphics2D.dispose();

                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showSaveDialog(RoundRectangleView2D.this);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        ImageIO.write(image, "png", selectedFile);
                        JOptionPane.showMessageDialog(RoundRectangleView2D.this, "Image saved successfully!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(RoundRectangleView2D.this, "Error saving image!");
                }
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame9= new RRectangle2D("2D Round Rectangle");
                frame9.setVisible(true);
                frame9.setSize(1000, 600);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        int x = (getWidth() - width) / 2; // Calculate the x-coordinate to center the shape
        int y = (getHeight() - height) / 2; // Calculate the y-coordinate to center the shape
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public static void main(String[] args) {
        RoundRectangleView2D roundRectView = new RoundRectangleView2D(200, 150, 20, 20, Color.GREEN);
        roundRectView.setVisible(true);
    }
}
