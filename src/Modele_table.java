import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class Modele_table extends DefaultTableModel {
    
    public Modele_table(Vector<Vector<Object>> data, Vector<String> columnNames)
    {
    	super(data, columnNames);
    }
    
    @Override
    public Class<?> getColumnClass(int column)
    {
    	switch (column)
    	{
    	case 3: return ImageIcon.class;
    	default: return String.class;
    	}
    }
}
