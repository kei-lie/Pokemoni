package Pokemoni;

public class AuguP extends Pokemons{
	public AuguP(String nosaukums) {
		super("Turtwig", 60, 35);
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
