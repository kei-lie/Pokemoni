package Pokemoni;

import javax.swing.JOptionPane;

public class Turnirs {

	public static void cinities(Pokemons tavs, Inventars inv) {
		// random pretinieks
		Pokemons pretinieks;
		if (Math.random() < 0.5)
			pretinieks = new ElektriskaisP("Pikachu");
		else
			pretinieks = new UdensP("Squirtle");
		
		JOptionPane.showMessageDialog(null, "Cīņa sākas.\nPretinieks:\n" + pretinieks.getInfo());
		//cikls
		while (tavs.irDzivs() && pretinieks.irDzivs()) {
			String[] darbibas = {
					"Uzbrukt",
					"Izmantot mikstūru",
					"Atvērt inventāru",
					"Bēgt"
			};
			
			int izvele = JOptionPane.showOptionDialog(null,
					"Tava kārta!\n" + tavs.getInfo(), "Cīņa",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			// uzbrukums
			 if (izvele == 0) {
				 int dmg = tavs.uzbrukt();
				 pretinieks.sanemtDMG(dmg);
				 JOptionPane.showMessageDialog(null, tavs.nosaukums + " uzbrūk un dara " + dmg + " dmg.\n" + "Pretinieka HP: " + pretinieks.veseliba);
			 }
			 
			 // miksturas/HP
			 else if (izvele == 1) {
				 String[] miksturuOpcijas = {
						 "Mikstūra (+20 HP)",
						 "Lielā mikstūra (+50 HP)",
						 "Atcelt"
				 };
				 
				 int m = JOptionPane.showOptionDialog(null,"Izvēlies mikstūru: ", "Mikstūras", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, miksturuOpcijas, miksturuOpcijas[0]);
				 if (m == 0) inv.izmantotMiksturu(tavs);
				 else if (m == 1) inv.izmantotLieloMiksturu(tavs);
						 
			 }
			 
			 // inventars
			 else if (izvele == 2) {
				 inv.paraditInventaru();
				 continue;
			 }
			 
			 // begt
			 else if (izvele == 3) {
				 JOptionPane.showMessageDialog(null, "Tu aizbēgi no cīņas.");
				 return;
			 }
			 
			 // pretinieks uzbruuk ja ir hp
			 if (pretinieks.irDzivs()) {
				 int dmg2 = pretinieks.uzbrukt();
				 tavs.sanemtDMG(dmg2);
				 
				 JOptionPane.showMessageDialog(null, pretinieks.nosaukums + " uzbrūk un dara " + dmg2 + " dmg.\n" + "Tavs HP: " + tavs.veseliba);
			 }
					
		}
		
		// cinas rezultats
		if (tavs.irDzivs())
			JOptionPane.showMessageDialog(null, "Tu uzvarēji! :)");
		else
			JOptionPane.showMessageDialog(null, "Tu zaudēji.. :(");
	}
}
