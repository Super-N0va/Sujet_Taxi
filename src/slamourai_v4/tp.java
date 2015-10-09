package slamourai_v4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public abstract class tp {

public static void main(String[] args) {

	List <Tarifs> lstTarifs = new ArrayList<Tarifs>();

					try {
							Class.forName("org.postgresql.Driver");
							String url ="jdbc:postgresql://172.16.99.2:5432/sgilbert";
							Connection maCo = DriverManager.getConnection(url, "s.gilbert", "trgb3zbj");
							
							Statement maRequete = maCo.createStatement();
							String txtRequete = "SELECT * FROM slamourai.departement";
							
							ResultSet curseurResultat = maRequete.executeQuery(txtRequete);
							
							ResultSetMetaData detailsDonnees = curseurResultat.getMetaData();
							
								for(int i = 1; i <= detailsDonnees.getColumnCount(); i++)
								{
									while(curseurResultat.next()){									
									lstTarifs.add(new Tarifs(Integer.parseInt(curseurResultat.getString("dept")), Double.parseDouble(curseurResultat.getString("pec")), Double.parseDouble(curseurResultat.getString("tarifKmSem")), Double.parseDouble(curseurResultat.getString("tarifHoraireSem")), Double.parseDouble(curseurResultat.getString("tarifKmDim")), Double.parseDouble(curseurResultat.getString("tarifHoraireDim"))));
									}
									
								}
							
								// On ferme le flux résultat
								curseurResultat.close();
								
								// On ferme l'objet lié à la connexion
								maRequete.close();
							
							
					}
					

					catch (Exception e) {
						System.out.println(e.getMessage());
					}



					// Création d'une nouvelle saisie

					Saisie reader1 = new Saisie();

					// Ajout des données aprés saisie de l'utilisateur dans les propriétés de la classe Saisie

					reader1.setJour(Methodes.saisieJour());
					reader1.setNbKm(Methodes.saisieKm());
					reader1.setDuree(Methodes.saisieMin());
					reader1.setDept(Methodes.saisieDept(lstTarifs));

					Methodes.Calcul(reader1, lstTarifs);

}

}
