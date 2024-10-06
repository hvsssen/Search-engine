package moteurDeRecherche;


import java.util.List;
// score du fichier pas de mot par apparence et par nombre de mots en cas degalitee dapparition 

public interface  Ordonnanceur  {
	
	
	public abstract List<FichierScore> calculeScore (List<Statistique> listStatistiques );  
	public abstract void trie(List<FichierScore> listFichierScore) ;

}