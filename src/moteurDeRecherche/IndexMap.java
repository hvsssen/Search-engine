package moteurDeRecherche ; 
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IndexMap implements Index {
	

	private Map <String, List<Statistique>> mapStatistiques;
	public IndexMap() {
		this.mapStatistiques = new  LinkedHashMap<>();
		}
	
	public Map <String, List<Statistique>> getIndex(){
		return this.mapStatistiques ; 
	}

// {mot1:[Statistique1 , Statistique2] , mot2:[Statistique1 , Statistique2]}
	
	public void indexer (List<motOcc> listdesMotsOcc , String path) {
		
		    for (motOcc element : listdesMotsOcc) {
		        Statistique newStat = new Statistique(element.getMot(), path, element.getOcc());
		        List<Statistique> list = mapStatistiques.get(element.getMot());
		        if (list == null) {
		            list = new ArrayList<>();
		            mapStatistiques.put(element.getMot(), list);
		        }
		        list.add(newStat);
		    }
		}

	
	
	@Override
	public List<Statistique> getStatistiqueMots(List<String> requete) {
		List<Statistique> listStatistiqueRequet = new ArrayList <Statistique> () ; 
		for (String element : requete ) {
			if(mapStatistiques.containsKey(element))  {
				List<Statistique> listStatistqiueMot = mapStatistiques.get(element) ;
				// list of statistique of the element of the query
				for (Statistique elt : listStatistqiueMot) {
					elt.setStat(elt.getStat()+10000) ; 
				}
				listStatistiqueRequet.addAll(listStatistqiueMot) ; 
			}
		
		}	
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
		for (Statistique elt : listStatistiqueRequet) {
			if (elt.getStat()>=requete.size()*10000){
				elt.setStat(elt.getStat()-(requete.size()*10000)+0.99999999999999) ; 
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
