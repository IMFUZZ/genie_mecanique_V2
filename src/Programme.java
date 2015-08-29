import java.awt.KeyboardFocusManager;
import java.nio.charset.Charset;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Programme {

	public static void main(String[] args) {
		
		String id = "";
		
		Fenetre fenetre_principale = new Fenetre();	

		System.out.println(Charset.defaultCharset());	
		
		while (!fenetre_principale.administrateur.est_administrateur)
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
				Membre temp = fenetre_principale.controlleur.creer_membre(id);
				if (temp.est_administrateur)
				{
					fenetre_principale.set_administrateur(temp);
					System.out.println(fenetre_principale.administrateur.id);
				}
			}
			else
			{
				System.out.println("Fin de l'exécution");
				System.exit(0); 
			}
		}	
		// "if" non nécessaire??
		if (fenetre_principale.administrateur.est_administrateur) 
		{
			fenetre_principale.setVisible(true);
			fenetre_principale.current_p_haut.actualiser();
		}

		
		//System.exit(0);  // SE DÉBARASSER DE LA FENETRE POUR QUITTER CORRECTEMENT L'APPLICATON!!!!
		System.out.println("Fin de l'exécution");
	}

}
