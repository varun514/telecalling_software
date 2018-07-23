import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sign_up implements ActionListener,MouseListener
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JFrame f1;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JTextArea a1,a2;
    JButton b1;
    JPasswordField j1,j2;
    JComboBox cb1,cb2,cb3;
    String day[]={"day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String month[]={"month","01","02","03","04","05","06","07","08","09","10","11","12"};
    String year[]={"year","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017"};
    Sign_up()
    {
    	f1=new JFrame("Create Employee Account");
    	f1.setBounds(100,100,1000,800);
    	Container c=f1.getContentPane();
    	c.setBackground(Color.cyan);

    	//Fonts//
    	Font f3=new Font("Times New Roman",Font.BOLD,30);
    	Font f2=new Font("Calibre",Font.ITALIC,20);


    	//Header//
    	l=new JLabel("Register as an employee");
    	l.setBounds(300,20,400,35);
    	f1.add(l);
    	l.setFont(f3);
    	l.setForeground(Color.black);

    	//Name Label//
		l1=new JLabel("Name:-");
		l1.setBounds(75,65,150,25);
		f1.add(l1);
		l1.setForeground(Color.blue);
		l1.setFont(f2);

		//Name Text_field//
		t1=new JTextField();
		t1.setBounds(300,65,150,25);
		f1.add(t1);
		t1.addMouseListener(this);

		//Phone Label//
		l2=new JLabel("Mobile No:-");
		l2.setBounds(75,95,150,25);
		f1.add(l2);
		l2.setForeground(Color.blue);
		l2.setFont(f2);

		//Phone TextField//
		t2=new JTextField();
		t2.setBounds(300,95,100,25);
		f1.add(t2);

		//Email_label//
		l3=new JLabel("Email_ID:-");
		l3.setBounds(75,125,150,25);
		f1.add(l3);
		l3.setForeground(Color.blue);
		l3.setFont(f2);

		//Email_Textfield//
		t3=new JTextField();
		t3.setBounds(300,125,200,25);
		f1.add(t3);

		//UserID_label//
		l4=new JLabel("Set New User_ID:-");
		l4.setBounds(75,155,170,25);
		f1.add(l4);
		l4.setForeground(Color.blue);
		l4.setFont(f2);

		//UserID_Textfield//
		t4=new JTextField();
		t4.setBounds(300,155,100,25);
		f1.add(t4);

		//Date of Birth combo box//
		l5=new JLabel("Date of birth");
		l5.setBounds(75,185,150,25);
		f1.add(l5);
		l5.setForeground(Color.blue);
		l5.setFont(f2);		

		//DOB TextField//
		cb1=new JComboBox(day);
	   	cb1.setBounds(300,185,60,25);
	    f1.add(cb1);

        cb2=new JComboBox(month);
	   	cb2.setBounds(370,185,80,25);
	   	f1.add(cb2);
            
        cb3=new JComboBox(year);
        cb3.setBounds(460,185,100,25);
	   	f1.add(cb3);

		//Password Label//
		l6=new JLabel("Create Password:-");
		l6.setBounds(75,215,175,25);
		f1.add(l6);
		l6.setForeground(Color.blue);
		l6.setFont(f2);		

		//Password TextField//
		j1=new JPasswordField();
		j1.setBounds(300,215,150,25);
		f1.add(j1);

		//Confirm Password Label//
		l7=new JLabel("Confirm Password:-");
		l7.setBounds(75,245,175,25);
		f1.add(l7);
		l7.setForeground(Color.blue);
		l7.setFont(f2);		

		//Password TextField//
		j2=new JPasswordField();
		j2.setBounds(300,245,150,25);
		f1.add(j2);

		b1=new JButton("Start");
		b1.setBounds(300,500,100,25);
		f1.add(b1);
		b1.addActionListener(this);

    	f1.setLayout(null);
    	f1.setResizable(false);
    	f1.setVisible(true);


    }

    //Abstract class mouseListener Providing body to every function//
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    //Function when some action is performed//
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==b1)
    	{
    		int confirm=1;
    		//Validation of attributes field to be filled//
    		String name=t1.getText();
    		String phone=t2.getText();
    		String email=t3.getText();
    		String user_id=t4.getText();
    		String dateBirth=cb1.getItemAt(cb1.getSelectedIndex())+"-"+cb2.getItemAt(cb2.getSelectedIndex())+"-"+cb3.getItemAt(cb3.getSelectedIndex());
    		String password=new String(j1.getPassword());
    		String confirm_password=new String(j2.getPassword());
    		if(name.equals("") || phone.equals("") || email.equals("") || user_id.equals("") || password.equals("") || confirm_password.equals(""))
    		{
    			JOptionPane.showMessageDialog(null,"Please fill all the space","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
    			confirm=0;
    		}
    		if(phone!="")
    		{	//Regex expression for checking valid mobile phone//
    			Pattern p=Pattern.compile("[6-9][0-9]{9}");
    			Matcher m=p.matcher(phone);
    			if(!(m.find() && m.group().equals(phone)))
    			{
    				JOptionPane.showMessageDialog(null,"mobile no is invalid","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
    				t2.setText("");
    				confirm=0;		
    			}
    		}
    		if(email!="")
    		{
    			Pattern p=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",Pattern.CASE_INSENSITIVE);
    			Matcher m=p.matcher(email);
    			if(!(m.find() && m.group().equals(email)))
    			{
    				JOptionPane.showMessageDialog(null,"email is invalid","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
    				confirm=0;		
    			}	
    		}
    		if(dateBirth!="")
    		{
    			Pattern p=Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
    			Matcher m=p.matcher(dateBirth);
    			try
    			{
    				if(!(m.find() && m.group().equals(dateBirth)))
    				{
    					JOptionPane.showMessageDialog(null,"Date of Birth is invalid","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
    					t5.setText("");	
    					confirm=0;
    				}
    				else if(true)
    				{	
    					String dateToValidate=cb1.getItemAt(cb1.getSelectedIndex())+"/"+cb2.getItemAt(cb2.getSelectedIndex())+"/"+cb3.getItemAt(cb3.getSelectedIndex());
    					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						sdf.setLenient(false);
						try 
						{
							//if not valid, it will throw ParseException
							Date date = sdf.parse(dateToValidate);
						}
						catch (ParseException x)
						{
							System.out.println("date is incorrect");
							JOptionPane.showMessageDialog(null,"Date of Birth is invalid","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
							confirm=0;
						}
    				}
    			}
    			catch(Exception x)
    			{
    				//Do Nothing
    			}	
    		}
    		if(password!="" && confirm_password!="")
    		{
    			if(!password.equals(confirm_password))
    			{
    				JOptionPane.showMessageDialog(null,"Both passwords do not match","WARNING WINDOW",JOptionPane.WARNING_MESSAGE);
    				confirm=0;
    				j1.setText("");
    				j2.setText("");
    			}
    		}
    		if(confirm==1)
    		{
    			try
    			{
    				Class.forName("oracle.jdbc.driver.OracleDriver");
    				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
    				String val="insert into empDemo values('"+name+"','"+phone+"','"+email+"','"+user_id+"',to_date('"+dateBirth+"','DD-MM-YYYY'),'"+password+"')";
    				Statement st=con.createStatement();
					st.executeUpdate(val);
					int a=JOptionPane.showConfirmDialog(null,"Hi You have been registered,press yes for login window");
					if(a==JOptionPane.YES_OPTION)
					{  
    					f1.setVisible(false);
    					new Login_soft();
					}
				}
				catch(Exception e2)
				{
					System.out.println("exception" +e2);
				}
    		}
    	}
    }
	public static void main(String args[])
	{
		new Sign_up();
	}
}