import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame {


    private JPanel mypanel;
    private JButton a2DButton;
    private JButton a3DButton;


    public dashboard(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mypanel);
        this.pack();

        a2DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.super.dispose();
                JFrame frame2= new all2d("All 2D");
                frame2.setVisible(true);
                frame2.setSize(1000, 600);

            }
        });
        a3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.super.dispose();
                JFrame frame3= new all3d("All 3D");
                frame3.setVisible(true);
                frame3.setSize(1000, 600);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new dashboard("Dashboard");
        frame.setVisible(true);
        frame.setSize(1000, 600);
    }
}
