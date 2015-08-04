import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;


public class Panneau_scroll extends JScrollPane {

	Tableau tableau;
	Font f_champ = new Font("SansSerif", Font.PLAIN, 15);
	Font f_titre = new Font("SansSerif", Font.BOLD, 20);
	TitledBorder border;
	
	public Panneau_scroll(String a_titre)
	{
		super();
		border = BorderFactory.createTitledBorder(a_titre);
		border.setTitleFont(f_titre);
		setBorder(border);
	}
	public Panneau_scroll(Tableau a_tableau)
	{
		super(a_tableau);
		tableau = a_tableau;
		if (tableau.nom_table.equals("membres"))
		{
			tableau.setRowHeight(75);
			tableau.getColumnModel().getColumn(3).setMaxWidth(75);
		}
		else
		{
			tableau.setRowHeight(35);
		}
		tableau.setFont(f_champ);
		
		border = BorderFactory.createTitledBorder("");
		border.setTitleFont(f_titre);
		setBorder(border);
	}
	public void set_titre(String a_titre)
	{
		border = BorderFactory.createTitledBorder(a_titre);
		border.setTitleFont(f_titre);
		setBorder(border);
	}
}
