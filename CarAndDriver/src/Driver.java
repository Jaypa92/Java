import java.io.ObjectInputFilter.Status;

public class Driver extends Car {
	public void drive() {
		System.out.println("Driving...");
		gas--;
		status();
	}
	
	public void boosters() {
		System.out.println("Using boosters...");
		gas -= 3;
		status();
	}
	
	public void refuel() {
		System.out.println("Refueling...");
		gas += 2;
		status();
	}
}
