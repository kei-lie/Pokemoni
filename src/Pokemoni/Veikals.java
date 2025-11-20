package Pokemoni;

import javax.swing.JOptionPane;

public class Veikals {
	public static void atvertVeikalu(Inventars inv) {
		String[] opcijas = {"Mikstūra (20 HP) - 20 PD", "Lielā mikstūra (50 HP) - 50 PD", "Iziet"};
		while (true) {
			int izvele = JOptionPane.showOptionDialog(null, "Izvēlies ko pirkt: ", "Veikals", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			if (izvele == 0) {
				if(inv.pokedolari >= 20) {		//Tiek limitēts, cik var nopirkt, lai nav tā ka var bezgalīgi daudz nopirkt
					inv.miksturas++;
					inv.pokedolari -= 20;
					JOptionPane.showMessageDialog(null, "Nopirkta 1 mikstūra.");
				}else if(inv.pokedolari <= 20) JOptionPane.showMessageDialog(null, "Nepietiek mikstūrai!", "Kļūda!", JOptionPane.ERROR_MESSAGE);
			} else if (izvele == 1) {
				if(inv.pokedolari >= 50) {
				inv.lielasMiksturas ++;
				inv.pokedolari -= 50;
				JOptionPane.showMessageDialog(null, "Nopirkta 1 lielā mikstūra.");
				}else if(inv.pokedolari <= 50) JOptionPane.showMessageDialog(null, "Nepietiek lielajai mikstūrai!", "Kļūda!", JOptionPane.ERROR_MESSAGE);
				
			}else break;
		}		
	}
}

