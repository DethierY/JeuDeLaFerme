package co.simplon.jeudelaferme;

import java.util.ArrayList;

public class Chat {
	
	private String nomChat;
	private int ageChat;
	private int missionDeChasse;
	private int zoneDeChasse;
	private int scoreDeLaNuit;
	private int handicap;
	private int scoreTotal;
	
	public Chat (String nomChat , int ageChat) {
		this.nomChat = nomChat;
		this.ageChat = ageChat;
		this.missionDeChasse = 0;
		this.zoneDeChasse = 0;
		this.scoreDeLaNuit = 0;
		this.scoreTotal = 0;
		if (this.ageChat < 3) {
			this.handicap = 4;
		}
		else if (this.ageChat > 10) {
			this.handicap = 3;
		}
		else {
			this.handicap = 2;
		}
	}
	
	protected ArrayList<Integer> chasserSouris (ArrayList<Integer> Souris ) {
		this.scoreDeLaNuit = 0; // réinitialisation de lattribut
		int sourisChassables = Souris.get (this.zoneDeChasse); // trouve le nombre de souris dans la zone de chasse du chat
		if (this.missionDeChasse > sourisChassables) {  // calcul le palmares du chat cette nuit
			this.scoreDeLaNuit = sourisChassables / this.handicap;
		}
		else {
			this.scoreDeLaNuit = this.missionDeChasse / this.handicap;
		}
		Souris.set(this.zoneDeChasse, sourisChassables - this.scoreDeLaNuit); // réactualise le nombre de souris restante dans la zone chassée
		this.scoreTotal = this.scoreTotal + this.scoreDeLaNuit; //incrémente le score du chat
		return Souris;   // retourne le nouveau tableau d'effectifs de souris par zone
	}
	
	protected void faireSonRapport (ArrayList<String> listeZones) {
		System.out.println(this.nomChat + " a chassé " + this.scoreDeLaNuit + " cette nuit dans la " + listeZones.get(this.zoneDeChasse) + ".");
	}
	
	public int getScoreTotal () {
		return this.scoreTotal;
	}
	
	public void setMissionDeChasse (int valeur) {
		this.missionDeChasse = valeur;
	}
	
	public void setZoneDeChasse (int valeur) {
		this.zoneDeChasse = valeur;
	}
	
}
