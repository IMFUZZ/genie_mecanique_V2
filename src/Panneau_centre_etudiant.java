import javax.swing.RowFilter;

/**
 * Classe représentant le panneau du centre affichant les informations sur les emprunts de l'étudiant
 * @author Daniel-Junior Dubé et Sarah Laflamme 
 * @version 1.0
 * @since 05-08-2015
 */

public class Panneau_centre_etudiant extends Panneau_centre {
		
	
	public Panneau_centre_etudiant(Fenetre a_parent)
	{
		super(a_parent);
		
		rafraichir_tableaux();
	}
	
	/*
	 * Tableaux 
	 */

	Tableau t_outils;
	Tableau t_bruts;
	Tableau t_bris;
	
	Panneau_scroll scroll_tableau_outils = new Panneau_scroll("OUTILS");
	Panneau_scroll scroll_tableau_bruts = new Panneau_scroll("BRUTS");
	Panneau_scroll scroll_tableau_bris = new Panneau_scroll("BRUTS");
	
	
	public void rafraichir_tableaux() {
		removeAll();
		ajouter_tableau_outils();
		ajouter_tableau_bruts();
		ajouter_tableau_bris();
		revalidate();
	}
	
	public void ajouter_tableau_outils() {
		scroll_tableau_outils.removeAll();
		t_outils = new Tableau(parent.controlleur.creer_modele_table("locations", parent.etudiant.id));
		scroll_tableau_outils = new Panneau_scroll("OUTILS", t_outils);
		add(scroll_tableau_outils);
	}
	
	/*
	 * Met à jour le tableau des bruts empruntés	
	 */
	public void ajouter_tableau_bruts() {
		scroll_tableau_bruts.removeAll();
		t_bruts= new Tableau(parent.controlleur.creer_modele_table("dons",  parent.etudiant.id));
		scroll_tableau_bruts = new Panneau_scroll("BRUTS", t_bruts);
		add(scroll_tableau_bruts);
	}
	
	/*
	 * Met à jour le tableau des outils brisés
	 */

	public void ajouter_tableau_bris() {
		scroll_tableau_bris.removeAll();
		t_bris = new Tableau(parent.controlleur.creer_modele_table("dons", parent.etudiant.id));
		scroll_tableau_bris = new Panneau_scroll("BRIS", t_bris);
		add(scroll_tableau_bris);
	}
	

	



}
