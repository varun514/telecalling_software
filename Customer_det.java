import javax.swing.*;
import java.awt.*;

public class Customer_det
{
	JLabel l,l1,l2,l3;
	JFrame f1;
	JTextField t1,t2,t3;
	JTextArea ta1;
	Customer_det()
	{
		f1=new JFrame("Customer_details");
		f1.setBounds(100,100,900,700);

		Font f3=new Font("Times New Roman",Font.BOLD,30);//set font for the text of software//
		Font f2=new Font("Times New Roman",Font.ITALIC,20);

		//front text//
		l=new JLabel("Customer Details Form");
		l.setBounds(300,20,400,35);
		f1.add(l);
		l.setForeground(Color.black);
		l.setFont(f3);

		//Name Label//
		l1=new JLabel("Name:-");
		l1.setBounds(75,65,150,25);
		f1.add(l1);
		l1.setForeground(Color.blue);
		l1.setFont(f2);

		//Name Text_field//
		t1=new JTextField();
		//	t1.setBounds();

		//Phone Label//
		l2=new JLabel("Mobile No:-");
		l2.setBounds(75,95,150,25);
		f1.add(l2);
		l2.setForeground(Color.blue);
		l2.setFont(f2);

		//Email_label//
		l3=new JLabel("Email_address:-");
		l3.setBounds(75,125,150,25);
		f1.add(l3);
		l3.setForeground(Color.blue);
		l3.setFont(f2);


		f1.setLayout(null);
		f1.setVisible(true);
	}
	public static void main(String arg[])
	{
		new Customer_det();
	}
}