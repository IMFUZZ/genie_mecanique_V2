import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Panneau_haut_gauche_recherche extends Panneau{

	JButton l_codebarre_centre;
	
	JPanel p_image_centre;
	
	public Panneau_haut_gauche_recherche(Fenetre a_parent)
	{
		super(a_parent);
		
		setMaximumSize(new Dimension(1000, 200));
		
		l_codebarre_centre = faire_codebarre("src/images/barcode.png");
		
		p_image_centre.setLayout(new GridLayout(1,1));
		p_image_centre.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p_image_centre.add(l_codebarre_centre);
	}
}
