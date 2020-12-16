
public class LimiteVisiteurException extends Exception{

	public LimiteVisiteurException(Zoo o) {
		super("Ce zoo a deja trop de visiteur "+o.toString());
	}
}
