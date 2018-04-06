package hof.game.event;

import hof.game.card.Carte;

public class Dice extends Carte{
	//Texte d'introduction de la carte
	String intro = "";
	//Limite a depasser au lancer de dés
	int limit = 0;
	//Textes de résultats Gagnant/Perdu
	String[] texts = new String[2];
	//Valeur des Resultats Gagnant/Perdu
	int[] results = new int[2];
	//Type de resultats Gagnant/Perdu
	EnumResult[] typeresult = new EnumResult[2];
	//Texte de fin de la carte
	String outro = "";

	//Constructeur
	public Dice(String nom, int id,EnumEvent type, String intro, int limit, String[] texts, int[] results,
			EnumResult[] typeresult, String outro) {
		super(nom, id,type);
		this.intro = intro;
		this.limit = limit;
		this.texts = texts;
		this.results = results;
		this.typeresult = typeresult;
		this.outro = outro;
	}

	//Getters & Setters
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTexts(int i) {
		return texts[i];
	}

	public void setTexts(String[] texts) {
		this.texts = texts;
	}

	public int[] getResults() {
		return results;
	}

	public void setResults(int[] results) {
		this.results = results;
	}

	public EnumResult[] getTyperesult() {
		return typeresult;
	}

	public void setTyperesult(EnumResult[] typeresult) {
		this.typeresult = typeresult;
	}


	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}



}
