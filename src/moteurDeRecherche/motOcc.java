package moteurDeRecherche;

public class motOcc {
	private  String mot;
	private  Double occ ;
    public motOcc(String mot , Double occ ) {
        this.mot = mot;
        this.occ = occ;
    }
    public String getMot() {
        return this.mot;
    }
    public Double getOcc() {
        return this.occ;
    }
    public void setMot(String mot ) {
        this.mot = mot;
    }
    public void setOcc(Double occ) {
        this.occ = occ;
    }
}
