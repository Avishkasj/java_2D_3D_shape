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
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mypanel2);
        this.pack();
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all2d.super.dispose();
                JFrame frame4= new Rectangle2D("2D Rectangle");
                frame4.setVisible(true);
                frame4.setSize(1000, 600);
            }
        });
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all2d.super.dispose();
                JFrame frame5= new Circle2D("2D Circle");
                frame5.setVisible(true);
                frame5.setSize(1000, 600);
            }
        });
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all2d.super.dispose();
                JFrame frame6= new Line2D("2D Line");
                frame6.setVisible(true);
                frame6.setSize(1000, 600);

            }
        });
        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all2d.super.dispose();
                JFrame frame7= new Ellipse2D("2D Ellipse");
                frame7.setVisible(true);
                frame7.setSize(1000, 600);
            }
        });
        arcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all2d.super.dispose();
                JFrame frame8= new Arc2D("2D Arc");
                frame8.setVisible(true);
                frame8.setSize(1000, 600);
            }
        });
        roundRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all2d.super.dispose();
                JFrame frame9= new RRectangle2D("2D Round Rectangle");
                frame9.setVisible(true);
                frame9.setSize(1000, 600);
            }
        });
    }






}

