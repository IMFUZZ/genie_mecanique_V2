import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class Panneau_droite_recherche extends Panneau_droite {
	
	JButton b_rechercher;
	JButton b_quitter;
	
	JComboBox sRechercher;
	
	JTextField t_rechercher;
	
	public Panneau_droite_recherche()
	{
		t_rechercher = new JTextField();
		
		b_rechercher = new JButton("Rechercher");
		b_quitter = new JButton("Quitter");
		
		liste_de_boites.addAll(Arrays.asList(t_rechercher, b_rechercher, b_quitter));
		ajuster_boites();
		
		add(t_rechercher);
		add(b_rechercher);
		add(b_quitter);
		
		b_rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b_quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
}
