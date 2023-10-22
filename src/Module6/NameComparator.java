package Module6;

//Define a comparator class for comparing Students by their names
public class NameComparator implements java.util.Comparator<Student> {
	
	@Override 
	public int compare(Student s1, Student s2) {
		
		return s1.name.compareTo(s2.name); // Compare Students by their names
	}
}
