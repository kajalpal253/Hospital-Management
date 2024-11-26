package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



public class Employee_inf extends JFrame {


        Employee_inf(){
            JPanel panel = new JPanel();
            panel.setBounds(5,40,990,580);
            panel.setBackground(new Color(213, 251, 253));
            panel.setLayout(null);
            add(panel);
            JPanel panel1 =new JPanel();
            panel1.setBounds(5,5,980,40);
            panel1.setBackground(new Color(30, 251, 253));
            add(panel1);
            JLabel label= new JLabel("EMPLOYEE INFORMATION");
            label.setFont(new Font("Tahoma",Font.BOLD,20));
            label.setBounds(360,10,300,20);
            panel1.add(label);
            JTable table =new JTable();
           table.setBounds(10,40,980,450);
            table.setBackground(new Color(226, 247, 248));
            table.setFont(new Font("Tahoma",Font.BOLD,12));
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(5, 40, 1050, 400);
            panel.add(scrollPane);



            try {
                conn c =new conn();
                String q = "select * from EMP_INF";
                ResultSet resultSet =c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));


            }catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);


            }
           JLabel label0 = new JLabel("Employee ID");
           label0.setBounds(20,9,330,20);
            label0.setFont(new Font("Tahoma",Font.BOLD,14));
            panel.add(label0);
            JLabel labell =new JLabel("Name");
            labell.setBounds(190,9,70,20);
            labell.setFont(new Font("Tahoma",Font.BOLD,14));
            labell.setBackground(Color.black);
            panel.add(labell);
            JLabel label1 =new JLabel("Age");
            label1.setBounds(340,9,70,20);
            label1.setFont(new Font("Tahoma",Font.BOLD,14));
            label1.setBackground(Color.black);
            panel.add(label1);
            JLabel label2 =new JLabel("Phone Number");
            label2.setBounds(450,9,130,20);
            label2.setFont(new Font("Tahoma",Font.BOLD,14));
            label2.setBackground(Color.black);
            panel.add(label2);
            JLabel label3 =new JLabel("Salary");
            label3.setBounds(600,9,130,20);
            label3.setFont(new Font("Tahoma",Font.BOLD,14));
            label3.setBackground(Color.black);
            panel.add(label3);
            JLabel label4 =new JLabel("Email");
            label4.setBounds(750,9,130,20);
            label4.setFont(new Font("Tahoma",Font.BOLD,14));
            label4.setBackground(new Color(15, 13, 64));
            panel.add(label4);
            JLabel label5 =new JLabel("Department");
            label5.setBounds(870,9,130,20);

            label5.setFont(new Font("Tahoma",Font.BOLD,14));
            label5.setBackground(new Color(15, 13, 64));

            panel.add(label5);
            JButton button =new JButton("Back");
            button.setBounds(300,800,120,30);
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

           setSize(1000,600);
           setLocation(200,150);
            setLocationRelativeTo(null);

            setLayout(null);
            setVisible(true);
        }

        public  static  void main(String[] args){
            new Employee_inf();
        }


}