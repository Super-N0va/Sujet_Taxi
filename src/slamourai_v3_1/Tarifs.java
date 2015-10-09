package slamourai_v3_1;

public class Tarifs {

	/** 
	 *@attributs Ces attributs correspondent aux informations de la grille de tarifs
	 * Ils permettront de calculer le prix d'un voyage en France.
	 */

	private int departement;
	private double priseEnCharge, tarifKmSemaine, tarifHoraireSemaine, tarifKmDimanche, tarifHoraireDimanche;

	// Accesseurs

	public double getDepartement(){
		return departement;
	}

	public double getPriseEnCharge() {
		return priseEnCharge;
	}

	public double getTarifKmSemaine(){
		return tarifKmSemaine;
	}

	public double getTarifHoraireSemaine() {
		return tarifHoraireSemaine;
	}

	public double getTarifKmDimanche(){
		return tarifKmDimanche;
	}

	public double getTarifHoraireDimanche(){
		return tarifHoraireDimanche;
	}

	// Constructeurs

	public Tarifs()
	{}

	public Tarifs(int departement, double priseEnCharge, double tarifKmSemaine, double tarifHoraireSemaine, double tarifKmDimanche, double tarifHoraireDimanche) {
		this.departement = departement;
		this.priseEnCharge = priseEnCharge;
		this.tarifKmSemaine = tarifKmSemaine;
		this.tarifHoraireSemaine = tarifHoraireSemaine;
		this.tarifKmDimanche = tarifKmDimanche;
		this.tarifHoraireDimanche = tarifHoraireDimanche;
	}


}
