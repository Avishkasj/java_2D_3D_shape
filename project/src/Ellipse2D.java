import javax.swing.*;
import java.awt.*;

public class Ellipse2D extends JFrame{
    private JTextField widthTextField;
    private JTextField xTextField;
    private JTextField heightTextField;
    private JTextField yTextField;
    private JRadioButton greenRadioButton;
    private JRadioButton blueRadioButton;
    private JRadioButton redRadioButton;
    private JButton createButton;
    private JPanel mypanel4;
    private ButtonGroup colorButtonGroup;

    public Ellipse2D(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mypanel4);
        this.pack();

        // Create the ButtonGroup and add radio buttons to it
        colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(redRadioButton);
        colorButtonGroup.add(greenRadioButton);
        colorButtonGroup.add(blueRadioButton);

        createButton.addActionListener(e -> {
            int x = Integer.parseInt(xTextField.getText());
            int y = Integer.parseInt(yTextField.getText());
            int width = Integer.parseInt(widthTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());
            Color color;

            if (redRadioButton.isSelected()) {
                color = Color.RED;
            } else if (greenRadioButton.isSelected()) {
                color = Color.GREEN;
            } else if (blueRadioButton.isSelected()) {
                color = Color.BLUE;
            } else {
                color = Color.BLACK;
            }

            EllipseView2D ellipseView = new EllipseView2D(x, y, width, height, color);
            ellipseView.setVisible(true);
            ellipseView.setSize(800, 600);
        });


    }

}
