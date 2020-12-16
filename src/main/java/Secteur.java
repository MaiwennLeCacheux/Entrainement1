import java.util.ArrayList;

public class Secteur {
	
	private TypeAnimal typeAnimauxDansSecteur;
	private ArrayList<Animal> animauxDansSecteur;
	
	public Secteur(TypeAnimal ta) {
		this.typeAnimauxDansSecteur = ta;
		animauxDansSecteur = new ArrayList<Animal>();
	}
	
	
	public void ajouterAnimal(Animal a) throws AnimalDansMauvaisSecteurException {
		if(a.getTypeAnimal()== this.typeAnimauxDansSecteur) {
			animauxDansSecteur.add(a);
		}else {
			throw new AnimalDansMauvaisSecteurException(a);
		}
	}
	
	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	
	public TypeAnimal obtenirType() {
		return typeAnimauxDansSecteur;
	}

}
