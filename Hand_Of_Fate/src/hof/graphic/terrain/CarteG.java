package hof.graphic.terrain;

import hof.game.event.EnumEvent;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class CarteG extends Parent {
	
	Rectangle fond;
	Text nomCartes;
	
	
	private String nom;
	private boolean active;
	private EnumEvent type;
	
	public CarteG(String nom,EnumEvent type) {
		
		
		this.nom=nom;
		this.type = type;
		active = false;
		
		if(type != null) {
			fond = new Rectangle(110,70,Color.RED);
			fond.setStroke(Color.BLACK);
		}
		else {
			fond = new Rectangle(110,70,Color.TRANSPARENT);
			fond.setStroke(Color.TRANSPARENT);
		}
		
		fond.setArcHeight(10);
		fond.setArcWidth(10);
        
		nomCartes = new Text(this.nom);
		nomCartes.setFont(new Font(11));
		nomCartes.setX(5);
		nomCartes.setY(35);
		nomCartes.setFill(Color.RED);
		
		 this.getChildren().add(fond);
		 this.getChildren().add(nomCartes);
		 
		
	}

	public void joue() {
		setNom(true);
		
		switch(type)
		{
		case Battle:
			fond.setFill(Color.PURPLE);
			break;
		case Choice:
			fond.setFill(Color.AZURE);
			break;
		case CardChoose:
			fond.setFill(Color.LIGHTGREEN);
			break;
		case Dice:
			fond.setFill(Color.YELLOW);
			break;
		}
		
	}
	
	public String getNom() {
		return nom;
	}

	protected void setNom(boolean bool) {
		if(bool) {
			nomCartes.setFill(Color.BLACK);
		}
		else {
			nomCartes.setFill(Color.RED);
		}
		
	}

	public void setNomCartes(Text nomCartes) {
		this.nomCartes = nomCartes;
	}

	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active=active;
	}
	
}
