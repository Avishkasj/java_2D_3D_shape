
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Emplyee {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table1;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton serchButton;
    private JPanel mypanel;
    private JScrollPane table10;

    public Emplyee() {
        connection();
        table_load();
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name  = textField1.getText();
            String salary = textField2.getText();
            String mobile = textField3.getText();

            try {
                pst = con.prepareStatement("INSERT INTO emplyee(name,salary,mobile)values (?,?,?)");
                pst.setString(1,name);
                pst.setString(2,salary);
                pst.setString(3,mobile);

                pst.executeUpdate();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    });
}

    Connection con;
    PreparedStatement pst;


public void connection(){
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


    void table_load() {
        try {
            pst = con.prepareStatement("SELECT * FROM employee");
            ResultSet rs = pst.executeQuery();

            // Get ResultSet metadata to determine the number of columns
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel();
            for (int column = 1; column <= columnCount; column++) {
                model.addColumn(metaData.getColumnLabel(column));
            }

            // Add rows to the model from the ResultSet
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    rowData[column - 1] = rs.getObject(column);
                }
                model.addRow(rowData);
            }

            // Set the model to your JTable
            table1.setModel(model);

            // Close the ResultSet and statement
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    JFrame frame  = new JFrame("Employee");
    frame.setContentPane(new Emplyee().mypanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    }
}
