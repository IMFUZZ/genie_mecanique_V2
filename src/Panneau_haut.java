import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Panneau_haut extends Panneau {
	
	Bouton l_codebarre_centre;
	
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
	
	public Panneau_haut(Fenetre a_parent)
	{
		super(a_parent);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		
		l_prof_prenom = new JLabel(parent.administrateur.prenom);
		l_prof_nom = new JLabel(parent.administrateur.nom);
		l_date = new JLabel();
		
		
		
		
		liste_de_boites.add(parent.b_lancer_commande);
		
		ajuster_boites();
		
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
		
		b_droite = BorderFactory.createTitledBorder("Administrateur(e) connecté(e) : ");
		p_droite.setBorder(b_droite);
		
		p_gauche.setMaximumSize(new Dimension(1000, 200));
		p_centre.setMaximumSize(new Dimension(1000, 200));
		p_droite.setMaximumSize(new Dimension(500, 200));
		
		p_gauche.setLayout(new BoxLayout(p_gauche, BoxLayout.Y_AXIS));
		p_droite.setLayout(new BoxLayout(p_droite, BoxLayout.Y_AXIS));
		p_image_centre.setLayout(new GridLayout(1,1));
		p_image_centre.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p_centre.setLayout(new BoxLayout(p_centre, BoxLayout.Y_AXIS));

		p_droite.add(l_prof_prenom);
		p_droite.add(l_prof_nom);
		p_droite.add(l_date);
		p_centre.add(parent.t_commande);
		p_centre.add(parent.b_lancer_commande);
		
		set_panneau_gauche_recherche();
		
		
	}
	public void set_panneau_gauche_recherche()
	{
		removeAll();
		revalidate();
		
		add(new Panneau_haut_gauche_recherche(parent));
		add(p_centre);
		add(p_droite);
	}
	public void set_panneau_gauche_etudiant()
	{
		removeAll();
		revalidate();
		
		add(new Panneau_haut_gauche_etudiant(parent));
		add(p_centre);
		add(p_droite);
	}
	public void actualiser()
	{
		l_prof_prenom.setText(parent.administrateur.prenom);
		l_prof_nom.setText(parent.administrateur.nom); 
	}
}
 