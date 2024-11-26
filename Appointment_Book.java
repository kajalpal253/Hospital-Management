package hospital.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Appointment_Book extends JFrame {
    Appointment_Book(){
        JComboBox comboBox;
        JTextField textFieldzNumber, textName, textFieldAge;
        JRadioButton r1, r2, r3;
        JDateChooser dateChooser;
        JSpinner  jtime;

        Choice c1;
        JLabel date;
        JButton b1, b2;
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(226, 247, 248));
        panel.setLayout(null);
        add(panel);

        JLabel label1 =new JLabel("Appointment Booking");
        label1.setBounds(124,11,300,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);
        JLabel labelId = new JLabel("ID :");
        labelId.setBounds(70, 70, 260, 15);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(labelId);
        comboBox = new JComboBox(new String[]{"Aadhar card", "Votar Id", "Driving License"});
        comboBox.setBounds(271, 70, 150, 20);
        comboBox.setBackground(new Color(3, 76, 200, 14));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);
        JLabel label2 =new JLabel("Number :");
        label2.setBounds(70,100,200,15);
        label2.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(label2);
        textFieldzNumber = new JTextField();
        textFieldzNumber.setBounds(271, 100, 150, 20);
        panel.add(textFieldzNumber);
        JLabel labelNameo = new JLabel("Name :");
        labelNameo.setBounds(70, 130, 200, 14);
        labelNameo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(labelNameo);
        textName = new JTextField();
        textName.setBounds(271, 130, 200, 20);
        panel.add(textName);
        JLabel label3 =new JLabel("Age:");
        label3.setBounds(70,160,30,20);
        label3.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(label3);
        textFieldAge  = new JTextField();
        textFieldAge.setBounds(271,160,200,20);
        panel.add(textFieldAge);
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(70, 190, 260, 14);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(labelGender);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        r1.setBounds(271, 190, 80, 15);
        panel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        r2.setBounds(350, 190, 80, 15);
        panel.add(r2);
        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        r3.setBounds(460, 190, 80, 15);
        panel.add(r3);
        JLabel labelRoom = new JLabel("Department :");
        labelRoom.setBounds(70, 220, 160, 14);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(labelRoom);
        c1 = new Choice();
        try{
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Department");
            while (resultSet.next()){

                c1.add(resultSet.getString("Department"));
            }
            c1.setBounds(271, 220, 200, 20);
            c1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            c1.setBackground(Color.white);
            panel.add(c1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel label4 = new JLabel("Date :");
        label4.setBounds(70, 270, 200, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(label4);
        dateChooser = new JDateChooser();

        dateChooser.setBounds(271, 270, 200, 25);
        panel.add(dateChooser);
        JLabel label5 = new JLabel("Time :");
        label5.setBounds(70, 300, 200, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(label5);
        jtime= new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jtime ,"HH:mm");
        jtime.setEditor(timeEditor);
        jtime.setBounds(271, 300, 200, 25);
       panel.add(jtime);



        b1 = new JButton("Submit");
        b1.setBounds(100, 400, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idType = (String) comboBox.getSelectedItem();
                String idNumber = textFieldzNumber.getText();
                String name = textName.getText();
                String age = textFieldAge.getText();
                String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "Other";
                String department = c1.getSelectedItem();
               Date selectedDate = dateChooser.getDate();
               Date selectTime =(Date) jtime.getValue();



                if (selectedDate == null) {
                    JOptionPane.showMessageDialog(null, "Please select a date!");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(selectedDate);
                SimpleDateFormat timeforment = new SimpleDateFormat("HH:mm");
                String  time = timeforment.format(selectTime);
                conn c = new conn();
                    try{
                       String  q ="insert into Appointment values( '"+idType+"','"+idNumber+"','"+name+"','"+age+"','"+gender+"','"+department+"','"+date+"','"+time+"')";
                        c.statement.executeUpdate(q);
                        //JOptionPane.showMessageDialog(null, "A");

                        setVisible(false);
                    } catch (Exception E) {
                        E.printStackTrace();
                    }




                JOptionPane.showMessageDialog(null, "Appointment Details:\n"
                        + "ID Type: " + idType + "\n"
                        + "ID Number: " + idNumber + "\n"
                        + "Name: " + name + "\n"
                        + "Age: " + age + "\n"
                        + "Gender: " + gender + "\n"
                        + "Department: " + department + "\n"
                        + "Date: " + date+"\n"
                        + "Time:"+time);
            }
        });

        panel.add(b1);
      b2 = new JButton("Back");
      b2.setBounds(300,400,100,30);
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
        setSize(950,500);
       setLayout(null);
       setLocation(400,250);
       setVisible(true);
    }
    public static  void main(String[] args){
        new Appointment_Book();
    }
}
