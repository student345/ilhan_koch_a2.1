public class PokemonManager {

	public static void main(String[] args) {

		Trainer Detlef = new Trainer("Detlef","Roemisch");
		Trainer Ash = new Trainer("Ash","Ketchum");
		
		Pokemon Pikachu = new Pokemon("Pikachu", Type.Thunder);
		Pokemon Nidoran = new Pokemon("Nidoran", Type.Poison);
		Pokemon Glumanda = new Pokemon("Glumanda", Type.Fire);
		Pokemon Lapras = new Pokemon("Lapras", Type.Water);
		Pokemon Taubsi = new Pokemon("Taubsi", Type.Air);
		
		Ash.setPokemon(Pikachu);
		Ash.setPokemon(Lapras);
		
		Detlef.setPokemon(Pikachu);
		Ash.containsPokemon(Pikachu);
		
		Detlef.setPokemon(Nidoran);
		Detlef.setPokemon(Glumanda);
		Detlef.setPokemon(Taubsi);
		
		Ash.allPokemon();
		Detlef.pokemonType(Type.Poison);
		
		
		System.out.println("-------------------------------------\n");
		
		//Test Aufgabe 2.1	
		
		//erfolgreicher Tausch		
		Swap swap1 = new Swap("Ash Ketchum/Detlef Römisch");
		swap1.execute(Pikachu, Nidoran);
		Nidoran.getSwapsInfo();
		System.out.println("-----------------------------------\n");
		
		//erfolgloser Tausch wegen Pokemon nicht zum Tausch freigegeben
		Pokemon Hornliu = new Pokemon("Hornliu", Type.Poison);
		Swap swap2 = new Swap("Ash Ketchum/Kein Trainer");
		swap2.execute(Lapras, Hornliu);
		
		System.out.println("-----------------------------------\n");
		
		//erfolgloser Tausch wegen Pokemons des selben Typs
		Detlef.setPokemon(Hornliu);
		Swap swap3 = new Swap("Ash Ketchum/Detlef Römisch");
		swap3.execute(Nidoran, Hornliu);
		Nidoran.getSwapsInfo();
		
		System.out.println("-----------------------------------\n");
		
		//erfolgloser Tausch wegen Tausch vom selben Trainer
		Swap swap4 = new Swap("Ash Ketchum/Ash Ketchum");
		swap4.execute(Nidoran, Lapras);
		
		System.out.println("-----------------------------------\n");
		//Teste Swap Information
		Swap swap5 = new Swap("Detlef Römisch/Ash Ketchum");
		swap5.execute(Glumanda, Nidoran);
		Nidoran.getSwapsInfo();
		
		
	}
}
