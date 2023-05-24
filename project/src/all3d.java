import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class all3d extends JFrame {

    private JPanel mypanel3;
    private JButton cubeButton1;
    private JButton sphere3DButton;

    public all3d(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mypanel3);
        this.pack();
        cubeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all3d.super.dispose();
                JFrame frame9= new Cube3Dinput();
                frame9.setVisible(true);
                frame9.setSize(1000, 600);
            }
        });
        sphere3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all3d.super.dispose();
                JFrame frame10= new Sphere3Dinput();
                frame10.setVisible(true);
                frame10.setSize(1000, 600);
            }
        });
    }

}
