import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class Panneau_haut_gauche_recherche extends Panneau{

	TitledBorder t_b_codeBarre;
	Border t_b_titre_gauche;

	JPanel p_gauche;
	JPanel p_remplissage;
	JPanel p_codebarre;
	
	JPanel p_titre_gauche;
	JLabel l_image_etudiant;
	JLabel l_titre;
	JLabel l_titre_suite;
	
	JButton l_codebarre_centre;
	
	public Panneau_haut_gauche_recherche(Fenetre a_parent)
	{
		super(a_parent);
	
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		setMaximumSize(new Dimension(1000, 200));
	
		p_gauche = new JPanel();
		p_remplissage = new JPanel();
		p_codebarre = new JPanel();
		
		p_titre_gauche = new JPanel();
		
		p_gauche.setMaximumSize(new Dimension(600, 200));
		p_titre_gauche.setMaximumSize(new Dimension(600, 200));
		p_codebarre.setMaximumSize(new Dimension(400, 200));
		
		l_titre = new JLabel("Logiciel de");
		l_titre_suite = new JLabel("gestion d'inventaire");
		l_codebarre_centre = faire_codebarre("src/images/barcodes/selection.png");
		
		l_titre.setBorder(BorderFactory.createEmptyBorder(35, 20, 0, 20));
		l_titre_suite.setBorder(BorderFactory.createEmptyBorder(0, 20, 35, 20));
		
		l_titre.setFont(f_titre);
		l_titre_suite.setFont(f_titre);
		
		p_gauche.setLayout(new BoxLayout(p_gauche, BoxLayout.Y_AXIS));
		p_gauche.setAlignmentX(Component.CENTER_ALIGNMENT);
		p_remplissage.setLayout(new BoxLayout(p_remplissage, BoxLayout.X_AXIS));
		p_remplissage.setMaximumSize(new Dimension(1000, 200));
		p_codebarre.setLayout(new GridLayout(1,1));
		p_codebarre.setAlignmentX(Component.CENTER_ALIGNMENT);
		p_titre_gauche.setLayout(new BoxLayout(p_titre_gauche, BoxLayout.Y_AXIS));
		p_titre_gauche.setAlignmentX(Component.CENTER_ALIGNMENT);
		p_titre_gauche.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		p_titre_gauche.setBackground(Color.white);
		
		t_b_titre_gauche = BorderFactory.createLineBorder(Color.black, 2);
		t_b_codeBarre = BorderFactory.createTitledBorder("Retour à la selection de client");
		
		p_gauche.setBorder(
				t_b_titre_gauche);
		p_codebarre.setBorder(
				t_b_codeBarre);
	
		p_titre_gauche.add(l_titre);
		p_titre_gauche.add(l_titre_suite);
		
		p_gauche.add(p_titre_gauche);
		
		p_codebarre.add(l_codebarre_centre);
		
		add(p_gauche, BorderLayout.WEST);
		add(p_codebarre, BorderLayout.EAST);
		add(p_remplissage, BorderLayout.EAST);
		
		l_codebarre_centre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.charger_panneau_etudiant();
			}
		});
	}
}
