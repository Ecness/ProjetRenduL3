package hof.game.entity;

import java.util.ArrayList;
import java.util.List;

import hof.game.card.Carte;
import hof.game.card.Equipment;
import hof.game.equipment.EnumEquipment;
import hof.game.event.Battle;
import hof.game.event.CardChoose;
import hof.game.event.Choice;
import hof.game.event.Dice;
import hof.game.event.EnumEvent;
import hof.game.event.EnumResult;
import hof.game.card.CarteEvenement;

public class GameMaster {

	//Deck de carte evenement
	private CarteEvenement DeckEvenement;
	//Deck de carte equipement
	private List<Equipment> equipement;
	//Map du donjon (carte)
	private Carte[][] map;
	//Niveau du donjon
	private int level;
	//Player
	private Player Heros;

	
	
	
	public GameMaster (String name) {

		equipement = new ArrayList<Equipment>();
		DeckEvenement = new CarteEvenement();
		Heros = new Player(name);
		this.level = 0;
		
		map = new Carte[5][5];
		
		for(int i = 0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				map[i][j] = new Carte();
			}
		}
	}
	
	

	// génére le premier donjon.
	public void generation_tuto() {
		equipement.add(new Equipment("Epee Rouille",0,EnumEquipment.Weapon,10,5));
		equipement.add(new Equipment("Hache de bucheron",1,EnumEquipment.Weapon,15,0));
		DeckEvenement.getDeckD().add(new Dice("Reveil",0,EnumEvent.Dice, "Vous vous reveillez douloureux, ne vous rappelant pas ce qui c'est passe.\nAutour de vous des corps sans vie,beaucoup de corps.\nVous etes dans une fosse commune, sans sous, sans nourriture, sans equipement.\nVous fouillez autour de vous dans l'espoir de trouver quelque chose!\n",10,new String[]{"Vous trouvez 25 pièces d'or dans les poches des defunts.\n Vous faites une priere pour eux avant de partir.\n","Vous trouvez 10 pièces d'or dans les poches des defunts.\n Vous etes decu de ne pas avoir trouve plus.\n"},new int[]{25,10},new EnumResult[]{EnumResult.plusgold,EnumResult.plusgold},"La faim vous tiraille alors que vous vous eloignez.\n"));
		DeckEvenement.getDeckCC().add(new CardChoose("Marchand Vereux",0,EnumEvent.CardChoose, "Vous croisez un marchand sur votre route.\nVous le suppliez de vous echangez votre or contre de la nourriture et de quoi vous defendre.\nIl vous donne quelques equipements rouilles et vous demande de choisir entre une \nepee et une hache\n",new String[]{"Vous choisissez l'epee\n","Vous choisissez la hache\n"},new Equipment[] {equipement.get(0),equipement.get(1)},"il vous lance un sac de nourriture et vous conseille de vous depechez car la route est longue \njusque la ville.\n"));
		DeckEvenement.getDeckB().add(new Battle("Bandit Malchanceux",0,EnumEvent.Battle, "Vous entendez un bruit venant des buissons.\nUn bandit surgit et vous ordonne de lui donner vos biens.\nLa diplomatie ne vous menera nulle part.\n","Bandit",30,10,10,new String[]{"Vous avez battu le bandit.\nLui faisant les poches vous trouvez un peu d'or\n","Le bandit vous blesse, mais vous arrivez a fuir de justesse.\nSaignant, vous essayez de le semer.\n"},new int[]{15,5},new EnumResult[]{EnumResult.plusgold,EnumResult.plushp},"Le combat vous a fatigue mais la vue de la ville proche vous soulage.\n"));
		DeckEvenement.getDeckC().add(new Choice("Avenir?",0,EnumEvent.Choice, "Vous suivez le chemin arrivant en ville. Mais vous apercevez une foule bloquant la porte.\nQue faire ?\n",new String[]{"Vous choisissez de continuer jusque la porte de la ville.\n","Vous choisissez de trouver une autre porte pour entrer en ville\n",""},new int[]{0,0},new EnumResult[]{null,null},"Vous arrivez a penetrer en ville avec difficultes\n"));
		map[0][0] = DeckEvenement.getDeckD().get(0);
		map[0][1] = DeckEvenement.getDeckCC().get(0);
		map[0][2] = DeckEvenement.getDeckB().get(0);
		map[0][3] = DeckEvenement.getDeckC().get(0);
	}

	//génére le donjon.
	public void generation_Donjon() {
		for(int i = 0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				switch((int) Math.random() * 4) 
				{
				case 0:
					map[i][j] = DeckEvenement.getDeckD().get((int) Math.random() * 10);
					break;
				case 1:
					map[i][j] = DeckEvenement.getDeckCC().get((int) Math.random() * 10);
					break;
				case 2:
					map[i][j] = DeckEvenement.getDeckB().get((int) Math.random() * 10);
					break;
				case 3:
					map[i][j] = DeckEvenement.getDeckC().get((int) Math.random() * 10);
					break;
				default:
					map[i][j] = DeckEvenement.getDeckB().get((int) Math.random() * 10);
					break;
				}

			}
		}
	}

	



	public Carte getMap(int i,int j) {
		return map[i][j];
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public Player getHeros() {
		return Heros;
	}



	public void setHeros(Player heros) {
		Heros = heros;
	}





}