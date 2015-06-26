import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Panneau_centre_etudiant extends Panneau_centre {
	
	JTable tableau_bris;
	JLabel titre_tableau_bris;
	JScrollPane scroll_tableau_bris;
	
	public Panneau_centre_etudiant()
	{
		titre_tableau_outils = new JLabel("Outils");
		add(titre_tableau_outils);
		initialiser_tableau_outils();
		
		titre_tableau_bruts = new JLabel("Bruts");
		add(titre_tableau_bruts);
		initialiser_tableau_bruts();
		
		titre_tableau_bris = new JLabel("Bris");
		add(titre_tableau_bris);
		initialiser_tableau_bris();
		
	}
	
	
	public void initialiser_tableau_outils() {
		/* Ajoute les informations des outils empruntés dans le tableau */
		
		int nb_outils = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_outils][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_outils = new JTable(donnees_tableau, noms_colonnes);
		tableau_outils.setGridColor(Color.LIGHT_GRAY);
		tableau_outils.setMaximumSize(dimension_tableaux);
		tableau_outils.setRowHeight(20);
		scroll_tableau_outils = new JScrollPane(tableau_outils);
		scroll_tableau_outils.setSize(dimension_tableaux);
		add(scroll_tableau_outils);
	}
	
	public void initialiser_tableau_bruts() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		
		int nb_bruts = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_bruts][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_bruts = new JTable(donnees_tableau, noms_colonnes);
		tableau_bruts.setGridColor(Color.LIGHT_GRAY);
		tableau_bruts.setSize(dimension_tableaux);
		tableau_bruts.setRowHeight(20);
		scroll_tableau_bruts = new JScrollPane(tableau_bruts);
		scroll_tableau_bruts.setSize(dimension_tableaux);
		add(scroll_tableau_bruts);
	}
	
	public void initialiser_tableau_bris() {
		/* Ajoute les informations des outils brisés dans le tableau */
		
		int nb_outils_brises = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_outils_brises][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD (fonction qui pourra être réutilisée pour refresh)
		
		tableau_bris = new JTable(donnees_tableau, noms_colonnes);
		tableau_bris.setGridColor(Color.LIGHT_GRAY);
		tableau_bris.setRowHeight(20);
		scroll_tableau_bris = new JScrollPane(tableau_bris);
		scroll_tableau_bris.setSize(dimension_tableaux);
		add(scroll_tableau_bris);
	}



	
	

}
