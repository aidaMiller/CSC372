package Module4;

public class ShapeArray {
	public static void main(String[] args) {
		
		Sphere sphere = new Sphere(10.0);
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        Cone cone = new Cone(6.0, 8.0);

        Shape[] shapeArray = {sphere, cylinder, cone};

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
	}

}
