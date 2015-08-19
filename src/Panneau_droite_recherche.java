import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panneau_droite_recherche extends Panneau_droite {
	
	Bouton b_rechercher;
	Bouton b_quitter;
	
	JComboBox cb_Rechercher;
	
	JTextField t_rechercher;
	
	public Panneau_droite_recherche(Fenetre a_parent)
	{
		super(a_parent);
		
/*		String[] comboBoxContenu = { "Id", "Nom", "Categorie", "Description",
		"Quantite" };
		cb_Rechercher = new JComboBox<String>(comboBoxContenu);
		*/
		t_rechercher = new JTextField();
		
		b_rechercher = new Bouton("Rechercher");
		b_quitter = new Bouton("Se Déconnecter");
		
		liste_de_boites.addAll(Arrays.asList(t_rechercher, b_rechercher, b_quitter));
		ajuster_boites();
		
		//add(cb_Rechercher);
		add(t_rechercher);
		add(b_rechercher);
		add(new JPanel());
		add(b_quitter);
		
		b_rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.current_p_centre_recherche.rafraichir_tableaux(t_rechercher.getText());
			}
		});
		b_quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
}
