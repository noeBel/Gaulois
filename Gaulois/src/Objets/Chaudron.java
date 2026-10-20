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
			quantitePotion--;
			return forcePotion;
		}
		else {
			forcePotion=0;
			return forcePotion;
		}
	}
}
