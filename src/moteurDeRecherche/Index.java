package moteurDeRecherche;

import java.util.List;

public interface Index {
	
	
	public abstract void indexer (List<motOcc> listdesMotsOcc, String filePath) ; // rendre ajouterIndex
	public abstract List<Statistique> getStatistiqueMots (List<String> requete) ;
}