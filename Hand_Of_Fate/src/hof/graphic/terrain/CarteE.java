package hof.graphic.terrain;

import hof.game.entity.Player;
import hof.game.equipment.EnumEquipment;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CarteE extends Parent {

	Rectangle fond;
	Text nomCartes;
	
	public CarteE(String nom,EnumEquipment type) {
		
		fond = new Rectangle(100,160,Color.BLUE);
		fond.setStroke(Color.BLACK);
		fond.setArcHeight(10);
		fond.setArcWidth(10);
		
		nomCartes = new Text(nom);
		nomCartes.setFont(new Font(11));
		nomCartes.setX(5);
		nomCartes.setY(35);
		nomCartes.setFill(Color.RED);
		
		this.getChildren().add(fond);
		this.getChildren().add(nomCartes);
	}

	public void maj(Player player,EnumEquipment type) {
		switch(type)
		{
		case Weapon:
			nomCartes.setText(player.getWeapon().getNom());
			break;
		case Accessory:
			nomCartes.setText(player.getAccessory().getNom());
			break;
		case Armor:
			nomCartes.setText(player.getArmor().getNom());
			break;
		case Shield:
			nomCartes.setText(player.getShield().getNom());
			break;
		}
		
		
	}
	
}
