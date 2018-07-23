import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.JFrame;
public class Login_soft implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JFrame f1,f2,f7,f8;
    JTextField t1,t2,t3,t4;
    JTextArea a1,a2;
	JButton b1,b2;
	JPasswordField p1;
    JComboBox c1,c2;
	Login_soft()
	{
		f1=new JFrame("Login");
		f1.setBounds(600,300,600,400);
		l1=new JLabel("User_ID");
		l1.setBounds(100,100,150,25);
		f1.add(l1);
		l1.setForeground(Color.red);

		Font f3=new Font("Times New Roman",Font.BOLD,30);
		l1.setFont(f3);

        t1=new JTextField();
        t1.setBounds(250,100,200,25);
        f1.add(t1);

        l2=new JLabel("Password");
        l2.setBounds(100,150,150,25);
        f1.add(l2);
        l2.setForeground(Color.blue);
		Font f4=new Font("Times New Roman",Font.BOLD,30);
		l2.setFont(f4);

        p1=new JPasswordField();
        p1.setBounds(250,150,200,25);
        f1.add(p1);
                

		b1=new JButton("login");
		b1.setBounds(150,250,100,25);
		f1.add(b1);
		b1.addActionListener(this);

		b2=new JButton("Create_New");
		b2.setBounds(300,250,150,25);
		f1.add(b2);

		b2.addActionListener(this);		

		f1.setResizable(false);
        f1.setLayout(null);
		f1.setVisible(true);
	}
	public void actionPerformed(ActionEvent e1)
	{
		String password_act=new String(p1.getPassword());
		String password="";
		if(e1.getSource()==b2)
		{
			new Sign_up();
			f1.setVisible(false);
		}
		else if(e1.getSource()==b1)
		{
			Calendar c=Calendar.getInstance();
			int timeOfDay=c.get(Calendar.HOUR_OF_DAY);
			if(timeOfDay >= 4 && timeOfDay < 12)
			{
				JOptionPane.showMessageDialog(null,"Hi "+t1.getText()+"  ,Good Morning");
			}
			else if(timeOfDay >= 12 && timeOfDay < 16)
			{
				JOptionPane.showMessageDialog(null,"Hi "+t1.getText()+"  ,Good Afternoon");
			}
			else if(timeOfDay >= 16 && timeOfDay < 21)
			{ 
				JOptionPane.showMessageDialog(null,"Hi "+t1.getText()+"  ,Good Evening");
			}
			else
			{
				/*int a=JOptionPane.showConfirmDialog(null,"Hi "+t1.getText()+" it's late,Are you Sure");
				if(a==JOptionPane.YES_OPTION)
				{
				}*/
			}
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
    			String val="SELECT emp_pass FROM empDemo WHERE emp_userid="+"'"+t1.getText()+"'";
    			Statement st=con.createStatement();
    			ResultSet rs=st.executeQuery(val);
    			while(rs.next())
    			{
    				password=rs.getString("emp_pass");
    			}
    		}
       		catch(Exception e)
    		{
    			System.out.println("Exception"+e);
    		}
    		if(password_act.equals(password))
    		{
    			System.out.println("You are logged in");
    			new After_login();
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"User_ID and Password Combination is illegal","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
    		}
		}	
	}
	public static void main(String st[])
	{
		new Login_soft();
	}
}
