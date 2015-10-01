import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Panneau_bas extends Panneau {
	
	JLabel l_commande;
	Object[] seuils;
		
	public Panneau_bas(Fenetre a_parent)
	{	
		super(a_parent);
		
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setLayout(new GridLayout(1,1));
		
		l_commande = new JLabel("");
		l_commande.setFont(f_texte);
		l_commande.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 100));
		
		add(l_commande);
		seuils = parent.controlleur.verifier_seuil();
		
		niveau_alerte(seuils);
	}
	
	public void set_l_commande(String a_s_notification)
	{
		l_commande.setText(a_s_notification);
	}
	
	// -------- Changer le niveau de couleur (light green, light yellow and light red)
	
	public void niveau_alerte(Object[] a_seuils)
	{
		if (a_seuils == null)
		{
			l_commande.setText("Aucun objet n'a atteint le seuil d'approvisionnement");
			setBackground(Color.green);
		}
		else if (a_seuils.length == 1)
		{
			String text = "Un objet à atteint le seuil d'approvisionnement : ";
			text += (String) a_seuils[0];
			l_commande.setText(text);
			setBackground(Color.yellow);
		}
		else if (a_seuils.length > 1)
		{
			String text = "Plusieurs objets ont atteint le seuil d'approvisionnement! : ";
			text += (String) a_seuils[0];
			for(int i = 1; i < a_seuils.length; i++)
			{
				text += ", ";
				text += (String) a_seuils[i];
			}
			l_commande.setText(text);
			
			setBackground(Color.red);
		}
		else
		{
			l_commande.setText("Erreur!");
			setBackground(Color.red);
		}
	}
}
