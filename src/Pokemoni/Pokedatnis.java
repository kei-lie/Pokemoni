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
					"Izveidot Pokemonu",
					"Aplūkot pokemonus",
					"Pokemonu cīņa",
					"Veikals",
					"Iziet"
			};
			
			int iz = JOptionPane.showOptionDialog(null,"Izvēlies darbību: ", "Pokdatnis", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			if (iz == 0) izveidotPokemonu();
			else if (iz == 1) paraditPokemonus();
			else if (iz == 2) uzsaktCinu();
			else if (iz == 3) Veikals.atvertVeikalu(inventars);
			else break;
		}
	}
	
	static void izveidotPokemonu() {
		String vards = JOptionPane.showInputDialog("Ievadi pokemona vārdu:");
		String[] tipi = {"Elektriskais", "Ūdens"};
		int tips = JOptionPane.showOptionDialog(null,"Izvēlies tipu:", "Tips", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipi, tipi[0]);
		
		Pokemons p;
		if (tips == 0)
			p = new ElektriskaisP(vards);
		else
			p = new UdensP(vards);
		
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
	
	static void uzsaktCinu() {
		if (pokemonuSaraksts.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vispirms izveido Pokemonu.");
			return;
		}
		
		String[] vardi = new String[pokemonuSaraksts.size()];
		for (int i = 0; i < pokemonuSaraksts.size(); i++) {
			vardi[i] = pokemonuSaraksts.get(i).nosaukums;
			
		}
		
		int izv = JOptionPane.showOptionDialog(null, "Izvēlies savu Pokémonu:", "Cīņa", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null , vardi , vardi[0]);
		if (izv < 0) return;
		Turnirs.cinities(pokemonuSaraksts.get(izv), inventars);
	}
}
