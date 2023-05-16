import javax.swing.*;

public class dashboard extends JFrame {


    private JPanel mypanel;

    public dashboard(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mypanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new dashboard("Dashboard");
        frame.setVisible(true);
        frame.setSize(1000, 600);
    }
}
