package  hospital.management.system;




import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JTextField textfiled;
    JPasswordField jPasswordField;
    JButton b1,b2;
    Login(){

        JLabel namelabel =new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel Password =new JLabel("Password");
        Password.setBounds(40,70,100,30);
        Password.setFont(new Font("Tahoma",Font.BOLD,16));
        Password.setForeground(Color.BLACK);
        add(Password);
        textfiled =new JTextField();
        textfiled.setBounds(150,20,150,30);
        textfiled.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(textfiled);
        jPasswordField =new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(jPasswordField);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/MedicalCare.png"));
        Image i1 =imageIcon.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 =new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(300,-30,400,300);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        b2=new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        getContentPane().setBackground(new Color(93, 226, 231));
        setUndecorated(true);
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try {
                conn c =new conn();
                String user = textfiled.getText();
                String pass = jPasswordField.getText();

                String q ="select *from login where ID ='"+user+"'and PW ='"+pass+"'";
                ResultSet resultSet =c.statement.executeQuery(q);
                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            System.exit(10);
        }

    }
    public static void main(String[] args) {
        new Login();
    }

}
