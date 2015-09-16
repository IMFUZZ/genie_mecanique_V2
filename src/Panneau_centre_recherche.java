/**
 * Classe représentant le panneau du centre permettant d'effectuer des recherches dans l'inventaire
 * @author Daniel-Junior Dubé et Sarah Laflamme 
 * @version 1.0
 * @since 05-08-2015
 */

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class Panneau_centre_recherche extends Panneau_centre {
	
	Tableau t_materiaux;
	Tableau t_etudiants;
	Tableau t_outils;
	Tableau t_bruts;
	
	Tableau[] liste_tableaux = {t_materiaux, t_etudiants, t_outils, t_bruts};
	
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
		
		panneau_outils = new JPanel();
		panneau_outils.setLayout(new BoxLayout(panneau_outils, BoxLayout.Y_AXIS));
		
		panneau_materiel = new JPanel();
		panneau_materiel.setLayout(new BoxLayout(panneau_materiel, BoxLayout.Y_AXIS));
		
		panneau_bruts = new JPanel();
		panneau_bruts.setLayout(new BoxLayout(panneau_bruts, BoxLayout.Y_AXIS));
		
		rafraichir_tableaux("");
	}
	
	/*
	 * Crée les onglets permettant de naviguer entre les tableaux et les associe aux bons panneaux de contenu
	 */
	public void creer_onglets() {
		tabbed_pane = new JTabbedPane();
		tabbed_pane.addTab("", panneau_etudiants);
		tabbed_pane.addTab("", panneau_outils);
		tabbed_pane.addTab("", panneau_materiel);
		tabbed_pane.addTab("", panneau_bruts);
		
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
	public void ajouer_panneau_etudiants(String a_filtre) {
		panneau_etudiants.removeAll();		
		t_etudiants = new Tableau(parent.controlleur.creer_modele_table("membres", ""));
		t_etudiants.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + a_filtre));
		scroll_tableau_etudiants = new Panneau_scroll(t_etudiants);
		panneau_etudiants.add(scroll_tableau_etudiants);
		t_etudiants.addMouseListener(new java.awt.event.MouseAdapter()
	    {
			public void mousePressed(java.awt.event.MouseEvent e)
			{
				if (e.getClickCount() == 2) {
					LinkedList<Object> a_noms_colonnes = new LinkedList<Object>();
					LinkedList<Object> a_donnees_ligne = new LinkedList<Object>();
					int row=t_etudiants.rowAtPoint(e.getPoint());
					for(int i = 0;i < t_etudiants.getColumnCount(); i++)
					{
						if (!t_etudiants.getColumnName(i).equals("Photos")) {
							a_noms_colonnes.add(t_etudiants.getColumnName(i));
							a_donnees_ligne.add(t_etudiants.getValueAt(row,i).toString());					
						}				
					}
					Object[] nouvelle_valeurs = parent.controlleur.optionPane_dynamique(a_noms_colonnes.toArray(), a_donnees_ligne.toArray());
					parent.controlleur.faire_modification(
							(String)nouvelle_valeurs[0], 
							t_etudiants.nom_table, 
							a_noms_colonnes.toArray(), 
							nouvelle_valeurs);
					rafraichir_tableaux("");
				}
			}
	    });
	}
	
	/*
	 * Vide le panneau_outils et lui ajoute un nouveau tableau contenant les informations sur les outils
	 */
	public void ajouter_panneau_outils(String a_filtre) {
		
		panneau_outils.removeAll();
		t_outils = new Tableau(parent.controlleur.creer_modele_table("outils", ""));
		t_outils.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + a_filtre));
		scroll_tableau_outils = new Panneau_scroll(t_outils);
		panneau_outils.add(scroll_tableau_outils);
		t_outils.addMouseListener(new java.awt.event.MouseAdapter()
	    {
			public void mousePressed(java.awt.event.MouseEvent e)
			{
				if (e.getClickCount() == 2) {
					LinkedList<Object> a_noms_colonnes = new LinkedList<Object>();
					LinkedList<Object> a_donnees_ligne = new LinkedList<Object>();
					int row=t_outils.rowAtPoint(e.getPoint());
					for(int i = 0;i < t_outils.getColumnCount(); i++)
					{
						a_noms_colonnes.add(t_outils.getColumnName(i));
						a_donnees_ligne.add(t_outils.getValueAt(row,i).toString());					
					}
					Object[] nouvelle_valeurs = parent.controlleur.optionPane_dynamique(a_noms_colonnes.toArray(), a_donnees_ligne.toArray());
					parent.controlleur.faire_modification(
							(String)nouvelle_valeurs[0], 
							t_outils.nom_table, 
							a_noms_colonnes.toArray(), 
							nouvelle_valeurs);
					rafraichir_tableaux("");
				}
			}
	    });
	}
	
	/*
	 * Vide le panneau_materiel et lui ajoute un nouveau tableau contenant les informations sur le matériel
	 */
	public void ajouter_panneau_materiel(String a_filtre) {
		
		panneau_materiel.removeAll();
		t_materiaux = new Tableau(parent.controlleur.creer_modele_table("bruts", ""));
		t_materiaux.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + a_filtre));
		scroll_tableau_materiel = new Panneau_scroll(t_materiaux);
		panneau_materiel.add(scroll_tableau_materiel);
		t_materiaux.addMouseListener(new java.awt.event.MouseAdapter()
	    {
			public void mousePressed(java.awt.event.MouseEvent e)
			{
				if (e.getClickCount() == 2) {
					LinkedList<Object> a_noms_colonnes = new LinkedList<Object>();
					LinkedList<Object> a_donnees_ligne = new LinkedList<Object>();
					int row=t_materiaux.rowAtPoint(e.getPoint());
					for(int i = 0;i < t_materiaux.getColumnCount(); i++)
					{
						a_noms_colonnes.add(t_materiaux.getColumnName(i));
						a_donnees_ligne.add(t_materiaux.getValueAt(row,i).toString());					
					}
					Object[] nouvelle_valeurs = parent.controlleur.optionPane_dynamique(a_noms_colonnes.toArray(), a_donnees_ligne.toArray());
					parent.controlleur.faire_modification(
							(String)nouvelle_valeurs[0], 
							t_materiaux.nom_table, 
							a_noms_colonnes.toArray(), 
							nouvelle_valeurs);
					rafraichir_tableaux("");
				}
			}
	    });
	}
	
	/*
	 * Vide le panneau_bruts et lui ajoute un nouveau tableau contenant les informations sur les bruts
	 */
	public void ajouter_panneau_bruts(String a_filtre) {
		
		panneau_bruts.removeAll();
		t_bruts = new Tableau(parent.controlleur.creer_modele_table("bruts", ""));
		t_bruts.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + a_filtre));
		scroll_tableau_bruts = new Panneau_scroll(t_bruts);
		panneau_bruts.add(scroll_tableau_bruts);
		t_bruts.addMouseListener(new java.awt.event.MouseAdapter()
	    {
			public void mousePressed(java.awt.event.MouseEvent e)
			{
				if (e.getClickCount() == 2) {
					LinkedList<Object> a_noms_colonnes = new LinkedList<Object>();
					LinkedList<Object> a_donnees_ligne = new LinkedList<Object>();
					int row=t_bruts.rowAtPoint(e.getPoint());
					for(int i = 0;i < t_bruts.getColumnCount(); i++)
					{
						a_noms_colonnes.add(t_bruts.getColumnName(i));
						a_donnees_ligne.add(t_bruts.getValueAt(row,i).toString());					
					}
					Object[] nouvelle_valeurs = parent.controlleur.optionPane_dynamique(a_noms_colonnes.toArray(), a_donnees_ligne.toArray());
					parent.controlleur.faire_modification(
							(String)nouvelle_valeurs[0], 
							t_bruts.nom_table, 
							a_noms_colonnes.toArray(), 
							nouvelle_valeurs);
					rafraichir_tableaux("");
				}
			}
	    });
	}
	
	public void rafraichir_tableaux(String a_filtre) {
		parent.setEnabled(false);
		ajouer_panneau_etudiants(a_filtre);
		ajouter_panneau_outils(a_filtre);
		ajouter_panneau_materiel(a_filtre);
		ajouter_panneau_bruts(a_filtre);
		revalidate();
		parent.setEnabled(true);
	}
	
}