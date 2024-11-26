package hospital.management.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldzNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2, r3;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(226, 247, 248));
        panel.setLayout(null);
        add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);
        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118, 11, 256, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(labelName);
        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(35, 76, 260, 14);
        labelId.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelId);
        comboBox = new JComboBox(new String[]{"Aadhar card", "Votar Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 76, 200, 14));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(35, 100, 260, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelNumber);
        textFieldzNumber = new JTextField();
        textFieldzNumber.setBounds(271, 103, 150, 20);
        panel.add(textFieldzNumber);

        JLabel labelNameo = new JLabel("Name:");
        labelNameo.setBounds(35, 130, 260, 14);
        labelNameo.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelNameo);
        textName = new JTextField();
        textName.setBounds(271, 130, 150, 20);
        panel.add(textName);
        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35, 160, 260, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelGender);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 15));
        r1.setBounds(271, 160, 80, 15);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 15));
        r2.setBounds(350, 160, 80, 15);
        panel.add(r2);
        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Tahoma", Font.BOLD, 15));
        r3.setBounds(460, 160, 80, 15);
        panel.add(r3);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(35, 198, 260, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 15));

        panel.add(labelDisease);
        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 198, 150, 20);
        panel.add(textFieldDisease);
        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(35, 245, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelRoom);
        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from  Room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 245, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setBackground(Color.white);
        panel.add(c1);
        JLabel labelDate = new JLabel("Time:");
        labelDate.setBounds(35, 280, 260, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelDate);
        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 280, 250, 14);
        date.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(date);
        JLabel labelDeposite = new JLabel("Deposite:");
        labelDeposite.setBounds(35, 310, 260, 17);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(labelDeposite);
        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 310, 150, 20);
        panel.add(textFieldDeposite);
        b1 = new JButton("Add");
        b1.setBounds(60, 370, 120, 30);
        b1.setBackground(new Color(246, 215, 118));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);
        b2 = new JButton("Back");
        b2.setBounds(240, 370, 120, 30);
        b2.setBackground(new Color(246, 215, 118));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);
        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            } else if (r3.isSelected()) {
                radioBTN = "Other";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldzNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                String q ="insert into   patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update Room set Availability ='Not Available' where room_no =" +s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();}
        }
        else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new NEW_PATIENT();
    }



}

