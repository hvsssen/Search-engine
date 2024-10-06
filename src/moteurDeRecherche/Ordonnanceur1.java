package moteurDeRecherche;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ordonnanceur1 implements Ordonnanceur {
	public Ordonnanceur1 () {
	}

	@Override
	public List<FichierScore> calculeScore( List<Statistique> listStatistiqueRequet ) {
		List<FichierScore> listDesScores = new ArrayList<FichierScore>() ; 
		for(Statistique elt : listStatistiqueRequet) {
	        if ( (elt.getStat()%1)!=0 ) {
	        	elt.setStat( elt.getStat()-0.99999999999999);
	        	DecimalFormat df = new DecimalFormat("0.00") ; 
	        	
	        	String formattedNumber = df.format(elt.getStat());
	        	
	        	try {
		        	elt.setStat( df.parse(formattedNumber).doubleValue());	        
	            } catch (ParseException e) {
	            }
	        	        } 
	        listDesScores.add(new FichierScore (elt.getFichier(),elt.getStat())) ;
		}
		return listDesScores ;
		}
	
	@Override
	public void trie(List<FichierScore> listFichierScore) {
		Collections.sort(listFichierScore); 
		
	}
	
}
