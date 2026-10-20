package village_gaulois;



import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois=0;
	private Gaulois villageois[];
	private Gaulois chef;
	
	public Village(String nom, Gaulois chef, int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.chef=chef;
		chef.setVillage(this);
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois==villageois.length) System.out.println("desole le nouveau, plus de place");
		else {
			villageois[nbVillageois]=gaulois;
			gaulois.setVillage(this);
			nbVillageois+=1;
		}
	}
	
	public Gaulois trouverGaulois(int numVillageois) {
		if (numVillageois>nbVillageois) System.out.println("ce village n'a pas autant de gaulois!");
		return villageois[numVillageois-1];
	}
	
	public void afficherGaulois() {
		System.out.println("Dans ce village vivent les gaulois:");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("	-"+villageois[i].getNom());
		}
	}
	public static void main(String[] args) {
		Gaulois abracourcix= new Gaulois("Abracourcix",6);
		Village village = new Village("Village des irreductibles",abracourcix,30);
		village.trouverGaulois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois=village.trouverGaulois(1);
		System.out.println(gaulois);
		gaulois=village.trouverGaulois(2);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherGaulois();
		Gaulois doublePolemix=new Gaulois("Doublepolémix", 0);
		abracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
