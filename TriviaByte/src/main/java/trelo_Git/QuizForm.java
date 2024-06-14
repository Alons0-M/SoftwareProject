import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuizForm implements ActionListener
{
    static int count;
    JFrame frame = new JFrame();
    JLabel Title = new JLabel("Quiz Question1");
    JLabel question1 = new JLabel("1) Which is the container that doesn't contain title bar and MenuBars but "
                                  + "it can have other components like button, textfield etc?");
    JCheckBox answer1 = new JCheckBox("a. Window");
    JCheckBox answer2 = new JCheckBox("b. Frame");
    JCheckBox answer3 = new JCheckBox("c. Panel");
    JCheckBox answer4 = new JCheckBox("d. Container");

    JButton submitButton = new JButton("Submit");

    QuizForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow()
    {
        frame = new JFrame();
        frame.setTitle("Question 1");
        frame.setBounds(300, 300, 1200, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize()
    {
    Title.setBounds(350, 10, 600, 40);
    Title.setBackground(Color.white);
    Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));

    question1.setBounds(50, 60, 1200, 40);
    question1.setBackground(Color.white);
    question1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

    answer1.setBounds(50, 130, 400, 40);
    answer1.setBackground(Color.white);
    answer1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

    answer2.setBounds(50, 180, 400, 40);
    answer2.setBackground(Color.white);
    answer2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

    answer3.setBounds(50, 230, 400, 40);
    answer3.setBackground(Color.white);
    answer3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

    answer4.setBounds(50, 280, 400, 40);
    answer4.setBackground(Color.white);
    answer4.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

    submitButton.setBounds(50, 330, 200, 40);
    submitButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    }

    public void addComponentsToFrame()
    {
        frame.add(Title);
        frame.add(question1);
        frame.add(answer1);
        frame.add(answer2);
        frame.add(answer3);
        frame.add(answer4);
        frame.add(submitButton);
    }

    public void actionEvent()
    {
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) 
        {
        String answer = null;
        if (e.getSource() == submitButton) {
            if (answer1.isSelected()) {
                answer = "a. Window";
            }
            if (answer2.isSelected()) 
            {
                answer = "b. Frame";
            }
            if (answer3.isSelected()) 
            {
                answer = "c. Panel";
            }
            if (answer4.isSelected()) 
            {
                answer = "d. Container";
            }

            if (answer == "c. Panel"){
                JOptionPane.showMessageDialog(null, "Wait for result");
                JOptionPane.showMessageDialog(null, "Wrong answer!");
                count += 1;
                QuizForm2 quizForm2 = new QuizForm2(count);
                frame.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Wait for result");
                JOptionPane.showMessageDialog(null, "Wrong answer!");                
                QuizForm quizForm2 = new QuizForm2(count);
                frame.setVisible(false);
            }                       
        }
    }
}

class main1{
    public static void main(String[] args) {
        QuizForm quizForm = new QuizForm();
    }
}