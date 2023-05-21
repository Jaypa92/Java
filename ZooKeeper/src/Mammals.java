
public class Mammals {
	private int energyLevel;
	
	public Mammals() {
		this.energyLevel = 100;
	}
	
	public Mammals(int energy) {
		this.energyLevel=energy;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
	System.out.println("Energy Level: "+getEnergyLevel());
	return getEnergyLevel();
	}
}
