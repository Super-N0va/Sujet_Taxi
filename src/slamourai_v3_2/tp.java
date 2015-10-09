package slamourai_v3_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public abstract class tp {

public static void main(String[] args) {

	List <Tarifs> lstTarifs = new ArrayList<Tarifs>();

					try {

					DocumentBuilderFactory readXML = DocumentBuilderFactory.newInstance();
					DocumentBuilder unDB = readXML.newDocumentBuilder();
					Document leDoc = unDB.parse(new File("P:/SLAM 4/Workspace/Slamourai 2/src/slamourai_v3_2/tarifs.xml"));

					Element racine = leDoc.getDocumentElement();
					NodeList racineNoeuds = racine.getChildNodes();
					
						for (int i = 0; i<racineNoeuds.getLength(); i++) {
							if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
								Element departement = (Element) racineNoeuds.item(i);
								
								Element pec = (Element) departement.getElementsByTagName("pec").item(0);
								Element tarifKmSem = (Element) departement.getElementsByTagName("tarifKmSem").item(0);
								Element tarifHoraireSem = (Element) departement.getElementsByTagName("tarifHoraireSem").item(0);
								Element tarifKmDim = (Element) departement.getElementsByTagName("tarifKmDim").item(0);
								Element tarifHoraireDim = (Element) departement.getElementsByTagName("tarifHoraireDim").item(0);
								
								lstTarifs.add(new Tarifs(Integer.parseInt(departement.getAttribute("numero")), Double.parseDouble(pec.getTextContent()), Double.parseDouble(tarifKmSem.getTextContent()), Double.parseDouble(tarifHoraireSem.getTextContent()), Double.parseDouble(tarifKmDim.getTextContent()), Double.parseDouble(tarifHoraireDim.getTextContent())));
								
							}
						}

					}

					catch(ParserConfigurationException e)
					{
						System.out.println(e.getMessage());
					}

					catch(IOException e)
					{
						System.out.println(e.getMessage());
					}

					catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
