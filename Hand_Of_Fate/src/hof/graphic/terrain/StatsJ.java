package hof.graphic.terrain;

import hof.game.entity.Player;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StatsJ extends Parent{

	Rectangle fond;
	Text nomCartes;
	protected String stats;
	
	public StatsJ(Player player) {
		
		fond = new Rectangle(200,160,Color.ANTIQUEWHITE);
		fond.setStroke(Color.BLACK);
		fond.setArcHeight(10);
		fond.setArcWidth(10);
		
		
		nomCartes = new Text(player.ToString());
		nomCartes.setFont(new Font(15));
		nomCartes.setX(5);
		nomCartes.setY(17);
		nomCartes.setFill(Color.RED);
		
		this.getChildren().add(fond);
		this.getChildren().add(nomCartes);
	}
	
	public void maj(Player player) {
		nomCartes.setText(player.ToString());
	}
	
	
}
