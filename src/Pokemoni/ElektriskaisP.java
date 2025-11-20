package Pokemoni;

public class ElektriskaisP extends Pokemons {
	
	public ElektriskaisP(String nosaukums) {
		super("Mareep", 80, 20);
		
	}
	
	@Override
	public int uzbrukt() {
		int sitiens = (int)(Math.random() * 10);
		
		// Ūdens pokemons reizem veic kritiskus sitienus
		if (sitiens == 1 || sitiens == 2)
			return uzbrukumaSpeks + 15;
		
		else return uzbrukumaSpeks;
	}

}
