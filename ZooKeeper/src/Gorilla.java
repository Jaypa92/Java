
public class Gorilla extends Mammals {

	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("Gorilla is throwing something... -5 Energy");
		int energy = getEnergyLevel()-5;
		setEnergyLevel(energy);
	}
	
	public void eatBananas() {
		System.out.println("Gorilla jumps up and down with excitement..... +10 Energy");
		int energy = getEnergyLevel() + 10;
		setEnergyLevel(energy);
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed a tree.... -10 Energy");
		int energy = getEnergyLevel() - 10;
		setEnergyLevel(energy);
	}

}
