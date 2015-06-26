import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public abstract class Panneau_centre extends Panneau {

	JTable tableau_outils;
	JLabel titre_tableau_outils;
	JScrollPane scroll_tableau_outils;
	
	JTable tableau_bruts;
	JLabel titre_tableau_bruts;
	JScrollPane scroll_tableau_bruts;
	
	Dimension dimension_tableaux;
	
	public Panneau_centre()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		dimension_tableaux = new Dimension(200, 200);
		setBackground(Color.cyan);	
	}
	
	public void set_tableau_outils() {
		
	}
	
	public void set_tableau_bruts() {
		
	}
	
	
	
}
