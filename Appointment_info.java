package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Appointment_info extends JFrame {
    Appointment_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,40,990,820);
        panel.setLayout(null);
        panel.setBackground(new Color(226, 247, 248));
        add(panel);
        JPanel panel1 =new JPanel();
        panel1.setBounds(5,5,990,40);
        panel1.setBackground(new Color(30, 251, 253));
        add(panel1);
        JLabel label= new JLabel("APPOINTMENT INFORMATION");
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setBounds(360,10,300,20);
        panel1   .add(label);
        JTable table = new JTable();
        table.setBounds(10,40,985,890);
        table.setRowHeight(23);
        table.setBackground(new Color(226, 247, 248));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(3, 40, 970, 500); // Properly positioned scroll pane
        panel.add(scrollPane);

        try{
            conn c =new conn();
            String q = "select * from Appointment";
            ResultSet resultSet =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel label0 = new JLabel("ID");
        label0.setBounds(40,9,330,20);
        label0.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label0);
        JLabel labell =new JLabel("Number");
        labell.setBounds(160,9,70,20);
        labell.setFont(new Font("Tahoma",Font.BOLD,14));
        labell.setBackground(Color.black);
        panel.add(labell);
        JLabel label1 =new JLabel("Name");
        label1.setBounds(280,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setBackground(Color.black);
        panel.add(label1);
        JLabel label2 =new JLabel("Age");
        label2.setBounds(400,9,130,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setBackground(Color.black);
        panel.add(label2);
        JLabel label3 =new JLabel("Gender");
        label3.setBounds(520,9,130,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setBackground(Color.black);
        panel.add(label3);
        JLabel label4 =new JLabel("Department");
        label4.setBounds(630,9,130,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setBackground(new Color(15, 13, 64));
        panel.add(label4);
        JLabel label5 =new JLabel("Date");
        label5.setBounds(760,9,130,20);

        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setBackground(new Color(15, 13, 64));

        panel.add(label5);
        JLabel label6 =new JLabel("Time");
        label6.setBounds(890,9,130,20);

        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setBackground(new Color(15, 13, 64));

        panel.add(label6);
        JButton button =new JButton("Back");
        button.setBounds(100,700,120,30);
        button.setBackground(Color.black);
        button.setForeground(new Color(246,215,118));
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(1000, 900);
        setLayout(null);
        setLocation(200, 230);
        setVisible(true);
    }

    public  static  void main(String[] args){
        new Appointment_info();
    }
}
