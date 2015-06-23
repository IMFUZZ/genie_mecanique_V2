import javax.swing.JLabel;

public class Panneau_bas extends Panneau {
	String s_notification;
	JLabel l_notification;
		
	public Panneau_bas()
	{
		s_notification = "";
		l_notification = new JLabel(s_notification);
	}
	
	public void set_notification(String a_s_notification)
	{
		s_notification = a_s_notification;
	}
}
