package moteurDeRecherche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class OrdonnanceurBinaire implements Ordonnanceur {

public List<FichierScore> calculeScore( List<Statistique> listStatistiqueRequet ) {
		
		List<FichierScore> listDesScores = new ArrayList<FichierScore>() ; 
		for(Statistique elt : listStatistiqueRequet) {
			
	        if ((elt.getStat()%1)!=0) {
	            elt.setStat(1.00);
				listDesScores.add(new FichierScore (elt.getFichier(),elt.getStat())) ;
				
	        } 

	        
		}
		return listDesScores ;
		}
	
	@Override
	public void trie(List<FichierScore> listFichierScore) {
		Collections.sort(listFichierScore); 
		
	}
	
}
