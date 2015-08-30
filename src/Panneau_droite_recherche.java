import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;

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
			public void actionPerformed(ActionEvent e) {
				parent.current_p_centre_recherche.rafraichir_tableaux(t_rechercher.getText());
			}
		});
		
		b_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		b_retirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
}
