package Pokemoni;

import javax.swing.JOptionPane;

public class Inventars {

	public int miksturas = 0;
	public int lielasMiksturas = 0;
	
	public void izmantotMiksturu(Pokemons p) {
		if (miksturas> 0) {
			miksturas--;
			p.dziedet(20);
			JOptionPane.showMessageDialog(null, p.nosaukums + " saņēma + 20 HP.");
		} else {
			JOptionPane.showMessageDialog(null, "Tev nav mikstūru.");
		}
	}
	public void izmantotLieloMiksturu(Pokemons p) {
		if (lielasMiksturas > 0) {
			lielasMiksturas--;
			p.dziedet(50);
			JOptionPane.showMessageDialog(null, p.nosaukums + " saņēma + 50 HP.");
		} else {
			JOptionPane.showMessageDialog(null, "Tev nav lielo mikstūru.");
		}
	}
	
	
	public void paraditInventaru() {
		JOptionPane.showMessageDialog(null,
				"Inventārs:\n" +
				"Mikstūras: " + miksturas + "\n" +
				"Lielās mikstūras: " + lielasMiksturas);
	}
}
