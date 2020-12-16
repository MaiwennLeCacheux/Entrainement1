
public class App {

	private static Zoo zoo;
	
	public static void main(String[] args) throws AnimalDansMauvaisSecteurException, LimiteVisiteurException {
		// TODO Auto-generated method stub
		
		zoo= new Zoo();
		
		zoo.ajouterSecteur(TypeAnimal.CHIEN);
		zoo.ajouterSecteur(TypeAnimal.CHAT);
		zoo.ajouterSecteur(TypeAnimal.CHIEN);
		
		zoo.nouvelAnimal(new Chat("Bibi"));
		zoo.nouvelAnimal(new Chat("Bibu"));
		zoo.nouvelAnimal(new Chat("Bibo"));
		zoo.nouvelAnimal(new Chien("Gildas"));
		
		zoo.NouveauVisiteur();
		
		System.out.println("nb visiteurs : "+zoo.getVisiteurs());
		System.out.println(zoo.nombreAnimaux());
	}

}
