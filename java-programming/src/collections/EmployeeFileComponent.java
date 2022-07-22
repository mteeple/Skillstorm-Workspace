package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeFileComponent {
	public static void main(String[] args) throws FileNotFoundException {
		//new EmployeeFileComponent().printEmployees();
		new EmployeeFileComponent().writeEmployee(new Employee(4, "Dillion", "Showmaker"));		
		System.out.println("Success");
	}

	public Scanner open() throws FileNotFoundException {
		/*
		 * a POJO that represents the file relative path - /files/data.txt absolute path
		 * - from the root drive (C) to where it exists
		 * C:\Users\MTeeple\Skillstorm-Workspace\java-programming Generally relative
		 * paths are better
		 * 
		 */
		// System.out.println("Enter the file name ");
		// Scanner in = new Scanner(System.in);
		File file = new File("employees.csv");
		try {
			// String input = in.nextLine();
			// File file = new File(input);
			Scanner scanner = new Scanner(file);
			System.out.println("File Found");
			return scanner;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			throw e;
		}
	}

	public void printEmployees() {
		String filename = "employees.csv";
		try {
			Scanner scanner = open();
			// delimiter
			scanner.useDelimiter(",");
			String line;
			while (scanner.hasNextLine()) {
				System.out.println(scanner.next() + " " + scanner.next() + " " + scanner.nextLine().substring(1));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}	

	}
	public void writeEmployee(Employee employee) {
		//OutputStream - PrintWriter
		//Try with resources When you include something in paranthesis next to try >>>> Try ()
		//Try-with resource only works with Auto-closeable 
		//Don't need the finally block anymore, as if it catches exception it will close it automatically
		try(FileWriter writer=new FileWriter(new File("employees.csv"), true)) {
			writer.write(employee.toString() + "\n");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
