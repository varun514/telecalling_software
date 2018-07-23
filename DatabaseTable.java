import java.sql.*;
public class DatabaseTable
{
	DatabaseTable()
	{
		try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				String val="create table empDemo(emp_name varchar(30) NOT NULL,emp_phone varchar(10) NOT NULL,emp_email varchar(50),emp_userid varchar(30) NOT NULL,emp_DOB date,emp_pass varchar(10) NOT NULL,CONSTRAINT emp_pk PRIMARY KEY(emp_userid))";
				//String val="drop table empDemo";
				String val="create table internship(name varchar(50),land_line varchar(15),mobile1 varchar(13),mobile2 varchar(13),contact_person varchar(20),address varchar(100),email varchar(20),city varchar(10),state varchar(10)),response varchar(50),n_row int";
				Statement st=con.createStatement();
				st.executeUpdate(val);
			}
			catch(Exception e2)
			{
				System.out.println("Exception="+e2);
			}
	}
	public static void main(String st[])
	{
		new DatabaseTable();
	}
}