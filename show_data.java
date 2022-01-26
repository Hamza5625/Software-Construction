import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;




public class show_data extends JFrame implements ActionListener{
    JTextArea l1;
    JLabel l2, l3;
    JTextField f1;
    JButton btn, btn2;
    public show_data(String data) {
        setTitle("Registration Form Data");
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        l2 = new JLabel("Information Retrieved from Registration From");
        l2.setBounds(200, 20, 400, 50);
        l1 = new JTextArea("");
        l1.setBounds(20, 200, 200, 100);
        l1.setText(data);
        btn = new JButton("Logout");
        btn.setBounds(20, 400, 100, 20);
        c.add(btn);
        f1 = new JTextField();
        f1.setBounds(300, 100, 100, 20);
        c.add(f1);
        l3 = new JLabel("abdullah");
        l3.setBounds(300, 150, 100, 100);
        c.add(l3);
        btn.addActionListener(this);

        btn2 = new JButton("search");
        btn2.setBounds(400, 100, 100, 20);
        c.add(btn2);
        btn2.addActionListener(this);
        
        l1.setBackground(Color.lightGray);
        c.add(l1); c.add(l2);
        c.setBackground(Color.YELLOW);
    }

    public static void main(String[] args) {
        new show_data("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        new LoginForm().setVisible(true);
        setVisible(false);}
        

}

