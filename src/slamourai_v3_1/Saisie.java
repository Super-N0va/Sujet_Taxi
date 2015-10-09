package slamourai_v3_1;

public class Saisie {

	// Propriétés

	private int dept;
	private int nbKm;
	private String jour;
	private int duree;

	// Accesseurs

	public int getDept() {
		return dept;
	}
	public void setDept(int D) {
		this.dept=D;
	}

	public int getNbKm() {
		return nbKm;
	}
	public void setNbKm(int d) {
		this.nbKm=d;
	}

	public String getJour() {
		return jour;
	}
	public void setJour (String J) {
		this.jour=J;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int Du) {
		this.duree=Du;
	}

	// Constructeurs

	public Saisie () {}

	public Saisie (int dept, int nbKm, String jour, int duree) {
		this.dept=dept;
		this.nbKm=nbKm;
		this.jour=jour;
		this.duree=duree;
	}
}

