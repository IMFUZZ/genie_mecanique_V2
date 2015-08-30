import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
		faire_ajout("table_test", test_colonnes, test_data);
		
	}
	
	/*
	 * Effectue une location d'outil pour le membre connecté (celui envoyé en argument)
	 */
	public void faire_location(Membre a_membre)
	{
		String id_outil;
		Boolean id_outil_valide = false;
		Boolean a_annule = false;
		
		
		if (a_membre != null) {
			while (!(a_annule) || !(id_outil_valide)) {
				
				id_outil = scanner_outil(); // lance un popup qui permet de scanner l'outil
				id_outil_valide = valider_id_outil(id_outil); // s'assure que l'id retourné correspond à un outil existant
				
				if (id_outil_valide) {
					// création de la location dans la bd
					faire_update_sqlite(
							"INSERT INTO locations(Identifiant_Objet, Identifiant_Proprietaire, Identifiant_Responsable) "
								+ "VALUES "
								+ "('"+ id_outil
								+"', '"+ a_membre.id
								+"', '"+ parent.administrateur.id
								+"');");
					// ajouter requête pour modifier quantité disponible de l'outil
					parent.current_p_centre_etudiant.rafraichir_tableaux();
				}
				
				// si l'usager a cliqué sur annuler
				if (id_outil != null) {
					a_annule = true;
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
					
			if (id_existe("membres", id_etudiant))
			{
				// création de la location dans la bd
				List<Object> result = faire_requete_sqlite(
					"SELECT * FROM membres WHERE Identifiant = '" + id_etudiant + "';");
				if (result.size() == 5)
				{
					return new Membre(result.get(0), result.get(1), result.get(2), result.get(3), result.get(4));
				}
			}
			
			// si l'usager a cliqué sur annuler
			if (id_etudiant == null) {
				a_annule = true;
			}
		}	
		return new Membre();
	}
	
	/*
	 * Vérifie que l'id envoyé en argument correspond à l'id d'un outil existant 
	 * et disponible à la location
	 */
	public boolean valider_id_outil(String a_id) {
		Boolean verification = true;
		
		// *** À faire (requête SQL)
		
		return verification;
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
	
	
}
