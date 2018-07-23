import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class After_login implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5;
	JFrame f1;
	JTextField t1,t2,t3;
	JTextArea t4;
	JComboBox cb1;
	String name,mobile1,mobile2,landline;
	String option[]={"choose","Ringing","engage","Out of range","Switch Off","Wrong Number","picked up"};
	JButton jb1,jb2;
	int x=1,rownum=1;
	After_login()
	{
		f1=new JFrame("Logged In");
		f1.setBounds(100,100,1000,800);

		//Fonts//
		Font f3=new Font("Times New Roman",Font.BOLD,30);
    	Font f2=new Font("Calibre",Font.ITALIC,20);

		l=new JLabel("Welcome");
		l.setBounds(300,20,400,35);
    	f1.add(l);
    	l.setFont(f3);   
    	l.setForeground(Color.black);

    	l1=new JLabel("Start calling");
    	l1.setBounds(75,65,150,25);
    	f1.add(l1);
    	l1.setFont(f2);
    	l1.setForeground(Color.red);

    	l2=new JLabel("  Land-line  /  Mobile1  /  Mobile2  ");
    	l2.setBounds(300,95,450,20);
    	f1.add(l2);

    	l3=new JLabel("Company name:-");
    	l3.setBounds(75,150,150,25);
    	f1.add(l3);
    	l3.setFont(f2);
    	l3.setForeground(Color.red);

    	l4=new JLabel("name");
    	l4.setBounds(300,150,150,25);
    	f1.add(l4);
    	l4.setFont(f3);

    	l5=new JLabel("Response:-");
    	l5.setBounds(75,185,120,30);
    	f1.add(l5);
    	l5.setFont(f2);
    	l5.setForeground(Color.red);

    	t1=new JTextField();
    	t1.setBounds(300,65,150,25);
    	f1.add(t1);
		t2=new JTextField();
    	t2.setBounds(460,65,150,25);
    	f1.add(t2);
    	t3=new JTextField();
    	t3.setBounds(620,65,150,25);
    	f1.add(t3);

    	jb1=new JButton("Show");
    	jb1.setBounds(300,600,100,25);
    	f1.add(jb1);
    	jb1.addActionListener(this);

    	jb2=new JButton("Submit");
    	jb2.setBounds(300,250,100,25);
    	f1.add(jb2);
    	jb2.addActionListener(this);

    	cb1=new JComboBox(option);
	   	cb1.setBounds(300,185,100,30);
	    f1.add(cb1);

		f1.setResizable(false);
		f1.setLayout(null);
		f1.setVisible(true);

	}
	public void actionPerformed(ActionEvent e1)
	{
		int row=rownum-1;
		if(e1.getSource()==jb1)
			{
				try
				{
					String value=Integer.toString(rownum);
					Class.forName("oracle.jdbc.driver.OracleDriver");
    				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
    				String val="SELECT contact_person,land_line,mobile1,mobile2 FROM internship WHERE n_row="+rownum;
    				Statement st=con.createStatement();
    				ResultSet rs=st.executeQuery(val);
    				while(rs.next())
    				{
    					name=rs.getString("contact_person");
    					landline=rs.getString("land_line");
    					mobile1=rs.getString("mobile1");
    					mobile2=rs.getString("mobile2");
    					t1.setText(landline);
    					t2.setText(mobile1);
    					t3.setText(mobile2);
    					l4.setText(name);
    					l4.setForeground(Color.blue);
    					jb1.setText("next");
    				}
    				rownum++;
    			}
       			catch(Exception e)
    			{
    				System.out.println("Exception"+e);
    			}
			}
		if(e1.getSource()==jb2)
		{
			/*try
				{
					String value=Integer.toString(rownum);
					Class.forName("oracle.jdbc.driver.OracleDriver");
    				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
    				String val="update internship set response="+"'"+t4.getText()+"'"+"where n_row="+row;
    				Statement st=con.createStatement();
    				st.executeUpdate(val);
    				JOptionPane.showMessageDialog(null,"Response Updated");
    				t4.setText("");
    			}
       			catch(Exception e)
    			{
    				System.out.println("Exception"+e);
    			}
    		*/
    		if(cb1.getSelectedIndex()==6)
    		{
    			
    		}
		}
	}
	public static void main(String args[])
	{
		new After_login();
	}
}