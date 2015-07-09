import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_haut_recherche extends Panneau_haut {
	
	JLabel l_titre;
	
	JPanel p_titre;
	
	public Panneau_haut_recherche()
	{
		l_titre = new JLabel("Logiciel de gestion d'inventaire");
		l_titre.setFont(f_titre);
		
		p_titre = new JPanel();
		p_titre.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		l_image_centre = faire_codebarre("src/images/barcode.png");
		
		b_codeBarre = BorderFactory.createTitledBorder("Selectionner un client");
		p_centre.setBorder(
				b_codeBarre);
		
		p_titre.add(l_titre);
		p_image_centre.add(l_image_centre);
		
		p_gauche.add(p_titre);
		p_centre.add(p_image_centre);
	}
}
