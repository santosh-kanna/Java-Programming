package employee_management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmploeeService {
	Scanner sc=new Scanner(System.in);
	
	private static String url="jdbc:postgresql://localhost:5432/base1?user=postgres&password=123";
	private static Connection con;
	static {
		
			try {
				
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection(url);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public int insert() {
		
		int res=0;
		System.out.println("Enter the id of employee : ");
		int id=sc.nextInt();
		System.out.println("Enter the emplyee name : ");
		String name=sc.next();
		System.out.println("Enter the age of the employee : ");
		int age=sc.nextInt();
		System.out.println("Enter the gender of the employee : ");
		String gender=sc.next();
		
		String sql="INSERT into EMPLOYEE values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setString(4, gender);
			
			res=pstm.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public void fetchAll() {
		
		String sql="SELECT * FROM EMPLOYEE";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println("id : "+rs.getInt(1));
				System.out.println("name : "+rs.getString(2));
				System.out.println("age : "+rs.getInt(3));
				System.out.println("gender : "+rs.getString(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int update() {
		
		System.out.println("Enter the id for updation ");
		int id=sc.nextInt();
		int res1=0;
		
		System.out.println("Enter the name: ");
		String name=sc.next();
		System.out.println("Enter the age:");
		int age=sc.nextInt();
		System.out.println("Enter the gender:");
		String gender=sc.next();
		
		
		String sql="UPDATE EMPLOYEE SET name=?, age=?, gender=? where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			
			
			pstm.setString(1,name);
			
			pstm.setInt(2, age);
			
			pstm.setString(3, gender);
			
			pstm.setInt(4,id);
			
			
			res1=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res1;
		
	}
	
	public int delete(){
		int res2=0;
		System.out.println("Enter the id for deletion...");
		int id=sc.nextInt();
	
		String sql="DELETE from EMPLOYEE where id=? ";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			res2=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res2;
	}
}
