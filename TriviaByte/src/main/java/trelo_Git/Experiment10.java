package trelo_Git;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Experiment10 implements ActionListener{

	JFrame frame;
	
	JLabel Title = new JLabel("Registration Form");
	JLabel prnLabel = new JLabel("PRN");
	JLabel nameLabel = new JLabel("UserName");
	JLabel addressLabel = new JLabel("Address");
	JLabel emailLabel = new JLabel("Email");
	JLabel contactLabel = new JLabel("Contact No");
	JLabel classLabel = new JLabel("Class");
	JLabel passwordLabel = new JLabel("Password");
	JLabel branchLabel = new JLabel("Branch");
	
	JTextField prnTextField = new JTextField();
	JTextField nameTextField = new JTextField();
	JTextField contactTextField = new JTextField();
	JTextField emailTextField = new JTextField();
	
	JTextArea addressTextArea = new JTextArea();
	
	JPasswordField passwordField = new JPasswordField();
	
	String[] branch = {"CSIT", "CSE", "ETC", "Electrical", "Mechanical", "Civil", "Automobile", "Mechatronics"};
	String[] Class = {"FY", "SY", "TY", "Final"};	
	
	JComboBox className = new JComboBox(Class);
	JComboBox branchname = new JComboBox(branch);
	
	JButton SumitButton = new JButton("Submit");
	JButton ResetButton = new JButton("Reset");
	
	Experiment10() {
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	
	public void createWindow() {
		frame = new JFrame();
		frame.setTitle("Students detail forms");
		frame.setBounds(50, 10, 1000, 1000);
		frame.setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}
	
	public void setLocationAndSize() {
		Title.setBounds(300, 2, 400, 40);
		Title.setBackground(Color.white);
		Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
		
		prnLabel.setBounds(300, 50, 400, 40);
		prnLabel.setBackground(Color.white);
		prnLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		prnTextField.setBounds(300, 100, 400, 40);
		prnTextField.setBackground(Color.white);
		prnTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		nameLabel.setBounds(300, 150, 400, 40);
		nameLabel.setBackground(Color.white);
		nameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		nameTextField.setBounds(300, 200, 400, 40);
		nameTextField.setBackground(Color.white);
		nameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		emailLabel.setBounds(300, 250, 400, 40);
		emailLabel.setBackground(Color.white);
		emailLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		emailTextField.setBounds(300, 300, 400, 40);
		emailTextField.setBackground(Color.white);
		emailTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		passwordLabel.setBounds(300, 350, 400, 40);
		passwordLabel.setBackground(Color.white);
		passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		passwordField.setBounds(300, 400, 400, 40);
		passwordField.setBackground(Color.white);
		passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		classLabel.setBounds(300, 450, 400, 40);
		classLabel.setBackground(Color.white);
		classLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		className.setBounds(300, 500, 400, 40);
		className.setBackground(Color.white);
		className.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		branchLabel.setBounds(300, 550, 400, 40);
		branchLabel.setBackground(Color.white);
		branchLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		branchname.setBounds(300, 600, 400, 40);
		branchname.setBackground(Color.white);
		branchname.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		contactLabel.setBounds(300, 650, 400, 40);
		contactLabel.setBackground(Color.white);
		contactLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		contactTextField.setBounds(300, 700, 400, 40);
		contactTextField.setBackground(Color.white);
		contactTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		addressLabel.setBounds(300, 750, 400, 40);
		addressLabel.setBackground(Color.white);
		addressLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		addressTextArea.setBounds(300, 820, 700, 40);
		classLabel.setBackground(Color.white);
		classLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		SumitButton.setBounds(300, 870, 100, 40);
		SumitButton.setBackground(Color.white);
		SumitButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		ResetButton.setBounds(300, 870, 100, 40);
		ResetButton.setBackground(Color.white);
		ResetButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
	}
	 	
	public void addComponentsToFrame() {
		frame.add(Title);
		frame.add(prnLabel);
		frame.add(prnTextField);
		frame.add(nameLabel);
		frame.add(nameTextField);
		frame.add(emailLabel);
		frame.add(emailTextField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(branchLabel);
		frame.add(branchname);
		frame.add(contactLabel);
		frame.add(contactTextField);
		frame.add(addressLabel);
		frame.add(addressTextArea);
		frame.add(SumitButton);
		frame.add(ResetButton);
		frame.add(classLabel);
		frame.add(className);
	}
	
	public void actionEvent() {
		SumitButton.addActionListener(this);
		ResetButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==SumitButton) {
			try {
				Connection connl = DriverManager.getConnection("", "root", "");
				PreparedStatement Pstatement = connl.prepareStatement("insert into User values(?, ?, ?, ?, ?, ?, ?, ?)");
				
				Pstatement.setString(1, prnTextField.getText());
				Pstatement.setString(2, addressTextArea.getText());
				Pstatement.setString(3, emailTextField.getText());
				Pstatement.setString(4, contactTextField.getText());
				Pstatement.setString(5, nameTextField.getText());
				Pstatement.setString(6, className.getSelectedItem().toString());
				Pstatement.setString(7, branchname.getSelectedItem().toString());
				Pstatement.setString(8, passwordField.getText()); //?
				
				String prn = prnTextField.getText();
				String pass = passwordField.getText();
				String email = emailTextField.getText();
				String classname = className.getSelectedItem().toString();
				String branch = branchname.getSelectedItem().toString();
				
				if (prn.equals("")) {
					JOptionPane.showMessageDialog(null, "UseId is Missing"); 
				}else if(pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Password is Missing"); 
				}else if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "Email is Missing"); 
				}
				
				Statement stat = connl.createStatement();
				
				String query = "SELECT * FROM User";
				ResultSet rs = stat.executeQuery(query);
				
				while(rs.next()) {
					String UserId = rs.getString("PRN");
					String Password = rs.getString("Password");
					
					if((UserId.equals(prn) || Password.equals(pass))) {
						JOptionPane.showMessageDialog(null, "UseId Already Exists"); 
					}else {
						Pstatement.executeUpdate();
						JOptionPane.showMessageDialog(null, "UseId Registered Sucessfully"); 
						frame.setVisible(false);
					}
				}if(!rs.next()) {
					Pstatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "UserId Registered Sucessfully"); 
				}
			}catch (SQLException el) {
				el.printStackTrace();
			}
		}if(e.getSource() == ResetButton) {
			prnTextField.setText("");
			nameTextField.setText("");
			addressTextArea.setText("");
			contactTextField.setText("");
			className.setSelectedItem("");
			branchname.setSelectedItem("");
			passwordField.setText("");
			emailTextField.setText("");
		}
	}	
}