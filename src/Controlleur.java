import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controlleur extends Base_de_donnees_sqlite{

	Fenetre parent;
	
	public Controlleur(Fenetre a_parent)
	{
		parent = a_parent;
		
	}
	

	
	/*
	 * Cette fonction permet d'effectuer un ajout dans la base de données, 
	 * peu importe le nombre d'argument envoyé à la requete 'insert'.
	 */
	public void faire_ajout(String a_nom_table, Object[] a_columnNames, Object[] a_data)
	{
		StringBuilder stringBuilder = new StringBuilder();
		if (a_columnNames.length == a_data.length)
		{
			 stringBuilder.append("INSERT INTO " + a_nom_table + " (" + a_columnNames[0]);
			 for (int i = 1; i < a_columnNames.length; i++)
			 {
				 stringBuilder.append(", " + a_columnNames[i]);
			 }
			 stringBuilder.append(") VALUES (?");
			 for (int i = 1; i < a_data.length; i++)
			 {
				 stringBuilder.append(", ?");
			 }
			 stringBuilder.append(");");
			 
			 faire_update_sqlite(stringBuilder.toString(), a_data);
		}
		else
		{
			System.out.println("Les listes ne sont pas égales!!");
		}
	}
	
	/*
	 * Cette fonction permet d'effectuer une modification dans la 
	 * base de données, peu importe le nombre d'argument envoyé à la requete 'update'.
	 */
	public void faire_modification(String a_id, String a_nom_table, Object[] a_columnNames, Object[] a_data)
	{		
		StringBuilder stringBuilder = new StringBuilder();
		if (a_columnNames.length == a_data.length)
		{
			 stringBuilder.append("UPDATE " + a_nom_table + " SET ");
			 stringBuilder.append(a_columnNames[0] + " = ?");
			 for (int i = 1; i < a_columnNames.length; i++)
			 {
				 stringBuilder.append(", " + a_columnNames[i] + " = ?");
			 }
			 stringBuilder.append(" WHERE Id = '" + a_id + "';");

			 faire_update_sqlite(stringBuilder.toString(), a_data);
		}
		else
		{
			System.out.println("Les listes ne sont pas égales!!");
		}
	}
	
	/*
	 * Effectue une location d'outil pour le membre connecté (celui envoyé en argument)
	 */
	public void faire_location(Membre a_membre)
	{
		String nom_table = "Outils";
		String id_outil;
		Boolean id_outil_valide = false;
		Boolean quantite_disponible_valide = false;
		Boolean a_annule = false;
		
		
		if (a_membre != null) {
			while (!(a_annule)) {
				
				id_outil = scanner_outil(); // lance un popup qui permet de scanner l'outil
					
				if (id_outil == null) {
					a_annule = true;
				}
				
				else {
					id_outil_valide = id_existe(nom_table, id_outil);
					quantite_disponible_valide = valider_quantite_disponible(nom_table, id_outil);
					
					if (id_outil_valide && quantite_disponible_valide) {
						Object[] colonnes_location = {"Id_Outil", "Id_Proprietaire", "Id_Responsable"};
						Object[] data_location = {id_outil, a_membre.id, parent.administrateur.id};
						Object[] data_outil = {id_outil};
						
						faire_ajout("Locations", colonnes_location, data_location);
						faire_update_sqlite(
								"UPDATE outils SET Quantite_Disponible = Quantite_Disponible - 1 "
									+ "WHERE Id = ?;", data_outil);
						
						a_annule = true;
						parent.current_p_centre_etudiant.rafraichir_tableaux();
					}
					
					else if (!id_outil_valide) {
						JOptionPane.showMessageDialog(parent, "L'id ne correspond pas à un outil existant");
					}
					
					else if (!quantite_disponible_valide) {
						JOptionPane.showMessageDialog(parent, "Tous ces outils sont empruntés ou brisés");
					}
				}
			}
		}		
	}
	
	/*
	 * Ouvre un popup permettant de scanner le code-barre d'un outil
	 * Retourne l'id scanné
	 */
	public String scanner_outil() {
		return (String) JOptionPane.showInputDialog(
				new JFrame(),
				"Id de l'outil : ",// -- Sujet
				"Scan de l'outil", 	// -- Titre
				3, new ImageIcon("src/images/icon_128.png"),  // -- Icône personnalisée
				null, "");
		
		
	}
	
	/*
	 * Ouvre un popup permettant d'entrer l'id d'un étudiant (manuellement ou en scannant sa carte)
	 * Retourne le membre
	 */	
	public Membre Scanner_etudiant()
	{
		String id_etudiant;
		Boolean a_annule = false;
		
		while (!(a_annule)) {
			
			id_etudiant = (String) JOptionPane.showInputDialog(
					new JFrame(),
					"Id de l'étudiant : ",// -- Sujet
					"Scan de l'étudiant", 	// -- Titre
					3, new ImageIcon("src/images/icon_128.png"),  // -- Icône personnalisée
					null, "");
			
			// si l'usager a cliqué sur annuler
			if (id_etudiant == null) {
				a_annule = true;
			}
			
			else if (id_existe("membres", id_etudiant))
			{
				// création de la location dans la bd
				Object[] data = {id_etudiant};
				List<Object> result = faire_requete_sqlite(
					"SELECT * FROM membres WHERE Id = ?;", data);
				if (result.size() == 5)
				{
					return new Membre(result.get(0), result.get(1), result.get(2), result.get(3), result.get(4));
				}
			}
			
			
			
		}	
		return new Membre();
	}

	
	/*
	 * Vérifie que l'id envoyé en argument a une quantité disponible supérieure à 0
	 */
	public boolean valider_quantite_disponible(String a_nom_table, String a_id) {
		// vérifier que c'est une table qui a une quantité disponible?
		Object[] data = {a_id};
		List<Object> result = faire_requete_sqlite(
				"SELECT * FROM " + a_nom_table + " WHERE Id = ? AND Quantite_Disponible > 0;", data);
		if (result.size() > 0)
		{
			return true;
		}
		
		return false;
	}
	
	

	
	/*
	 * 
	 */
	
	public boolean id_existe(String a_table, String a_id) // ----- FONCTIONNEL -----
	{
		Object[] data = {a_id};
		List<Object> result = faire_requete_sqlite(
				"SELECT * FROM " + a_table + " WHERE Id = ?;", data);
		if (result.size() > 0)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * 
	 */
	public Membre creer_membre(String a_id)
	{
		if (id_existe("membres", a_id))
		{
			Object[] data = {a_id};
			List<Object> result = faire_requete_sqlite(
					"SELECT * FROM membres WHERE Id = ?;", data);
			if (result.size() == 5)
			{
				return new Membre(result.get(0), result.get(1), result.get(2), result.get(3), result.get(4));
			}
		}
		return new Membre();
	}
	
	/*
	 * Retourne Object[] qui correspond aux informations retournées par un OptionPane. Ce OptionPane
	 * est conçu dynamiquement par la concaténation des Object[] reçues en argument. L'ordre des données
	 * contenues dans les Object[] est très importante, elles sont associées d'une liste à l'autre selon
	 * leur index
	 */
	public Object[] optionPane_dynamique(Object[] a_noms_colonnes, Object[] a_donnees_ligne)
	{
		if(a_noms_colonnes.length == a_donnees_ligne.length)
		{
			LinkedList<Object> liste_objects = new LinkedList<Object>();
			LinkedList<JTextField> liste_JTextField = new LinkedList<JTextField>();
			
			for(int i = 0 ; i < a_noms_colonnes.length; i++)
			{
				liste_objects.add((String) a_noms_colonnes[i]+" : ");
				liste_JTextField.add(new JTextField((String) a_donnees_ligne[i]));
				liste_objects.add(liste_JTextField.get(i));
			} 
			int optionPane_return_value = JOptionPane.showConfirmDialog(
				null, 
				liste_objects.toArray(), 
				"Modification d'un champ",
				JOptionPane.OK_CANCEL_OPTION
			);
			liste_objects.clear();
			for(int i = 0 ; i < liste_JTextField.size(); i++)
			{
				liste_objects.add(liste_JTextField.get(i).getText());
			} 
			
			if (optionPane_return_value == 0)
			{
				return (Object[])liste_objects.toArray();
			}
			else
			{
				return a_donnees_ligne;
			}
		}
		else
		{
			System.out.println("ERREUR : La liste des noms de colonnes et la liste des valeurs de la ligne ne sont pas de même longueur!");
			return a_donnees_ligne;
		}
	}
}
