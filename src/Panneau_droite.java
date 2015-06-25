import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;


public class Panneau_droite extends Panneau {
	
	public Panneau_droite()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBackground(Color.red);
	}
}
