import java.util.ArrayList;

public class Zoo {
	
	private static final int LIMITE_PAR_SECTEUR = 15;

	private int visiteurs;
	private ArrayList<Secteur> secteursAnimaux;
	private String name ="zoo";
	
	public Zoo() {
		visiteurs = 0;
		secteursAnimaux = new ArrayList<Secteur>();
	}
	
	
	public void ajouterSecteur(TypeAnimal ta) {
		secteursAnimaux.add(new Secteur(ta));
	}
	
	public void NouveauVisiteur() throws LimiteVisiteurException {
		if (visiteurs < this.getLimiteVisiteur()) {
			visiteurs++;
		}else {
			throw new LimiteVisiteurException(this);
		}
	}
	
	public int getLimiteVisiteur() {
		return LIMITE_PAR_SECTEUR*secteursAnimaux.size();
	}
	
	public Secteur getSecteurFromType(TypeAnimal type) {
		return secteursAnimaux.stream().filter(s -> s.obtenirType() == type).findFirst().orElse(null);
	}
	
	public void nouvelAnimal(Animal a) throws AnimalDansMauvaisSecteurException {
		getSecteurFromType(a.getTypeAnimal()).ajouterAnimal(a);
	}
	
	public int nombreAnimaux() {
		int res=0;
		for (Secteur s : secteursAnimaux) {
			res+=s.getNombreAnimaux();
		}
		//return secteursAnimaux.stream().mapToInt(x->x.getNombreAnimaux()).sum();
		return res;
	}
	
	
	
	public int getVisiteurs() {
		return visiteurs;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


