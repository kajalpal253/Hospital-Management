package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Patient_info extends JFrame {

    Patient_info() {
        JPanel panel =new JPanel();
        panel.setBounds(5,40,970,500);
        panel.setBackground(new Color(213, 251, 253));
        panel.setLayout(null);
        add(panel);
        JPanel panel1 =new JPanel();
        panel1.setBounds(5,5,980,40);
        panel1.setBackground(new Color(30, 251, 253));
        add(panel1);
        JLabel labelL = new JLabel("PATIENT  INFORMATION");
        labelL.setFont(new Font("Tahoma",Font.BOLD,20));
        labelL.setBounds(360,10,300,20);

        panel1.add(labelL);
        JTable table = new JTable();
        table.setBounds(10,50,970,1000);
        table.setBackground(new Color(213, 251, 253));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 40, 950, 500);
        panel.add(scrollPane);
        try {
            conn c= new conn();
            String q ="select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel label = new JLabel("Document");
        label.setBounds(20,17,300,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);
        JLabel label1 = new JLabel("Number");
        label1.setBounds(160,17,340,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        JLabel label2 = new JLabel("Name");
        label2.setBounds(280,17,300,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        JLabel label3 = new JLabel("Gender");
        label3.setBounds(400,17,300,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);
        JLabel label4 = new JLabel("Disease");
        label4.setBounds(530,17,300,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);
        JLabel label5 = new JLabel("Room No");
        label5.setBounds(650,17,300,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);
        JLabel label6 = new JLabel("Time");
        label6.setBounds(780,17,300,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);
        JLabel label7 = new JLabel("Deposite");
        label7.setBounds(880,17,300,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);


        setUndecorated(true);
        setSize(980, 600);
        setLayout(null);
        setLocation(300, 230);
        setVisible(true);
    }
    public  static  void  main(String args[]){
        new Patient_info();
    }
}

