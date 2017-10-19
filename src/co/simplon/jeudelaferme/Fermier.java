package co.simplon.jeudelaferme;

import java.util.ArrayList;

public class Fermier {

	private int nbreChatsDuFermier;
	
	public Fermier (int nbreChatsDuFermier) {
		this.nbreChatsDuFermier = nbreChatsDuFermier;
	}
	
	protected Chat [] etablirOrdreDeChasse (Chat [] listeChat) {
		ArrayList<Integer> nombre = new ArrayList<Integer> ();
		for (int i = 0 ; i < listeChat.length ; i++) {
			nombre.add(0);
		}
		Chat [] ordre = new Chat [listeChat.length];
		for (int i = 0 ; i < this.nbreChatsDuFermier ; i++) {
			nombre.set(i, i);
		}
		for (int i = 0; i < listeChat.length ; i++) {
			int tirage = (int) Math.random () * nombre.size();
			ordre [i] = listeChat [(int) nombre.get(tirage)];
			nombre.remove(tirage);
		}
		return ordre;
	}
	
	protected void donnerMission (Chat [] listeChat) {
		for (int i = 0 ; i < listeChat.length ; i++) {
			listeChat[i].setMissionDeChasse( ( (int) Math.random () * 15) +15);
		}
	}
	
	protected void attribuerZoneChasse (Chat [] listeChat , int nbreZones) {
		for (int i = 0 ; i < listeChat.length ; i++) {
			listeChat[i].setZoneDeChasse ( (int) Math.random () * nbreZones);
		}
	}
	
	public int getNbreChats () {
		return nbreChatsDuFermier;
	}
}
