import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Fenetre extends JFrame{

	Panneau_centre_recherche current_p_centre_recherche;
	Panneau_bas current_p_bas_recherche;
	Panneau_droite_recherche current_p_droit_recherche;
	
	Panneau_haut current_p_haut;
	Panneau_centre_etudiant current_p_centre_etudiant;
	Panneau_bas current_p_bas_etudiant;
	Panneau_droite_etudiant current_p_droit_etudiant;
	
	JPanel p_haut;
	JPanel p_gauche;
	JPanel p_centre;
	JPanel p_droite;
	JPanel p_bas;
	
	JTextField t_commande;
	
	int screen_height;
	int screen_width;
	
	Membre administrateur = new Membre();
	Membre etudiant = new Membre();
	Controlleur controlleur;
	
	public Fenetre() {
		
		new JFrame();
		UIManager.put("TitledBorder.border", new LineBorder(new Color(125,125,125), 1));
		
		t_commande = new JTextField();
		t_commande.setPreferredSize(
				new Dimension(150, 30));
		t_commande.setMaximumSize(
				new Dimension(150, 30));
		
		controlleur = new Controlleur(this);

		setTitle("Système de gestion - 2014");
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setMinimumSize(new Dimension(800, 600));
		
		setLayout(new BorderLayout());
		setVisible(false);
		
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
		
		current_p_haut = new Panneau_haut(this);
		
		current_p_centre_recherche = new Panneau_centre_recherche(this);
		current_p_droit_recherche = new Panneau_droite_recherche(this);
		current_p_bas_recherche = new Panneau_bas(this);
		
		current_p_centre_etudiant = new Panneau_centre_etudiant(this);
		current_p_droit_etudiant = new Panneau_droite_etudiant(this);
		current_p_bas_etudiant = new Panneau_bas(this);
		
		p_bas.add(current_p_bas_recherche);
		p_droite.add(current_p_droit_recherche);
		p_haut.add(current_p_haut);
		p_centre.add(current_p_centre_recherche);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				setVisible(false);
			}
		});
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      public boolean dispatchKeyEvent(KeyEvent e) {
		        System.out.println(e.getKeyChar());
		        return false;
		      }
		});
	}
	
	public void set_panneau_recherche()
	{	
		p_bas.removeAll();
		p_droite.removeAll();
		p_centre.removeAll();
		
		p_bas.revalidate();
		p_droite.revalidate();
		p_centre.revalidate();
		
		p_bas.add(current_p_bas_recherche);
		p_droite.add(current_p_droit_recherche);
		p_centre.add(current_p_centre_recherche);
	}
	
	public void set_panneau_etudiant()
	{		
		p_bas.removeAll();
		p_droite.removeAll();
		p_centre.removeAll();
		
		p_bas.revalidate();
		p_droite.revalidate();
		p_centre.revalidate();
		
		p_bas.add(current_p_bas_etudiant);
		p_droite.add(current_p_droit_etudiant);
		p_centre.add(current_p_centre_etudiant);
	}
	
	public void set_administrateur(Membre a_membre)
	{
		administrateur = a_membre;
	}

	
}
