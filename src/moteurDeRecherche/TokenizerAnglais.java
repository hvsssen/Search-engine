package moteurDeRecherche;
import java.util.List;
public class TokenizerAnglais implements Pretraiteur {
	@Override
	public List <String> traiter(List<String> text ) {
		        for (int i=0;i<text.size();i++) {
		            if (text.get(i).endsWith("ing")) {
		            	text.set (i, text.get(i).substring(0, text.get(i).length() - 3)); 
		            }
		            else if (text.get(i).endsWith("ed")) {
		            	text.set (i, text.get(i).substring(0, text.get(i).length() - 2));
		            }
		            
		        }
		        return text;
			}
}