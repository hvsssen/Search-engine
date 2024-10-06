package moteurDeRecherche;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEngine { 
	private Analyseur analyseur ; 
	private Ordonnanceur ordonnanceur ; 
	private Index index ;
	private List<Pretraiteur> pretraiteurs ; 
    

  // Constructeur Par Defaut   
    public SearchEngine () {
    	this.analyseur = new AnalyseurParOccurence () ; 
    	this.ordonnanceur = new Ordonnanceur1(); 
    	this.index = new IndexStatistique();
    	this.pretraiteurs = new ArrayList<>(Arrays.asList(new TokenizerAnglais(),new PretraiteurEspace(), new PretraiteurMajuscule(), new PretraiteurStopWords()));
    }
   
  // Constructeur avec parameters   
    public SearchEngine (List<Pretraiteur> pretraiteurs , Analyseur analyseur , Ordonnanceur ordonnanceur , Index index ) {
    	this.pretraiteurs = pretraiteurs ; 
    	this.analyseur = analyseur ; 
    	this.setOrdonnanceur(ordonnanceur) ; 
    	this.index=index ; 
    }
    
    public Analyseur getAnalyseur() {
    	return this.analyseur ; 
    }
    
    public void setAnalyseur(Analyseur analyseur) {
        this.analyseur = analyseur;
    }
    
    public Index getIndex() {
        return this.index; 
    }
 
    public void setIndex(Index index) {
        this.index = index; 
    }
    
    public List<Pretraiteur> getPretraiteurs() {
    	return this.pretraiteurs ; 
    	
    }
    
    public void setPretraiteurs(List<Pretraiteur> newListPretraiteurs) {
    	this.pretraiteurs= newListPretraiteurs ; 
    	
    }
    
    public void ajouterPretraiteur(Pretraiteur pretraiteurAajouter) {
        this.pretraiteurs.add(pretraiteurAajouter) ;
    }

    public void effacerPretraiteur(Pretraiteur pretraiteurAeffacer) {
        this.pretraiteurs.remove(pretraiteurAeffacer) ;
    }
    
    public Ordonnanceur getOrdonnanceur() {
		return ordonnanceur;
	}

	public void setOrdonnanceur(Ordonnanceur ordonnanceur) {
		this.ordonnanceur = ordonnanceur;
	}
    
    public void index (String path){
        File filePath = Paths.get(path).toFile();
        if(filePath.exists()){
            if(filePath.isDirectory()){
                System.out.println(path+" is a directory");
                indexDirectory(path);
            }else{
                System.out.println(path+" is a file");
                indexSingleDocument(path);
            }
        }else{
            System.out.println(path+" does not exist");
        }
        
    }
    
    private void indexSingleDocument(String path){
    	
    	WordByWordDocumentReader lecteur = new WordByWordDocumentReader () ; 
    	List<String> words = lecteur.readDocument(path) ;
    	if (!pretraiteurs.isEmpty()) {
	    	for ( Pretraiteur element : pretraiteurs) {
	    	element.traiter(words)  ; 
	    	}}
    	this.index.indexer(this.analyseur.analyser(words), path);
    	
    	
    	}
    
    private void indexDirectory(String path){
        File pathFile = Paths.get(path).toFile();
        File[] files = pathFile.listFiles();
        for(File f: files ){
            if(f.isDirectory()){
                indexDirectory(f.getAbsolutePath());
            }else{
                indexSingleDocument(f.getAbsolutePath());
            }
        }
    }

     
    public List<FichierScore> chercher(List<String> requete ){
    	return  this.getOrdonnanceur().calculeScore( this.getIndex().getStatistiqueMots(requete)) ; 
    }
    
    
    
	


}
