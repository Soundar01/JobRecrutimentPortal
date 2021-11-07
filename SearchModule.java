import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchModule {
	static boolean quit;
public void search_rec() {while(!quit)
{
	LoginCredentials l=new LoginCredentials();
	Scanner sc=new Scanner(System.in);
	Registration r=new Registration();
	if(l.login_rec()==true) {
System.out.println("\n**********SEARCH MODULE**********\n");
String c=null;
do {
System.out.println("Enter skill");
String skill_emp=sc.next();
try {
	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/JobPortalProject","root","Ketki@99");
	Statement stmt=con.createStatement();
	ResultSet rs1=stmt.executeQuery("Select * from emp_details where emp_skill='" + skill_emp+"'");
	

	
System.out.println("\n***EMPLOYEE DETAILS***\n");
String y1=null;
int count=0;
String name=null;
while(rs1.next())
y1=rs1.getString(3);
//System.out.println(y1);
if(y1!=null)
	{
	ResultSet rs3=stmt.executeQuery("Select * from emp_details where emp_skill='" + skill_emp+"'");
	while(rs3.next()) {

		System.out.println(rs3.getString(1)+" "+rs3.getString(2)+" "+rs3.getString(3)+" "+rs3.getString(4));
		count++;
	}
	if(count>1) {
		System.out.println("Enter the username of Employee that you want to recruit");
		 name=sc.next();
	}
	else {
		 name=rs3.getString(2);
	}
		System.out.println("\nDo you want to recruit " +name+" ??\n Y or N ?");
		String grb=sc.nextLine();
		String y=sc.nextLine();
		
		switch(y) {
		
		case "Y":
			System.out.println("You will receive the contact details of this employee shortly");
			System.out.println("You can search for other skills as well.");
			break;
		
		case "N":
		
			System.out.println("\nYou can search for other skills listed below:\n");
			ResultSet rs2=stmt.executeQuery("Select * from emp_details ");
			while(rs2.next()) {
				System.out.println(rs2.getString(3));
			}
			break;
		}}
		else {
			System.out.println("There is no item match for your search");
			
			System.out.println("\nYou can search for other skills listed below:\n");
			ResultSet rs4=stmt.executeQuery("Select * from emp_details ");
			while(rs4.next()) {
				System.out.println(rs4.getString(3));
			}
		}
//con.close();
}
catch(Exception e) {
	System.out.println(e);
}
		System.out.println("Do you want to continue?\n Y or N?");
		c=sc.next();
		}while(c.equalsIgnoreCase("Y"));
quit=true;

}
else {
System.out.println("Please enter the correct username and password.");
quit=false;
}}
	
}
public void search_emp() {
	LoginCredentials l=new LoginCredentials();
	Scanner sc=new Scanner(System.in);
	Registration r=new Registration();
	EmployeeDeatils emp=new EmployeeDeatils(null,null,null);
	while(!quit)
	{

		if(l.login_emp()==true) {
	
	
	
	System.out.println("\n***Search Module***");
	String c=null;
	do {
	System.out.println("Enter skill");
	String skill_rec=sc.next();
	//System.out.println("Enter location");
	//String loc_rec=sc.next();
	System.out.println("\n***RECRUITER DETAILS***\n");
	//r.registration_recruiter(skill_rec);
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/JobPortalProject","root","Ketki@99");
		Statement stmt=con.createStatement();
		ResultSet rs1=stmt.executeQuery("Select * from rec_details where rec_skill_req='" + skill_rec+"'");
		
	
		String y1=null;
		String name=null;
		int count =0;
		while(rs1.next())
		y1=rs1.getString(3);
		//System.out.println(y1);
		if(y1!=null)
			{
			ResultSet rs3=stmt.executeQuery("Select * from rec_details where rec_skill_req='" + skill_rec+"'");
			while(rs3.next()) {
				System.out.println(rs3.getString(1)+" "+rs3.getString(2)+" "+rs3.getString(3)+" "+rs3.getString(4)+" "+rs3.getString(5));
				count++;
			}
	if(count>1) {
		System.out.println("Please enter the company name that you apply.");
		name=sc.next();
	}
	else {
		name=rs3.getString(5);
	}
	
	System.out.println("\nDo you want to apply in "+name+" ??\n Y or N ?");
	String grb=sc.nextLine();
	String y=sc.nextLine();
	
	switch(y) {
	
	case "Y":
		System.out.println("You will receive a call for an interview shortly!");
		System.out.println("You can search for other jobs as well.");
		break;
	
	case "N":
		
		System.out.println("\nYou can search for other skills listed below:\n");
		ResultSet rs2=stmt.executeQuery("Select * from rec_details ");
		while(rs2.next()) {
			System.out.println(rs2.getString(3));
		}
		break;
	}}
	else {
		System.out.println("There is no item match for your search");
		System.out.println("You can search for other skills listed below:");
		ResultSet rs4=stmt.executeQuery("Select * from rec_details ");
		while(rs4.next()) {
			System.out.println(rs4.getString(3));
		}
	}}
	catch(Exception e) {
		System.out.println(e);
	}
	System.out.println("Do you want to continue?\n Y or N?");
	c=sc.next();
	}while(c.equalsIgnoreCase("Y"));
	quit=true;
	
}
else {
	System.out.println("Please enter the correct username and password.");
	quit=false;
}}
}
}
