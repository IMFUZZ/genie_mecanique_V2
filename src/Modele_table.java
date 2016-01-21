import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


public class Modele_table extends DefaultTableModel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nom_table;
	
    public Modele_table(String a_nom_table, Vector<Vector<Object>> data, Vector<String> columnNames)
    {
    	super(data, columnNames);
    	nom_table = a_nom_table;
    	if (nom_table == "membres")
    	{
        	for (int i=0; i < data.size(); i++) {
        		String path = getValueAt(i, 3).toString();
        		ImageIcon image_etudiant = new ImageIcon(path);
        		Image img = image_etudiant.getImage();
        		Image newimg = img.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
        		setValueAt(new ImageIcon(newimg), i, 3); 
        	}
    	}
    	
    }
    
    @Override
    public Class<?> getColumnClass(int column)
    {
    	if (column == 3 && nom_table == "membres") {
    		return ImageIcon.class;
    	}
    	else {
    		return getValueAt(0, column).getClass();
    	}
    }
}
