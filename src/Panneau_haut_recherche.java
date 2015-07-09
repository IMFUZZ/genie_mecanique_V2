import java.awt.Color;

import javax.swing.JLabel;


public class Panneau_haut_recherche extends Panneau_haut {
	
	JLabel l_titre;
	
	public Panneau_haut_recherche()
	{
		l_titre = new JLabel("Logiciel de gestion d'inventaire");
		l_titre.setFont(f_titre);
		
		l_image_centre = faire_image("src/images/barcode.png", 300, 200);
		
		p_image_centre.add(l_image_centre);
		p_centre.add(p_image_centre);
	}
}
