package Pokemoni;

import javax.swing.JOptionPane;

public class Veikals {
	public static void atvertVeikalu(Inventars inv) {
		String[] opcijas = {"Mikstūra (20 HP)", "Lielā mikstūra (50 HP)", "Iziet"};
		while (true) {
			int izvele = JOptionPane.showOptionDialog(null, "Izvēlies ko pirkt: ", "Veikals", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			if (izvele == 0) {
				inv.miksturas++;
				JOptionPane.showMessageDialog(null, "Nopirkta 1 mikstūra.");
			} else if (izvele == 1) {
				inv.lielasMiksturas ++;
				JOptionPane.showMessageDialog(null, "Nopirkta 1 lielā mikstūra.");
			} else break;
			}
		}
	}


