import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RRectangle2D extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton redRadioButton;
    private JRadioButton greenRadioButton;
    private JRadioButton blueRadioButton;
    private JButton createButton;
    private JPanel mypanel4;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel ArcHeight;
    private JLabel ArcWidth;

    private ButtonGroup colorButtonGroup;

    public RRectangle2D(String title) {
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
                int height = Integer.parseInt(textField1.getText());
                int width = Integer.parseInt(textField2.getText());
                int arcHeight = Integer.parseInt(textField4.getText());
                int arcWidth = Integer.parseInt(textField3.getText());
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

                RoundRectangleView2D rrectangleView = new RoundRectangleView2D(width, height,arcWidth,arcHeight, color);
                rrectangleView .setVisible(true);
                rrectangleView .setSize(1000, 600);
            }
        });
    }
}
