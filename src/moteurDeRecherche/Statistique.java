package moteurDeRecherche;
//changeons les termes de triple par cette classe 
public class Statistique  {
	private String mot ; 
	private String fichier ; 
	public Double stat ; 
	
	public Statistique (String mot,String fichier,Double stat ) {
		this.mot=mot; 
		this.fichier=fichier ; 
		this.stat=stat; 
	}
	
	public String getMot() {
		return this.mot ; 
	}
	public String getFichier() {
		return this.fichier ; 
	}
	public Double getStat() {
		return this.stat ; 
	}
	
	public void setMot(String mot) {
		this.mot=mot ; 
	}
	public void setFichier(String fichier) {
		this.fichier=fichier ; 
	}
	public void setStat(double stat ) {
		this.stat=stat ; 
	}
	
	
		
	}
	


