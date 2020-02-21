import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesList {

	private List<Employee> employees;
	
	public EmployeesList() {
		employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void addAll(Employee ...employees) {
		this.employees.addAll(Arrays.asList(employees));
	}
	
	public void sortById() {
		this.employees.sort(CompareUtils.getIdComparator());
	}
	
	public void sortByLastName() {
		this.employees.sort(CompareUtils.getLastNameComparator());
	}
	
	public void sortByFirstName() {
		this.employees.sort(CompareUtils.getFirstNameComparator());
	}
	
	/**
	 * helper
	 */
	public List<String> getEmployeesAsStrings() {
		return employees.stream().map(e -> e.toString()).collect(Collectors.toList());
	}
	
	/**
	 * helper
	 */
	public List<String> getEmployeesAsDescriptions() {
		return employees.stream().map(e -> e.getDescription()).collect(Collectors.toList());
	}
}
