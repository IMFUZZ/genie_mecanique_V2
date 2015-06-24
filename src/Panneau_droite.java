import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;


public class Panneau_droite extends Panneau {
	
	ArrayList<JComponent> liste_de_boites;
	
	public Panneau_droite()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		liste_de_boites = new ArrayList<JComponent>();
	}

	protected void ajuster_boites()
	{
		for (int x = 0; x < liste_de_boites.size(); x++) {
			liste_de_boites.get(x).setFont(f_texte);
			liste_de_boites.get(x).setPreferredSize(
					new Dimension(boite_standard_largeur, boite_standard_hauteur));
			liste_de_boites.get(x).setMaximumSize(
					new Dimension(boite_standard_largeur, boite_standard_hauteur));
			liste_de_boites.get(x).setAlignmentX(Component.CENTER_ALIGNMENT);
		}
	}
}
