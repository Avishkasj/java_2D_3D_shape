import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CircleView2D extends JFrame {
    private JPanel panel6;
    private JButton editButton;
    private JButton downloadButton;
    private int diameter;
    private Color color;

    public CircleView2D(int diameter, Color color) {
        this.diameter = diameter;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panel6);
        this.setLayout(new BorderLayout());

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame5 = new Circle2D("2D Circle");
                frame5.setVisible(true);
                frame5.setSize(1000, 600);
            }
        });

        downloadButton = new JButton("Download");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveShapeToFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(downloadButton);
        this.add(buttonPanel, BorderLayout.NORTH);
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

    private void saveShapeToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            String extension = getFileExtension(filePath);

            if (extension.equalsIgnoreCase("png")) {
                saveAsImage(fileToSave);
            } else {
                JOptionPane.showMessageDialog(this, "Unsupported file format!");
            }
        }
    }

    private void saveAsImage(File file) {
        try {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            paint(g2d);
            g2d.dispose();
            ImageIO.write(image, "png", file);
            JOptionPane.showMessageDialog(this, "Shape saved as image successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving the shape as image: " + e.getMessage());
        }
    }


    private String getFileExtension(String filePath) {
        int dotIndex = filePath.lastIndexOf(".");
        if (dotIndex != -1 && dotIndex < filePath.length() - 1) {
            return filePath.substring(dotIndex + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CircleView2D circleView = new CircleView2D(200, Color.RED);
                circleView.setVisible(true);
            }
        });
    }
}
