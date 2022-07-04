package jdbcsql;

import java.sql.*;


import java.util.*;

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch=0;
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Password123");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			if(ch==1) {
				
				PreparedStatement stmt=con.prepareStatement("Insert into emps values(?,?,?,?,?)");
				Scanner sc1=new Scanner(System.in);
				System.out.print("ID: ");
				int id=sc1.nextInt();
				System.out.print("Name: ");
				String name=sc1.next();
				System.out.print("Age: ");
				int age=sc1.nextInt();
				System.out.print("Salary: ");
				int salary=sc1.nextInt();
				System.out.print("Designation: ");
				String desig=sc1.next();

				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setInt(3, age);
				stmt.setInt(4, salary);
				stmt.setString(5, desig);

				stmt.execute();
				con.close();
				System.out.println("Data Saved");
				
			}
			if (ch==2) {
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from emps");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+ ": "+rs.getString(2)+" : "+rs.getInt(3)+": "+rs.getInt(4)+": "+rs.getString(5));
				}
			}
			if (ch==3) {
				
				PreparedStatement stmt=con.prepareStatement("update emps set salary=? where id=?");
				Scanner sc2=new Scanner(System.in);
				
				System.out.print("ID: ");
				int id = sc2.nextInt();
				
				System.out.print("Salary: ");
				int salary=sc2.nextInt();
				
				stmt.setInt(1, salary);
				stmt.setInt(2, id);
				
				stmt.execute();
				con.close();
				System.out.println("Data updated");
			}
			if(ch==4) {
				
				PreparedStatement stmt=con.prepareStatement("Delete from emps where id=?");
				Scanner sc3=new Scanner(System.in);
				
				System.out.print("ID: ");
				int id = sc3.nextInt();
				
				
				
				
				stmt.setInt(1, id);
				System.out.println("Do u really want to delete: ?");
				String ch4=sc3.next();
				if (ch4.equalsIgnoreCase("yes"))
				{
					stmt.execute();
				}
				else {
					System.out.println("not deleted");
				}
				
				con.close();
				System.out.println("Data Deleted");
			}
			
		
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
			
		
			

	}

}

