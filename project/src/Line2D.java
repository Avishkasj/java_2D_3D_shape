import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line2D extends JFrame {
    private JPanel mypanel4;
    private JTextField textField1;
    private JTextField textField2;
    private JButton createButton;
    private JRadioButton redRadioButton;
    private JRadioButton greenRadioButton;
    private JRadioButton blueRadioButton;
    private JButton backButton;
    private ButtonGroup colorButtonGroup; // ButtonGroup to manage radio button selection

    public Line2D(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mypanel4);
        this.pack();

        // Create the ButtonGroup and add radio buttons to it
        colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(redRadioButton);
        colorButtonGroup.add(greenRadioButton);
        colorButtonGroup.add(blueRadioButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startX = 0; // Start X-coordinate of the line
                int startY = 0; // Start Y-coordinate of the line
                int endX = Integer.parseInt(textField1.getText()); // End X-coordinate of the line
                int endY = Integer.parseInt(textField2.getText()); // End Y-coordinate of the line
                Color color;

                if (redRadioButton.isSelected()) {
                    // Red radio button is selected
                    // Do something with the red selection
                    color = Color.RED;
                } else if (greenRadioButton.isSelected()) {
                    // Green radio button is selected
                    // Do something with the green selection
                    color = Color.GREEN;
                } else if (blueRadioButton.isSelected()) {
                    // Blue radio button is selected
                    // Do something with the blue selection
                    color = Color.BLUE;
                } else {
                    // No radio button is selected
                    // Handle the case where no selection is made
                    color = Color.BLACK; // or set a default color value
                }

                LineView2D lineView = new LineView2D(startX, startY, endX, endY, color);
                lineView.setVisible(true);
                lineView.setSize(1000, 600);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Line2D.super.dispose();
                JFrame frame2= new all2d("All 2D");
                frame2.setVisible(true);
                frame2.setSize(1000, 600);
            }
        });
    }
}
