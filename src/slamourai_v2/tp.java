package slamourai_v2;

import java.util.ArrayList;
import java.util.List;


public abstract class tp {

public static void main(String[] args) {

					// Création du tableau tarifs ligne par ligne

					final int departement[] = { 21, 25, 39, 44, 72, 73, 74, 75, 85, 90 };
					final double PeC[] = { 2, 2.1, 2.1, 2.2, 2.15, 2.4, 3.15, 2.5, 2.3, 2.2 };
					final double kmSem[] = { 1.72, 1.66, 1.66, 1.58, 1.58, 1.68, 1.84, 1.24, 1.6, 1.66 };
					final double horSem[] = { 21.93, 22.5, 22.5, 24.19, 22.86, 25.4, 17.3, 0, 22.2, 21 };
					final double kmDim[] = { 1.29, 1.2, 1.23, 1.19, 1.19, 1.26, 1.38, 1.5, 1.2, 1.15 };
					final double horDim[] = { 21.93, 22.5, 25, 24.19, 22.86, 25.4, 17.3, 0, 22.2, 21 };

					List <Tarifs> lstTarifs = new ArrayList<Tarifs>();

					// Ajout des données tarifs dans la liste

					for(int i=0; i<10; i++) {
						lstTarifs.add(new Tarifs(departement[i], PeC[i], kmSem[i], horSem[i], kmDim[i], horDim[i]));
					}

					// Création d'une nouvelle saisie

					Saisie reader1 = new Saisie();

					// Ajout des données après saisie de l'utilisateur dans les propriétés de la classe Saisie

					reader1.setJour(Methodes.saisieJour());
					reader1.setNbKm(Methodes.saisieKm());
					reader1.setDuree(Methodes.saisieMin());
					reader1.setDept(Methodes.saisieDept(lstTarifs));

					Methodes.Calcul(reader1, lstTarifs);

}
}
