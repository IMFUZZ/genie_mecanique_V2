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
		
		initialiser_panneau();
	}
	
	/*
	 * Tableaux 
	 */
	Panneau_scroll scroll_tableau_bruts;
	Panneau_scroll scroll_tableau_bris;
	
	/*
	 * Met à jour le tableau des outils empruntés
	 */
	public void initialiser_panneau()
	{
		removeAll();
		revalidate();
		
		initialiser_tableau_outils();
		initialiser_tableau_bruts();
		initialiser_tableau_bris();
	}
	
	public void initialiser_tableau_outils() {

		scroll_tableau_outils = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("locations", parent.etudiant.id)));
		scroll_tableau_outils.set_titre("OUTILS");
		
		add(scroll_tableau_outils);
	}
	
	/*
	 * Met à jour le tableau des bruts empruntés	
	 */
	public void initialiser_tableau_bruts() {
		
		scroll_tableau_bruts = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("dons",  parent.etudiant.id)));
		scroll_tableau_bruts.set_titre("BRUTS");
		
		add(scroll_tableau_bruts);
	}
	
	/*
	 * Met à jour le tableau des outils brisés
	 */

	public void initialiser_tableau_bris() {
		
		scroll_tableau_bris = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("dons", parent.etudiant.id)));
		scroll_tableau_bris.set_titre("BRUTS");
		
		add(scroll_tableau_bris);
	}


}
