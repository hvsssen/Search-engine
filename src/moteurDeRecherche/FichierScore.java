package moteurDeRecherche;

public class FichierScore implements Comparable<FichierScore>  {
	public FichierScore(String fichier, Double score ) {
		this.fichier=fichier ; 
		this.score = score  ; 
	}
	
	public String fichier ; 
	public  Double score; 
	 public String getFichier() {
	        return fichier;
	    }

	    
	    public void setFichier(String fichier) {
	        this.fichier = fichier;
	    }

	    
	    public Double getScore() {
	        return score;
	    }


	    public void setScore(Double score) {
	        this.score = score;
	    }
	    
	    public int compareTo (FichierScore fS) {
			// int o = p1.compareTo(p2) if o <0 <=> p1 < p2 ,,,, if o =0 <=> p1 equals p2 ,,,,,,if o >0 <=> p1 >p2 
			if (this.getScore()>fS.getScore()) {
				return 1 ; 
			}
			if (this.getScore()<fS.getScore()) {
				return -1 ; 
			}
			else {
				return 0 ; 
			}
	    
	    
}
}