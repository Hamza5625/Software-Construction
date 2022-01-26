import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;


class RegistrationForm extends JFrame implements ActionListener{
    Connection con=null;
    PreparedStatement stmt=null;
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JTextField Name, Id, Batch_Advisor;
    JRadioButton C_yes, C_no, F_yes, F_no;
    JComboBox day, month, year;
    JTextArea sub;
    JCheckBox terms;
    JButton submit;
    JLabel msg, msg2, msg3, msg4, msg5, msg6, msg7;

    RegistrationForm(){
        setTitle("Registration Form");
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("Name");
        label1.setBounds(20,50,100,20);
        c.add(label1);
        Name = new JTextField();
        Name.setBounds(130,50,100,20);
        c.add(Name);

        label2 = new JLabel("ID");
        label2.setBounds(20,100,100,20);
        c.add(label2);
        Id = new JTextField();
        Id.setBounds(130,100,100,20);
        c.add(Id);

        label3 = new JLabel("Batch Advisor");
        label3.setBounds(20,150,100,20);
        c.add(label3);
        Batch_Advisor = new JTextField();
        Batch_Advisor.setBounds(130,150,100,20);
        c.add(Batch_Advisor);

        label7 = new JLabel("Fee Cleared?");
        label7.setBounds(20,200,100,20);
        c.add(label7);
        F_yes = new JRadioButton("Yes");
        F_no = new JRadioButton("No");
        F_yes.setBounds(130,200,80,20);
        F_no.setBounds(220,200,80,20);
        F_yes.setSelected(true);
        c.add(F_yes);
        c.add(F_no);
        ButtonGroup F = new ButtonGroup();
        F.add(F_yes);
        F.add(F_no);
        label3 = new JLabel("CGPA>2.25");
        label3.setBounds(20,250,100,20);
        c.add(label3);

        C_yes = new JRadioButton("Yes");
        C_no = new JRadioButton("No");
        C_yes.setBounds(130,250,80,20);
        C_no.setBounds(220,250,80,20);
        C_yes.setSelected(true);
        c.add(C_yes);
        c.add(C_no);
        ButtonGroup C = new ButtonGroup();
        C.add(C_yes);
        C.add(C_no);

        label4 = new JLabel("Registration Date");
        label4.setBounds(20,300,100,20);
        c.add(label4);
        String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String years[] = {"2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);
        day.setBounds(130,300,50,20);
        month.setBounds(190,300,50,20);
        year.setBounds(250,300,60,20);
        c.add(day);
        c.add(month);
        c.add(year);

        label5 = new JLabel("Subjects");
        label5.setBounds(20,350,100,20);
        c.add(label5);
        sub = new JTextArea();
        sub.setBounds(130,350,200,50);
        c.add(sub);

        terms = new JCheckBox("Accept Terms and Condition");
        terms.setBounds(50,410,250,20);
        c.add(terms);

        submit = new JButton("Submit");
        submit.setBounds(150,520,80,20);
        c.add(submit);
        submit.addActionListener(this);

        msg = new JLabel("");
        msg.setBounds(20,450,250,20);
        c.add(msg);

        msg2 = new JLabel("");
        msg2.setBounds(250,450,250,20);
        c.add(msg2);
       
        msg4 = new JLabel("");
        msg4.setBounds(600,450,250,20);
        c.add(msg4);
      
        msg7 = new JLabel("");
        msg7.setBounds(250,480,250,20);
        c.add(msg7);

        c.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }
    
    private boolean validateName() {
        String N = Name.getText().toString().trim();
        if (N.isEmpty()) {
            msg.setText("Name is Required!");
            return false;
        } else {
            msg.setText("");
            return true;}
        }
    private boolean validateID() {
        String id = Id.getText().toString().trim();
        if (id.isEmpty()) {
            msg2.setText("ID is Required!");
            return false;
        } else {
            msg2.setText("");
            return true;}
        }
    private boolean validateSub() {
        String add = sub.getText().toString().trim();
        if (add.isEmpty()) {
            msg4.setText("Subjects is Required!");
            return false;
        } else {
            msg4.setText("");
            return true;}
        }
    private boolean validateCheck() {
        if (!terms.isSelected()){
            msg7.setText("Accept Terms and Condition To Submit!");
            return false;
        } else {
            msg7.setText("");
            return true;}
        }
    public void actionPerformed(ActionEvent e){

        if (!validateName()|!validateID()|!validateSub()|!validateCheck()){
            return;
        }
        String name = Name.getText().toString().trim();
        String ID = Id.getText().toString().trim();
        String Advisor = Batch_Advisor.getText().toString().trim();
        String Subjects = sub.getText().toString().trim();
        String dor = day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem();
        // try {
        //     try {
        //         Class.forName("com.mysql.jdbc.Driver");
        //     } catch (ClassNotFoundException e1) {
        //         // TODO Auto-generated catch block
        //         e1.printStackTrace();
        //     }
        //         con=DriverManager.getConnection(
        //         "jdbc:mysql://localhost:3306/registration_app","root","");
        //         String query= "INSERT INTO `student` (`Name`, `Batch_Advisor`) VALUES ('basit', 'hamza');)";
        //         stmt=con.prepareStatement(query);
        //         // stmt.setString(1,id.getText());
        //         // stmt.setString(1,name);
        //         // stmt.setString(2, Advisor);
        //         stmt.executeUpdate();
        //         con.close();
        //         System.out.println("Succesful");
    
        //     } catch (SQLException e1) {
        //         // TODO Auto-generated catch block
        //         System.out.println("Not Succesful");

        //         e1.printStackTrace();
        //     }

        if(C_yes.isSelected()&&F_yes.isSelected())
        {
            String Data = "Name : " +name+"\n"+"ID : "+ID+"\n"+"Batch Advisor : " +Advisor+"\n"+"Registration Date : "+dor+"\n"+"Subjects : "+Subjects;
            new show_data(Data).setVisible(true);
            setVisible(false);
            try {

                FileWriter fw = new FileWriter("Registration_Database.txt");
                fw.write("Name: "+name+"\nID: ");
                fw.write(ID+"\nBatch Advisor:");
                fw.write(Advisor+"\nDate-Of_Birth: ");
                fw.write(dor+"\nSubjects: ");
                fw.write(Subjects+"\n");
                fw.close();

            } catch (IOException e1) {
                // Auto-generated catch block
                e1.printStackTrace();
            }

        } else {
            showMessageDialog(null, ID+":Fee Defaulter or CPA does not meet the registration criteria!");

        }
    }
    public static void main(String args[]){
        new RegistrationForm();

    }
}
// String x = f1.getText().toString();
//                 if(!x.equals("18013065006")){
//                     l3.setText("No Record Found");
//                 } else {
//                     String info = "Name: Hamza Abbas\nID: 18013065006\nFees Status: NO Defaulter\nCGPA: 3.00";
//                     l3.setText(info);
//                 }