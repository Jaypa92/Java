
public class Bat extends Mammals {
	
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("Whoosh! Bat flies..... -50 Energy");
		int energy = getEnergyLevel() - 50;
		setEnergyLevel(energy);
	}
	
	public void eatHumans() {
		System.out.println("Bat eats a bloody meal..... +25 Energy");
		int energy = getEnergyLevel() + 25;
		setEnergyLevel(energy);
	}
	
	public void attackTown() {
		System.out.println("Crack...pop....fire everywhere in nearby town..... -100 Energy");
		setEnergyLevel(getEnergyLevel()-100);
	}
}
