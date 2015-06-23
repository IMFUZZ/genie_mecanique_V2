import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;



public abstract class Panneau extends JPanel{

	Font f_titre;
	Font f_sousTitre;
	Font f_texte;
	
	public Panneau() 
	{
		f_titre = new Font("SansSerif", Font.PLAIN, 40);
		f_sousTitre = new Font("SansSerif", Font.PLAIN, 20);
		f_texte = new Font("SansSerif", Font.PLAIN, 15);
	}
	
}
