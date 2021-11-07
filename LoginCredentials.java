import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginCredentials {
	Scanner sc=new Scanner(System.in);
	boolean status;
public boolean login_emp() {
try {
	   String databaseUsername = "";
	    String databasePassword = "";
	System.out.println("Enter User name:");
	String emp_user=sc.next();
	System.out.println("Enter the password:");
	String emp_pass=sc.next();
	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/JobPortalProject","root","Ketki@99");
	//System.out.println("Database connected successfully");
	Statement stmt=con.createStatement();
	//int irs=stmt.executeUpdate("insert into manager_tbl"+"(manager_id,manager_name,manager_city)"+"values"+"(150,'John','up')");
 String SQL = "SELECT * FROM emp_login WHERE username='" + emp_user + "' && pass_word='" + emp_pass+ "'";

 ResultSet rs = stmt.executeQuery(SQL);

         // Check Username and Password
 while (rs.next()) {
     databaseUsername = rs.getString("username");
     databasePassword = rs.getString("pass_word");
 }

 if (emp_user.equals(databaseUsername) && emp_pass.equals(databasePassword)) {
     System.out.println("Successful Login!\n----");
     System.out.println("Your details are");
     ResultSet rs1=stmt.executeQuery("Select * from emp_details where emp_username='"+emp_user+"'");
   while(rs1.next())
		System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
     status=true;
     
 } else {
     System.out.println("Incorrect Password\n----");
     status=false;
     
 }
	con.close();
}
catch(Exception e) {
	System.out.println(e);
	
}
return status;
}
public boolean login_rec() {
	try {
		   String databaseUsername = "";
		    String databasePassword = "";
		System.out.println("Enter User name:");
		String rec_user=sc.next();
		System.out.println("Enter the password:");
		String rec_pass=sc.next();
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/JobPortalProject","root","Ketki@99");
		
		Statement stmt=con.createStatement();
		//int irs=stmt.executeUpdate("insert into manager_tbl"+"(manager_id,manager_name,manager_city)"+"values"+"(150,'John','up')");
	    String SQL = "SELECT * FROM rec_login WHERE username='" + rec_user + "' && pass_word='" + rec_pass+ "'";

	    ResultSet rs = stmt.executeQuery(SQL);

	            // Check Username and Password
	    while (rs.next()) {
	        databaseUsername = rs.getString("username");
	        databasePassword = rs.getString("pass_word");
	    }

	    if (rec_user.equals(databaseUsername) && rec_pass.equals(databasePassword)) {
	        System.out.println("Successful Login!\n----");
	        System.out.println("Your details are");
	        
	        ResultSet rs1=stmt.executeQuery("Select * from rec_details where rec_username='" + rec_user+"'");
	      while(rs1.next())
			System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
	        status=true;
	    } else {
	        System.out.println("Incorrect Password\n----");
	        status=false;
	    }
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return status;
}
	
}
