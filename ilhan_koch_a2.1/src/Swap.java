

import java.util.Date;

public class Swap {

	private Date date;
	private String ID;
	private static int nextID = 1;
	
	
	public Swap(String iD) {
		
		this.date = new Date();
		ID = iD + " (ID: " + nextID + ")";
		nextID ++;
	}
	
	
	
	public Date getDate() {
		return date;
	}



	public String getID() {
		return ID;
	}



	public void execute(Pokemon p1, Pokemon p2) {
		
		String id_status = "(Pokemon couldn't be exchanged successfully.)";
		String anzeige = "";

		if(p1.getTrainer() != null && p2.getTrainer() != null) {
			anzeige =  p1.getTrainer().getFirstname() + " " + p1.getTrainer().getLastname() + 
			 		  " try to exchange " + p1.getName() + " with " + 
			 		  p2.getTrainer().getFirstname() + " " + p2.getTrainer().getLastname() + 
			 		  "'s " + p2.getName() + ":" ;} 
		else {
				if(p1.getTrainer() == null && p2.getTrainer() != null) {
					anzeige = p1.getName() + " try to exchange with " + p2.getTrainer().getFirstname() + " " +
							  p2.getTrainer().getLastname() + "'s " + p2.getName() + ":";}
				else {
						if(p1.getTrainer() != null && p2.getTrainer() == null) {
							anzeige = p1.getTrainer().getFirstname() + " " + p1.getTrainer().getLastname() + 
							 		  " try to exchange " + p1.getName() + " with " + p2.getName() + ":";}
						else {
								if(p1.getTrainer() == null && p2.getTrainer() == null) { anzeige = p1.getName() + " try to exchange with " + p2.getName() + ":"; } 
						}
				}
		}
		
		System.out.println(anzeige);
		
		
		if(p1.isSwapAllow() == true && p2.isSwapAllow() == true) {
			//Pokemons können nur getauscht werden, wenn sie jeweils einen Trainer haben
				if(p1.getTrainer() != p2.getTrainer()) {
					if(p1.getType() != p2.getType()) {
						
				      Trainer t1 = p1.getTrainer();
				      Trainer t2 = p2.getTrainer();
				  
				      t1.removePokemon(p1);
				      t2.removePokemon(p2);
				  
				      t1.changePokemon(p2);
				      t2.changePokemon(p1);
				  
				      p1.setSwaps(this);
				      p2.setSwaps(this);

				      
				      id_status = "(Pokemon has been exchanged successfully.)";
				      
					}
					else { System.out.println( p1.getName() + " kann nicht mit " + p2.getName() + " getauscht werden, da beide von Typ " + p1.getType() + " sind.");}
				}
				else { System.out.println("You can not change Pokemon with the same Trainer.");}
		}
		else {
			if(p1.isSwapAllow() == false) {
				System.out.println( p1.getName() + " ist nicht zum Tauschen freigegeben.");
				}
			if(p2.isSwapAllow() == false) {
				System.out.println( p2.getName() + " ist nicht zum Tauschen freigegeben.");
				}
		}
		
		System.out.println(id_status);
	}
	

}
