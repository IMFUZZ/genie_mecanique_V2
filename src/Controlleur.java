import java.util.List;


public class Controlleur extends Base_de_donnees_sqlite{

	Fenetre parent;
	
	public Controlleur(Fenetre a_parent)
	{
		parent = a_parent;
	}
		
	public void faire_locations(String a_id_proprietaire, String a_id_outil)
	{
		faire_requete_sqlite(
				"INSERT INTO locations(Identifiant_Objet, Identifiant_Propriétaire, Identifiant_Responsable) "
					+ "VALUES "
					+ "('"+ a_id_outil
					+"', '"+ a_id_proprietaire
					+"', '"+ parent.administrateur.numero
					+"');");
	}
	public void faire_don(String a_id_proprietaire, String a_id_brut)
	{
		faire_requete_sqlite(
				"INSERT INTO dons(Identifiant_Objet, Identifiant_Propriétaire, Identifiant_Responsable) "
					+ "VALUES "
					+ "('"+ a_id_brut
					+"', '"+ a_id_proprietaire
					+"', '"+ parent.administrateur.numero
					+"');");
	}
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
	public void declarer_bris(int a_id_outil)
	{
		faire_update_sqlite(
				"UPDATE outils SET Brisé = 1 "
					+ "WHERE Identifiant = "
					+ a_id_outil
					+";");
	}
	public boolean membre_existe(String id) // ----- FONCTIONNEL -----
	{
		List<Object> result = faire_requete_sqlite(
				"SELECT * FROM membres WHERE Identifiant = '" + id + "';");
		if (result.size() > 0)
		{
			return true;
		}
		return false;
	}
	
	public Membre creer_membre(String a_id)
	{
		List<Object> result = faire_requete_sqlite(
				"SELECT * FROM membres WHERE Identifiant = '" + a_id + "';");
		if (result.size() == 5)
		{
			return new Membre(result.get(0), result.get(1), result.get(2), result.get(3), result.get(4));
		}
		return new Membre("", "", "", "", 0);
	}
}
