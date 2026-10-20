package personnages;

import Objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[]=new Equipement[2];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"\""+texte+"\"");
	}
	private String prendreParole() {
		return "Le romain "+nom+" : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>=0;
		if (force>forceCoup){
			force-=forceCoup;
			parler("Aïe");
		}
		else {
			force=0;
			parler("J'abandonne...");
		}
		assert isInvariantVerified();
	}
	private void ajouterEquipement(Equipement equip) {
		assert nbEquipement<2;
		equipements[nbEquipement]=equip;
		nbEquipement++;
		System.out.println("Le soldat "+nom+" s'équipe avec un "+equip+".");
	}
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
		case 2: 
			System.out.println("Le soldat "+nom+" est déjà bien protégé");
			break;
		case 1:
			if (equip.equals(equipements[0])) System.out.println("Le soldat "+nom+" possède déjà un "+equip+" !");
			else ajouterEquipement(equip);
			break;
		case 0: 
			ajouterEquipement(equip);
			break;
		}
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	private boolean isInvariantVerified() {
		return force>=0;
	}
	public static void main(String[] args) {
		Romain minus=new Romain("Minus", 6);
		minus.recevoirCoup(5);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
