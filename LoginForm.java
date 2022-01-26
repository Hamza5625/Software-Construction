import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
class LoginForm extends JFrame implements ActionListener{
    JTextArea t1, t2, t3;
    JButton b;
    JLabel l1, l2;
    LoginForm(){
        setTitle("Login Form");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        l1 = new JLabel("Username");
        l1.setBounds(50, 50, 100, 30);
        l2 = new JLabel("Password");
        l2.setBounds(50, 100, 100, 30);
        t1 = new JTextArea();
        t1.setBounds(200,50,150,30);

        t2 = new JTextArea();
        t2.setBounds(200,100,150,30);

        b=new JButton("Login");
        b.setBounds(50,150,80,30);
        b.addActionListener(this);

        c.add(t1);c.add(t2);c.add(b);c.add(l1); c.add(l2);
        c.setBackground(Color.green);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String name = t1.getText().toString();
        String password = t2.getText().toString();
            if(!name.equals("Hamza")|!password.equals("hamza56251")){
                JOptionPane.showMessageDialog(this,"Name or Password is not correct. Plz Try Again");
            }
            else {
                JOptionPane.showMessageDialog(this,"Successful");
                new RegistrationForm().setVisible(true);
                setVisible(false);

            }

    }
    public static void main(String args[]){
    new LoginForm();
    }
}