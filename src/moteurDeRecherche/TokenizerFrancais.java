package moteurDeRecherche;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TokenizerFrancais implements Pretraiteur {
	@Override
	public List <String> traiter(List<String> text) {
		@SuppressWarnings("unused")
		List<String> tokens = new ArrayList<>();
        List<String> terminaisons = Arrays.asList("ent", "ez", "ons", "e", "es", "ions", "iez", "ient", "ais", "ait", "er", "ir", "re", "ais", "ait", "ions", "iez", "aient", "is", "issais", "issait", "issions", "issiez", "issent", "îmes", "îtes", "ître", "îtent", "îtrai", "îtras", "îtra", "îtrons", "îtrez", "îtront", "îtriez", "îtrais", "îtrait", "îtriions", "îtriiez", "îtraient", "isse", "isses", "issiez", "issons", "issez", "issant", "issante", "issantes", "issants", "ai", "as", "a", "ons", "ez", "ont", "erai", "eras", "era", "erons", "erez", "eront", "erais", "erais", "erait", "erions", "eriez", "eraient", "é", "ée", "ées", "és", "éz", "ies", "ient", "iant", "îtes", "ît", "ît", "îmes", "irai", "irons", "iront", "irez", "irai", "irait", "irais", "iraient", "iras", "iriez", "irions", "isse", "isses", "issent", "issiez", "issions", "issent", "issiez", "irais", "irait", "iras", "irait", "irait", "îtes", "iront", "issent", "iront", "iront", "iront", "issant", "issez", "isses", "issons", "irais", "irions", "irons", "îtes", "îtes", "it", "ît", "îmes", "isse", "isses", "issent", "it", "ît", "îtes", "it", "îmes", "îtes", "ir", "irai", "irais", "irait", "iras", "irent", "irons", "iront", "is", "isse", "isses", "issez", "issions", "issiez", "issons", "issait", "issais", "issions", "issiez", "issait", "issions", "issiez", "îtes", "it", "ît", "isses", "isses", "issent", "isses", "ît", "issent", "ît");
        for (int i=0;i<text.size();i++) {
        		for (String terminaison : terminaisons) {
        			if (text.get(i).endsWith(terminaison)) {
        				text.set(i,text.get(i).substring(0, text.get(i).length() - terminaison.length()));
	                    break;
                    
        			}
        		}
        	}
         return text;
	}
}
