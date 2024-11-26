package hospital.management.system;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class report extends JFrame {
    report() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 980, 650);
        panel.setBackground(new Color(226, 247, 248));
        panel.setLayout(null);
        add(panel);
        JLabel titleLabel = new JLabel("Medical Report System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(300, 20, 300, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        JLabel IdLabel = new JLabel("Document:");
        IdLabel.setBounds(50, 80, 150, 25);
        panel.add(IdLabel);
        JComboBox<String> DocumentBox = new JComboBox<>(new String[]{"Aadhar card", "Votar Id", "Driving License"});
        DocumentBox.setBounds(200, 80, 300, 25);
        panel.add(DocumentBox);
        JLabel nameLabel = new JLabel("Number:");
        nameLabel.setBounds(50, 120, 150, 25);
        panel.add(nameLabel);
        Choice choice = new Choice();
        choice.setBounds(200,120,300,25);
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

        JLabel Label = new JLabel("Patient Name:");
        Label.setBounds(50, 160, 150, 25);
        panel.add(Label);


        JLabel In = new JLabel();
        In.setBounds(200,160,300,20);
        In.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(In);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 200, 150, 25);
        panel.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(200, 200, 300, 25);
        panel.add(ageField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 240, 150, 25);
        panel.add(genderLabel);


       JLabel RNO= new JLabel();
        RNO.setBounds(200,240,300,20);
        RNO.setFont(new Font( "Tahoma",Font.BOLD,14));
        panel.add(RNO);
        JLabel historyLabel = new JLabel("Medical History:");
        historyLabel.setBounds(50, 280, 150, 25);
        panel.add(historyLabel);

        JTextArea historyArea = new JTextArea();
        JScrollPane historyScroll = new JScrollPane(historyArea);
        historyScroll.setBounds(200, 280, 300, 100);
        panel.add(historyScroll);
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(200, 400, 100, 30);
        saveButton.setForeground(Color.white);
        saveButton.setBackground(Color.black);
        panel.add(saveButton);

        JButton Button = new JButton("Clear");
        Button.setBounds(460, 400, 100, 30);
        Button.setForeground(Color.white);
        Button.setBackground(Color.black);

        panel.add(Button);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String document = (String) DocumentBox.getSelectedItem();
               // String num = name.getText();
               // String name = nameField.getText();
                String age = ageField.getText();
               // String gender = (String) genderBox.getSelectedItem();
                String history = historyArea.getText();

                if (age.isEmpty() || history.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Patient Details Saved Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                conn c= new conn();
                try {
                    String q ="insert into   report values ('"+document+"',"+age+"','"+history+"')";

                    c.statement.executeUpdate(q);

                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();}
            }
        });
        JButton check = new JButton("Check");
        check.setBounds(320,400,120,30);
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
                        RNO.setText(resultSet.getString("Gender"));
                        In.setText(resultSet.getString("Name"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ageField.setText("");

                historyArea.setText("");
            }
        });


        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new report();
    }
}

