package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class IndexStatistique implements Index {
	public List<Statistique> listStatistiques;
	public IndexStatistique () {
		this.listStatistiques= new ArrayList<>();
	}
	
	public  List<Statistique> getIndex(){
		return this.listStatistiques ; 
	}
	
	// Indexer dans une liste de Statistique
	public void indexer (List<motOcc> listdesMotsOcc, String filePath) {
		for( int i=0; i< listdesMotsOcc.size();i++ ) {
			Statistique statistique = new Statistique (listdesMotsOcc.get(i).getMot(), filePath ,listdesMotsOcc.get(i).getOcc() );
			listStatistiques.add(statistique);
		}
	}	
	
	@Override

	public List<Statistique> getStatistiqueMots(List<String> requete) {
		List<Statistique> listStatistiqueRequet = new ArrayList <Statistique> () ; 
		for (String element : requete ) {
			for(Statistique elt : listStatistiques) {
				if (elt.getMot().equals(element)) {
					Statistique StatistqiueMot = elt ;
					StatistqiueMot.setStat(StatistqiueMot.getStat()+10000); // Pour Verifier Combien de mots de requete apparaissent dans notre liste dindex
					listStatistiqueRequet.add(StatistqiueMot) ; 
					
					}
			}
			
		}
		
		//Supprimer la duplication de fichier vu qu'on va passer ca vers l'ordonannceur pour calculerScore
		if (!listStatistiqueRequet.isEmpty()) {		
			for (int i=0 ; i<listStatistiqueRequet.size() ; i++) {
				for (int j=i+1 ; j<listStatistiqueRequet.size() ; j++) {
					if (listStatistiqueRequet.get(i).getFichier().equals(listStatistiqueRequet.get(j).getFichier())) {
						listStatistiqueRequet.get(i).setStat(listStatistiqueRequet.get(i).getStat() +listStatistiqueRequet.get(j).getStat());
						listStatistiqueRequet.remove(j) ;
						j-- ; 
					}
				}
			}
		}
		// Verification Combien de mots de requete apparaissent dans notre liste dindex et la compararer avec le nombre des mots dans la requete 
		for (Statistique elt : listStatistiqueRequet) {
			if (elt.getStat()>=requete.size()*10000){
				elt.setStat(elt.getStat()-(requete.size()*10000)+0.99999999999999) ; // Critere apparition de toutes les mots de requete dans lindex du fichier "0.99"
				
			}
			else {
				while(elt.getStat()>10000) {
					elt.setStat(elt.getStat()-10000);

				}
			}
		}
		return listStatistiqueRequet;
	}
}
