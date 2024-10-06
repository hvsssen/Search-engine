package moteurDeRecherche;

import java.util.List;

public class PretraiteurMajuscule implements Pretraiteur  {
	public List<String>  traiter (List <String> text ){
		for (int i = 0; i < text.size(); i++) {
            text.set(i, text.get(i).toLowerCase());
        }
		return text;  
    }

}
