package trelo_Git;

import java.awt.Color;  
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;

public class HomePage implements ActionListener{
    static String prn = null;
    JFrame frame;
    JLabel welcome = new JLabel("WELCOME TO TRIVIABYTES. The coolest. The simplest");
    JMenuBar menuBar = new JMenuBar();
    
    JMenu menu1 = new JMenu("File");
    JMenu menu2 = new JMenu("Help");
    JMenu menu3 = new JMenu("FeedBack");

    JMenuItem menuItem = new JMenuItem("New? SIGN UP");
    JMenuItem menuItem2 = new JMenuItem("Not new? LOG IN");
    JMenuItem menuItem3 = new JMenuItem("Ready? Set, LETS GO");
    JMenuItem menuItem4 = new JMenuItem("You give up? LOG OUT");
    
    JMenuItem menuItem5 = new JMenuItem("Change password?");
    JMenuItem menuItem6 = new JMenuItem("Tell us anything");
    
    JTextArea feedBackTextArea = new JTextArea();
    JLabel help = new JLabel();

    Icon quiz;
    JLabel image = new JLabel();

    HomePage(){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow(){
        frame = new JFrame();
        frame.setTitle("Online Quiz");
        frame.setBounds(50,10,1300,1000);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize(){
        
        menuBar.setBounds(2,2,1280,30);

        menu1.setBounds(2,2,100,30);
        menu1.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        menuItem.setBounds(2,2,100,40);
        menuItem.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        menuItem2.setBounds(2,2,100,40);
        menuItem2.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        menuItem3.setBounds(2,2,100,40);
        menuItem3.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        menuItem4.setBounds(2,2,100,40);
        menuItem4.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        
        menu2.setBounds(30,2,100,30);
        menu2.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        menuItem5.setBounds(30,2,100,40);
        menuItem5.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        
        menu3.setBounds(60,2,100,30);
        menu3.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));

        menuItem6.setBounds(90,2,100,40);
        menuItem6.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));

        menu1.add(menuItem);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.add(menuItem4);

        menu2.add(menuItem5);

        menu3.add(menuItem6);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        welcome.setBounds(250,80,800,50);
        welcome.setBackground(Color.lightGray);
        welcome.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));

        quiz = new ImageIcon("\\TriviaByte\\PHOTOS\\quizLogo.jpg");

        image.setBounds(95,90,1024,761);
        image.setIcon(quiz);
    }

    public void addComponentsToFrame(){
        frame.add(menuBar);
        frame.add(image);
        frame.add(welcome);
    }

    public void actionEvent(){
        menuItem.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == menuItem) {
        	Experiment10 exp = new Experiment10();
        }
        
        if(e.getSource() == menuItem2) {
        	LoginPage lg1 = new LoginPage();
        }
        
        if(e.getSource() == menuItem3) {
        	prn = JOptionPane.showInputDialog("Enter your PRN");
        	try {
        		Connection conn1 = DriverManager.getConnection("jdbc:://localhost:3306/rit", "root", "");
        		Statement stmt = conn1.createStatement();
        		
        		String query = "Select PRN FROM Login";
        		ResultSet rs = stmt.executeQuery(query);
        		
        		while(rs.next()) {
        			String UserId = rs.getString("PRN");
        			
        			if(UserId.equals(prn)) {
        				JOptionPane.showMessageDialog(null,  "Good luck");
        				QuizForm q = new QuizForm();
        				frame.setVisible(false);
        			}
        			else {
        				JOptionPane.showMessageDialog(null, "User not logged in");
        			}
        		}
        		}
            catch(Exception ex) {
            	ex.printStackTrace();
            }
        }
        if(e.getSource() == menuItem5) {
        	try {
        		Connection conn1 = DriverManager.getConnection("jdbc:://localhost:3306/rit", "root", "");
        		Statement stmt = conn1.createStatement();
        		
        		String query = "Select PRN FROM Login";
        		ResultSet rs = stmt.executeQuery(query);
        		
        		while(rs.next()) {
        			prn = rs.getString("PRN");
        			PreparedStatement pst = conn1.prepareStatement("Delete from login where PRN '" + prn + "'");
        			pst.execute();
        			frame.setVisible(false);
        			JOptionPane.showMessageDialog(null, "Logout successful");
        		}
        		}
            catch(Exception ex) {
            	ex.printStackTrace();
            }
        }
        if(e.getSource() == menuItem6) {
        	FeedBack fd = new FeedBack();
        	frame.setVisible(false);
        }
    }

}