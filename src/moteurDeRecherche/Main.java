package moteurDeRecherche ; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void afficher(List<FichierScore> scoreDurequete) {
		if (scoreDurequete.isEmpty()) {
            System.out.println("Doesn't exist");

	}
		else {
		
        for (FichierScore element : scoreDurequete) {
            System.out.println("Fichier " + element.fichier + "  Score " + element.score);
        }
    }
	}
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        
          
        	
            while (true) {
            	SearchEngine s = new SearchEngine();
            	
            	 int check =0 ;
            	while(check==0) {

	                System.out.println("Welcome , What language u want to use ?  ");
	                System.out.println("1) French  ");
	                System.out.println("2) English  ");
                
                
	                String langueChoisi = scanner.nextLine();
	                if(langueChoisi.equals("1")) {
	                	@SuppressWarnings("unused")
						TokenizerAnglais tokenizerAnglais= new TokenizerAnglais() ;
	                	check=1;
	                }
	                else if(langueChoisi.equals("2")) {
	                	@SuppressWarnings("unused")
						TokenizerFrancais tokenizerFrancais= new TokenizerFrancais() ;
	                	check=1;
	                }
	                else {
	                    System.out.println("Welcome , What language u want to use ?  ");
	
	                }
                }
                
             	System.out.println(" Where do you want to look for the words?");
                String path = scanner.nextLine();

                System.out.println("Enter the query you are looking for:");
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                List<String> requete = Arrays.asList(parts);
                check =0 ;
                if(!s.getPretraiteurs().isEmpty()) {
	                for (Pretraiteur pretraiteur :s.getPretraiteurs()) {
	                	pretraiteur.traiter(requete) ; 
	                }
                
                }
                
                while(check ==0) {
                System.out.println("Which type of index do you want to use?");
                System.out.println("1) IndexStatistque ");
                System.out.println("2) IndexMap  ");
                
                String indexChoisi = scanner.nextLine();
                
                if(indexChoisi.equals("2")) {
                	s.setIndex(new IndexMap()) ; 
                	System.out.println("U have chosen IndexMap ") ; 
                	check = 1 ;
                }
                else if (indexChoisi.equals("1")) {
                	System.out.println("U have chosen IndexStatistique ") ; 
                	check= 1 ; 
                }      
          }
                
                check=0 ; 
      
                
                
                while(check ==0) {
                	System.out.println("Which pre-processor do you want to use?");
                    System.out.println("1) PretraiteurEspace");
                    System.out.println("2) PretraiteurMajuscule");
                    System.out.println("3) PretraiteurStopWords");
                    System.out.println("4) PretraiteurEspace and PretraiteurStopWords");
                    System.out.println("5) PretraiteurEspace and PretraiteurMajuscule");
                    System.out.println("6) PretraiteurMajuscule and PretraiteurStopWords");
                    System.out.println("7) All");
                    System.out.println("8) No pre-processing");
                    String pretraiteurChoisi = scanner.nextLine();
                    
                if(pretraiteurChoisi.equals("1")) {
                	s.setPretraiteurs(new ArrayList<>(Arrays.asList(new PretraiteurEspace() ))); 
                	check=1 ; 
                } 
                else if(pretraiteurChoisi.equals("2")) {
                	s.setPretraiteurs(new ArrayList<>(Arrays.asList(new PretraiteurMajuscule() ))); 
                	check=1 ; 

                } 
                else if(pretraiteurChoisi.equals("3")) {
                	s.setPretraiteurs(new ArrayList<>(Arrays.asList(new PretraiteurStopWords() )));
                	check=1 ; 

                } 
                else if(pretraiteurChoisi.equals("4")) {
                	s.setPretraiteurs(new ArrayList<>(Arrays.asList(new PretraiteurEspace() , new PretraiteurStopWords() ))); 
                	check=1 ;

                } 
                else if(pretraiteurChoisi.equals("5")) {
                	s.setPretraiteurs(new ArrayList<>(Arrays.asList(new PretraiteurEspace() , new PretraiteurMajuscule() ))); 
                	check=1 ; 

                } 
                else if(pretraiteurChoisi.equals("6")) {
                	s.setPretraiteurs(new ArrayList<>(Arrays.asList(new PretraiteurMajuscule() , new PretraiteurStopWords() ))); 
                	check=1 ; 

                } 
                else if(pretraiteurChoisi.equals("7")) {
                	// Already defined
                	check=1 ; 
                } 
                else if(pretraiteurChoisi.equals("8")) {
                	s.setPretraiteurs(new ArrayList<>()); 
                	check=1 ; 
                } 
        
            }
                
                check=0 ; 
                
                while(check==0) {
                	
	                System.out.println("Which analyzer do you want to use?");
	                System.out.println("1) AnalyseurParOccurence");
	                System.out.println("2) AnalyseurBinaire");
	                String analyseurChoisi = scanner.nextLine();
	                if(analyseurChoisi.equals("2")) {
	                	s.setAnalyseur(new AnalyseurBinaire ()); 
	                	check=1 ;
	                } 
	                else if(analyseurChoisi.equals("1")) {
	                	check=1 ;
	                } 
                }
                
                check=0 ; 
                String ordonnanceurChoisi = ""; 
                while (check==0) {
	                System.out.println("Which sorter do you want to use?");
	                System.out.println("1) OrdonnanceurOccurence :") ;
	                System.out.println("In Case u have chosen 1) AnalyseurParOccurence OrdonnanceurOccurence gives how many times words of your query appears in  " + path + " even though one of them doesn't appear");
	                System.out.println("In Case u have chosen 2) AnalyseurBinaire OrdonnanceurOccurence gives how many words of your query appears in  " + path  );
	                System.out.println("2) OrdonnanceurBinaire : Tells if the whole query appears in  " + path +" (1)=appears ; (0)=doesnt appear ");
	                String ordonnanceurChoisie = scanner.nextLine();
	                ordonnanceurChoisi =ordonnanceurChoisie ; 
	                if(ordonnanceurChoisi.equals("2")) {
	                	s.setOrdonnanceur(new OrdonnanceurBinaire ()); 
	                	check=1 ; 
	                } 
	                else if (ordonnanceurChoisi.equals("1")) {
	                	s.setOrdonnanceur(new Ordonnanceur1 ()); 
	                	check=1 ; 
	                } 
                } 
                
             
              
               
            	
                s.index(path) ; 
                List<FichierScore> fs = s.chercher(requete) ; 
                s.getOrdonnanceur().trie(fs) ; 
                if(ordonnanceurChoisi.equals("1")) {
                	s.getOrdonnanceur().trie(fs) ; 
                }
                afficher(fs) ;  
              
               System.out.println("Do you want to search again? (yes/no)");
                String yesOrNo = scanner.nextLine();
                if (!yesOrNo.equalsIgnoreCase("yes")) {
                    break; // Exit the loop if user doesn't want to search again
                } 
            }
        }
        }
        }           
            
