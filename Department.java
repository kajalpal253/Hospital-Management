package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.ResolutionException;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
        JPanel panel =new JPanel();
        panel.setBounds(5,40,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(226, 247, 248));
        add(panel);
        JPanel panel1 =new JPanel();
       panel1.setBounds(5,5,690,40);
        panel1.setBackground(new Color(30, 251, 253));
        add(panel1);
        JLabel label = new JLabel("DEPARTMENT");
        label.setFont(new Font("Tahoma",Font.BOLD,20));
         label.setBounds(360,10,30,20);
         panel1.add(label);
         JTable  table = new JTable();
         table.setBounds(0,40,690,490);
        table.setBackground(new Color(226, 247, 248));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 800, 400); // Properly positioned scroll pane
        panel.add(scrollPane);
         try
         {
             conn c= new conn();
             String q = "select * from department";
             ResultSet resultSet = c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
         } catch (Exception e) {
             e.printStackTrace();
         }
       JLabel label1 =new JLabel("Department");
         label1.setBounds(145,11,105,20);
         label1.setFont(new Font("Tahoma",Font.BOLD,14));
         label1.setBackground(Color.black);
         panel.add(label1);
        JLabel label2 =new JLabel("Contact Number");
        label2.setBounds(450,11,300,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setBackground(Color.black);
        panel.add(label2);
        JButton b1 = new JButton("Back");
        b1.setBounds(270,200,70,25);
        b1.setFont(new Font("Tahoma",Font.BOLD,14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(700,500);
        setLocation(300,250);
       setLayout(null);
        setVisible(true);
    }

    public  static  void  main(String[] args){
      new Department();
    }
}
