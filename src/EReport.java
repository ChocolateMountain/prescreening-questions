import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EReport {

	public static final String PATH = "employees.dat";
	private static final EmployeesList employeesList = new EmployeesList();
	
	/**
	 * 1. read employees into a List of Strings
	 * 2. preprocess strings
	 * 3. build employees list 
	 * 4. perform requirements from pdf instructions 
	 * 
	 */
	public static void main(String[] args) {
		
		List<String> lines = getLinesFromDat(PATH);
		lines = filterComments(lines);		
		buildEmployeesList(lines);
				
		// 3. sort by employee number -> log output
		sortByIdAndLog();
		
		// 4. sort by last name -> log output 
		sortByLastNameAndLog();
		
		
		// sometimes there are wrapping spaces
		// i did not remove them in the log output above
		// uncomment the line below for a prettier print
		//logList(employeesList.getEmployeesAsStrings());
	}

	public static List<String> getLinesFromDat(String path) {
		List<String> lines = new ArrayList<>();
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static List<String> filterComments(List<String> lines) {
		char hash = '#';
		List<String> result = new ArrayList<>();
		for (String line: lines) {
			int indexOfHash = line.indexOf(hash);
			if (indexOfHash == 0) {
				// entire line is a comment 
				continue;
			} else if (indexOfHash > 0) {
				// half the line is a comment
				result.add(line.substring(0, indexOfHash));
			} else {
				result.add(line);
			}
		}
		return result;
	}
	
	/**
	 * Employees.java lists a few assumptions about employees
	 * 
	 * A few extra notes: 
	 * 
	 * 	1. we wont check for duplicate ids here, 
	 *     thats more of a "back end" problem
	 *     
	 * 	2. we will toss out any lines that dont meet the 
	 * 	   other assumptions
	 * 
	 */
	public static void buildEmployeesList(List<String> lines) {
		for (String line: lines) {
			
			String[] tokens = line.split(",");
			if (tokens.length != 2) continue;
			
			int id = readIntFromString(tokens[0]);
			if (id < 0) continue;
			
			// remove multiple spaces and wrapping spaces 
			String[] nameTokens = tokens[1].trim().split("\\s+");
			if (nameTokens.length < 2) continue;
			
			String firstName = String.join(" ", Arrays.copyOfRange(nameTokens, 0, nameTokens.length - 1));
			String lastName = nameTokens[nameTokens.length - 1];
			
			employeesList.addEmployee(new Employee(id, firstName, lastName, line));
		}
	}
	
	public static void sortByIdAndLog() {
		employeesList.sortById();
		System.out.println("Processing by employee number...");
		logList(employeesList.getEmployeesAsDescriptions());
		System.out.println();
	}
	
	public static void sortByLastNameAndLog() {
		employeesList.sortByLastName();
		System.out.println("Processing by last (family) Name...");
		logList(employeesList.getEmployeesAsDescriptions());
		System.out.println();
	}

	public static void sortByFirstNameAndLog() {
		employeesList.sortByFirstName();
		System.out.println("Processing by first Name...");
		logList(employeesList.getEmployeesAsDescriptions());
		System.out.println();
	}
	
	/**
	 * helper
	 */
	public static int readIntFromString(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	/**
	 * helper
	 */
	public static void logList(List<String> list) {
		list.forEach(System.out::println);
	}
}
