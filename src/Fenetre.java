import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Fenetre extends JFrame {

	JPanel p_haut;
	JPanel p_gauche;
	JPanel p_centre;
	JPanel p_droite;
	JPanel p_bas;
	
	int screen_height;
	int screen_width;
	
	public Fenetre() {
		/* Constructeur de l'objet Fenetre */
		
		new JFrame();
		setTitle("Système de gestion - 2014");
		setLayout(new BorderLayout());
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setVisible(false);
		
		screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		p_haut = new JPanel();
		p_gauche = new JPanel();
		p_centre = new JPanel();
		p_droite = new JPanel();
		p_bas = new JPanel();
		
		add(p_haut, BorderLayout.NORTH);
		add(p_gauche, BorderLayout.WEST);
		add(p_centre, BorderLayout.CENTER);
		add(p_droite, BorderLayout.EAST);
		add(p_bas, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				setVisible(false);
			}
		});
	}
}
