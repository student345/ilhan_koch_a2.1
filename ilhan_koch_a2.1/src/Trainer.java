

import java.util.ArrayList;

public class Trainer {
	private String firstname;
	private String lastname;
	private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	private static ArrayList<Pokemon> allPokemon = new ArrayList<Pokemon>();
	
	public Trainer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public boolean containsPokemon(Pokemon p) {
		if( pokemon.contains(p)) {
			System.out.println( this.firstname +" has " + p.getName());
		    return true;
		}
		else {
			System.out.println(this.firstname+ " has not " + p.getName());
			return false;
		}
	}
	
	public void allPokemon() {
		System.out.println(this.firstname + " has: ");
		for (Pokemon i : pokemon) {
			System.out.println("   " + i.getName());	
		}
	}
		
    public void pokemonType (Type type) {
			for (Pokemon i : pokemon) {
				if (i.getType()==type) {System.out.println(this.firstname + " has " + type + " Type " + i.getName());}

			}
			
		}
    
	public void setPokemon(Pokemon pokemon) {
		if (!allPokemon.contains(pokemon)) {
			this.pokemon.add(pokemon);
			
			pokemon.setSwapAllow(true);
			pokemon.setTrainer(this);
			
			allPokemon.add(pokemon);
			System.out.println( this.firstname + " catched a new Pokemon : " + pokemon.getName());
		}
		else {
			System.out.println(this.firstname +" tried to catch " + pokemon.getName() + ", but " + pokemon.getName() +" already has a Trainer.");
		}
	}
	
	public void changePokemon(Pokemon pokemon) {

			this.pokemon.add(pokemon);
			pokemon.setTrainer(this);
	}
	
	public void removePokemon(Pokemon poke) {	
		pokemon.remove(poke);
		
	}
}
