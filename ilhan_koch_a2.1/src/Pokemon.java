

import java.util.ArrayList;

public class Pokemon {
    
    private String name;
	private Type type;
	private int number;
	private static int nextNumber = 1;
	private Trainer trainer = null;
	private ArrayList<Swap> swaps;	
	private boolean swapAllow = false;
	
	
	public Pokemon(String name, Type type) {
		this.name = name;
		this.type = type;
		this.number = nextNumber;
		this.swaps = new ArrayList<>();
		
		nextNumber ++ ;
	}
	
	public String getName() {
		return name;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}
	
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


	public void setName(String name) {
		this.name = name; 
		// this-Referenz bezieht sich auf die Klassenvariable
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}

	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + ", number=" + number + "]";
	}

	public boolean isSwapAllow() {
		return swapAllow;
	}

	public void setSwapAllow(boolean swapAllow) {
		this.swapAllow = swapAllow;
	}
	
	public ArrayList<Swap> getSwaps() {
		return swaps;
	}

	public void setSwaps(Swap swaps) {
		this.swaps.add(swaps);
	}
	
	public void getSwapsInfo() {
		
		System.out.println("\nSwap Information (" + this.name + "): " );
		for(Swap swap:swaps) {
			try {
				System.out.println("Date : " + swap.getDate() + " | " + swap.getID());
				//System.out.println(swap.getID());
			}
			catch (NullPointerException e) {
				System.out.println("Here is a null pointer exception.");
			}
		}
	}
}
