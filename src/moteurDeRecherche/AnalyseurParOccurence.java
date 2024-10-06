package moteurDeRecherche;
import java.util.ArrayList;
import java.util.List;

public class AnalyseurParOccurence implements Analyseur{
	
    public AnalyseurParOccurence() {
    }
    
    public List<motOcc> analyser(List<String> contenudufichiertraité) {
    	 
        
    	List<motOcc> listdesMotsOcc = new ArrayList<>() ;
    	List<String> listWordsChecked= new ArrayList<>();
        for(int i=0 ; i<contenudufichiertraité.size();i++) {
            
            double s = 1;
            if (!listWordsChecked.contains(contenudufichiertraité.get(i))) {
            	for(int j=i+1;j<contenudufichiertraité.size();j++) {
            		if(contenudufichiertraité.get(j).equals(contenudufichiertraité.get(i))) {
            			s++;
            		}
            	}
            motOcc motOcc1=new motOcc(contenudufichiertraité.get(i) ,s);
            listdesMotsOcc.add(motOcc1);
            listWordsChecked.add(contenudufichiertraité.get(i));}
        }
       
    	return listdesMotsOcc ; 
    }
 // [mot1occ , mot2occ,........ , motnocc]

}


            
            
            
            
            
            
            
            
            
            
            
            
      
