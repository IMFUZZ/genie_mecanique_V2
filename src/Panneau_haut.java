import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau_haut extends Panneau {
	
	JLabel l_image_centre;
	JLabel l_texte_image_centre;
	
	JPanel p_image_centre;
	JPanel p_texte_image_centre;
	JPanel p_gauche;
	JPanel p_centre;
	JPanel p_droite;
	
	public Panneau_haut()
	{
		l_image_centre = faire_image("", 300, 200);
		l_texte_image_centre = new JLabel("");
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		p_gauche = new JPanel();
		p_centre = new JPanel();
		p_droite = new JPanel();
		p_image_centre = new JPanel();
		p_texte_image_centre = new JPanel();
		
		p_image_centre.setLayout(new FlowLayout());
		p_texte_image_centre.setLayout(new FlowLayout());
		
		p_image_centre.setAlignmentX(Component.CENTER_ALIGNMENT);
		p_texte_image_centre.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p_centre.setLayout(new BoxLayout(p_centre, BoxLayout.Y_AXIS));
		
		add(p_gauche);
		add(p_centre);
		add(p_droite);
		
		p_texte_image_centre.add(l_texte_image_centre);
			
		/* ----- Ces lignes servent à vérifier la position des panneaux
		 * 
		 */
		p_gauche.setBackground(Color.red);
		p_centre.setBackground(Color.pink);
		p_droite.setBackground(Color.green);
		setBackground(Color.blue);
		p_image_centre.setBackground(Color.blue);
		p_texte_image_centre.setBackground(Color.yellow);
		
	}
}
 