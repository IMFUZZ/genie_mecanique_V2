import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panneau_droite_etudiant extends Panneau_droite {

	JLabel l_image_location;
	JLabel l_image_brute;
	JLabel l_image_retour;
	
	JLabel l_texte_image_location;
	JLabel l_texte_image_brute;
	JLabel l_texte_image_retour;
	
	JPanel p_image_location;
	JPanel p_image_brute;
	JPanel p_image_retour;
	
	public Panneau_droite_etudiant(){
		
		p_image_location = new JPanel();
		p_image_brute = new JPanel();
		p_image_retour = new JPanel();
		
		p_image_location.setLayout(new BoxLayout(p_image_location, BoxLayout.Y_AXIS));
		p_image_brute.setLayout(new BoxLayout(p_image_brute, BoxLayout.Y_AXIS));
		p_image_retour.setLayout(new BoxLayout(p_image_retour, BoxLayout.Y_AXIS));
		
		l_image_location = faire_codebarre("src/images/barcode.png");
		l_image_brute = faire_codebarre("src/images/barcode.png");
		l_image_retour = faire_codebarre("src/images/barcode.png");
		
		l_texte_image_location = new JLabel("Faire emprunt");
		l_texte_image_brute = new JLabel("Donner brutes");
		l_texte_image_retour = new JLabel("Faire retour");
		
		p_image_location.add(l_image_location);
		p_image_location.add(l_texte_image_location);
		p_image_brute.add(l_image_brute);
		p_image_brute.add(l_texte_image_brute);
		p_image_retour.add(l_image_retour);
		p_image_retour.add(l_texte_image_retour);
		
		add(p_image_location);
		add(p_image_brute);
		add(p_image_retour);
	}
}
