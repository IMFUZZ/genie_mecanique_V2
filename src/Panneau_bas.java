import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;

public class Panneau_bas extends Panneau {
	
	JLabel l_commande;
		
	public Panneau_bas()
	{	
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setLayout(new GridLayout(1,1));
		
		l_commande = new JLabel("");
		l_commande.setFont(f_texte);
		l_commande.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 100));
		
		add(l_commande);
		
		niveau_alerte(0);
	}
	
	public void set_l_commande(String a_s_notification)
	{
		l_commande.setText(a_s_notification);
	}
	
	public void niveau_alerte(int niveau_alerte)
	{
		if (niveau_alerte == 0)
		{
			l_commande.setText("Aucune commande nécessaire!");
			setBackground(Color.green);
		}
		else if (niveau_alerte == 1)
		{
			l_commande.setText("Certaines quantitées de brutes sont près du seuil de livraison!");
			setBackground(Color.yellow);
		}
		else
		{
			l_commande.setText("Vous devez commander des brutes!");
			setBackground(Color.red);
		}
	}
}
