package com.slot1hibernate;



import java.util.List;
import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	int Id,salary,hike,experience,contract,choice=0;
    	String name;
    	
    	// CREATING OBJECT OF EMPLOYEE
    	employee1 emp = new employee1 ();
    	// CREATING OBJECT OF FRESHER EMPLOYEE
    	FresherEmployee femp = new FresherEmployee();
    	// CREATING OBJECT OF EXPERIENCED EMPLOYEE
    	ExperienceEmployee Eemp = new ExperienceEmployee();	
    	//CREATING OBJECT OF EMPLOYEE DAO
    	employee1dao dao = new employee1dao();
    	
    	while(choice<7) {
    		System.out.println("\t\t\tWELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
			System.out.println("\nPress 1 - New Register \nPress 2 - Register as Fresher \nPress 3 - Rgister as Experienced \nPress 4 - Print Employee \nPress 5 - Print All Employee \nPress 6 - Remove Employee \nPress 7 - Exit");
			System.out.print("ENTER CHOICE : ");
			choice = scan.nextInt();
			
			
			switch(choice) {
			
			// To Add Employee
			case 1->{
				System.out.print("Enter Name : ");
				name = scan.next();
				emp.setEmpName(name);
				
				dao.connect();
				dao.registerEmp(emp);
				System.out.println(emp);
				
				dao.disconnect();
			}
			
			// To Add Fresher Employee
			case 2->{
				System.out.print("Enter Name : ");
				name = scan.next();
				femp.setEmpName(name);
				System.out.print("Enter Salary : ");
				salary = scan.nextInt();
				femp.setSalary(salary);
				System.out.print("Enter Contract Period : ");
				contract = scan.nextInt();
				femp.setContractPeriod(contract);
				System.out.print("Enter Increment : ");
				hike = scan.nextInt();
				femp.setIncrement(hike);
				
				dao.connect();
				dao.registerEmp(femp);
				System.out.println(femp);
				
				dao.disconnect();
			}
		
			// To Add Experienced Employee
			case 3->{
				System.out.print("Enter Name : ");
				name = scan.next();
				Eemp.setEmpName(name);
				System.out.print("Enter Salary : ");
				salary = scan.nextInt();
				Eemp.setSalary(salary);
				System.out.print("Enter Experience : ");
				experience = scan.nextInt();
				Eemp.setExperience(experience);
				System.out.print("Enter hike : ");
				hike = scan.nextInt();
				Eemp.setHike(hike);
				
				dao.connect();
				dao.registerEmp(Eemp);
				System.out.println(Eemp);
				
				dao.disconnect();
			}
			
			// To Fetch Employee Detail
			case 4 ->{
				System.out.print("Enter Id : ");
				Id = scan.nextInt();
				
				dao.connect();
				try {
				emp = dao.fetchEmp(Id);
				System.out.println(emp);
				}
				catch(Exception e) {
					System.out.println("Employee does not exist");
				}
				
				dao.disconnect();
			}
			
			// To Fetch Details Of All Employees
			case 5 ->{
				
				
				dao.connect();
				List<employee1> empl = dao.fetchAll();
				
				dao.disconnect();
				for(employee1 e : empl)
					System.out.println(e);
			}
			
			// To Delete Employee
			case 6 ->{
				
				dao.connect();
				System.out.print("Enter Id : ");
				Id = scan.nextInt();
				int ret = dao.deleteEmp(Id);				
				
				dao.disconnect();
				if (ret==1)
					System.out.println("Employee removed Successfully");
				else
					System.out.println("OOPS!!--Employee does not exist--");
			}
			}
    	}
    	
    	// Closing Scanner Object
    	scan.close();
    }
}