import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Registration2 extends Detail{
	public void registration_recruiter() {
		Scanner sc=new Scanner(System.in);
		try {
			   String databaseUsername = "";
			    String databasePassword = "";
		
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/JobPortalProject","root","Ketki@99");
		System.out.println("Enter User name:");
			String rec_username=sc.next();
			System.out.println("Set your password");
			String pass_word=sc.next();
			System.out.println("Enter Name:");
			String rec_name=sc.next();
			System.out.println("Enter Skill req:");
			String rec_skill_req=sc.next();
			System.out.println("Enter Location:");
			String rec_loc=sc.next();
			System.out.println("Enter Company name:");
			String rec_company=sc.next();
		
			//System.out.println("Database connected successfully");
			Statement stmt=con.createStatement();
			//int irs=stmt.executeUpdate("insert into manager_tbl"+"(manager_id,manager_name,manager_city)"+"values"+"(150,'John','up')");
			int irs=stmt.executeUpdate("insert into rec_details"+"(rec_username,rec_name,rec_skill_req,rec_loc,rec_company) values ('"+rec_username+"','"+rec_name+"','"+rec_skill_req+"','"+rec_loc+"','"+rec_company+"')");
			int irs1=stmt.executeUpdate("insert into rec_login"+"(username,pass_word) values ('"+rec_username+"','"+pass_word+"')");
			//ResultSet rs=stmt.executeQuery("Select * from rec_details where rec_username=rec_username");
			
	
			//while(rs.next())
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			con.close();
			//con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}
	public void registration_emp() {
		Scanner sc=new Scanner(System.in);
		try {
			   String databaseUsername = "";
			    String databasePassword = "";
		
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/JobPortalProject","root","Ketki@99");
		System.out.println("Enter User name:");
			String emp_username=sc.next();
			System.out.println("Set your password");
			String pass_word=sc.next();
			System.out.println("Enter Name:");
			String emp_name=sc.next();
			System.out.println("Enter Skill req:");
			String emp_skill_req=sc.next();
			System.out.println("Enter Location:");
			String emp_loc=sc.next();
		
			//System.out.println("Database connected successfully");
			Statement stmt=con.createStatement();
			//int irs=stmt.executeUpdate("insert into manager_tbl"+"(manager_id,manager_name,manager_city)"+"values"+"(150,'John','up')");
			int irs=stmt.executeUpdate("insert into emp_details"+"(emp_username,emp_name,emp_skill,emp_loc) values ('"+emp_username+"','"+emp_name+"','"+emp_skill_req+"','"+emp_loc+"')");
			int irs1=stmt.executeUpdate("insert into emp_login"+"(username,pass_word) values ('"+emp_username+"','"+pass_word+"')");
			//ResultSet rs=stmt.executeQuery("Select * FROM emp_details where emp_username='"+emp_username+"'");
			
	
			//while(rs.next())
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			con.close();
			//con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
