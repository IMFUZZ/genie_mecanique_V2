
public class Programme {

	public static void main(String[] args) {
		Fenetre fenetre_principale = new Fenetre();
		fenetre_principale.p_bas.add(new Panneau_bas());
		fenetre_principale.p_droite.add(new Panneau_droite_etudiant());
		fenetre_principale.p_haut.add(new Panneau_haut_etudiant());
		fenetre_principale.setVisible(true);
	}

}
