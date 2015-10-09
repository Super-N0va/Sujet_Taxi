package slamourai_v2;

import java.util.Scanner;
import java.util.List;

public class Methodes {

	// Propri�t�s

	public static Scanner reader = new Scanner(System.in);

	/**
	 * @return
	 * Retourne une cha�ne de caract�res que l'utilisateur saisie.
	 * 
	 * La fonction saisieJour() permet de savoir si le client a voyag� en semaine ou un dimanche.
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
				System.out.println("La saisie rentr�e n'est pas celle attendue");
			}
			
		
		}while(j.equalsIgnoreCase("semaine") && j.equalsIgnoreCase("dimanche"));
		return j;
	}

	/**
	 * 
	 * @return 
	 * Retourne un d�cimal long que l'utilisateur a saisi.
	 * 
	 * La fonction saisieKm() permet la saisie du nombre de kilmom�tres parcourus pendant le voyage.
	 */
	
	public static int saisieKm () {
		int k = 0;
		
		do{
			System.out.println("-Le nombre de kilom�tre(s) :");
			k = reader.nextInt();
		}while(k==0);
		return k;
	}

	/**
	 * 
	 * @return 
	 * Retourne un entier que l'utilisateur saisie.
	 * 
	 * La fonction saisieMin() permet la saisie de la dur�e du voyage(en min).
	 */

	public static int saisieMin () {
		int m = 0;
		
		do{
		System.out.println("-La dur�e du trajet (en minutes) :");
		m = reader.nextInt();
		}while(m==0);
		
		return m;
		
		
	}

	/**
	 * 
	 * @param liste
	 * La grille de tarifs est contenue dans une liste d'objets.
	 * @return
	 * Retourne un entier que l'utilisateur a saisi au pr�alable.
	 * 
	 * La fonction saisieDept() permet la saisie d'un num�ro de d�partement en v�rifiant l'existence de celui-ci.
	 * 
	 */
	
	public static int saisieDept (List<Tarifs> liste) {
		boolean check = false;
		int i = 0;
		
		while(check == false){
		System.out.println("-Le d�partement :");
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

	// M�thode de calcul

	public static void Calcul (Saisie reader2, List <Tarifs> liste) {

		// D�claration des variables

		double prix=0;
		int indice=0;


			while (reader2.getDept() != liste.get(indice).getDepartement() && indice < liste.size() )
			{
				indice ++;
			}
				if (indice >= liste.size())
				{
					System.out.println("Le departement n'a pas �t� trouv�");
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

		// Affichage du prix apr�s calcul

		System.out.println("Votre prix pour le deplacement est de : "+prix+"�");

	}

}