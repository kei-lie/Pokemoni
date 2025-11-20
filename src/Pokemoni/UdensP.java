package Pokemoni;

public class UdensP extends Pokemons {
	public UdensP(String nosaukums) {
		super("Squirtle", 100, 15);
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
