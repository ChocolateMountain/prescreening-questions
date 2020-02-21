import java.util.Comparator;

/**
 * Not really needed, 
 * but might be easier 
 * if we want to cascade 
 * comparisons in the future
 * 
 * @author lchen120
 *
 */
public class CompareUtils {

	public static Comparator<Employee> getIdComparator() {
		return Comparator.comparing(e -> e.getId());
	}
	
	public static Comparator<Employee> getFirstNameComparator() {
		return Comparator.comparing(e -> e.getFirstName());
	}
	
	public static Comparator<Employee> getLastNameComparator() {
		return Comparator.comparing(e -> e.getLastName());
	}
}
