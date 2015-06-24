import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	
	public void ajouter_image(Panneau a_panneau, String a_chemin_image)
	{
	      try {
	          BufferedImage img = ImageIO.read(new File(a_chemin_image));
	          ImageIcon icon = new ImageIcon(img);
	          JLabel lImage = new JLabel(icon);
	          a_panneau.add(lImage);
	          /* Cette ligne montre l'image dans une fenetre 'dialogue'
	           * JOptionPane.showMessageDialog(null, lImage);
	           */
	       } catch (Exception exceptions) {
	    	   System.out.println("ERREUR : COULD NOT IMPORT IMAGE!");
	    	   exceptions.printStackTrace();
	       }
	}
	
}
