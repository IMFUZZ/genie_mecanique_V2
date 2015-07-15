import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Programme {

	public static void main(String[] args) {
	
		Boolean professeur_existe = false;
		
		String id = "";
		
		Fenetre fenetre_principale = new Fenetre();	
		
		String temp_secret = "";

		while (!professeur_existe && (id != null))
		{
			id = (String) JOptionPane.showInputDialog(
					fenetre_principale, 			// -- Component
					"Identifiant administrateur : ",// -- Sujet
					"Connection",  					// -- Titre
					3,  							// -- Type d'icône (si l'image ne fonctionne pas)
					new ImageIcon(
							"src/images/icon_128.png"),  // -- Icône personnalisée
					null,  							// -- Liste pour comboBox (non-utilisé)
					"");  							// -- Texte par défault
			if (id != null) {
				if (fenetre_principale.controlleur.administrateur_existe(id))
				{
					professeur_existe = true;
				}
			}
		}	
		if (professeur_existe) {fenetre_principale.setVisible(true);}
		
		System.out.println("Fin de l'exécution");
	}

}
