import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panneau_droite_recherche extends Panneau_droite {
	
	JTextField t_rechercher;
	
	Bouton b_rechercher;
	Bouton b_ajouter;
	Bouton b_modifier;
	Bouton b_retirer;
	Bouton b_remplir_bd;

	
	public Panneau_droite_recherche(Fenetre a_parent)
	{
		super(a_parent);
		
		b_rechercher = new Bouton("Rechercher");
		b_ajouter = new Bouton("Ajouter");
		b_modifier = new Bouton("Modifier");
		b_retirer = new Bouton("Retirer");
		b_remplir_bd = new Bouton("Remplir la base de données");
		
		t_rechercher = new JTextField();
		t_rechercher.addActionListener( 
				new AbstractAction()
				{
				    @Override
				    public void actionPerformed(ActionEvent e)
				    {
				    	b_rechercher.doClick();
				    	t_rechercher.setText("");
				    }
				});
		
		liste_de_boites.addAll(Arrays.asList(t_rechercher, b_rechercher, b_ajouter, b_modifier,  b_retirer, new JPanel(), b_remplir_bd));
		ajuster_boites();
	
		for(Iterator<JComponent> i = liste_de_boites.iterator();  i.hasNext(); ) 
		{
		    add(i.next());
		}
		
		b_rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				parent.current_p_centre_recherche.rafraichir_tableaux(t_rechercher.getText());
			}
		});
		
		b_remplir_bd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				parent.controlleur.remplir_bd();
				parent.current_p_centre_recherche.rafraichir_tableaux("");
			}
		});
		
		b_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Boolean result_null = false;
				Tableau tab = (Tableau) parent.current_p_centre_recherche.liste_tableaux[
				      parent.current_p_centre_recherche.tabbed_pane.getSelectedIndex()];
				
				ArrayList<Object> colonnes = new ArrayList<Object>();
				ArrayList<Object> data = new ArrayList<Object>();
				
				for (int x = 0; x < tab.getColumnCount(); x++)
				{
					if (!tab.getColumnName(x).equals("Photo"))
					{
						colonnes.add(tab.getColumnName(x));
						data.add("");
					}
					
				}
				Object[] result = parent.controlleur.optionPane_dynamique(colonnes.toArray(), data.toArray());
				for (int i = 0; i < result.length; i++)
				{
					if (result[i] == null){
						result_null = true;
					}
				}
				if (!result_null)
				{
					parent.controlleur.faire_ajout( 
							tab.nom_table, 
							colonnes.toArray(), 
							result);
				}
				else{
					System.out.println("données résultantes du optionPaneDynamique = null");
				}
				parent.current_p_centre_recherche.rafraichir_tableaux("");
			}
		});
		
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Boolean result_null = false;
				Tableau tab = (Tableau) parent.current_p_centre_recherche.liste_tableaux[
					                                                   				      parent.current_p_centre_recherche.tabbed_pane.getSelectedIndex()];
				int row = tab.getSelectedRow();
				
				LinkedList<Object> colonnes = new LinkedList<Object>();
				LinkedList<Object> data = new LinkedList<Object>();
				
				for (int x = 0; x < tab.getColumnCount(); x++)
				{
					if (!tab.getColumnName(x).equals("Photo")) {
						colonnes.add(tab.getColumnName(x));
						data.add(tab.getValueAt(row, x).toString());
					}
					
				}
				Object[] result = parent.controlleur.optionPane_dynamique(colonnes.toArray(), data.toArray());
				for (int i = 0; i < result.length; i++)
				{
					if (result[i] == null){
						result_null = true;
					}
				}
				if (!result_null)
				{
					parent.controlleur.faire_modification( 
							tab.getValueAt(row, 0).toString(),
							tab.nom_table, 
							colonnes.toArray(), 
							result);
				}
				parent.current_p_centre_recherche.rafraichir_tableaux("");
			}
		});
		
		b_retirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Tableau tab = (Tableau) parent.current_p_centre_recherche.liste_tableaux[
					                                                   				      parent.current_p_centre_recherche.tabbed_pane.getSelectedIndex()];
				int resultat_confirmation = JOptionPane.showConfirmDialog(null,
						"Voulez-vous vraiment effacer définitivement le champ : " 
								+ tab.getValueAt(tab.getSelectedRow(), 0).toString(),
						"Retirer" , 
						JOptionPane.YES_NO_OPTION);
				
				if (resultat_confirmation == 0){
					
					Object[] data = new Object[1];
					
					data[0] = tab.getValueAt(tab.getSelectedRow(), 0);
					
					parent.controlleur.faire_update_sqlite("DELETE FROM "+ tab.nom_table +" WHERE "+ tab.getColumnName(0) +" = ?;", data);
					
					parent.current_p_centre_recherche.rafraichir_tableaux("");
				}
			}
		});
		
	}
}
