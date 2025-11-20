package Pokemoni;

public class UgunsP extends Pokemons{
	public UgunsP(String nosaukums) {
		super(nosaukums, 60, 35);
	}
	
	@Override
	public int uzbrukt() {
		int sitiens = (int)(Math.random() * 10);
	
	// Uguns pokemons reizem veic kritiskus sitienus
	if (sitiens == 1 || sitiens == 2)
		return uzbrukumaSpeks + 15;
	
	else return uzbrukumaSpeks;
	}
}
