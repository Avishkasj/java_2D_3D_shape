import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arc2D extends JFrame {
    private JTextField StartAngle;
    private JTextField ArcAngle;
    private JTextField Diameter;
    private JRadioButton redRadioButton;
    private JRadioButton greenRadioButton;
    private JRadioButton blueRadioButton;
    private JButton createButton;
    private JPanel mypanel7;

    private ButtonGroup colorButtonGroup;


    public Arc2D(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mypanel7);
        this.pack();

        colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(redRadioButton);
        colorButtonGroup.add(greenRadioButton);
        colorButtonGroup.add(blueRadioButton);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int diameter = Integer.parseInt(Diameter.getText());
                int startAngle = Integer.parseInt(StartAngle.getText());
                int arcAngle = Integer.parseInt(ArcAngle.getText());

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

                ArcView2D arcView = new ArcView2D(diameter, startAngle, arcAngle, color);
                arcView.setVisible(true);
                arcView.setSize(1000, 600);

            }
        });
    }
}

