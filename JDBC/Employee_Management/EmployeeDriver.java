package employee_management.driver;

import java.util.Scanner;

import employee_management.service.EmploeeService;

public class EmployeeDriver {
	public static void main(String args[]) {
		
		System.out.println("Welcome to my application");
		System.out.print("Menu");
		System.out.print("Enter 1 to add Employee  ");
		System.out.println("Enter 2 to fetchAll Employee ");
		System.out.println("Enter 3 to update Employee ");
		System.out.println("Enter 4 to delete Employee ");
		System.out.println("Enter 5 to exit the application ");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Choice");
		
		
		int choice = sc.nextInt();
		EmploeeService service = new EmploeeService();
		switch(choice) {
		case 1:
			int res=service.insert();
			if(res!=0) {
				System.out.println("Data Saved");
			}
			else {
				System.out.println("Data Not Saved");
			}
			break;
			
		case 2:
			service.fetchAll();
			break;
			
		case 3:
			int res1=service.update();
			if(res1!=0) {
				System.out.println("Data is Updated");
			}
			else {
				System.out.println("Data is not Updated");
			}
			break;
		case 4:
			int res2=service.delete();
			if(res2!=0) {
				System.out.println("Respected Data is Deleted");
			}
			else {
				System.out.println("Respected Data is Not Deleted");
			}
			break;
		case 5:
			System.out.println("Application is closed");
			break;
			
		default:
			break;
		}
		
		
	}
	
	
}
