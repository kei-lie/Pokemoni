package Pokemoni;

public class ElektriskaisP extends Pokemons {
	
	public ElektriskaisP(String nosaukums) {
		super(nosaukums, 80, 20);
		
	}
	
	@Override
	public int uzbrukt() {
		// elektriskais pokemons reizem sit critical atk
		if (Math.random() < 0.25) {
			return uzbrukumaSpeks + 15;
			
		}
		return uzbrukumaSpeks;
	}

}
