package Pokemoni;

public abstract class Pokemons {
	protected String nosaukums;
	protected int veseliba;
	protected int maxVeseliba;
	protected int limenis;
	protected int uzbrukumaSpeks;
	
	public Pokemons(String nosaukums, int veseliba, int uzbrukumaSpeks) {
		this.nosaukums = nosaukums;
		this.veseliba = veseliba;
		this.maxVeseliba = veseliba;
		this.uzbrukumaSpeks = uzbrukumaSpeks;
		this.limenis = 1;
	}
	
	public String getInfo() {
		return nosaukums +
				"\nLīmenis: " + limenis +
				"\nVeselība: " + veseliba + "/" + maxVeseliba +
				"\nUzbrukums: " + uzbrukumaSpeks;
	}
	
	public void dziedet(int daudzums) {
		veseliba += daudzums;
		if (veseliba > maxVeseliba) veseliba = maxVeseliba;
	}
	
	public void attistit() {
		limenis++;
		maxVeseliba += 10;
		uzbrukumaSpeks += 5;
		veseliba = maxVeseliba;
	}
	
	// abstraktaa metode
	public abstract int uzbrukt();
	
	public boolean irDzivs() {
		return veseliba > 0;
	}
	
	public void sanemtDMG(int dmg) {
		veseliba -= dmg;
		if (veseliba < 0) veseliba = 0;
	}

}
