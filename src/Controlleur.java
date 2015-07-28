import java.util.List;


public class Controlleur extends Base_de_donnees_sqlite{

	Fenetre parent;
	
	public Controlleur(Fenetre a_parent)
	{
		parent = a_parent;
		//ajouter_brut("B2", "Brut #1", "Ceci est un test", 100);
	}
		
	public void faire_locations(String a_id_proprietaire, String a_id_outil)
	{
		faire_requete_sqlite(
				"INSERT INTO locations(item_id, owner_id, admin_id) "
					+ "VALUES "
					+ "('"+ a_id_outil
					+"', '"+ a_id_proprietaire
					+"', '"+ parent.administrateur.numero
					+"');");
	}
	public void faire_don(String a_id_proprietaire, String a_id_brut)
	{
		faire_requete_sqlite(
				"INSERT INTO dons(item_id, owner_id, admin_id) "
					+ "VALUES "
					+ "('"+ a_id_brut
					+"', '"+ a_id_proprietaire
					+"', '"+ parent.administrateur.numero
					+"');");
	}
	public void ajouter_etudiant(String a_id_etudiant, String a_prenom, String a_nom)
	{
		faire_requete_sqlite(
				"INSERT INTO membres(id, name, last_name) "
					+ "VALUES "
					+ "('"+ a_id_etudiant
					+"', '"+ a_prenom
					+"', '"+ a_nom
					+"');");
	}
	public void ajouter_administrateur(String a_id_admin, String a_prenom, String a_nom)
	{
		faire_requete_sqlite(
				"INSERT INTO membres(id, name, last_name, is_admin) "
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
				"INSERT INTO outils(id, name, description) "
					+ "VALUES "
					+ "('"+ a_id_outil
					+"', '"+ a_nom
					+"', '"+ a_description
					+"');");
	}
	public void ajouter_brut(String a_id_brut, String a_nom, String a_description, int a_quantity)
	{
		faire_requete_sqlite(
				"INSERT INTO bruts(id, name, description, quantity) "
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
				"UPDATE outils SET broken = 1 "
					+ "WHERE id = "
					+ a_id_outil
					+";");
	}
	public boolean administrateur_existe(String id) // ----- FONCTIONNEL -----
	{
		List<Object> result = faire_requete_sqlite(
				"SELECT is_admin FROM membres WHERE id = '" + id + "' and is_admin = 1;");
		if (result.size() > 0)
		{
			return true;
		}
		return false;
	}
}
