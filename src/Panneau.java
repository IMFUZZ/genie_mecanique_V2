import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;



public abstract class Panneau extends JPanel{

	Font f_titre;
	Font f_sousTitre;
	Font f_texte;
	
	int boite_standard_largeur;
	int boite_standard_hauteur;
	
	public Panneau() 
	{
		f_titre = new Font("SansSerif", Font.PLAIN, 40);
		f_sousTitre = new Font("SansSerif", Font.PLAIN, 20);
		f_texte = new Font("SansSerif", Font.PLAIN, 15);
		
		boite_standard_largeur = 120;
		boite_standard_hauteur = 40;
	}
	
}
