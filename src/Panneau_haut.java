import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Panneau_haut extends Panneau {
	
	JButton l_codebarre_centre;
	JLabel l_prof_prenom;
	JLabel l_prof_nom;
	JLabel l_date;
	
	JPanel p_image_centre;
	JPanel p_gauche;
	JPanel p_centre;
	JPanel p_remplissage;
	JPanel p_droite;
	
	TitledBorder b_codeBarre;
	TitledBorder b_droite;
	
	Panneau_haut_gauche_etudiant p_haut_gauche_etudiant;
	
	public Panneau_haut(Fenetre a_parent)
	{
		super(a_parent);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		
		l_prof_prenom = new JLabel(parent.administrateur.prenom);
		l_prof_nom = new JLabel(parent.administrateur.nom);
		l_date = new JLabel();
		
		l_prof_prenom.setFont(f_sousTitre);
		l_prof_nom.setFont(f_sousTitre);
		l_date.setText("Date : "
				+ (dateFormat.format(cal.getTime())).toString());

		l_prof_prenom.setBorder(BorderFactory.createEmptyBorder(30, 10, 0, 10));
		l_prof_nom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		l_date.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
		
		p_gauche = new JPanel();
		p_centre = new JPanel();
		p_remplissage = new JPanel();
		p_droite = new JPanel();
		p_image_centre = new JPanel();
		p_haut_gauche_etudiant = new Panneau_haut_gauche_etudiant(parent);
		
		b_droite = BorderFactory.createTitledBorder("Administrateur(e) connecté(e) : ");
		p_droite.setBorder(b_droite);
		
		p_gauche.setMaximumSize(new Dimension(1000, 200));
		//p_remplissage.setMaximumSize(new Dimension(300, 200));
		p_centre.setMaximumSize(new Dimension(1000, 200));
		p_droite.setMaximumSize(new Dimension(500, 200));
		
		p_gauche.setLayout(new BoxLayout(p_gauche, BoxLayout.Y_AXIS));
		p_droite.setLayout(new BoxLayout(p_droite, BoxLayout.Y_AXIS));
		p_image_centre.setLayout(new GridLayout(1,1));
		p_image_centre.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p_centre.setLayout(new BoxLayout(p_centre, BoxLayout.Y_AXIS));
		

		p_gauche.add(p_haut_gauche_etudiant);
		p_droite.add(l_prof_prenom);
		p_droite.add(l_prof_nom);
		p_droite.add(l_date);
		p_centre.add(parent.t_commande);
		p_centre.setBackground(Color.red);
		
		add(p_gauche);
	//	add(p_remplissage);
		add(p_centre);
		add(p_droite);
		
		
		//p_gauche.add(p_haut_gauche_etudiant);
		
	}
	public void actualiser()
	{
		l_prof_prenom.setText(parent.administrateur.prenom);
		l_prof_nom.setText(parent.administrateur.nom); 
	}
}
 