import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;



public abstract class Panneau extends JPanel{

	Fenetre parent;
	
	ArrayList<JComponent> liste_de_boites;
	
	Font f_titre;
	Font f_sousTitre;
	Font f_texte;
	
	int boite_standard_largeur;
	int boite_standard_hauteur;
	
	public Panneau(Fenetre a_parent) 
	{
		parent = a_parent;
		
		setVisible(true);
		
		liste_de_boites = new ArrayList<JComponent>();
		
		f_titre = new Font("SansSerif", Font.PLAIN, 40);
		f_sousTitre = new Font("SansSerif", Font.PLAIN, 20);
		f_texte = new Font("SansSerif", Font.PLAIN, 15);
		
		boite_standard_largeur = 150;
		boite_standard_hauteur = 50;
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
	
	public JLabel faire_image(String a_chemin_image, int largeur, int hauteur)
	{
	      try {
	          JLabel lImage = new JLabel(
	        		  (new ImageIcon(
	        				  ((new ImageIcon(
	        						  a_chemin_image)).getImage()).getScaledInstance(
	        								  largeur, 
	        								  hauteur, 
	        								  java.awt.Image.SCALE_SMOOTH))));
	          /* Cette ligne montre l'image dans une fenetre 'dialogue'
	           * JOptionPane.showMessageDialog(null, lImage);
	           */
	          return lImage;
	       } catch (Exception exceptions) {
	    	   System.out.println("ERREUR : COULD NOT IMPORT IMAGE!");
	    	   exceptions.printStackTrace();
	       }
	      return new JLabel("Erreur : image inexistante!");
	}
	
	public JButton faire_codebarre(String a_chemin_image)
	{
	      try {
	          JButton lImage = new JButton(
	        		  (new ImageIcon(
	        				  ((new ImageIcon(
	        						  a_chemin_image)).getImage()).getScaledInstance(
	        								  150, 
	        								  100, 
	        								  java.awt.Image.SCALE_SMOOTH))));
	          /* Cette ligne montre l'image dans une fenetre 'dialogue'
	           * JOptionPane.showMessageDialog(null, lImage);
	           */
	          return lImage;
	       } catch (Exception exceptions) {
	    	   System.out.println("ERREUR : COULD NOT IMPORT IMAGE!");
	    	   exceptions.printStackTrace();
	       }
	      return new JButton("Erreur : image inexistante!");
	}
}
