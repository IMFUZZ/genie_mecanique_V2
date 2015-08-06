/**
 * Classe représentant le panneau du centre permettant d'effectuer des recherches dans l'inventaire
 * @author Daniel-Junior Dubé et Sarah Laflamme 
 * @version 1.0
 * @since 05-08-2015
 */

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class Panneau_centre_recherche extends Panneau_centre {
	
	
	public Panneau_centre_recherche(Fenetre a_parent) {
		
		super(a_parent);
		creer_contenu_onglets();
		creer_onglets();
		add(tabbed_pane);

	}

	/*
	 * Attributs d'affichage des onglets
	 */
	Dimension dimension_onglets = new Dimension(250, 50);
	Border padding_onglets = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	Border contour_onglets = BorderFactory.createEtchedBorder();
	Border bordure_onglets = new CompoundBorder(contour_onglets, padding_onglets);

	/*
	 * Conteneur des onglets
	 */
	JTabbedPane tabbed_pane;
	
	/*
	 * Panneaux représentant le contenu des onglets
	 */
	JPanel panneau_etudiants;
	JPanel panneau_outils;
	JPanel panneau_materiel;
	JPanel panneau_bruts;
	
	/*
	 * Tableaux contenant les données à afficher dans les onglets
	 */
	JTable tableau_etudiants;
	JLabel titre_tableau_etudiants;
	Panneau_scroll scroll_tableau_etudiants;
	
	JTable tableau_materiel;
	JLabel titre_tableau_materiel;
	Panneau_scroll scroll_tableau_materiel;
	
	
	
	/*
	 * Crée les JPanel qui vont contenir les tableaux
	 */
	public void creer_contenu_onglets() {
		
		panneau_etudiants = new JPanel();
		panneau_etudiants.setLayout(new BoxLayout(panneau_etudiants, BoxLayout.Y_AXIS));
		rafraichir_panneau_etudiants();
		
		panneau_outils = new JPanel();
		panneau_outils.setLayout(new BoxLayout(panneau_outils, BoxLayout.Y_AXIS));
		rafraichir_panneau_outils();
		
		panneau_materiel = new JPanel();
		panneau_materiel.setLayout(new BoxLayout(panneau_materiel, BoxLayout.Y_AXIS));
		rafraichir_panneau_materiel();
		
		panneau_bruts = new JPanel();
		panneau_bruts.setLayout(new BoxLayout(panneau_bruts, BoxLayout.Y_AXIS));
		rafraichir_panneau_bruts();
	}
	
	/*
	 * Crée les onglets permettant de naviguer entre les tableaux et les associe aux bons panneaux de contenu
	 */
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
	
	
	/*
	 * Vide le panneau_etudiants et lui ajoute un nouveau tableau contenant les informations sur les étudiants
	 */
	public void rafraichir_panneau_etudiants() {
		panneau_etudiants.removeAll();		
		scroll_tableau_etudiants = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("membres")));
		panneau_etudiants.add(scroll_tableau_etudiants);
	}
	
	/*
	 * Vide le panneau_outils et lui ajoute un nouveau tableau contenant les informations sur les outils
	 */
	public void rafraichir_panneau_outils() {
		
		panneau_outils.removeAll();
		scroll_tableau_outils = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("outils")));
		panneau_outils.add(scroll_tableau_outils);
	}
	
	/*
	 * Vide le panneau_materiel et lui ajoute un nouveau tableau contenant les informations sur le matériel
	 */
	public void rafraichir_panneau_materiel() {
		
		panneau_materiel.removeAll();
		scroll_tableau_materiel = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("bruts")));
		panneau_materiel.add(scroll_tableau_materiel);
	}
	
	/*
	 * Vide le panneau_bruts et lui ajoute un nouveau tableau contenant les informations sur les bruts
	 */
	public void rafraichir_panneau_bruts() {
		
		panneau_bruts.removeAll();
		scroll_tableau_bruts = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("bruts")));
		panneau_bruts.add(scroll_tableau_bruts);
	}
	
}