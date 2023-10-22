package Module6;

import java.util.ArrayList;

class Student {
	int rollno;
    String name;
    String address;
    
    // Constructor for creating a Student object with roll number, name, and address
    public Student(int rollno, String name, String address) {
    	this.rollno = rollno;
    	this.name = name;
    	this.address = address; 
    }
    
 // Override the toString method to provide a custom string representation of a Student
    @Override
    public String toString(){
    	return "Student Roll No: " + rollno + ", Name: " + name + ", Address: " + address;
    }
}


