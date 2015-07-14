import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	JPanel p_haut;
	JPanel p_gauche;
	JPanel p_centre;
	JPanel p_droite;
	JPanel p_bas;
	
	int screen_height;
	int screen_width;
	
	Personne utilisateur;
	
	public Fenetre() {
		/* Constructeur de l'objet Fenetre */
		
		new JFrame();

		setTitle("Système de gestion - 2014");
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Met la fenêtre "fullscreen" si elle est "resizable"
		setMinimumSize(new Dimension(800, 600));
		
		setLayout(new BorderLayout());
		setVisible(false);
		/*  ----- Affecte le "fullscreen" -----
		setResizable(false);
		 */
		
		screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		p_haut = new JPanel();
		p_gauche = new JPanel();
		p_centre = new JPanel();
		p_droite = new JPanel();
		p_bas = new JPanel();
		
		p_haut.setLayout(new GridLayout(1, 1));
		p_gauche.setLayout(new GridLayout(1, 1));
		p_centre.setLayout(new GridLayout(1, 1));
		p_droite.setLayout(new GridLayout(1, 1));
		p_bas.setLayout(new GridLayout(1, 1));
		
		add(p_haut, BorderLayout.NORTH);
		add(p_gauche, BorderLayout.WEST);
		add(p_centre, BorderLayout.CENTER);
		add(p_droite, BorderLayout.EAST);
		add(p_bas, BorderLayout.SOUTH);
		
		set_panneau_recherche();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				setVisible(false);
			}
		});
	}
	
	public void set_panneau_recherche()
	{
		p_bas.add(new Panneau_bas());
		p_droite.add(new Panneau_droite_recherche());
		p_haut.add(new Panneau_haut_recherche());
		p_centre.add(new Panneau_centre_recherche());
	}
	
	public void set_panneau_etudiant()
	{
		p_bas.add(new Panneau_bas());
		p_droite.add(new Panneau_droite_etudiant());
		p_haut.add(new Panneau_haut_etudiant());
		p_centre.add(new Panneau_centre_etudiant());
	}
}
