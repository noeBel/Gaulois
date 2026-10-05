package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"\""+texte+"\"");
	}
	private String prendreParole() {
		return "Le Gaulois "+nom+" : ";
	}
	
	public void frapper(Romain romain) {
		int forceCoup=force/3;
		System.out.println(nom+" envoie un grand coup dans la machoîre de "+romain.getNom());
		romain.recevoirCoup(forceCoup);
	}
	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.print(asterix);
	}
}
