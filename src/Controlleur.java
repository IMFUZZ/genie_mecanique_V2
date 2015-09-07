import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controlleur extends Base_de_donnees_sqlite{

	Fenetre parent;
	
	public Controlleur(Fenetre a_parent)
	{
		parent = a_parent;
		Vector <String> test_colonnes = new Vector<String>(4, 1); ;
		test_colonnes.addElement("colonne1");
		test_colonnes.addElement("colonne2");
		test_colonnes.addElement("colonne3");
		test_colonnes.addElement("colonne4");
		test_colonnes.addElement("colonne5");
		Vector <String> test_data = new Vector<String>(4, 1) ;
		test_data.addElement("test1");
		test_data.addElement("test2");
		test_data.addElement("test3");
		test_data.addElement("test4");
		test_data.addElement("test5");
		faire_modification("123456", "table_test", test_colonnes, test_data);
		
		Object[] columns = {"Id", "Nom", "Prenom"};
		Object[] values = {"1245278", "Dube", "Daniel-Junior"};
		optionPane_dynamique(columns, values);
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
						// création de la location dans la bd
						faire_update_sqlite(
								"INSERT INTO locations(Identifiant_Objet, Identifiant_Proprietaire, Identifiant_Responsable) "
									+ "VALUES "
									+ "('"+ id_outil
									+ "', '"+ a_membre.id
									+ "', '"+ parent.administrateur.id
									+ "');");
						// ajouter requête pour modifier quantité disponible de l'outil
						faire_update_sqlite(
								"UPDATE outils SET Disponible = Disponible - 1 "
									+ "WHERE Identifiant = '" + id_outil + "';");
						
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
	
	public void faire_ajout(String a_nom_table, Vector<String> a_columnNames, Vector<String> a_data)
	{
		String id_outil;
		
			StringBuilder stringBuilder = new StringBuilder();
		if (a_columnNames.size() == a_data.size())
		{
			 stringBuilder.append("INSERT INTO " + a_nom_table + " (" + a_columnNames.firstElement());
			 for (int i = 1; i < a_columnNames.size(); i++)
			 {
				 stringBuilder.append(", " + a_columnNames.get(i));
			 }
			 stringBuilder.append(") VALUES ('" + a_data.firstElement());
			 for (int i = 1; i < a_data.size(); i++)
			 {
				 stringBuilder.append("', '" + a_data.get(i));
			 }
			 stringBuilder.append("');");
			 
			 String requete = stringBuilder.toString();
			 System.out.println(requete);
		}
		else
		{
			System.out.println("Les listes ne sont pas égales!!");
		}
	}
	
	public void faire_modification(String a_identifiant, String a_nom_table, Vector<String> a_columnNames, Vector<String> a_data)
	{		
		StringBuilder stringBuilder = new StringBuilder();
		if (a_columnNames.size() == a_data.size())
		{
			 stringBuilder.append("UPDATE " + a_nom_table + " SET ");
			 stringBuilder.append(a_columnNames.get(0) + " = '" + a_data.get(0));
			 for (int i = 1; i < a_columnNames.size(); i++)
			 {
				 stringBuilder.append("', " + a_columnNames.get(i) + " = '" + a_data.get(i));
			 }
			 stringBuilder.append("' WHERE identifiant = '" + a_identifiant + "';");

			 
			 String requete = stringBuilder.toString();
			 System.out.println(requete);
		}
		else
		{
			System.out.println("Les listes ne sont pas égales!!");
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
	
	public Membre Scanner_etudiant()
	{
		String id_etudiant;
		Boolean id_outil_valide = false;
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
				List<Object> result = faire_requete_sqlite(
					"SELECT * FROM membres WHERE Identifiant = '" + id_etudiant + "';");
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
		List<Object> result = faire_requete_sqlite(
				"SELECT * FROM " + a_nom_table + " WHERE Identifiant = '" + a_id + "' AND Disponible > 0;");
		if (result.size() > 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	/*
	 * 
	 */
	public void faire_don(String a_id_proprietaire, String a_id_brut)
	{
		faire_requete_sqlite(
				"INSERT INTO dons(Identifiant_Objet, Identifiant_Propriétaire, Identifiant_Responsable) "
					+ "VALUES "
					+ "('"+ a_id_brut
					+"', '"+ a_id_proprietaire
					+"', '"+ parent.administrateur.id
					+"');");
	}
	
	
	/*
	 * 
	 */
	public void ajouter_etudiant(String a_id_etudiant, String a_prenom, String a_nom)
	{
		faire_requete_sqlite(
				"INSERT INTO membres(Identifiant, Nom, Nom_Famille) "
					+ "VALUES "
					+ "('"+ a_id_etudiant
					+"', '"+ a_prenom
					+"', '"+ a_nom
					+"');");
	}
	
	/*
	 * 
	 */
	public void ajouter_administrateur(String a_id_admin, String a_prenom, String a_nom)
	{
		faire_requete_sqlite(
				"INSERT INTO membres(Identifiant, Nom, Nom_Famille, Est_Administrateur) "
					+ "VALUES "
					+ "('"+ a_id_admin
					+"', '"+ a_prenom
					+"', '"+ a_nom
					+"', "+ 1
					+");");
	}
	
	/*
	 * 
	 */
	public void ajouter_outil(String a_id_outil, String a_nom, String a_description)
	{
		faire_requete_sqlite(
				"INSERT INTO outils(Identifiant, Nom, Description) "
					+ "VALUES "
					+ "('"+ a_id_outil
					+"', '"+ a_nom
					+"', '"+ a_description
					+"');");
	}
	
	/*
	 * 
	 */
	public void ajouter_brut(String a_id_brut, String a_nom, String a_description, int a_quantity)
	{
		faire_requete_sqlite(
				"INSERT INTO bruts(Identifiant, Nom, Description, Quantité) "
					+ "VALUES "
					+ "('"+ a_id_brut
					+"', '"+ a_nom
					+"', '"+ a_description
					+"', "+ a_quantity
					+");");
	}
	
	/*
	 * 
	 */
	public void declarer_bris(int a_id_outil)
	{
		faire_update_sqlite(
				"UPDATE outils SET Brisé = 1 "
					+ "WHERE Identifiant = "
					+ a_id_outil
					+";");
	}
	
	/*
	 * 
	 */
	
	public boolean id_existe(String a_table, String a_id) // ----- FONCTIONNEL -----
	{
		List<Object> result = faire_requete_sqlite(
				"SELECT * FROM " + a_table + " WHERE Identifiant = '" + a_id + "';");
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
			List<Object> result = faire_requete_sqlite(
					"SELECT * FROM membres WHERE Identifiant = '" + a_id + "';");
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
	 * contenues dans les Object[] est très importantes, elle sont associées d'une liste à l'autre selon
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
			JOptionPane.showConfirmDialog(
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
			return (Object[])liste_objects.toArray();
		}
		else
		{
			System.out.println("ERREUR : La liste des noms de colonnes et la liste des valeurs de la ligne ne sont pas de même longueur!");
			return a_donnees_ligne;
		}
	}
}
