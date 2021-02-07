package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= n; i++) {
			System.out.printf("Employee #%d:%n", i);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
				while (hasId(list, id)) {
					System.out.print("Id already taken. Try again: ");
					id =sc.nextInt();
					
				}
			
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			sc.nextLine();
			
			employee = new Employee(id, name, salary);
			list.add(employee);
			
			System.out.println("");
			
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		Employee employeeIncreaseSalary = list.stream().filter(x -> id.equals(x.getId())).findFirst().orElse(null);
		
		if(employeeIncreaseSalary != null) {
			System.out.print("Enter the percentage: ");
			Double percentage = sc.nextDouble();
			employeeIncreaseSalary.increaseSalary(percentage);
		} else {
			System.out.println("This id does not exits!");
		}
		
		System.out.println("");
		System.out.println("List of employees:");
		for(Employee obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("Fim");

	}
	
	public static Boolean hasId(List<Employee> list, Integer id) {
		Employee emp = list.stream().filter(x -> id.equals(x.getId())).findFirst().orElse(null);
		return emp != null;
	}

}
