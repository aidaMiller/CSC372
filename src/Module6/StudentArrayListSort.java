package Module6;

import java.util.ArrayList;

public class StudentArrayListSort {
	public static void main(String[] args) {
		//Create an ArreyList to store Student objects
		ArrayList<Student> students = new ArrayList<>();
		
		//Add several Student objects to the ArrayLIst
		students.add(new Student(200, "Cindy", "198 Cinderella St"));
		students.add(new Student(201, "Bell", "645 Beuty and The Beast St"));
		students.add(new Student(202, "Ariel", "276 Ocean St"));
		students.add(new Student(203, "Moana", "787 Hawaii St"));
		students.add(new Student(204, "Mulan", "123 China St"));
		students.add(new Student(205, "Merida", "948 Brave St"));
		students.add(new Student(206, "Elsa", "405 Frozen St"));
		students.add(new Student(207, "Rapunzel", "658 Tangled St"));
		students.add(new Student(208, "Tiana", "831 The Princess and the Frog St"));
		students.add(new Student(209, "Aurora", "199 Sleeping Beauty St"));
		
		
		//Print the unsorted list of students
		System.out.println("Unsorted Students:");
		
		for (Student student : students) {
			System.out.println(student);
		}
		
		//Sort the students using the NameComparator and print the sorted list
		selectionSort(students, new NameComparator());
	    System.out.println("\nStudents sorted by Name:");
	     
	    for (Student student : students) {
	            System.out.println(student);
	    }
	     
	    // Sort the students using the RollNoComparator and print the sorted list
	    selectionSort(students, new RollNoComparator());
	    System.out.println("\nStudents sorted by Roll No:");
	     
	    for (Student student : students) {
	    	System.out.println(student);
	    }
	}
	
	// Implement a selection sort algorithm for sorting Students using a given comparator
	public static void selectionSort (ArrayList<Student> students, java.util.Comparator<Student> comparator) {
		int n = students.size();
		for (int i = 0; i< n-1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
			//Compare Students using the provided comparator
			if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
				minIndex = j;
			}
			}
		
		// Swap the Students if needed to sort in ascending order
		if (minIndex !=i) {
			Student temp = students.get(i);
			students.set(i,  students.get(minIndex));
			students.set(minIndex, temp);		
		}

	}
	}

}
