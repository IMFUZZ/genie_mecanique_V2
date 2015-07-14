import java.util.ArrayList;


public class Personne {

	int numero;
	
	String nom;
	String prenom;
	String chemin_image;
	
	
	/* Note : La location d'un outil et la prise d'un brute 
	 * revient au meme, l'important est le type et le propriétaire.
	 */
	ArrayList<String> locations;
	ArrayList<String> bris;
	
	public Personne(String a_prenom, String a_nom, String a_chemin_image)
	{
		prenom = a_prenom;
		nom = a_nom;
		chemin_image = a_chemin_image;
	}
	
	public void charger_location()
	{
		
	}
	
}
