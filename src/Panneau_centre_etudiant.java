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
		
		initialiser_tableau_outils();
		
		initialiser_tableau_bruts();
		
		initialiser_tableau_bris();
	}
	
	JTable tableau_bris;
	JLabel titre_tableau_bris;
	Panneau_scroll scroll_tableau_outils;
	Panneau_scroll scroll_tableau_bruts;
	Panneau_scroll scroll_tableau_bris;
	
	
	public void initialiser_tableau_outils() {
		/* Ajoute les informations des outils empruntés dans le tableau */

		scroll_tableau_outils = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("outils")));
		scroll_tableau_outils.set_titre("OUTILS");
		
		add(scroll_tableau_outils);
	}
	
	public void initialiser_tableau_bruts() {
		/* Ajoute les informations des bruts empruntés dans le tableau */
		
		scroll_tableau_bruts = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("bruts")));
		scroll_tableau_bruts.set_titre("BRUTS");
		
		add(scroll_tableau_bruts);
	}
	
	public void initialiser_tableau_bris() {
		/* Ajoute les informations des outils brisés dans le tableau */
		
		scroll_tableau_bris = new Panneau_scroll(new Tableau(parent.controlleur.creer_modele_table("bruts")));
		scroll_tableau_bris.set_titre("BRUTS");
		
		add(scroll_tableau_bris);
	}


}
