import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle2D extends JFrame {
    private JTextField textField1;
    private JRadioButton redRadioButton;
    private JRadioButton greenRadioButton;
    private JRadioButton blueRadioButton;

    private ButtonGroup colorButtonGroup;
    private JButton createButton;
    private JPanel panel7;
    private JButton backButton;

    public Circle2D(String title) {
    super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setContentPane(panel7);
    this.pack();


        // Create the ButtonGroup and add radio buttons to it
        colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(redRadioButton);
        colorButtonGroup.add(greenRadioButton);
        colorButtonGroup.add(blueRadioButton);

    createButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int diameter = Integer.parseInt(textField1.getText());

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

            CircleView2D circleView = new CircleView2D(diameter, color);
            circleView.setVisible(true);
            circleView.setSize(1000, 600);


        }
    });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle2D.super.dispose();
                JFrame frame2= new all2d("All 2D");
                frame2.setVisible(true);
                frame2.setSize(1000, 600);
            }
        });
    }
}
