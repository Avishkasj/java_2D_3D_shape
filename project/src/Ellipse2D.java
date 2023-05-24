import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton backButton;
    private ButtonGroup colorButtonGroup;

    public Ellipse2D(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ellipse2D.super.dispose();
                JFrame frame2= new all2d("All 2D");
                frame2.setVisible(true);
                frame2.setSize(1000, 600);
            }
        });
    }

}
