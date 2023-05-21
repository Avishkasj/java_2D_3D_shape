import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Emploee extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton saveButton;
    private JPanel mypanel;
    

public Emploee() {

    connection();
    connection2();
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String name = textField1.getText();
            String salary = textField2.getText();
            String mobile = textField3.getText();


            try {
                pst= con.prepareStatement("insert into emplyee(name,salary,mobile)values (?,?,?)");
                pst.setString(1,name);
                pst.setString(2,salary);
                pst.setString(3,mobile);
                pst.executeUpdate();
                System.out.println("data add sucsess");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }



        }
    });
}


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Emploee().mypanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800,1000);
        frame.pack();
    }

    Connection con;
PreparedStatement pst;


    void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/companydb","root","");
            System.out.println("sucsess");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void connection2(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/companydb","root","");
            System.out.println("connected");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}






