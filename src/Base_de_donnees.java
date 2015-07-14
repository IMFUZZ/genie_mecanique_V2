
import java.util.LinkedList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Base_de_donnees {
	// Fonction abstraite ne servant qu'à permettre d'intéragir avec la base de
	// données
	private java.sql.Connection con;
	private java.sql.Statement stmt;

	public Base_de_donnees() {
		/* Constructeur de l'objet BaseDeDonnee */
	}

	public String[] faire_requete(String requete) {
		/* Fonction permettant d'effectuer une requête 
		 * à la base de donnée. Celle-ci effectue les 
		 * requête en "polling" et retourne une String[] 
		 * contenant les élements retourné par la base 
		 * de donnée */
		
		ResultSet rs = null;
		int nombreColonne = 0;
		String entree = "";
		List<String> enregistrement = new LinkedList<String>();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:baseDeDonnee.db");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			ResultSetMetaData rm = rs.getMetaData();
			//nombreColonne = rm.getColumnCount();
			while (rs.next()) {
				for (int x = 1; x <= (rm.getColumnCount()); x++) {
					int typeColonne = rm.getColumnType(x);
					if (typeColonne == 4) {
						// Si le Nuplet est de type INTEGER alors
						entree = Integer.toString(rs.getInt(x));
					} else if (typeColonne == 12) {
						// Si le Nuplet est de type STRING alors
						entree = rs.getString(x);
					} else {
						// Si le Nuplet est d'un autre type
						System.out.println("autre type non géré!!");
					}
					enregistrement.add(entree);
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Impossible d'effectuer la requête dans la base de donnée");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return enregistrement.toArray(new String[0]);
	}

	public void faire_update(String requete) {
		/* Fonction permettant d'effectuer une requête 
		 * à la base de donnée. Celle-ci effectue les 
		 * requête en "polling" et retourne une String[] 
		 * contenant les élements retourné par la base 
		 * de donnée */
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:baseDeDonnee.db");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate(requete);
			stmt.close();
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println("Impossible d'écrire dans la base de donnée");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return;
	}

}
