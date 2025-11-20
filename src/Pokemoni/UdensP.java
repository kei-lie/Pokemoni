package Pokemoni;

public class UdensP extends Pokemons {
	public UdensP(String nosaukums) {
		super(nosaukums, 100, 15);
	}
	
	@Override
	public int uzbrukt() {
		return uzbrukumaSpeks + (int)(Math.random() * 10);
	}

}
