/**
 * Student Management System To Create Student,Laptop And Add In DataBase Using Hibernate
 * And Print Data Of One Or All Students And Laptops,Delete Students using Data Access Object 
 * ONE TO MANY MAPPING OF ENTITY IN DATABASE USING HIBERNATE
 * ONE STUDENT -> MANY LAPTOP
 * By Renu
 */


package com.slot1hibernate;

//One To Many
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner bs = new Scanner(System.in);
		int id,age,ram, op = 0,n;
		String name,phone;
		List<laptop1> lapList = new ArrayList<laptop1>();
		List<student1> stList = new ArrayList<student1>();
		
		student1 s = new student1();
		
		laptop1 l = new laptop1();
		
		student1dao dao = new student1dao();
		
		while(op<7) {
			System.out.println("\nPress 1 - Add Student \nPress2 - Print Student \nPress 3 - Print Laptop \nPress 4 - Print All Student \nPress5 - Print All Laptop \nPress 6 - Remove Student ");
			System.out.print("Enter Operation : ");
			op = bs.nextInt();
			
			switch(op) {
			
			case 1 ->{
				
				System.out.print("\nEnter Name : ");
				name = bs.next();
				s.setStName(name);
				System.out.print("\nEnter Phone No : ");
				phone = bs.next(); 
				s.setStPhn(phone);
				System.out.print("\nEnter Age : ");
				age = bs.nextInt();
				s.setStAge(age);
				System.out.print("\nEnter How many laptop : ");
				n = bs.nextInt();
				dao.connect();
				
				for(int i = 0;i<=n;i++) {
					
					laptop1 lap = new laptop1();
					System.out.println("Enter "+i+" Laptop Name : ");
					name  = bs.next();
					lap.setLapName(name);
					System.out.println("\nEnter "+i+" Laptop RAM : ");
					ram = bs.nextInt();
					lap.setLapRAM(ram);
					dao.registerlap(lap);
					
					}
					s.setL(lapList);
					dao.registerSt(s);
					dao.disconnect();
				
				    }
			
			case -2->{
				System.out.print("\nEnter Id : ");
				id = bs.nextInt();
				dao.connect();
				s = dao.fetchStd(id);
				System.out.println(s);
				dao.disconnect();
			}
			
			case 3->{
				System.out.println("\nEnter Id : ");
				id = bs.nextInt();
				dao.connect();
				l = (laptop1)dao.fetchLap(id);
				System.out.println(l);
				dao.disconnect();
				
			}
			
			case 4->{
				dao.connect();
				stList = dao.fetchAll();
				for(student1 st : stList)
					System.out.println(st);
				dao.disconnect();
			}
			
			case 5->{
				
				dao.connect();
				lapList = dao.fetchAllLap();
				for(laptop1 lap : lapList)
					System.out.println(lap);
				dao.disconnect();
				
				
			}
			
			case 6->{
				
				System.out.println("\nEnter Id : ");
				id = bs.nextInt();
				dao.connect();
				n = dao.deleteStd(id);
				if(n == 1)
					System.out.println("Student Removed!!");
				else
					System.out.println("OOPS!!--Student Does Not Exist--");
				dao.disconnect();
				
				
				
			}
			}
			
		}
		
		bs.close();

	}

}
