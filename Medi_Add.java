package hospital.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Medi_Add extends JFrame {
    Medi_Add(){
        JTextField textName,textField,textFieldDos,textFieldQuntity,textFieldBatch,textsuppler,textFieldreoder;
        JButton b1,b2;
        JDateChooser dateChooser;
        JPanel  panel = new JPanel();

        panel.setBounds(5,5,980,590);
        panel.setLayout(null);
        panel.setBackground(new Color(226, 247, 248));
        add(panel);

        JLabel labelL = new JLabel("New Medicine Add");
        labelL.setFont(new Font("Tahoma",Font.BOLD,30));
        labelL.setBounds(350,20,350,40);
        panel.add(labelL);
        JLabel label1 = new JLabel("Name :");
        label1.setFont(new Font("Tahoma",Font.PLAIN,16));
        label1.setBounds(110,130,90,30);
        panel.add(label1);
        textName = new JTextField();
        textName.setBounds(300,130,160,30);
        panel.add(textName);
        JLabel label2 = new JLabel("Dosage :");
        label2.setFont(new Font("Tahoma",Font.PLAIN,16));
        label2.setBounds(110,180,90,30);
        panel.add(label2);
        textFieldDos = new JTextField();
        textFieldDos.setBounds(300,180,160,30);
        panel.add(textFieldDos);
        JLabel label3 = new JLabel(" Form(Tablet,Syrup) :");
        label3.setFont(new Font("Tahoma",Font.PLAIN,16));
        label3.setBounds(110,240,200,30);
        panel.add(label3);
        textField = new JTextField();
        textField.setBounds(300,240,160,30);
        panel.add(textField);

        JLabel label4 = new JLabel("Quantity Available :");
        label4.setFont(new Font("Tahoma",Font.PLAIN,16));
        label4.setBounds(110,300,200,30);
        panel.add(label4);
        textFieldQuntity = new JTextField();
        textFieldQuntity.setBounds(300,300,160,30);
        panel.add(textFieldQuntity);
        JLabel label5 = new JLabel("Expiry Date :");
        label5.setFont(new Font("Tahoma",Font.PLAIN,16));
        label5.setBounds(540,130,200,30);
        panel.add(label5);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(740,130,160,30);
        panel.add(dateChooser);

        JLabel label6= new JLabel("Batch Number :");
        label6.setFont(new Font("Tahoma",Font.PLAIN,16));
        label6.setBounds(540,180,200,30);
        panel.add(label6);
        textFieldBatch = new JTextField();
       textFieldBatch.setBounds(740,180,160,30);
       panel.add(textFieldBatch);
        JLabel label7 = new JLabel("Supplier :");
        label7.setFont(new Font("Tahoma",Font.PLAIN,16));
        label7.setBounds(540,240,200,30);
        panel.add(label7);
        textsuppler = new JTextField();
        textsuppler.setBounds(740,240,160,30);
        panel.add(textsuppler);
        JLabel label8= new JLabel("Reorder Level :");
        label8.setFont(new Font("Tahoma",Font.PLAIN,16));
        label8.setBounds(540,300,200,30);
        panel.add(label8);
        textFieldreoder = new JTextField();
        textFieldreoder.setBounds(740,300,160,30);
        panel.add(textFieldreoder);
        b1 =new JButton("Submit");
        b1.setBounds(200,450,150,40);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = textName.getText();
                String s2 = textFieldDos.getText();
                String s3 = textField.getText();
                String s4 = textFieldQuntity.getText();
                Date selectedDate = dateChooser.getDate();
                String s5 = textFieldBatch.getText();
                String s6 = textsuppler.getText();
                String s7 = textFieldreoder.getText();
                if (selectedDate == null) {
                    JOptionPane.showMessageDialog(null, "Please select a date!");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(selectedDate);

                conn c= new conn();
                try {
                    String q = "insert into Medicine values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+date+"','"+s5+"','"+s6+"','"+s7+"')";
                    c.statement.executeUpdate(q);
                    setVisible(false);

                }catch (Exception E){
                    E.printStackTrace();
                }
            }

        });
        b2 = new JButton("Back");
        b2.setBounds(500,450,150,40);
        b2.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(1000,600);
        setLocation(200,150);

        setLayout(null);
        setVisible(true);

    }
    public  static  void  main(String[] args){
        new Medi_Add();
    }
}
