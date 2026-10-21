package personnages;

import objets.Equipement;



public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements=new Equipement[2];
	private int nbEquipement=0;
	private static String texte="Le soldat ";
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+"\""+texte+"\"");
	}
	private String prendreParole() {
		return "Le romain "+nom+" : ";
	}

	private void ajouterEquipement(Equipement equip) {
		assert nbEquipement<2;
		equipements[nbEquipement]=equip;
		nbEquipement++;
		System.out.println(texte+nom+" s'équipe avec un "+equip+".");
	}
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
		case 2: 
			System.out.println(texte+nom+" est déjà bien protégé");
			break;
		case 1:
			if (equip.equals(equipements[0])) System.out.println(texte+nom+" possède déjà un "+equip+" !");
			else ajouterEquipement(equip);
			break;
		default: 
			ajouterEquipement(equip);
			break;
		}
	}

	private int CalculerResistanceEquipement(int forceCoup) {
		String indication = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			indication += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && 
						equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			indication += resistanceEquipement + "!";
		}
		parler(indication);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom+ " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] != null) {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
		}
		}
		return equipementEjecte;
		}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force==0) {
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	private boolean isInvariantVerified() {
		return force>=0;
	}
	public static void main() {
		Romain minus=new Romain("Minus", 6);
		minus.recevoirCoup(5);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
