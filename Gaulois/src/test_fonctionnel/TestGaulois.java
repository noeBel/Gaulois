package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		asterix.parler("Bonjour "+obelix.getNom());
		obelix.parler("Bonjour "+asterix.getNom()+" ça te dirqit d'aller chasser des romains?");
		asterix.parler("Oui,bonne idée");
		Romain centurion = new Romain("Hector", 5);
		asterix.frapper(centurion);
		obelix.frapper(centurion);
	}
}
