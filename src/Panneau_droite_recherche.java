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
	
	JButton b_rechercher;
	JButton b_quitter;
	JButton b_test;
	
	JComboBox cb_Rechercher;
	
	JTextField t_rechercher;
	
	public Panneau_droite_recherche(Fenetre a_parent)
	{
		super(a_parent);
		
		String[] comboBoxContenu = { "Id", "Nom", "Categorie", "Description",
		"Quantite" };
		//parent.current_p_centre_recherche.tabbed_pane.ge
		cb_Rechercher = new JComboBox<String>(comboBoxContenu);
		t_rechercher = new JTextField();
		
		b_rechercher = new JButton("Rechercher");
		b_quitter = new JButton("Se Déconnecter");
		
		b_test = new JButton("Selectionner");
		
		liste_de_boites.addAll(Arrays.asList(cb_Rechercher, t_rechercher, b_rechercher, b_test, b_quitter));
		ajuster_boites();
		
		add(cb_Rechercher);
		add(t_rechercher);
		add(b_rechercher);
		add(b_test);
		add(new JPanel());
		add(b_quitter);
		
		b_rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b_quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b_test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.set_panneau_etudiant();
			}
		});
	}
	
}
