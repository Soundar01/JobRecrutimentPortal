

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



import java.util.*;
public class Main {

static int loginchoice;
static boolean quit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Registration r=new Registration();
		Registration2 r2=new Registration2();
		LoginCredentials l=new LoginCredentials();
		EmployeeDeatils emp=new EmployeeDeatils(null,null,null);
		SearchModule sm=new SearchModule();
		quit=false;
		
		
		System.out.println("\n\n******JOB RECRUITMENT PORTAL******");
		System.out.println("Do you have to \n 1)signup or 2)login??\n");
		int num=sc.nextInt();
		
		
		switch(num) {
		case 1:
			System.out.println("Signup as \n 1)Recruiter \n 2)Employee\nPlease enter number 1 or 2");
			int sno=sc.nextInt();
			switch(sno) {
			case 1:
				r2.registration_recruiter();
				//l.login_rec();
				System.out.println("\n\nLogin Page!");
				sm.search_rec();
				break;
			case 2:
				r2.registration_emp();
				//l.login_emp();
				System.out.println("\n\nLogin Page!");
				sm.search_emp();
				break;
				
			}
		break;
		
case 2:
	
	
		System.out.println("\nLogin Page\n");
		
	
		try {
			do {
			System.out.println("Login as \n 1)Recruiter \n 2)Employee\nPlease enter number 1 or 2");
			loginchoice=sc.nextInt();
					
			}while(loginchoice!=1&&loginchoice!=2);//if other integer entered
			}
		catch(InputMismatchException e) {
		System.out.println("Please enter number 1 or 2 \n Refresh the page!");
			}
		switch(loginchoice) {
		case 1:
			sm.search_rec();
			break;
		case 2:
			sm.search_emp();
			break;
			
		}
		
		}
System.out.println("Page exited successfully!!");
	
	}
}
