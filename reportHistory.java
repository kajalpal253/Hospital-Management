package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class reportHistory extends JFrame {
    reportHistory(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(226, 247, 248));
        panel.setBounds(5,45,900,750);
        panel.setLayout(null);
        add(panel);
        JPanel panel1 =new JPanel();
        panel1.setBounds(5,5,900,40);
        panel1.setBackground(new Color(30, 251, 253));
        add(panel1);
        JLabel label= new JLabel("MEDICAL REPORT");
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setBounds(360,10,300,20);
        panel1.add(label);
        JTable table = new JTable();
        table.setBounds(2,3,850,500);
        table.setBackground(new Color(213, 251, 253));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(2, 3, 870, 460);
        panel.add(scrollPane);
        try {
            conn c= new conn();
            String q ="select * from report";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JButton addButton = new JButton("Add");
        addButton.setBounds(250, 500, 100, 30);
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.black);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new report();
            }
        });




        JButton bButton = new JButton("Back");
        bButton.setBounds(500, 500, 100, 30);
        bButton.setForeground(Color.white);
       bButton.setBackground(Color.black);
        panel.add(bButton);
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

setUndecorated(true);
        setSize(900, 800);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }
    public  static  void main(String[] args){
     new reportHistory();
    }
}
