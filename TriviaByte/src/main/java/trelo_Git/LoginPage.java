package trelo_Git;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class LoginPage implements ActionListener{
	JFrame frame;
	
	JLabel PRNLabel = new JLabel("USER ID");
	JLabel Title = new JLabel("LOGIN FORM");
	JTextField PRNTextField = new JTextField();
	
	JLabel passwordLabel = new JLabel("PASSWORD");
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("Login");
	JLabel image = new JLabel();
	Icon p;
	
	LoginPage(){
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	
	public void createWindow(){
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setBounds(300, 300, 800, 900);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize(){
        Title.setBounds(300,50,400,40);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        Title.setBackground(Color.white);
        Title.setForeground(Color.blue);
        
        PRNLabel.setBounds(200,200,400,40);
        PRNLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        PRNLabel.setBackground(Color.white);
        PRNLabel.setForeground(Color.blue);
    
        PRNTextField.setBounds(200,250,400,40);
        PRNTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        PRNTextField.setBackground(Color.white);
    
        passwordLabel.setBounds(200,300,400,40);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        passwordLabel.setBackground(Color.white);
        passwordLabel.setForeground(Color.blue);
        
        passwordField.setBounds(200,250,400,40);
        passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        passwordField.setBackground(Color.white);
        
        p = new ImageIcon("\\TriviaByte\\PHOTOS\\login.png");
        
        image.setBounds(10,130,800,419);
        image.setIcon(p);
        loginButton.setBounds(200,450,400,40);
    
    
    }

    public void addComponentsToFrame(){
    	frame.add(Title);
        frame.add(PRNLabel);
        frame.add(PRNTextField);
        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.add(loginButton);
        frame.add(image);
    }

    public void actionEvent(){
        loginButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton) {
        	try {
        		Connection conn1 = DriverManager.getConnection("jdbc:://localhost:3306/rit", "root", "");
        		
        		Statement stmt = conn1.createStatement();
        		Statement stmt1 = conn1.createStatement();
        		String prn = PRNTextField.getText();
        		String pass = passwordField.getText();
        		
        		String query = "Select FROM USER";
        		ResultSet rs = stmt.executeQuery(query);
        		
        		while(rs.next()) {
        			String UserId = rs.getString("PRN");
        			String Password = rs.getString("Password");
        			
        			if(UserId.equals(prn) && Password.equals(pass)) {
        				JOptionPane.showMessageDialog(null, "Logged In");
        				PreparedStatement pstatement = conn1.prepareStatement("Insert into login value:");
        				pstatement.setString(1, PRNTextField.getText());
        				pstatement.setString(2, passwordField.getText());
        				pstatement.executeUpdate();
        				HomePage h = new HomePage();
        				frame.setVisible(false);
        				
        			}
        		}
        		}
            catch(Exception ex) {
            	ex.printStackTrace();
            }
        }
        else JOptionPane.showMessageDialog(null, "Invalid credentials");
    }
}