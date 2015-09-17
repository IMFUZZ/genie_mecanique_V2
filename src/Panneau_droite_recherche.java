import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panneau_droite_recherche extends Panneau_droite {
	
	JTextField t_rechercher;
	
	Bouton b_rechercher;
	Bouton b_ajouter;
	Bouton b_retirer;
	
	public Panneau_droite_recherche(Fenetre a_parent)
	{
		super(a_parent);

		t_rechercher = new JTextField();
		
		b_rechercher = new Bouton("Rechercher");
		b_ajouter = new Bouton("Ajouter");
		b_retirer = new Bouton("Retirer");
		
		liste_de_boites.addAll(Arrays.asList(t_rechercher, b_rechercher, b_ajouter,  b_retirer, new JPanel()));
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
		
		b_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Boolean result_null = false;
				Tableau tab = (Tableau) parent.current_p_centre_recherche.liste_tableaux[
				      parent.current_p_centre_recherche.tabbed_pane.getSelectedIndex()];
				
				Object[] colonnes = new Object[tab.getColumnCount()];
				Object[] data = new Object[tab.getColumnCount()];
				
				for (int x = 0; x < tab.getColumnCount(); x++)
				{
					colonnes[x] = tab.getColumnName(x);
					data[x] = "";
					
				}
				Object[] result = parent.controlleur.optionPane_dynamique(colonnes, data);
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
							colonnes, 
							result);
				}
			}
		});
		
		b_retirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
	}
}
