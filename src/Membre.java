import java.util.ArrayList;


public class Membre {
	
	String id;
	String nom;
	String prenom;
	String chemin_image;
	int est_administrateur;

	/* Note : La location d'un outil et la prise d'un brute 
	 * revient au meme, l'important est le type et le propriétaire.
	 */
	ArrayList<String> locations;
	ArrayList<String> bris;
	
	public Membre(Object a_id, Object a_prenom, Object a_nom, Object a_chemin_image, Object a_est_administrateur)
	{
		try
		{
			if (!a_id.equals(""))
			{
				id = (String) a_id;
				prenom = (String) a_prenom;
				nom = (String) a_nom;
				chemin_image = (String) a_chemin_image;
				est_administrateur = (int) a_est_administrateur;
			}
			else
			{
				
			}

		} catch (Exception e) {
			System.out.println("Impossible de créer l'objet 'Membre'!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	public Membre()
	{
		id = "";
		prenom = "";
		nom = "";
		chemin_image = "";
		est_administrateur = 0;
	}
	
	public void charger_location()
	{
		
	}
	
}
