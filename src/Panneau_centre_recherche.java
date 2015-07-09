import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class Panneau_centre_recherche extends Panneau_centre {
	
	
	public Panneau_centre_recherche()	{
		
		dimension_tableaux = new Dimension(200, 200);
		
		creer_contenu_onglets();
		
		creer_onglets();
		
		add(tabbed_pane);

	}

	Dimension dimension_onglets = new Dimension(250, 50);
	Border padding_onglets = border_factory.createEmptyBorder(10, 10, 10, 10);
	Border contour_onglets = border_factory.createEtchedBorder();
	Border bordure_onglets = new CompoundBorder(contour_onglets, padding_onglets);

	JTable tableau_etudiants;
	JLabel titre_tableau_etudiants;
	JScrollPane scroll_tableau_etudiants;
	
	JTable tableau_materiel;
	JLabel titre_tableau_materiel;
	JScrollPane scroll_tableau_materiel;
	
	JTabbedPane tabbed_pane;
	
	JPanel panneau_etudiants;
	JPanel panneau_outils;
	JPanel panneau_materiel;
	JPanel panneau_bruts;
	
	
	public void creer_contenu_onglets() {
		
		panneau_etudiants = new JPanel();
		panneau_etudiants.setLayout(new BoxLayout(panneau_etudiants, BoxLayout.Y_AXIS));
		afficher_tableau_etudiants();
		
		panneau_outils = new JPanel();
		panneau_outils.setLayout(new BoxLayout(panneau_outils, BoxLayout.Y_AXIS));
		afficher_tableau_outils();
		
		panneau_materiel = new JPanel();
		panneau_materiel.setLayout(new BoxLayout(panneau_materiel, BoxLayout.Y_AXIS));
		afficher_tableau_materiel();
		
		panneau_bruts = new JPanel();
		panneau_bruts.setLayout(new BoxLayout(panneau_bruts, BoxLayout.Y_AXIS));
		afficher_tableau_bruts();
	}
	
	public void creer_onglets() {
		tabbed_pane = new JTabbedPane();
		tabbed_pane.addTab("Étudiants", panneau_etudiants);
		tabbed_pane.addTab("Outils", panneau_outils);
		tabbed_pane.addTab("Matériel", panneau_materiel);
		tabbed_pane.addTab("Bruts", panneau_bruts);
		
		JLabel titre_onglet_etudiants = new JLabel("Étudiants");
		titre_onglet_etudiants.setPreferredSize(dimension_onglets);
		titre_onglet_etudiants.setFont(f_sousTitre);
		tabbed_pane.setTabComponentAt(0, titre_onglet_etudiants);
		
		JLabel titre_onglet_outils = new JLabel("Outils");
		titre_onglet_outils.setPreferredSize(dimension_onglets);
		titre_onglet_outils.setFont(f_sousTitre);
		tabbed_pane.setTabComponentAt(1, titre_onglet_outils);
		
		JLabel titre_onglet_materiel = new JLabel("Matériel");
		titre_onglet_materiel.setPreferredSize(dimension_onglets);
		titre_onglet_materiel.setFont(f_sousTitre);
		tabbed_pane.setTabComponentAt(2, titre_onglet_materiel);
		
		JLabel titre_onglet_bruts = new JLabel("Bruts");
		titre_onglet_bruts.setPreferredSize(dimension_onglets);
		titre_onglet_bruts.setFont(f_sousTitre);
		tabbed_pane.setTabComponentAt(3, titre_onglet_bruts);
	}
	
	public void afficher_tableau_etudiants() {
		/* Ajoute les informations des outils empruntés dans le tableau */
		panneau_etudiants.removeAll();
		
		int nb_etudiants = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Code utilisateur", "Prénom", "Nom", "Photo"};
		String[][] donnees_tableau = new String[nb_etudiants][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_etudiants = new JTable(donnees_tableau, noms_colonnes);
		tableau_etudiants.setGridColor(Color.LIGHT_GRAY);
		tableau_etudiants.setRowHeight(20);
		scroll_tableau_etudiants = new JScrollPane(tableau_etudiants);
		panneau_etudiants.add(scroll_tableau_etudiants);
	}
	
	public void afficher_tableau_outils() {
		/* Ajoute les informations des outils empruntés dans le tableau */
		panneau_outils.removeAll();
		
		int nb_outils = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_outils][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_outils = new JTable(donnees_tableau, noms_colonnes);
		tableau_outils.setGridColor(Color.LIGHT_GRAY);
		tableau_outils.setRowHeight(20);
		scroll_tableau_outils = new JScrollPane(tableau_outils);
		panneau_outils.add(scroll_tableau_outils);
	}
	
	public void afficher_tableau_materiel() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		panneau_materiel.removeAll();
		
		int nb_materiaux = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_materiaux][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_materiel = new JTable(donnees_tableau, noms_colonnes);
		tableau_materiel.setGridColor(Color.LIGHT_GRAY);
		tableau_materiel.setRowHeight(20);
		scroll_tableau_materiel = new JScrollPane(tableau_materiel);
		panneau_materiel.add(scroll_tableau_materiel);
	}
	
	public void afficher_tableau_bruts() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		panneau_bruts.removeAll();
		
		int nb_bruts = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_bruts][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_bruts = new JTable(donnees_tableau, noms_colonnes);
		tableau_bruts.setGridColor(Color.LIGHT_GRAY);
		tableau_bruts.setRowHeight(20);
		scroll_tableau_bruts = new JScrollPane(tableau_bruts);
		panneau_bruts.add(scroll_tableau_bruts);
	}
	
}