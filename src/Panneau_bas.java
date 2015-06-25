import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;

public class Panneau_bas extends Panneau {
	
	String s_notification;
	JLabel l_notification;
		
	public Panneau_bas()
	{	
		s_notification = "";
		
		l_notification = new JLabel(s_notification);
		l_notification.setFont(f_texte);
		
		add(l_notification);
		
		niveau_alerte(0);
	}
	
	public void set_notification(String a_s_notification)
	{
		s_notification = a_s_notification;
	}
	
	public void niveau_alerte(int niveau)
	{
		if (niveau == 0)
			{setBackground(Color.green);}
		else if (niveau == 1)
			{setBackground(Color.yellow);}
		else if (niveau == 2)
			{setBackground(Color.red);}
		else
			{setBackground(Color.green);}
	}
}
