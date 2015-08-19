import java.awt.Color;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class Tableau extends JTable {
	
	String nom_table;
	TableRowSorter sorter;
	
	public Tableau(Modele_table a_modele_table) {
		// The regex filter is a work in progress
		
		super(a_modele_table);
		sorter = new TableRowSorter(a_modele_table);
		setRowSorter(sorter);
		nom_table = ((Modele_table) getModel()).nom_table;
		setGridColor(Color.LIGHT_GRAY);
		setRowHeight(30);
		setRowMargin(0);
		setFillsViewportHeight(true);
		
		sorter.setRowFilter(RowFilter.regexFilter(""));
	}

}
