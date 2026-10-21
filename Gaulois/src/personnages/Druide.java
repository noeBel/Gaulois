package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	@SuppressWarnings("unused")
	private int force;
	private Chaudron chaudron=new Chaudron();
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	public void booster(Gaulois gaulois) {
		if (chaudron.resterPotion()){
			String nomGaulois=gaulois.getNom();
			if (nomGaulois!=null && nomGaulois.equals("Obélix")) {
				parler("Non, "+gaulois.getNom()+" Non! Et tu le sais bien!");
			}
			gaulois.boirePotion(chaudron.prendreLouche());
		}
	}
	
}
