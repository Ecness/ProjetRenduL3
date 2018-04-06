package hof.graphic.terrain;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Timer;
import java.util.TimerTask;

import hof.game.card.Equipment;
import hof.game.entity.GameMaster;
import hof.game.event.Battle;
import hof.game.event.CardChoose;
import hof.game.event.Choice;
import hof.game.event.Dice;
import hof.game.event.EnumResult;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class Terrain extends Parent {
	
	
	private GameMaster gameMaster = new GameMaster("player 1");
	private CarteG[][] carte;
	private Text[][] nomCarte;
	private AffichageCarte affichageCarte;
	private StatsJoueur statsJoueur;
	private Circle cercleJoueur;
	
	private int choix = 0;
	
	private int x = 0,y=0;
	
	public Terrain() {
		
		gameMaster.generation_tuto();
		carte = new CarteG[5][5];
		affichageCarte = new AffichageCarte();
		
		// creation des élements graphique.
		
		Rectangle fondTerrain = new Rectangle();
		
		GridPane gridPane = new GridPane();
		GridPane gridPaneEquipement = new GridPane();
		
		// creéation du terrain
		fondTerrain.setFill(Color.GREEN);
		fondTerrain.setStroke(Color.BLACK);
		fondTerrain.setWidth(600);
		fondTerrain.setHeight(400);
		fondTerrain.setArcWidth(30);
		fondTerrain.setArcHeight(30);
		
		//création des cartes
		gridPane.setLayoutX(5);
        gridPane.setLayoutY(5);
		
		for(int i = 0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				carte[i][j]=new CarteG(gameMaster.getMap(i, j).getNom(),gameMaster.getMap(i, j).getType());
				gridPane.add(carte[i][j], i, j);
			}
		}
		
		
		//creation joueur
		
		cercleJoueur = new Circle(10,Color.BLACK);
		
		
		//création des stats joueur
		
		statsJoueur = new StatsJoueur(gameMaster.getHeros());
		
		
		this.setTranslateX(5);
        this.setTranslateY(5);
        gridPane.setLayoutX(25);
        gridPane.setLayoutY(25);
        cercleJoueur.setLayoutX(35);
        cercleJoueur.setLayoutY(35);
        statsJoueur.setLayoutX(610);
        statsJoueur.setLayoutY(410);
        affichageCarte.setLayoutX(610);
		this.getChildren().add(fondTerrain);
		this.getChildren().add(gridPane);
		this.getChildren().add(cercleJoueur);
		this.getChildren().add(statsJoueur);
		this.getChildren().add(affichageCarte);
		
		//joue la premiére carte
		
		playCarte(0, 0);
		carte[0][0].joue();
		
	}
	
	
	
	
	//Jeu
		public void playCarte(int x, int y) {
		
			int n = 0;
			int d = 0;
			int m = 1;
			int k= 0;
			
			if(!carte[x][y].getActive()) {
				carte[x][y].setActive(true);
				
				switch(gameMaster.getMap(x,y).getType())
				{
				case Battle:
					Battle b = (Battle) gameMaster.getMap(x,y);
					affichageCarte.maj(b.getIntro());
					b.getNom();
					//Tour player, bouton atck = 1, bouton def = 2
					while(b.getHp()>0 && gameMaster.getHeros().getHp()>0)
					{
						switch(m) {
						case 1:
							switch(n)
							{
							case 1:
								n =(gameMaster.getHeros().getAttack()-b.getDef());
								if(n>0)
									b.setHp(b.getHp()-n);
								else
									n = 0;
								break;
							case 2:
								gameMaster.getHeros().setDefence(gameMaster.getHeros().getDefence()*2);
								break;
							}
							m = 2;
							break;
						case 2:
							//Tour ennemi
							switch((int)Math.random())
							{
							case 0:
								n = (b.getAtk() - gameMaster.getHeros().getDefence()); 
								if(n>0)
									gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()-n);
								else
									n = 0;
								break;
							case 1:
								d = 1;
								b.setDef(b.getDef()*2);
								break;
							}
							m = 1;
							break;
						}
						//Reset def heros
						gameMaster.getHeros().reset();
						//Reset def ennemi
						if(d!=0)
							b.setDef((int)(b.getDef()/2));
					}
					m=1;
					//Selection recompense
					int[] s = b.getResults();
					String[] text = b.getTexts();
					EnumResult[] typeresult = b.getTyperesult();
					
					if(b.getHp()<=0)
					{
						k=0;
					}
					if(gameMaster.getHeros().getHp()<=0)
					{
						k = 1;
					}
					//apliquer results
					switch(typeresult[k])
					{
					case plusgold:
						gameMaster.getHeros().setGold(gameMaster.getHeros().getGold()+s[k]);
						break;
					case minusgold:
						gameMaster.getHeros().setGold(gameMaster.getHeros().getGold()-s[k]);
						break;
					case plusfood:
						gameMaster.getHeros().setFood(gameMaster.getHeros().getFood()+s[k]);
						break;
					case minusfood:
						gameMaster.getHeros().setFood(gameMaster.getHeros().getFood()-s[k]);
						break;
					case plusrep:
						gameMaster.getHeros().setReputation(gameMaster.getHeros().getReputation()+s[k]);
						break;
					case minusrep:
						gameMaster.getHeros().setReputation(gameMaster.getHeros().getReputation()-s[k]);
						break;
					case plushp:
						gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()+s[k]);
						break;
					case minushp:
						gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()-s[k]);
						break;
					}
					//Afficher text result
					//text[k];
					
					
					//afficher outro
					affichageCarte.maj(affichageCarte.getText() + b.getOutro());
					break;
					
				case Choice:
					Choice c = (Choice)gameMaster.getMap(x,y);
					affichageCarte.maj(c.getIntro());
					int[] s1 = c.getResults();
					EnumResult[] typeresult1 = c.getTyperesult();
					// k = valeur bouton 1 ou 2 ou 3
					
					k = 0;
					//afficher text1[k]
					affichageCarte.maj(affichageCarte.getText() + c.getTexts(k));
					
					
					switch(typeresult1[k])
					{
					case plusgold:
						gameMaster.getHeros().setGold(gameMaster.getHeros().getGold()+s1[k]);
						break;
					case minusgold:
						gameMaster.getHeros().setGold(gameMaster.getHeros().getGold()-s1[k]);
						break;
					case plusfood:
						gameMaster.getHeros().setFood(gameMaster.getHeros().getFood()+s1[k]);
						break;
					case minusfood:
						gameMaster.getHeros().setFood(gameMaster.getHeros().getFood()-s1[k]);
						break;
					case plusrep:
						gameMaster.getHeros().setReputation(gameMaster.getHeros().getReputation()+s1[k]);
						break;
					case minusrep:
						gameMaster.getHeros().setReputation(gameMaster.getHeros().getReputation()-s1[k]);
						break;
					case plushp:
						gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()+s1[k]);
						break;
					case minushp:
						gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()-s1[k]);
						break;
					}
					//Afficher outro
					affichageCarte.maj(affichageCarte.getText() + c.getOutro());
					break;
					
				case CardChoose:
					choix = 0;
					CardChoose cc = (CardChoose)gameMaster.getMap(x,y);
					
					affichageCarte.maj(cc.getIntro());
					
					// k = valeur bouton 1 ou 2 ou refuser
					
					
					
					//afficher text2[k]
					affichageCarte.maj(affichageCarte.getText() + cc.getTexts(k));
					Equipment e = cc.getChoix()[k];
					switch(e.getEquipmentCard().getType())
					{
					case Weapon:
						gameMaster.getHeros().setWeapon(e);
						gameMaster.getHeros().reset();
						break;
					case Shield:
						gameMaster.getHeros().setShield(e);
						gameMaster.getHeros().reset();
						break;
					case Armor:
						gameMaster.getHeros().setArmor(e);
						gameMaster.getHeros().reset();
						break;
					case Accessory:
						gameMaster.getHeros().setAccessory(e);
						gameMaster.getHeros().reset();
						break;
					}
					//Afficher outro
					affichageCarte.maj(affichageCarte.getText() + cc.getOutro());
					choix = 0;
					break;
					
				case Dice:
					Dice dc = (Dice)gameMaster.getMap(x,y);
					affichageCarte.maj( dc.getIntro());
					int[] s3 = dc.getResults();
					EnumResult[] typeresult3 = dc.getTyperesult();
					//Bouton lancer dés
					int l = ((int)Math.random()*6)+1 + ((int)Math.random()*6)+1 + ((int)Math.random()*6)+1;
					if(l>dc.getLimit())
					{
						k = 0;
					}
					else
					{
						k = 1;
					}
					//afficher text3[k]
					affichageCarte.maj(affichageCarte.getText() + dc.getTexts(k));
					//appliquer result k
					switch(typeresult3[k])
					{
					case plusgold:
						gameMaster.getHeros().setGold(gameMaster.getHeros().getGold()+s3[k]);
						break;
					case minusgold:
						gameMaster.getHeros().setGold(gameMaster.getHeros().getGold()-s3[k]);
						break;
					case plusfood:
						gameMaster.getHeros().setFood(gameMaster.getHeros().getFood()+s3[k]);
						break;
					case minusfood:
						gameMaster.getHeros().setFood(gameMaster.getHeros().getFood()-s3[k]);
						break;
					case plusrep:
						gameMaster.getHeros().setReputation(gameMaster.getHeros().getReputation()+s3[k]);
						break;
					case minusrep:
						gameMaster.getHeros().setReputation(gameMaster.getHeros().getReputation()-s3[k]);
						break;
					case plushp:
						gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()+s3[k]);
						break;
					case minushp:
						gameMaster.getHeros().setHp(gameMaster.getHeros().getHp()-s3[k]);
						break;
					}
					//Afficher outro
					affichageCarte.maj(affichageCarte.getText() + dc.getOutro());
					
					
					break;
				}
				this.statsJoueur.setPlayer(gameMaster.getHeros());
			}
			else {
				affichageCarte.maj("C'est parage vous paraisse familier, vous ne devriez pas trop trainer.");
			}
			

		}

	
	
	public GameMaster getGameMaster() {
		return gameMaster;
	}

	public CarteG getCarte(int i, int j) {
		return carte[i][j];
	}
	
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public void setx(int x) {
		this.x=x;
	}
	public void sety(int y) {
		this.y=y;
	}
	
	public void setchoix(int choix) {
		this.choix=choix;
	}

	public void maj(int x,int y) {
		cercleJoueur.setLayoutX(35+110*x);
        cercleJoueur.setLayoutY(35+70*y);
	}
	

}
