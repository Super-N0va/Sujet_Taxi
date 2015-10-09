package slamourai_v3_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public abstract class tp {

public static void main(String[] args) {

	List <Tarifs> lstTarifs = new ArrayList<Tarifs>();

					// Parcours du fichier tarifs.txt et récupération des valeurs dans notre liste

					try {
						String ligne;
						String tableau[];
						BufferedReader tarifsLecture = new BufferedReader(new FileReader("P:/SLAM 4/Workspace/Slamourai 2/src/slamourai_v3_1/tarifs.txt"));

							while((ligne=tarifsLecture.readLine())!=null){
								tableau = ligne.split(",");
								lstTarifs.add(new Tarifs(Integer.parseInt(tableau[0]), Double.parseDouble(tableau[1]), Double.parseDouble(tableau[2]),Double.parseDouble(tableau[3]), Double.parseDouble(tableau[4]), Double.parseDouble(tableau[5])));

								}

							tarifsLecture.close();
					}

					catch(IOException e)
					{
						System.out.println(e.getMessage());
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
