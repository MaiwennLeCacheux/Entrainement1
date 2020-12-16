import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.thoughtworks.xstream.XStream;

public class App {
	
	  private static void menu(Zoo zoo) {
		  System.out.println("" + zoo.getName() + " : Que souhaitez vous faire ?");
		  System.out.println("1 : Creer un nouveau zoo");
		  System.out.println("2 : Ajouter un nouvel secteur");
		  System.out.println("3 : Ajouter un nouvel animal");
		  System.out.println("4 : Ajouter un visiteur");
		  System.out.println("5 : Sauvegarder mon zoo");
		  System.out.println("6 : Charger un zoo");
		  System.out.println("0 : Pour quitter");
		  System.out.println("Votre choix");
	  }
	  
	  private static void serializeZoo(Zoo zoo) {
			  //XMLEncoder encoder = null;
			  
			  try {
					/*encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("zoo.xml")));
					encoder.writeObject(zoo);
					encoder.flush();*/
					  XStream xstream = new XStream();
					  xstream.toXML(zoo, new FileOutputStream(new File("zoo.xml")));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				/*finally {
					  if(encoder != null)
						  encoder.close();
			  }*/
	  }
	  
	  private static Zoo deSerializeZoo(Zoo zoo) {
			  FileInputStream file;
			  
			  try {
					  XStream xstream = new XStream();
					  file = new FileInputStream("zoo.xml");
					  zoo = (Zoo) xstream.fromXML(file);
					  file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			  
			  return zoo;
	  }
	
	public static void main(String[] args) throws AnimalDansMauvaisSecteurException, LimiteVisiteurException, IOException {
		// TODO Auto-generated method stub
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		Zoo zoo = new Zoo();
		
		boolean flag = true ;
		
		while(flag) {
			
			menu(zoo);
			String choix = br.readLine();
			
		         
		          switch(choix) {
		          
			            case "1": 
				              System.out.println("Quel est le nom du nouveau zoo ?");
				              String name = br.readLine();
				              zoo = new Zoo();
				              zoo.setName(name);
				              System.out.println("Zoo " + name + " créé !");
				              break;
				              
			            case "2": 
			                   System.out.println("Quel type d'animal ?");
			                   String typeS = br.readLine();
			                   try {
			                        TypeAnimal type = TypeAnimal.valueOf(typeS); 	//transformation en TypeAnimal
			                        zoo.ajouterSecteur(type);
			                   }
			                   catch (Exception e) {
			                            System.out.println(typeS + "n'est pas un type reconnu.");
			                   }
			                   break;
			                
			            case "3": 
			                   System.out.println("Quel type d'animal ?");
			                   String typeA = br.readLine();
			                   try {
			                        TypeAnimal type = TypeAnimal.valueOf(typeA);
	
			                        System.out.println("Quel est le nom de l'animal ?");
			                        String nameA = br.readLine();
			                        Animal a;
			                        if(type == TypeAnimal.CHAT) {
			                            a = new Chat(nameA);
			                        }else if(type == TypeAnimal.CHIEN) {
			                                a = new Chien(nameA);
			                        }
			                    }
			                    catch (Exception e) {
			                            System.out.println(typeA + "n'est pas un type reconnu.");
			                    }
			                   	break;
		                   
			            case "4":
				  				try {
				  					zoo.NouveauVisiteur();
				  		  			System.out.println("Ajout d'un visiteur.");
				  				} catch (LimiteVisiteurException e) {
				  		  			System.out.println("Impossible : zoo plein !");
				  				}
				  	  			 break;
			  	  		case "5": 
				  	  			serializeZoo(zoo);
				  	  			 System.out.println("Zoo sauvergarde !");
				  	  			 break;
			  	  		case "6": 
				  	  			zoo= deSerializeZoo(zoo);
				  	  			 System.out.println("Zoo charge !");
				  	  			 break;
			  	  		case "0":
				  	  			 System.out.println("Au revoir.");
				  	  			 flag = false;
				  	  			 break;
		  	  			
		  	  			 
		          	}
		      }
		System.out.println("nb visiteurs "+zoo.getVisiteurs());
        System.out.println("nom "+zoo.getName());
		}
}
