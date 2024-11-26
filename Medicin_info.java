package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Medicin_info extends JFrame {
    Medicin_info(){
        JButton b1,b2,b3;

        JPanel panel = new JPanel();
        panel.setBackground(new Color(226, 247, 248));
        panel.setBounds(5,45,1100,800);
        panel.setLayout(null);
        add(panel);
        JPanel panel1 =new JPanel();
        panel1.setBounds(5,5,1100,40);
        panel1.setBackground(new Color(30, 251, 253));
        add(panel1);
        JLabel label= new JLabel("MEDICINE INVENTORY");
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setBounds(360,10,300,20);
        panel1.add(label);
        JTable table = new JTable();
        table.setBackground(new Color(226, 247, 248));
        table.setBounds(6,50,1100,760);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 40, 1050, 400);
        panel.add(scrollPane);
       try {
           conn c = new conn();
           String q = "select * from Medicine";
           ResultSet resultSet = c.statement.executeQuery(q);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));
       } catch (Exception e) {
           e.printStackTrace();
       }
        JLabel label0 = new JLabel("Name");
        label0.setBounds(20,9,330,20);
        label0.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label0);
        JLabel labell =new JLabel("Dosage");
        labell.setBounds(190,9,70,20);
        labell.setFont(new Font("Tahoma",Font.BOLD,14));
        labell.setBackground(Color.black);
        panel.add(labell);
        JLabel label1 =new JLabel("Form");
        label1.setBounds(300,9,90,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setBackground(Color.black);
        panel.add(label1);
        JLabel label2 =new JLabel("Quantity Available");

        label2.setBounds(420,9,130,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setBackground(Color.black);
        panel.add(label2);
        JLabel label3 =new JLabel("Expiry Date");
        label3.setBounds(580,9,130,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setBackground(Color.black);
        panel.add(label3);
        JLabel label4 =new JLabel("Batch Number");
        label4.setBounds(720,9,130,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setBackground(new Color(15, 13, 64));
        panel.add(label4);
        JLabel label5 =new JLabel("Supplier");
        label5.setBounds(870,9,130,20);

        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setBackground(new Color(15, 13, 64));

        panel.add(label5);
        JLabel label6=new JLabel("Reorder Level");
        label6.setBounds(950,9,130,20);

        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setBackground(new Color(15, 13, 64));

        panel.add(label6);

        b1 = new JButton("Add");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(300, 500, 100, 30);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Medi_Add();
            }
        });

        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(500, 500, 100, 30); // Adjusted position
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1100,900);
        setLayout(null);

        setLocationRelativeTo(null);
        setVisible(true);


    }
    public  static  void  main(String[] args){
       new Medicin_info();
    }
}
