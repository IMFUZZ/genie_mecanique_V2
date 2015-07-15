
public class Controlleur {

	Base_de_donnees bd;
	Fenetre parent;
	
	public Controlleur(Fenetre a_parent)
	{
		parent = a_parent;
		bd = new Base_de_donnees();
	}
		
	public void faire_locations(int a_id_proprietaire, int a_id_outil)
	{
		bd.faire_requete_sqlite(
				"INSERT INTO locations(item_id, owner_id, admin_id) "
					+ "VALUES "
					+ "("+a_id_outil
					+", "+a_id_proprietaire
					+", "+parent.utilisateur.numero
					+")");
	}
	
}
