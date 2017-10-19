package co.simplon.jeudelaferme;

import java.util.ArrayList;

public class JeuxDeLaFerme {
	static int nbreSouris = 1500;
	static int sourisTuees = 0;
	static ArrayList<Integer> nbreSourisParZone = new ArrayList<Integer> () {{
		add (0);
		add (0);
		add (0);
		add (0);
	}};
	static ArrayList<String> identificationZone = new ArrayList<String> () {{
		add ("zone A");
		add ("zone B");
		add ("zone C");
		add ("zone D");
	}};
	static ArrayList<String> nomChats = new ArrayList<String> () {{
		add ("Nemo");
		add ("Garfield");
		add ("Fripouille");
		add ("Princesse");
		add ("Mimine");
	}};
	static ArrayList<Integer> ageChats = new ArrayList<Integer> () {{
		add (5);
		add (1);
		add (15);
		add (2);
		add (7);
	}};
	static ArrayList<Integer> ordreDeChasse = new ArrayList<Integer> ();
	
	public static void main(String[] args) {

		Fermier chefDeChasse = new Fermier (5); 
		Chat [] instanceChat = creationChats (chefDeChasse.getNbreChats()); // crée les objets chats et les met dans un tableau
		repartirSourisDebut (nbreSouris);
		for (int i = 0; i < 4; i++) {
			System.out.println(identificationZone.get(i) + " : " +nbreSourisParZone.get(i));
		}
		//while (nbreSouris != 0) {    // boucle qui joue un tour tant qu'il reste une souris de vivante
			changerSourisDeZone ();
			for (int i = 0; i < 4; i++) {
				System.out.println(identificationZone.get(i) + " nouveau : " +nbreSourisParZone.get(i));
			}
			Chat ordreDeChasse [] = chefDeChasse.etablirOrdreDeChasse (instanceChat);
			chefDeChasse.donnerMission (instanceChat);
			/*for (int i = 0 ; i < ordreDeChasse.length ; i++){
				ordreDeChasse [i].chasserSouris(nbreSourisParZone);
			}*/
			for (int i = 0 ; i < instanceChat.length ; i++) {
				nbreSourisParZone = ordreDeChasse[i].chasserSouris (nbreSourisParZone);
				instanceChat [i].faireSonRapport(identificationZone);
		//	}
		}
		//afficherLePalmares ();
	}

	protected static Chat [] creationChats (int nbreChats) {
		Chat [] objetsChat = new Chat [nbreChats];
		for (int i = 0 ; i < nbreChats ; i++) {
			objetsChat[i] = new Chat (nomChats.get(i) , ageChats.get(i));
		}
		return objetsChat;
	}
	
	private static void repartirSourisDebut (int nombre) {
		int sourisARepartir = nombre;
		for (int i = 0 ; i <nbreSourisParZone.size() - 1 ; i++) {  // on affecte les souris zone après zone
			nbreSourisParZone.set (i, (int) (Math.random () * sourisARepartir));  // on tir ealéatoirement dans le nombre de souris qui restent à répartir
			sourisARepartir = sourisARepartir - nbreSourisParZone.get(i); // a réactualise le nombre de souris à répartir
		}
		nbreSourisParZone.set(nbreSourisParZone.size() - 1, sourisARepartir); // la dernière zone a les souris qui restent
	}
	
	private static void changerSourisDeZone () {
		Integer sourisRestant;
		Integer sourisArrivant;
		ArrayList<Integer> nouvelleRepartition = new ArrayList<Integer> ();
		for (int i = 0; i < nbreSourisParZone.size() - 1 ; i++) {
			nouvelleRepartition.add(0);
			if (i == 0) {  // gère l'exception du passage de fin de tableau à 0
				sourisArrivant =/*(int) Math.round( (double) */(nbreSourisParZone.get(nbreSourisParZone.size() - 1) + 1) /2 /*)*/; // le nombre de souris bougeant est arrondis au sup
				sourisRestant = /*(int) Math.round( (double)*/ nbreSourisParZone.get(0) /2/*)*/; // le nombre de souris restant est arrondi à l'inf
			}
			else {
				sourisArrivant = /*(int) Math.round( (double) */(nbreSourisParZone.get(i-1) + 1) /2/*)*/;
				sourisRestant = /*(int) Math.round( (double) */nbreSourisParZone.get(i)  /2/*/*)*/;
			}
			nouvelleRepartition.set(i , sourisRestant + sourisArrivant);
			System.out.println("Ancien : " + identificationZone.get(i) + " = " + nbreSourisParZone.get(i) + " Nouveau : " + nouvelleRepartition.get(i));
		}
		
		for (int i = 0 ; i < nouvelleRepartition.size(); i++) {
			nbreSourisParZone.set(i, nouvelleRepartition.get(i));
		}
	}
	/*private static void afficherLePalmares () {
		
	}*/
	
}
