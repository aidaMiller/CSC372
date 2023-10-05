
public class Cone extends Shape{
	
	private double radius;
	private double height;
	
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double surface_area() {
		double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
	}

	@Override
	public double volume() {
		return (1/3) * Math.PI * Math.pow(radius, 2.0) * height; 
	}
	
	@Override
    public String toString() {
        return "Cone - Radius: " + radius + ", Height: " + height + ", Surface Area: " + surface_area() + ", Volume: " + volume();
    }

}

