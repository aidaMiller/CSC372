package Module8Final;
import java.io.FileWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) {		
	   // Collect vehicle information
	  LinkedList<Vehicle> vehicles = collectVehicles();	
	  Collections.sort(vehicles); // Sort the list of vehicles
	  saveVehiclesToFile(vehicles);// Save the sorted vehicle information to a file
	}
	
	private static LinkedList<Vehicle>  collectVehicles() {
		 LinkedList<Vehicle> vehicles = new LinkedList<Vehicle>();
		 Scanner scanner = new Scanner(System.in);
		    
		   System.out.println("Enter vehicle information.");
		   
		   Boolean shouldContinue = true;
		   
		   while (shouldContinue) {
			   String make;
			   String model;
			   double milesPerGallon;
			   
			   System.out.print("Make: ");
			   make = scanner.nextLine();	
			   
			   System.out.print("Model: ");
			   model = scanner.nextLine();
			   
			   System.out.print("Miles per gallon: ");
			   // Check if the input is a valid double for miles per gallon
			   milesPerGallon = possibleMilesPerGallon(scanner.nextLine());	
			   
			   // Create a Vehicle object and add it to the LinkedList
			   Vehicle vehicle = new Vehicle(make, model, milesPerGallon);
				  vehicles.add(vehicle);
//				  scanner.nextLine();
				  
				  
			   System.out.print("Do you wish to add another car? ");		
			   shouldContinue = scanner.nextLine().equalsIgnoreCase("Y")? true : false;
		   }
		   return vehicles;		   
	}
	
	private static void saveVehiclesToFile( LinkedList<Vehicle> vehicles) {
		FileWriter writer; 
		try {
			writer = new FileWriter("inventory.txt");
			System.out.println("Successfully created inventory.txt");
		} catch (Exception error){
			System.out.println(error);	
			return;
		} 
		
		try {
			writer.write("Make\t\tModel\t\t MPG \n");
			 // Write each vehicle's information to the file
			for (Vehicle car: vehicles) {
				writer.write(car.getMake()+"\t\t"+car.getModel()+"\t\t"+car.getMilesPerGallon()+"\n");
			} 
			writer.close();
		} catch (Exception error) {
			System.out.println(error);	
		}
	} 
	private static Double possibleMilesPerGallon(String possibleDouble) {
		try {
			return Double.parseDouble(possibleDouble);
		} catch (NumberFormatException ex){
			// If the input is not a valid number, prompt the user to enter a number
			Scanner scanner = new Scanner(System.in);
			System.out.println("Try again.That was not a number.");
			// Recursively call the method until a valid number is entered
			return possibleMilesPerGallon(scanner.nextLine());
		}
	}
}


