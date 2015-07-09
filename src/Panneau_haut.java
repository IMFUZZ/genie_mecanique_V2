import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Panneau_haut extends Panneau {
	
	JLabel l_image_centre;
	JLabel l_prof;
	JLabel l_date;
	
	JPanel p_image_centre;
	JPanel p_gauche;
	JPanel p_centre;
	JPanel p_remplissage;
	JPanel p_droite;
	
	TitledBorder b_droite;
	
	public Panneau_haut()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		
		l_image_centre = faire_image("", 300, 200);
		l_prof = new JLabel("Professeur connecté : BONJOUR TEST");
		l_date = new JLabel();
		
		l_date.setText("Date : "
				+ (dateFormat.format(cal.getTime())).toString());

		l_prof.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		l_date.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		p_gauche = new JPanel();
		p_centre = new JPanel();
		p_remplissage = new JPanel();
		p_droite = new JPanel();
		p_image_centre = new JPanel();
		
		b_droite = BorderFactory.createTitledBorder("test");
		p_droite.setBorder(b_droite);
		
		p_gauche.setMaximumSize(new Dimension(500, 300));
		p_centre.setMaximumSize(new Dimension(300, 300));
		p_remplissage.setMaximumSize(new Dimension(1000, 300));
		p_droite.setMaximumSize(new Dimension(400, 300));
		
		p_droite.setLayout(new GridLayout(2,1));
		p_image_centre.setLayout(new GridLayout(1,1));
		p_image_centre.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p_centre.setLayout(new BoxLayout(p_centre, BoxLayout.Y_AXIS));
		
		p_droite.add(l_prof);
		p_droite.add(l_date);
		
		add(p_gauche);
		add(p_centre);
		add(p_remplissage);
		add(p_droite);
		
			
		/* ----- Ces lignes servent à vérifier la position des panneaux
		 * 
		p_gauche.setBackground(Color.red);
		p_centre.setBackground(Color.pink);
		p_droite.setBackground(Color.green);
		setBackground(Color.blue);
		p_image_centre.setBackground(Color.blue);
		p_texte_image_centre.setBackground(Color.yellow);
		*/
	}
}
 