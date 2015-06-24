import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JTextField;


public class Panneau_droite_recherche extends Panneau_droite {
	
	JButton b_rechercher;
	JButton b_quitter;
	
	JTextField t_rechercher;
	
	public Panneau_droite_recherche()
	{
		b_rechercher = new JButton("Rechercher");
		b_quitter = new JButton("Quitter");
		
		t_rechercher = new JTextField();
		
		liste_de_boites.addAll(Arrays.asList(b_rechercher, b_quitter, t_rechercher));
		ajuster_boites();
		
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
