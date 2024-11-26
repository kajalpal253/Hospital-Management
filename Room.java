package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    Room(){
        JPanel panel =new JPanel();
        panel.setBounds(5,40,970,500);
        panel.setBackground(new Color(226, 247, 248));
        panel.setLayout(null);
        add(panel);
        JPanel panel1 =new JPanel();
        panel1.setBounds(5,5,980,40);
        panel1.setBackground(new Color(30, 251, 253));
        add(panel1);
        JLabel label = new JLabel("HOSPITAL  ROOM");
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setBounds(360,10,300,20);

        panel1.add(label);
        table = new JTable();
        table.setBounds(10,50,970,1000);
        table.setBackground(new Color(226, 247, 248));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(2, 40, 960, 400);
        panel.add(scrollPane);
        try{
            conn c= new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(70,15,80,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label1);
        JLabel label2 = new JLabel("Availability");
        label2.setBounds(330,15,350,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label2);
        JLabel label3 = new JLabel("Room Price");
        label3.setBounds(550,15,350,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label3);
        JLabel label4 = new JLabel("Department");
        label4.setBounds(800,15,350,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(label4);
        setUndecorated(true);
        setSize(980,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);

    }
    public  static  void main(String args[]){
        new Room();
    }
}
