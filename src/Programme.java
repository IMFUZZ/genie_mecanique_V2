import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Programme {

	public static void main(String[] args) {
	
		Boolean professeur_existe = false;
		
		String id = "";
		
		String temp_secret = "i";

		Fenetre fenetre_principale = new Fenetre();	
		
		while (!professeur_existe && (id != null))
		{
			id = (String) JOptionPane.showInputDialog(
					fenetre_principale, 
					"Identifiant administrateur : ", 
					"Connection", 
					3, 
					new ImageIcon("src/images/icon_128.png"), 
					null, 
					"");
			if (id != null) {
				if (id.equals(temp_secret)) 
					{professeur_existe = true;}
			}
		}	
		if (professeur_existe)
		{
			fenetre_principale.setVisible(true);
		}
		
		System.out.println("Fin de l'exécution");
	}

}
