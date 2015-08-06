/**
 * Classe abstraite représentant le panneau au centre de la fenêtre
 * @author Daniel-Junior Dubé et Sarah Laflamme 
 * @version 1.0
 * @since 05-08-2015
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;


public abstract class Panneau_centre extends Panneau {


	public Panneau_centre(Fenetre a_parent)
	{
		super(a_parent);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	/**
	 * Tableaux présents dans tous les types de Panneau_centre
	 */
	JTable tableau_outils;
	JLabel titre_tableau_outils;
	Panneau_scroll scroll_tableau_outils;
	
	JTable tableau_bruts;
	JLabel titre_tableau_bruts;
	Panneau_scroll scroll_tableau_bruts;
	
	
	/**
	 * Attributs d'affichage
	 */
	BorderFactory border_factory;
	Border padding_tableaux = BorderFactory.createEmptyBorder(0, 20, 10, 20);
	
}
