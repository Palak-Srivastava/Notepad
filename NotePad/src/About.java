import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
    JButton b1;
    About(){
        setBounds(330,100,700,500);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/windows.png"));
        Image i2=i1.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(150,40,400,80);
        add(l1);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image i5=i4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l2=new JLabel(i6);
        l2.setBounds(50,180,70,70);
        add(l2);

        JLabel l3=new JLabel("<html>About the Notepad Editor<br>Version 1.1, 2021<br>Notepad editor, All Rights Reserved<br><br>Notepad is a free and open source word processor<br>which allows chaning of text in a computer file. <br>Notepad is a simple text editor for basic text editing programs<br> which enables computer user to create documents.</html>");
        l3.setBounds(150,130,500,300);
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN,18));
        add(l3);

        b1=new JButton("OK");
        b1.setBounds(300,410,80,25);
        b1.addActionListener(this);
        add(b1);
    }
    public static void main(String[] args){
        new About().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
    

}
