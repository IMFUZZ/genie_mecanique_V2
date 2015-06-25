import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;

public class Panneau_bas extends Panneau {
	String s_notification;
	JLabel l_notification;
		
	public Panneau_bas()
	{
		setLayout(new GridLayout());
		setBackground(Color.red);
		s_notification = "allo";
		l_notification = new JLabel(s_notification);
		l_notification.setFont(f_texte);
	}
	
	public void set_notification(String a_s_notification)
	{
		s_notification = a_s_notification;
	}
}
