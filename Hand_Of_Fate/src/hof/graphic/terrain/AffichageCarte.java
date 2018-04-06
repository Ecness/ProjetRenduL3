package hof.graphic.terrain;

import hof.game.entity.Player;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AffichageCarte extends Parent {
	
	Rectangle fond;
	Text nomCartes;
	String text;
	
	public AffichageCarte() {
		
		fond = new Rectangle(620,400,Color.LIGHTGREY);
		fond.setStroke(Color.BLACK);
		fond.setArcHeight(10);
		fond.setArcWidth(10);
		
		nomCartes = new Text();
		nomCartes.setFont(new Font(15));
		nomCartes.setX(5);
		nomCartes.setY(35);
		nomCartes.setFill(Color.RED);
		
		this.getChildren().add(fond);
		this.getChildren().add(nomCartes);
	}
	
	public void maj(String text) {
		nomCartes.setText(text);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
}
