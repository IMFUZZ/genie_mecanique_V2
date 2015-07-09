import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Panneau_centre_recherche extends Panneau_centre {
	
	
	public Panneau_centre_recherche()	{
		
		setPanneauMenu();
		add(panneauMenu);
		setPanneauxContenu();
		add(panneauxContenu);
		
	}
	
	JTable tableau_etudiants;
	JLabel titre_tableau_etudiants;
	JScrollPane scroll_tableau_etudiants;
	
	JTable tableau_materiel;
	JLabel titre_tableau_materiel;
	JScrollPane scroll_tableau_materiel;
	
	
	/**
	 * Panneau contenant les onglets
	 */
	protected JPanel panneauMenu;	
	
	/**
	 * Crée le panneau contenant les boutons du menu et l'ajoute à la fenêtre
	 */
	protected void setPanneauMenu(){
		panneauMenu = new JPanel();
		panneauMenu.setLayout(new BoxLayout(panneauMenu, BoxLayout.LINE_AXIS));
		
		ajouterBoutonEtudiants();
		ajouterBoutonOutils();
		ajouterBoutonMateriel();
		ajouterBoutonBruts();
	}
	
	/**
	 * Ajoute le bouton «Étudiants» au menu
	 */
	protected void ajouterBoutonEtudiants(){
		JButton boutonEtudiants = new JButton("Étudiants");
		panneauMenu.add(boutonEtudiants);
		
		ActionListener actionBoutonEtudiants = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutCartes.show(panneauxContenu, "Étudiants");
				afficher_etudiants(listeCartes.get(0));
			}
		};
		boutonEtudiants.addActionListener(actionBoutonEtudiants);
	}
	
	/**
	 * Ajoute le bouton « Outils » au menu
	 */
	protected void ajouterBoutonOutils(){
		JButton boutonOutils = new JButton("Outils");
		panneauMenu.add(boutonOutils);
		
		ActionListener actionBoutonOutils = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutCartes.show(panneauxContenu, "Outils");
				afficher_outils(listeCartes.get(1));
			}
		};
		boutonOutils.addActionListener(actionBoutonOutils);
	}
	
	/**
	 * Ajoute le bouton « Matériel » au menu
	 */
	protected void ajouterBoutonMateriel(){
		JButton boutonMateriel = new JButton("Matériel");
		panneauMenu.add(boutonMateriel);
		
		ActionListener actionBoutonMateriel = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutCartes.show(panneauxContenu, "Matériel");
				afficher_materiel(listeCartes.get(2));
			}
		};
		boutonMateriel.addActionListener(actionBoutonMateriel);
	}
	
	/**
	 * Ajoute le bouton « Bruts » au menu
	 */
	protected void ajouterBoutonBruts(){
		JButton boutonBruts = new JButton("Bruts");
		panneauMenu.add(boutonBruts);
		
		ActionListener actionBoutonBruts = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutCartes.show(panneauxContenu, "Bruts");
				afficher_bruts(listeCartes.get(3));
			}
		};
		boutonBruts.addActionListener(actionBoutonBruts);
	}
	
	
	
	
	
	/**
	 * Panneau contenant tous les panneaux de contenu
	 */
	protected JPanel panneauxContenu;
	/**
	 * Liste contenant les cartes de panneauxContenu
	 */
	protected ArrayList<JPanel> listeCartes;
	
	/**
	 * Layout de panneauxContenus
	 */
	protected CardLayout layoutCartes;
	
	/**
	 * Créée le panneau de contenu avec toutes ses cartes
	 */
	protected void setPanneauxContenu(){
		panneauxContenu = new JPanel();
		layoutCartes = new CardLayout();
		panneauxContenu.setLayout(layoutCartes);
		
		listeCartes = new ArrayList<JPanel>();
		
		JPanel carteEtudiants = new JPanel(); 
		carteEtudiants.setLayout(new BoxLayout(carteEtudiants, BoxLayout.Y_AXIS));
		panneauxContenu.add(carteEtudiants, "Étudiants");
		listeCartes.add(carteEtudiants);
		
		JPanel carteOutils = new JPanel();
		carteOutils.setLayout(new BoxLayout(carteOutils, BoxLayout.Y_AXIS));
		panneauxContenu.add(carteOutils, "Outils");
		listeCartes.add(carteOutils);
		
		JPanel carteMateriel = new JPanel(); 
		carteMateriel.setLayout(new BoxLayout(carteMateriel, BoxLayout.Y_AXIS));
		panneauxContenu.add(carteMateriel, "Matériel");
		listeCartes.add(carteMateriel);
		
		JPanel carteBruts = new JPanel(); 
		carteBruts.setLayout(new BoxLayout(carteBruts, BoxLayout.Y_AXIS));
		panneauxContenu.add(carteBruts, "Bruts");
		listeCartes.add(carteBruts);
		
		// Onglet affiché par défaut
		layoutCartes.show(panneauxContenu, "Étudiants");
		afficher_etudiants(listeCartes.get(0));
			
	}
	
	public void afficher_etudiants(JPanel carteEtudiants) {
		carteEtudiants.removeAll();
		JLabel labelTitre = new JLabel("Liste des étudiants");
		carteEtudiants.add(labelTitre);
		JScrollPane scrollEnCours = initialiser_tableau_etudiants();
		carteEtudiants.add(scrollEnCours);
	}
	
	public void afficher_outils(JPanel carteOutils) {
		carteOutils.removeAll();
		JLabel labelTitre = new JLabel("Liste des outils");
		carteOutils.add(labelTitre);
		JScrollPane scrollEnCours = initialiser_tableau_outils();
		carteOutils.add(scrollEnCours);
	}
	
	public void afficher_materiel(JPanel carteMateriel) {
		carteMateriel.removeAll();
		JLabel labelTitre = new JLabel("Liste du matériel");
		carteMateriel.add(labelTitre);
		JScrollPane scrollEnCours = initialiser_tableau_materiel();
		carteMateriel.add(scrollEnCours);
	}
	
	public void afficher_bruts(JPanel carteBruts) {
		carteBruts.removeAll();
		JLabel labelTitre = new JLabel("Liste des bruts");
		carteBruts.add(labelTitre);
		JScrollPane scrollEnCours = initialiser_tableau_bruts();
		carteBruts.add(scrollEnCours); 
	}

	
	public JScrollPane initialiser_tableau_etudiants() {
		/* Ajoute les informations des outils empruntés dans le tableau */
		
		int nb_etudiants = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Code utilisateur", "Prénom", "Nom", "Photo"};
		String[][] donnees_tableau = new String[nb_etudiants][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_etudiants = new JTable(donnees_tableau, noms_colonnes);
		tableau_etudiants.setGridColor(Color.LIGHT_GRAY);
		tableau_etudiants.setMaximumSize(dimension_tableaux);
		tableau_etudiants.setRowHeight(20);
		scroll_tableau_etudiants = new JScrollPane(tableau_etudiants);
		scroll_tableau_etudiants.setSize(dimension_tableaux);
		return scroll_tableau_etudiants;
	}
	
	public JScrollPane initialiser_tableau_outils() {
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
		return scroll_tableau_outils;
	}
	
	public JScrollPane initialiser_tableau_materiel() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		
		int nb_materiaux = 10; // ajuster en fonction du nb d'articles à lister
		String[] noms_colonnes = {"Id", "Description", "Responsable (professeur)"};
		String[][] donnees_tableau = new String[nb_materiaux][noms_colonnes.length];
		
		// ici aller chercher infos dans la BD
		
		tableau_materiel = new JTable(donnees_tableau, noms_colonnes);
		tableau_materiel.setGridColor(Color.LIGHT_GRAY);
		tableau_materiel.setSize(dimension_tableaux);
		tableau_materiel.setRowHeight(20);
		scroll_tableau_materiel = new JScrollPane(tableau_materiel);
		scroll_tableau_materiel.setSize(dimension_tableaux);
		return scroll_tableau_materiel;
	}
	
	public JScrollPane initialiser_tableau_bruts() {
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
		return scroll_tableau_bruts;
	}
	
}