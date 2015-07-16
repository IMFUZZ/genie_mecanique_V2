import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_haut_recherche extends Panneau_haut {
	
	JLabel l_titre_debut;
	JLabel l_titre_fin;
	
	JPanel p_titre;
	
	public Panneau_haut_recherche(Fenetre a_parent)
	{
		super(a_parent);
		
		l_titre_debut = new JLabel("Logiciel de");
		l_titre_fin = new JLabel("gestion d'inventaire");
		l_titre_debut.setFont(f_titre);
		l_titre_fin.setFont(f_titre);
		
		p_titre = new JPanel();
		p_titre.setLayout(new BoxLayout(p_titre, BoxLayout.Y_AXIS));
		
		l_titre_debut.setBorder(BorderFactory.createEmptyBorder(35, 20, 0, 20));
		l_titre_fin.setBorder(BorderFactory.createEmptyBorder(0, 20, 35, 20));
		p_titre.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		p_titre.setBackground(Color.white);
		l_image_centre = faire_codebarre("src/images/barcode.png");
		
		b_codeBarre = BorderFactory.createTitledBorder("Selectionner un client");
		p_centre.setBorder(
				b_codeBarre);
		
		p_titre.add(l_titre_debut);
		p_titre.add(l_titre_fin);
		p_image_centre.add(l_image_centre);
		
		p_gauche.add(p_titre);
		p_centre.add(p_image_centre);
	}
}
