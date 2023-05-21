import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RectangleView2D extends JFrame {
    private JPanel panel6;
    private JButton editButton;
    private JButton saveButton;
    private int width;
    private int height;
    private Color color;

    public RectangleView2D(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel6);
        this.setLayout(new BorderLayout());

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new Rectangle2D("2D Rectangle");
                frame4.setVisible(true);
                frame4.setSize(1000, 600);
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsImage();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.pack();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        int x = (getWidth() - width) / 2; // Center the shape horizontally
        int y = (getHeight() - height) / 2; // Center the shape vertically
        g.fillRect(x, y, width, height);
    }

    private void saveAsImage() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = image.createGraphics();
                paint(g2d);
                g2d.dispose();
                ImageIO.write(image, "png", fileToSave);
                JOptionPane.showMessageDialog(this, "Shape saved as image successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving the shape as image: " + e.getMessage());
            }
        }
    }


}
