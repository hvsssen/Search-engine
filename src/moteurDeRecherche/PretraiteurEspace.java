package moteurDeRecherche;

import java.util.List;

public class PretraiteurEspace implements Pretraiteur  {
	
	public List<String>  traiter (List <String> text ){
		text.removeIf(str -> str.trim().isEmpty());
		return text;  
    }
	
}
