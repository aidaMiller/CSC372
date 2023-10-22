package Module6;

//Define a comparator class for comparing Students by their roll numbers
public class RollNoComparator implements java.util.Comparator<Student> {
	
	@Override 
	public int compare (Student s1, Student s2) {
		
		return s1.rollno - s2.rollno; // Compare Students by their roll numbers
	}
}

