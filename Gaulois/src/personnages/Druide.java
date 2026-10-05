package personnages;

import Objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron= new Chaudron();
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"\""+texte+"\"");
	}
	public String prendreParole() {
		return "Le Druide "+nom+" : ";
	}
	public void fabriquerPotion(int quantite,int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("j'ai concocté "+quantite+" doses de potion magique. Elle a une force de "+forcePotion+".");
	}
	public void boosterGaulois(Gaulois gaulois) {
		if (chaudron.resterPotion()){
			if (gaulois.getNom()=="Obélix") {
				parler("Non, "+gaulois.getNom+" Non! Et tu le sais bien!");
			}
			gaulois.boirePotion(chaudron.prendreLouche());
		}
	}
	
}
