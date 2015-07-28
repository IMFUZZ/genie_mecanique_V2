import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;


public class Panneau_centre_etudiant extends Panneau_centre {
		
	
	public Panneau_centre_etudiant(Fenetre a_parent)
	{
		super(a_parent);
		
		dimension_tableaux = new Dimension(200, 200);
		
		titre_tableau_outils = new JLabel("Outils");
		titre_tableau_outils.setFont(f_sousTitre);
		titre_tableau_outils.setBorder(padding_tableaux);
		add(titre_tableau_outils);
		initialiser_tableau_outils();
		
		titre_tableau_bruts = new JLabel("Bruts");
		titre_tableau_bruts.setFont(f_sousTitre);
		titre_tableau_bruts.setBorder(padding_tableaux);
		add(titre_tableau_bruts);
		initialiser_tableau_bruts();
		
		titre_tableau_bris = new JLabel("Bris");
		titre_tableau_bris.setFont(f_sousTitre);
		titre_tableau_bris.setBorder(padding_tableaux);
		add(titre_tableau_bris);
		initialiser_tableau_bris();
		
	}
	
	
	JTable tableau_bris;
	JLabel titre_tableau_bris;
	JScrollPane scroll_tableau_bris;
	
	
	public void initialiser_tableau_outils() {
		/* Ajoute les informations des outils empruntés dans le tableau */
		
		int nb_outils = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_outils][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_outils = new Tableau(parent.controlleur.creer_modele_table("membres"));
		tableau_outils.setGridColor(Color.LIGHT_GRAY);
		tableau_outils.setMaximumSize(dimension_tableaux);
		tableau_outils.setRowHeight(20);
		
		scroll_tableau_outils = new JScrollPane(tableau_outils);
		scroll_tableau_outils.setBorder(padding_tableaux);
		scroll_tableau_outils.setBorder(BorderFactory.createTitledBorder("OUTILS"));
		add(scroll_tableau_outils);
	}
	
	public void initialiser_tableau_bruts() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		
		int nb_bruts = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_bruts][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_bruts = new Tableau(parent.controlleur.creer_modele_table("membres"));
		tableau_bruts.setGridColor(Color.LIGHT_GRAY);
		tableau_bruts.setSize(dimension_tableaux);
		tableau_bruts.setRowHeight(20);
		
		scroll_tableau_bruts = new JScrollPane(tableau_bruts);
		scroll_tableau_bruts.setBorder(padding_tableaux);
		scroll_tableau_bruts.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		add(scroll_tableau_bruts);
	}
	
	public void initialiser_tableau_bris() {
		/* Ajoute les informations des outils brisés dans le tableau */
		
		int nb_outils_brises = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_outils_brises][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD (fonction qui pourra être réutilisée pour refresh)
		
		tableau_bris = new Tableau(parent.controlleur.creer_modele_table("membres"));
		tableau_bris.setGridColor(Color.LIGHT_GRAY);
		tableau_bris.setRowHeight(20);
		
		scroll_tableau_bris = new JScrollPane(tableau_bris);
		scroll_tableau_bris.setBorder(padding_tableaux);
		scroll_tableau_bris.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(scroll_tableau_bris);
	}


}
