package trelo_Git;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FeedBack implements ActionListener{
    JFrame frame;
    JLabel PRNLabel = new JLabel("USERID");
    JLabel Title = new JLabel("YOUR FeedBack Improves Us. Kindly give us 5 minutes of your time to make us improve");
    JTextField PRNTextField = new JTextField();
    JLabel feedBack = new JLabel("FeedBack");
    JTextArea fd = new JTextArea();   
    JButton submitButton = new JButton("Submit");
    JLabel image = new JLabel();
    Icon p;


    FeedBack(){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow(){
        frame = new JFrame();
        frame.setTitle("FeedBack");
        frame.setBounds(300, 300, 1300, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize(){
        Title.setBounds(100, 50, 800, 40);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        Title.setBackground(Color.white);
        Title.setForeground(Color.blue);

        PRNLabel.setBounds(500, 200, 200, 40);
        PRNLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        PRNLabel.setBackground(Color.white);
        PRNLabel.setForeground(Color.blue);
        
        PRNTextField.setBounds(500, 250, 300, 40);
        PRNTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        PRNTextField.setBackground(Color.white);
        
        feedBack.setBounds(500, 300, 400, 40);
        feedBack.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20));
        feedBack.setBackground(Color.white);
        feedBack.setForeground(Color.blue);

        fd.setBounds(500,350,800,80);
        fd.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        fd.setBackground(Color.white);

        p = new ImageIcon("C:\\TriviaBytes\\TriviaByte\\PHOTOS\\Feedback-en-una-reunion-de-trabajo.png");

        image.setBounds(5, 5, 1254, 836);
        image.setIcon(p);
        submitButton.setBounds(500, 450, 200, 40);
    }   

    public void addComponentsToFrame(){
        frame.add(Title);
        frame.add(PRNLabel);
        frame.add(PRNTextField);
        frame.add(feedBack);
        frame.add(fd);
        frame.add(submitButton);
        frame.add(image);
    }

    public void actionEvent(){
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submitButton){
            try{
                Connection conn1 = DriverManager.getConnection("url");
                Statement stmt = conn1.createStatement();
                String prn = PRNTextField.getText();

                String query = "SELECT * From User";
                ResultSet rs = stmt.executeQuery(query);

                while(rs.next()){
                    String UserId = rs.getString("PRN");

                    if(UserId.equals(prn)){
                        JOptionPane.showMessageDialog(PRNTextField, "THANK YOU");
                        PreparedStatement pStatement = conn1.prepareStatement("Insert into feedback value");
                        pStatement.setString(1, PRNTextField.getText());
                        pStatement.setString(2, fd.getText());
                        pStatement.executeUpdate();
                        HomePage h = new HomePage();
                        frame.setVisible(false);
                    }
                }
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else JOptionPane.showMessageDialog(null, "Invalid PRN");
    }

class Main9{
    public void main(String[] args) {
        FeedBack fb = new FeedBack();
    }
}

}