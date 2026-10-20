package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void setVillage(Village village) {
		this.village = village;
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
		int forceCoup=(force*effetPotion)/3;
		System.out.println(nom+" envoie un grand coup dans la machoîre de "+romain.getNom());
		romain.recevoirCoup(forceCoup);
	}
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
	}
	
	public void sePresenter() {
		if (village!=null) {
			if (village.getChef().equals(this)) parler("Je suis "+nom+" et je suis chef du village "+village.getNom());
			else parler("Je suis "+nom+" et j'habite au village "+village.getNom());
		}
		else parler("Je suis "+nom+" et je suis nomade");
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
