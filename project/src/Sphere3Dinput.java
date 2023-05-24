import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sphere3Dinput extends JFrame {
    private JTextField textField1;
    private JButton createButton;
    private JPanel frame10;
    private JButton backButton;

    public Sphere3Dinput() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(frame10);
        frame10.setSize(1000, 600);
        this.pack();
    createButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int size = Integer.parseInt(textField1.getText());
            Color color = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to add a shadow?", "Shadow", JOptionPane.YES_NO_OPTION);
            boolean hasShadow = (choice == JOptionPane.YES_OPTION);

            Color shadowColor = null;
            if (hasShadow) {
                shadowColor = JColorChooser.showDialog(null, "Choose a shadow color", Color.BLACK);
            }

            Sphere3D sphereGenerator = new Sphere3D(size, color, hasShadow, shadowColor);
            sphereGenerator.setVisible(true);

        }
    });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sphere3Dinput.super.dispose();
                JFrame frame3= new all3d("All 3D");
                frame3.setVisible(true);
                frame3.setSize(1000, 600);
            }
        });
    }
}
