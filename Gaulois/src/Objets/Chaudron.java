package Objets;

public class Chaudron {
	private int quantitePotion=0;
	private int forcePotion=0;
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion=quantite;
		this.forcePotion=forcePotion;
	}
	public boolean resterPotion() {
		return quantitePotion==0;
	}
	public int prendreLouche() {
		if (resterPotion()) {
			this.quantitePotion=this.quantitePotion-1;
			return forcePotion;
		}
		else {
			this.forcePotion=0;
			return forcePotion;
		}
	}
}
