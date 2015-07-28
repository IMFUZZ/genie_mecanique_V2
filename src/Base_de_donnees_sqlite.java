
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;

public class Base_de_donnees_sqlite {
	// Fonction abstraite ne servant qu'à permettre d'intéragir avec la base de
	// données
	private java.sql.Connection con;
	private java.sql.Statement stmt;

	public Base_de_donnees_sqlite() {
		/* Constructeur de l'objet BaseDeDonnee */
	}

	public List<Object> faire_requete_sqlite(String requete) {
		/* Fonction permettant d'effectuer une requête 
		 * à la base de donnée. Celle-ci effectue les 
		 * requête en "polling" et retourne une String[] 
		 * contenant les élements retourné par la base 
		 * de donnée */
		ResultSet rs = null;
		int nombreColonne = 0;
		Object entree = null;
		List<Object> enregistrement = new LinkedList<Object>();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:base_de_donnees.db");
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			ResultSetMetaData rm = rs.getMetaData();
			//nombreColonne = rm.getColumnCount();
			
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
	
	public Modele_table creer_modele_table(String a_nom_table) {
		/* Fonction permettant d'effectuer une requête 
		 * à la base de donnée. Celle-ci effectue les 
		 * requête en "polling" et retourne une String[] 
		 * contenant les élements retourné par la base 
		 * de donnée */
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
			return new Modele_table(data, columnNames);
		} catch (Exception e) {
			System.out.println("Impossible d'obtenir le ResultSet de la base de données!");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return new Modele_table(new Vector<Vector<Object>>(), new Vector<String>());

	}
	
	public void faire_update_sqlite(String requete) {
		/* Fonction permettant d'effectuer une requête 
		 * à la base de donnée. Celle-ci effectue les 
		 * requête en "polling" et retourne une String[] 
		 * contenant les élements retourné par la base 
		 * de donnée */
		
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
