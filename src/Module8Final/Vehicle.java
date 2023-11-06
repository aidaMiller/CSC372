package Module8Final;

import java.util.Scanner;

public class Vehicle implements Comparable<Vehicle>{
	private String make;
	private String model;
	private Double milesPerGallon; 
	
	public Vehicle (String make, String model, double milesPerGallon) {
		
		this.make = make;
		this.model = model;
		this.milesPerGallon = milesPerGallon;
	}
	
	public String getMake(){
		return this.make;
	}
	
	public String getModel(){
		return this.model;
	}
	
	public double getMilesPerGallon(){
		return this.milesPerGallon;
	}

	@Override
	public int compareTo(Vehicle otherVehicle) {

		return this.milesPerGallon.compareTo(otherVehicle.milesPerGallon);
	}
	
}
