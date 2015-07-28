import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class Panneau_centre_recherche extends Panneau_centre {
	
	
	public Panneau_centre_recherche(Fenetre a_parent) {
		
		super(a_parent);
		
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
		Object[][] donnees_tableau = new Object[nb_etudiants][noms_colonnes.length];
		
		// remplir donnees_tableau à partir de la bd
		donnees_tableau[0][0] = "1357059";
		ImageIcon image_etudiant = new ImageIcon("src/images/etudiant1.png");
		Image img = image_etudiant.getImage();
		Image newimg = img.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
		donnees_tableau[0][3] = new ImageIcon(newimg);
		
		tableau_etudiants = new Tableau(parent.controlleur.creer_modele_table("membres"));
		tableau_etudiants.setRowHeight(70);
		tableau_etudiants.getColumnModel().getColumn(3).setMaxWidth(70);
		tableau_etudiants.setFont(f_sousTitre);
		scroll_tableau_etudiants = new JScrollPane(tableau_etudiants);
		panneau_etudiants.add(scroll_tableau_etudiants);
	}
	
	public void afficher_tableau_outils() {
		/* Ajoute les informations des outils empruntés dans le tableau */
		panneau_outils.removeAll();
		
		int nb_outils = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		Object[][] donnees_tableau = new String[nb_outils][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_outils = new Tableau(parent.controlleur.creer_modele_table("outils"));
		scroll_tableau_outils = new JScrollPane(tableau_outils);
		panneau_outils.add(scroll_tableau_outils);
	}
	
	public void afficher_tableau_materiel() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		panneau_materiel.removeAll();
		
		int nb_materiaux = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		Object[][] donnees_tableau = new String[nb_materiaux][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_materiel = new Tableau(parent.controlleur.creer_modele_table("bruts"));
		scroll_tableau_materiel = new JScrollPane(tableau_materiel);
		panneau_materiel.add(scroll_tableau_materiel);
	}
	
	public void afficher_tableau_bruts() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		panneau_bruts.removeAll();
		
		int nb_bruts = 30; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		Object[][] donnees_tableau = new String[nb_bruts][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_bruts = new Tableau(parent.controlleur.creer_modele_table("bruts"));
		scroll_tableau_bruts = new JScrollPane(tableau_bruts);
		panneau_bruts.add(scroll_tableau_bruts);
	}
	
}