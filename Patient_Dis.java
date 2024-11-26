package hospital.management.system;

import jdk.jfr.RecordingState;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import  java.util.Date;
import java.awt.*;

public class Patient_Dis extends JFrame {
    Patient_Dis(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,400);
        panel.setBackground(new Color(213, 251, 253));
         panel.setLayout(null);
         add(panel);
         JLabel label = new JLabel("CHECK-OUT");
         label.setBounds(100,20,300,20);
         label.setFont(new Font( "Tahoma",Font.BOLD,20));
         panel.add(label);
         JLabel label1= new JLabel("Customer Id -");
         label1.setBounds(30,80,150,22);
         label1.setFont(new Font("Tahoma",Font.BOLD,14));
         panel.add(label1);
         Choice choice = new Choice();
         choice.setBounds(200,80,150,25);
         panel.add(choice);
         try {
             conn c =new conn();
             ResultSet resultSet = c.statement.executeQuery("select  * from  Patient_info");
             while ( resultSet.next()){
                 choice.add(resultSet.getString("number"));
             }
         }catch (Exception e){
             e.printStackTrace();
         }
        JLabel label3 = new JLabel("Room Number -");
        label3.setBounds(30,130,300,20);
        label3.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(label3);
        JLabel RNO = new JLabel();
        RNO.setBounds(200,130,300,20);
        RNO.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(RNO);
        JLabel label4 = new JLabel("In Time -");
        label4.setBounds(30,180,300,20);
        label4.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(label4);
        JLabel In = new JLabel();
        In.setBounds(200,180,300,20);
        In.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(In);
        JLabel label5 = new JLabel("Out Time -");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(label5);
        Date date = new Date();
        JLabel OUTtime = new JLabel(""+date);
        OUTtime.setBounds(200,230,300,20);
        OUTtime.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(OUTtime);
        JButton dicharge = new JButton("Discharge");
        dicharge.setBounds(30,300,120,30);
        dicharge.setBackground(Color.BLACK);
        dicharge.setForeground(Color.white);
        panel.add(dicharge);
        dicharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from Patient_info where  number ='" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update  room set Availability ='Available' where  room_no = '"+RNO.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }

        });
        JButton check = new JButton("Check");
        check.setBounds(160,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from  Patient_info where number ='"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        RNO.setText(resultSet.getString("Room"));
                        In.setText(resultSet.getString("Time"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
         back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
             }
         });
         setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }
    public  static  void  main(String[] args){
        new Patient_Dis();
    }
}
