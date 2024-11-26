package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame{
    Reception(){
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1350,670);

        panel.setBackground(new Color(213, 251, 253));
        add(panel);
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1350,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);
        ImageIcon i =new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=i.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(image);
        JLabel label =new JLabel(i1);
        label.setBounds(1100,0,250,250);
        panel1.add(label);
        ImageIcon i11 =new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 =i11.getImage().getScaledInstance(400,100,Image.SCALE_DEFAULT);
        ImageIcon i22 =new ImageIcon(image1);
        JLabel label1 =new JLabel(i22);
        label1.setBounds(900,50,300,100);
        panel1.add(label1);
        JButton button = new JButton("Add New Patient");
        button.setBounds(30,10,180,25);
        button.setBackground(new Color(246,215,118));
        panel1.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           new NEW_PATIENT();
            }
        });
        JButton button1 =new JButton("Room");

        button1.setBounds(30,45,180,25);
        button1.setBackground(new Color(246,215,118));
        panel1.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new  Room();
            }
        });
        JButton button2 =new JButton("Department");

        button2.setBounds(30,80,180,25);
        button2.setBackground(new Color(246,215,118));
        panel1.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Department();
            }
        });
        JButton button3 =new JButton("All Employee Info");
        button3.setBounds(30,115,180,25);
        button3.setBackground(new Color(246,215,118));
        panel1.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         new Employee_inf();
            }
        });
        JButton button4 =new JButton("Patient Info");
        button4.setBounds(270,10,180,25);
        button4.setBackground(new Color(246,215,118));
        panel1.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new Patient_info();
            }
        });
        JButton button5 =new JButton("Patient Discharge");
        button5.setBounds(270,45,180,25);
        button5.setBackground(new Color(246,215,118));
        panel1.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new Patient_Dis();
            }
        });
        JButton button6 =new JButton("Appointment Booking");
        button6.setBounds(270,80,180,25);
        button6.setBackground(new Color(246,215,118));
        panel1.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Appointment_Book();
            }
        });
        JButton button7 =new JButton("Appointment Information");
        button7.setBounds(270,115,180,25);
        button7.setBackground(new Color(246,215,118));
        panel1.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Appointment_info();
            }
        });

        JButton button9 =new JButton("Medicine Inventory");
        button9.setBounds(500,10,180,25);
        button9.setBackground(new Color(246,215,118));
        panel1.add(button9);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new Medicin_info();
            }
        });
        JButton button10 =new JButton("Report");
        button10.setBounds(500,45,180,25);
        button10.setBackground(new Color(246,215,118));
        panel1.add(button10);
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

             new reportHistory();
            }
        });
        JButton button11 =new JButton("Logout");
        button11.setBounds(500,80,180,25);
        button11.setBackground(new Color(246,215,118));
        panel1.add(button11);
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        setSize(1950, 1000);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Reception();
    }
}
