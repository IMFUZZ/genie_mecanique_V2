import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;


public abstract class Panneau_centre extends Panneau {

	JTable tableau_outils;
	JLabel titre_tableau_outils;
	JScrollPane scroll_tableau_outils;
	
	JTable tableau_bruts;
	JLabel titre_tableau_bruts;
	JScrollPane scroll_tableau_bruts;
	
	Dimension dimension_tableaux;
	
	BorderFactory border_factory;
	Border padding_tableaux = border_factory.createEmptyBorder(0, 20, 10, 20);
	
	public Panneau_centre(Fenetre a_parent)
	{
		super(a_parent);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}
