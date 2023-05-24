import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LineView2D extends JFrame {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Color color;
    private JButton editButton;
    private JButton downloadButton;

    public LineView2D(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JFrame frame6 = new Line2D("2D Line");
//                frame6.setVisible(true);
//                frame6.setSize(1000, 600);
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
        g2d.setStroke(new BasicStroke(5)); // Set the line thickness

        Line2D.Double line = new Line2D.Double(startX, startY, endX, endY);
        g2d.draw(line);
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
