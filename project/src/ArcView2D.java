import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArcView2D extends JFrame {
    private JPanel panel7;
    private JButton downloadButton;
    private JButton editButton;
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

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D graphics2D = image.createGraphics();
                    paint(graphics2D);
                    graphics2D.dispose();

                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showSaveDialog(ArcView2D.this);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        ImageIO.write(image, "png", selectedFile);
                        JOptionPane.showMessageDialog(ArcView2D.this, "Image saved successfully!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ArcView2D.this, "Error saving image!");
                }
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame8= new Arc2D("2D Arc");
                frame8.setVisible(true);
                frame8.setSize(1000, 600);
            }
        });
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
