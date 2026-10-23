package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees= new Trophee[200];
	private int nTrophee=0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		assert nTrophee<200;
		trophees[nTrophee++]=new Trophee(gaulois,equipement);
	}
	public String extraireInstructionsOCaml() {
		String texte="let musee = [\n";
		texte+="     "+trophees[0].extrairePourOCaml();
		for (int i=1;i<nTrophee;i++) {
			texte+=";\n     "+trophees[i].extrairePourOCaml();
		}
		texte+="\n]";
		return texte;
	}
}
