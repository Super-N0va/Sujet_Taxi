package slamourai_v1;

import java.util.Scanner;

public class tp {

	// Variables globales
	static Scanner reader = new Scanner(System.in);
	static int dept, duree, km;
	static char dimanche;

	// Constantes
	static double tarifs [][] = {
		{ 21, 2, 1.72, 21.93, 1.29, 21.93 },
		{ 25, 2.1, 1.66, 22.5, 1.2, 22.5 },
		{ 39, 2.1,  1.66, 22.5, 1.23, 25 },
		{ 44, 2.2,  1.58, 24.19, 1.19, 24.19 },
		{ 72, 2.15, 1.58, 22.86, 1.19,  22.86 },
		{ 73, 2.4, 1.68, 25.4, 1.26, 25.4 },
		{ 74, 3.15,  1.84, 17.3, 1.38, 17.3 },
		{ 75, 2.5, 1.24, 0.0, 1.5, 0.0 },
		{ 85, 2.3, 1.6, 22.2, 1.2, 22.2 },
		{ 90, 2.2, 1.66, 21, 1.15, 21 }
	};


		public static void Saisie() { // Méthode permettant la saisie des entrées
do{
			System.out.println("Saisissez le département : ");
			dept = reader.nextInt();
			if (dept < 0 || dept > 95){
				System.out.print("Le département saisi est incorrect\n");
			}} while (dept < 0 || dept > 95); // Tant que le département n'est pas compris entre 0 et 95

		do {
				System.out.println("Le trajet était-il un dimanche ? (o/n)");
				dimanche = reader.next().toLowerCase().charAt(0);
				if (dimanche != 'o' && dimanche !='n')
					System.out.print("La réponse est incorrecte\n");
		} while(dimanche != 'o' && dimanche != 'n');  // Tant que la réponse n'est pas o ou n

				do {
					System.out.println("Durée du trajet ? (en min)");
					duree = reader.nextInt();
					if (duree < 0)
					{
						System.out.print("La durée saisie est incorrecte\n");
					}} while ( duree < 0); // Tant que la durée est inférieure à  0

					do {
						System.out.println("Nombre de kilométres parcourus ?");
						km = reader.nextInt();
						if (km < 0){
							System.out.print("Le nombre de kilométres saisi est incorrect\n");
						}
					}while (km<0); // Tant que le nb de km est inférieur à 0


		}
					public static double Calcul(int departement) { // Methode calculant le total des frais en fonction du departement choisi
						//duree = (int)(duree / 60);
						double price =0.0;

						if (dimanche == 'o') { // Si le trajet est un dimanche
							price = tarifs[departement][1] + (km * tarifs[departement][4]);
							if (duree > 60) // Si le trajet est de plus d'une heure
								price += (int) (duree/60) * tarifs[departement][5];
						}

						else  { // Si le trajet est en semaine
							price = tarifs[departement][1] + (km * tarifs[departement][2]);
									if(duree > 60) // Si le trajet est de plus d'une heure
										price += (int) (duree/60) * tarifs[departement][3];
						}

						return price;
					}




				public static void main(String[] args) {
					java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");

					int departement = 0;

					Saisie(); // Saisie de l'utilisateur

					for(int i = 0; i < 10; i++)  { // Pour chaque ligne du tableau, vérification si le département existe
						if(tarifs[i][0] == dept) {
							departement = i;
							break;
						}

					}

						System.out.print("\n\nPrix : " + String.valueOf(df.format(Calcul(departement))) + "€"); // Affichage du prix

					}

}