package personnages;

import objets.Equipement;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	private Village village;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	private static String prefixe="Je suis";
	
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
//	private String prendreParole() {
//		return "Le Gaulois "+nom+" : ";
//	}
	private String prendreParole() {
		return "Le Gaulois "+nom+" : ";
		
	}
//	public void frapper(Romain romain) {
//		int forceCoup=(force*effetPotion)/3;
//		System.out.println(nom+" envoie un grand coup dans la machoîre de "+romain.getNom());
//		romain.recevoirCoup(forceCoup);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom());
		Equipement[] tropheesRecues = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
		effetPotion = 1;
		}
		for (int i = 0; tropheesRecues != null && i < tropheesRecues.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRecues[i];
		}
		}
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
	}
	
	public void sePresenter() {
		
		String presentation=prefixe;
		if (village!=null) {
			if (village.getChef().equals(this)) presentation+=nom+" et je suis chef du village "+village.getNom();
			else presentation+=nom+" et j'habite au village "+village.getNom();
		}
		else presentation+=nom+" et je suis nomade";
		parler(presentation);
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
