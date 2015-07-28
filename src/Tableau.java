import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Tableau extends JTable {
	
	public Tableau(Modele_table a_modele_table) {
		super(a_modele_table);
		setGridColor(Color.LIGHT_GRAY);
		setRowHeight(30);
		setRowMargin(0);
	}
	

}
