import javax.swing.*;

public class Arc2D extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JRadioButton redRadioButton;
    private JRadioButton greenRadioButton;
    private JRadioButton blueRadioButton;
    private JButton createButton;
    private JPanel mypanel7;

    private ButtonGroup colorButtonGroup;


    public Arc2D(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mypanel7);
        this.pack();

        colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(redRadioButton);
        colorButtonGroup.add(greenRadioButton);
        colorButtonGroup.add(blueRadioButton);

    }
}

