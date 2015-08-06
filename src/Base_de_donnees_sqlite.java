
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;

// RENDRE LA CLASSE ABSTRAITE!!

public class Base_de_donnees_sqlite {
	
	private java.sql.Connection con;
	private java.sql.Statement stmt;
	
	/* Constructeur de l'objet BaseDeDonnee */
	public Base_de_donnees_sqlite() {

	}

	/* Fonction permettant d'effectuer une requête 
	 * à la base de donnée. Celle-ci effectue les 
	 * requête en "polling" et retourne une String[] 
	 * contenant les élements retourné par la base 
	 * de donnée */
	public List<Object> faire_requete_sqlite(String requete) {
		
		ResultSet rs = null;
		int nombreColonne = 0;
		Object entree = null;
		List<Object> enregistrement = new LinkedList<Object>();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:base_de_donnees.db");
			con.setAutoCommit(false);
			SQLiteConfig config = new SQLiteConfig();
			config.setEncoding(SQLiteConfig.Encoding.UTF8);
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			ResultSetMetaData rm = rs.getMetaData();
			
			while (rs.next()) {
				for (int x = 1; x <= (rm.getColumnCount()); x++) {
					int typeColonne = rm.getColumnType(x);
					if (typeColonne == Types.TINYINT
							|| typeColonne == Types.INTEGER) {
						entree = rs.getInt(x);
					} else if (typeColonne == Types.VARCHAR 
							|| typeColonne == Types.NVARCHAR
							|| typeColonne == Types.CHAR
							|| typeColonne == Types.DATE
							|| typeColonne == Types.TIME
							|| typeColonne == Types.NCHAR) {
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
			System.out.println("Impossible d'effectuer la requête dans la base de donnée!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return enregistrement;
	}
	
	/* Cette fonction, à l'aide du nom de la table, 
	 * créer retourne un objet 'Modele_table'. La
	 * fonction utilise des boucles pour remplir 
	 * les données d'un vecteur de vecteur et l'
	 * attribut ensuite au modèle table.*/
	public Modele_table creer_modele_table(String a_nom_table) {

		ResultSet rs = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:base_de_donnees.db");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from " + a_nom_table + "");
			ResultSetMetaData rm = rs.getMetaData();
			
		    // names of columns
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = rm.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(rm.getColumnName(column));
		    }
	
		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rs.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs.getObject(columnIndex));
		        }
		        data.add(vector);
		    }
			stmt.close();
			con.close();
			return new Modele_table(a_nom_table, data, columnNames);
		} catch (Exception e) {
			System.out.println("Impossible d'obtenir le ResultSet de la base de données!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return new Modele_table(a_nom_table, new Vector<Vector<Object>>(), new Vector<String>());

	}
	
	/* Fonction permettant d'effectuer une requête 
	 * à la base de donnée. Celle-ci effectue les 
	 * requête en "polling" et retourne une String[] 
	 * contenant les élements retourné par la base 
	 * de donnée */
	public void faire_update_sqlite(String requete) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:base_de_donnees.db");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate(requete);
			stmt.close();
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println("Impossible d'effectuer l'update dans la base de données!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return;
	}

}
