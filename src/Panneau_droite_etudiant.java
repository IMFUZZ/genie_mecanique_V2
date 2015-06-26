import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_droite_etudiant extends Panneau_droite {

	JLabel l_image_location;
	JLabel l_image_brute;
	JLabel l_image_retour;
	
	JPanel p_image_location;
	JPanel p_image_brute;
	JPanel p_image_retour;
	
	public Panneau_droite_etudiant(){
		
		p_image_location = new JPanel();
		p_image_brute = new JPanel();
		p_image_retour = new JPanel();
		
		l_image_location = faire_image("src/images/barcode.png", 300, 200);
		l_image_brute = faire_image("src/images/barcode.png", 300, 200);
		l_image_retour = faire_image("src/images/barcode.png", 300, 200);
		
		p_image_location.add(l_image_location);
		p_image_brute.add(l_image_brute);
		p_image_retour.add(l_image_retour);
		
		add(p_image_location);
		add(p_image_brute);
		add(p_image_retour);
	}
}
