import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class all2d extends JFrame {

    private JPanel mypanel2;
    private JButton rectangleButton;
    private JButton circleButton;
    private JButton lineButton;
    private JButton ellipseButton;
    private JButton arcButton;
    private JButton roundRectangleButton;

    public all2d(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mypanel2);
        this.pack();
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4= new Rectangle2D("2D Rectangle");
                frame4.setVisible(true);
                frame4.setSize(1000, 600);
            }
        });
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame5= new Circle2D("2D Circle");
                frame5.setVisible(true);
                frame5.setSize(1000, 600);
            }
        });
    }






}

