package slamourai_v2;

import java.util.Scanner;
import java.util.List;

public class Methodes {

	// Propriétés

	public static Scanner reader = new Scanner(System.in);

	/**
	 * @return
	 * Retourne une chaîne de caractères que l'utilisateur saisie.
	 * 
	 * La fonction saisieJour() permet de savoir si le client a voyagé en semaine ou un dimanche.
	 * 
	 */	
	
	public static String saisieJour () {
		String j = "";
		do{
			System.out.println("-Le jour de la semaine :");
			try{
				j = reader.next();
			}
			catch(Exception e){
				String J = reader.next();
				System.out.println("La saisie rentrée n'est pas celle attendue");
			}
			
		
		}while(j.equalsIgnoreCase("semaine") && j.equalsIgnoreCase("dimanche"));
		return j;
	}

	/**
	 * 
	 * @return 
	 * Retourne un décimal long que l'utilisateur a saisi.
	 * 
	 * La fonction saisieKm() permet la saisie du nombre de kilmomètres parcourus pendant le voyage.
	 */
	
	public static int saisieKm () {
		int k = 0;
		
		do{
			System.out.println("-Le nombre de kilomètre(s) :");
			k = reader.nextInt();
		}while(k==0);
		return k;
	}

	/**
	 * 
	 * @return 
	 * Retourne un entier que l'utilisateur saisie.
	 * 
	 * La fonction saisieMin() permet la saisie de la durée du voyage(en min).
	 */

	public static int saisieMin () {
		int m = 0;
		
		do{
		System.out.println("-La durée du trajet (en minutes) :");
		m = reader.nextInt();
		}while(m==0);
		
		return m;
		
		
	}

	/**
	 * 
	 * @param liste
	 * La grille de tarifs est contenue dans une liste d'objets.
	 * @return
	 * Retourne un entier que l'utilisateur a saisi au préalable.
	 * 
	 * La fonction saisieDept() permet la saisie d'un numéro de département en vérifiant l'existence de celui-ci.
	 * 
	 */
	
	public static int saisieDept (List<Tarifs> liste) {
		boolean check = false;
		int i = 0;
		
		while(check == false){
		System.out.println("-Le département :");
			try{
				i = reader.nextInt();
				
				for(int j=0;j<=liste.size();j++){
					if(i==liste.get(j).getDepartement()){
						check = true;
						break;
					}
						
					}
				
			}
			catch(Exception e){
				String D = reader.next();
				System.out.println("La saisie ne figure pas dans la liste");
			}
		}	
		return i;
	}

	// Méthode de calcul

	public static void Calcul (Saisie reader2, List <Tarifs> liste) {

		// Déclaration des variables

		double prix=0;
		int indice=0;


			while (reader2.getDept() != liste.get(indice).getDepartement() && indice < liste.size() )
			{
				indice ++;
			}
				if (indice >= liste.size())
				{
					System.out.println("Le departement n'a pas été trouvé");
				}

				else {

					if ((int)(reader2.getDuree()/60) >=1 && reader2.getJour().equals("Dimanche"))
					{
					prix = liste.get(indice).getPriseEnCharge() + ((int)(reader2.getDuree()/60) * liste.get(indice).getTarifHoraireDimanche()) + (reader2.getNbKm() * liste.get(indice).getTarifKmDimanche());
					}

					if ((int)(reader2.getDuree()/60) >= 1 && !reader2.getJour().equals("Dimanche"))
					{
					prix = liste.get(indice).getPriseEnCharge() + ((int)(reader2.getDuree()/60) * liste.get(indice).getTarifHoraireSemaine()) + reader2.getNbKm() * liste.get(indice).getTarifKmSemaine();
					}

					if ( (int)(reader2.getDuree()/60) < 1  && reader2.getJour().equals("Dimanche"))
					{
					prix = liste.get(indice).getPriseEnCharge() + (reader2.getNbKm() * liste.get(indice).getTarifKmDimanche());
					}

					if ((int)(reader2.getDuree()/60) < 1 && ! reader2.getJour().equals("Dimanche"))
					{
						prix = liste.get(indice).getPriseEnCharge() + (reader2.getNbKm() * liste.get(indice).getTarifKmSemaine());
					}
				}

		// Affichage du prix après calcul

		System.out.println("Votre prix pour le deplacement est de : "+prix+"€");

	}

}