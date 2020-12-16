
public class AnimalDansMauvaisSecteurException extends Exception {

	public AnimalDansMauvaisSecteurException(Animal a) {
		super("Cet animal n'a pas le bon type "+a.toString());
	}
}
