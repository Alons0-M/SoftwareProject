package trelo_Git;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;



public class PasswordReset implements ActionListener{
    JFrame frame;
    JLabel prnLabel = new JLabel("PRN");
    JLabel passwordLabel = new JLabel("Password");
    JLabel changepassLabel = new JLabel("New Password");
    JLabel Title = new JLabel("Change your password if you don't remember");
    JLabel repassLabel = new JLabel("Re-Type New Password");
    
    JTextField passwordField = new JPasswordField();
    JTextField changepassField = new JPasswordField();
    JTextField repasswordField = new JPasswordField();
    JTextField prnTextField = new JTextField();
    
    JButton changeButton = new JButton("Change");
    
    PasswordReset() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("JFC Details Form");
        frame.setBounds(50, 10, 850, 850);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize() {
        Title.setBounds(200, 5, 600, 40);
        Title.setBackground(Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        
        prnLabel.setBounds(200, 60, 400, 40);
        prnLabel.setBackground(Color.white);
        prnLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        prnTextField.setBounds(200, 110, 400, 40);
        prnTextField.setBackground(Color.white);
        prnTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        passwordLabel.setBounds(200, 160, 400, 40);
        passwordLabel.setBackground(Color.white);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        passwordField.setBounds(200, 210, 400, 40);
        passwordField.setBackground(Color.white);
        passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        changepassLabel.setBounds(200, 260, 400, 40);
        changepassLabel.setBackground(Color.white);
        changepassLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        changepassField.setBounds(200, 310, 400, 40);
        changepassField.setBackground(Color.white);
        changepassField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        repassLabel.setBounds(200, 360, 400, 40);
        repassLabel.setBackground(Color.white);
        repassLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        repasswordField.setBounds(200, 410, 400, 40);
        repasswordField.setBackground(Color.white);
        repasswordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        
        changeButton.setBounds(300, 490, 200, 40);
        changeButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    }

    public void addComponentsToFrame() {
    frame.add(prnLabel);
    frame.add(prnTextField);
    frame.add(Title);
    frame.add(passwordLabel);
    frame.add(passwordField);
    frame.add(changepassLabel);
    frame.add(changepassField);
    frame.add(repassLabel);
    frame.add(repasswordField);
    frame.add(changeButton);
}

public void actionEvent() {
    changeButton.addActionListener(this);
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == changeButton) {
        try {
            // Creating Connector Object
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sit", "root", "");

            String prn = prnTextField.getText();
            String pass = passwordField.getText();
            String changePass = changepassField.getText();
            String re_pass = repasswordField.getText();

            if (prn.equals("")) {
                JOptionPane.showMessageDialog(null, "UserId Is Missing");
            }
        else if (pass.equals("")) {
            JOptionPane.showMessageDialog(null,"Password is missing");
        }
        else if (changePass.equals("")) {
            JOptionPane.showMessageDialog(null,"New password is missing");
        }
        else if (!changePass.equals("")) {
            JOptionPane.showMessageDialog(null,"Password doesn't match");
        }


        Statement stmt = conn1.createStatement();

        String query = "SELECT * FROM User";
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            String UserId = rs.getString("PRN");
            String Password = rs.getString("Password");

            if(UserId.equals(prn)) {
                JOptionPane.showMessageDialog(null, "User Already Exists");

                PreparedStatement Pstatement = conn1.prepareStatement("Update User set Password = ? where PRN = ?");

                Pstatement.setString(1, changepassField.getText());
                Pstatement.setString(2, prnTextField.getText());

                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password Updated Successfully");
             }
            }

    frame.setVisible(false);
        }
    catch(Exception ex) {
        ex.printStackTrace();
            }
        }

    }
}
