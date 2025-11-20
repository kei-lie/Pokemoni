package Pokemoni;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Pokedatnis {

	
	static ArrayList<Pokemons> pokemonuSaraksts = new ArrayList<>();
	static Inventars inventars = new Inventars();
	
	public static void main(String[] args) {
		while (true) {
			String[] opcijas = {
					"Izveidot pokemonu",
					"Aplūkot pokemonus",
					"Pokemonu cīņa",
					"Apskatīt inventāru",
					"Dziedēt",
					"Veikals",
					"Iziet"
			};
			
			int iz = JOptionPane.showOptionDialog(null,"Izvēlies darbību: ", "Pokdatnis", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			if (iz == 0) izveidotPokemonu();
			else if (iz == 1) paraditPokemonus();
			else if (iz == 2) uzsaktCinu();
			else if (iz == 3) inventars.paraditInventaru();
			else if (iz == 4) dziedet();
			else if (iz == 5) Veikals.atvertVeikalu(inventars);
			else break;
		}
	}
	
	static void izveidotPokemonu() {
		String[] tipi = {"Elektriskais", "Ūdens", "Uguns", "Augu"};
		int tips = JOptionPane.showOptionDialog(null,"Izvēlies pokemonu: ", "Tips", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipi, tipi[0]);
		
		Pokemons p;
		if (tips == 0)
			p = new ElektriskaisP(tipi[tips]);
		else if (tips == 1)
			p = new UdensP(tipi[tips]);
		else if (tips == 2)
			p = new UgunsP(tipi[tips]);
		else 
			p = new AuguP(tipi[tips]);
		
		pokemonuSaraksts.add(p);
		JOptionPane.showMessageDialog(null, "Pokemons izveidots.\n" + p.getInfo());
	}
	
	static void paraditPokemonus() {
		if (pokemonuSaraksts.size() > 0) {
			String teksts = "Pokemonu skaits: " + pokemonuSaraksts.size() +
					"\n_________________________________\n";
			
			for (int i = 0; i < pokemonuSaraksts.size(); i++) {
				teksts += pokemonuSaraksts.get(i).getInfo() +
						"\n_________________________________\n";
				
			}
			
			JTextArea ta = new JTextArea(teksts, 10, 40);
			ta.setEditable(false);
			
			JScrollPane sp = new JScrollPane(ta);
			sp.setVerticalScrollBarPolicy(
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
			JOptionPane.showMessageDialog(null, sp, "Pokemonu saraksts",
					JOptionPane.PLAIN_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(null,
					"Nav izveidots neviens pokemons.", "Kļūda", JOptionPane.ERROR_MESSAGE);
					
		}
	}
		//Uzsāk cīņu ar nejaušu pokemonu
	static void uzsaktCinu() {
		if (pokemonuSaraksts.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vispirms izveido Pokemonu.");
			return;
		}
		
		String[] vardi = new String[pokemonuSaraksts.size()];
		for (int i = 0; i < pokemonuSaraksts.size(); i++) {
			vardi[i] = pokemonuSaraksts.get(i).nosaukums;
			
		}
		String[] pretinieki = {"Savvaļas pokemoni", "Cits treneris"};
		int pret = JOptionPane.showOptionDialog(null, "Pret ko cīnīsies?", "Cīņa", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null , pretinieki , pretinieki[0]);
		int izv = JOptionPane.showOptionDialog(null, "Izvēlies savu Pokémonu:", "Cīņa", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null , vardi , vardi[0]);
		if (izv < 0) return;
		if(pret == 0) Turnirs.SavCinities(pokemonuSaraksts.get(izv), inventars);
		else if(pret == 1) Turnirs.TrenCinities(pokemonuSaraksts.get(izv), inventars);
	}
	
		//Iespēja dziedināt pokemonu ārpus cīņas, lai varētu viņu izmantot arī turpmākās cīņās jau iepriekšējo zaudēji
	static void dziedet() {
		if (pokemonuSaraksts.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vispirms izveido Pokemonu.");
			return;
		}
		
		String[] vardi = new String[pokemonuSaraksts.size()];
		for (int i = 0; i < pokemonuSaraksts.size(); i++) {
			vardi[i] = pokemonuSaraksts.get(i).nosaukums;
			
		}
		int izv = JOptionPane.showOptionDialog(null, "Izvēlies kuru dziedēt:", "Palīdzība", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null , vardi , vardi[0]);
		
		if(izv < 5) {
			String[] miksturuOpcijas = {
					 "Mikstūra (+20 HP)",
					 "Lielā mikstūra (+50 HP)",
					 "Atcelt"
			 };
			 
			 int m = JOptionPane.showOptionDialog(null,"Izvēlies mikstūru: ", "Mikstūras", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, miksturuOpcijas, miksturuOpcijas[0]);
			 if (m == 0) inventars.izmantotMiksturu(pokemonuSaraksts.get(izv));
			 else if (m == 1) inventars.izmantotLieloMiksturu(pokemonuSaraksts.get(izv));
		}
		
		else if (izv < 0) return;
		
		
		 
	}
	
}
