
/**
 * Some assumptions (for simplicity):
 * 
 * 	1. id is positive and unique.
 * 	   uniqueness not enforced here
 * 
 * 	2. if middle name exists, it is 
 *     included in the first name.
 *     not enforced here 
 *     
 * 	3. an employee must have 
 * 	   an id, a first name, a last 
 *     name and a description.
 *     description is just parsed 
 *     employee from the dat file
 * 
 * 	4. an employee is immutable 
 * 
 * @author lchen120
 *
 */
public class Employee {

	private final int id;
	private final String firstName;
	private final String lastName;
	private final String description;
	
	/**
	 * @pre id >= 0 && firstName != null && lastName != null && description != null
	 */
	public Employee(int id, String firstName, String lastName, String description) {
		assert id >= 0 && firstName != null && lastName != null && description != null;
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return String.format("Employee %d: { Last Name: %s, First Name: %s }", id, lastName, firstName);
	}
}
