package moteurDeRecherche;
import java.util.ArrayList;
import java.util.List;
// Cet Analyseur indique si le mot est present ou non 
public class AnalyseurBinaire implements Analyseur{

    public AnalyseurBinaire() {
    	}
    
    public List<motOcc> analyser(List<String> contenudufichiertraité) {
    	List<motOcc> listdesMotsOcc = new ArrayList<>() ;
    	List<String> listWordsChecked= new ArrayList<>();
        for(String element :contenudufichiertraité ) {
            if (!listWordsChecked.contains(element)) {
	            motOcc motOcc1=new motOcc(element ,1.0);
	            listdesMotsOcc.add(motOcc1);
	            listWordsChecked.add(element);
	            }
	        }
    	return listdesMotsOcc ; 
    }
   // [mot1(1ou0) , mot2(1ou0),........ , motn(1ou0)]

}