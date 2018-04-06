package hof.graphic.terrain;

import hof.game.entity.Player;
import hof.game.equipment.EnumEquipment;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class StatsJoueur extends Parent{
	
	private GridPane gridPane;
	private CarteE Weapon;
	private CarteE Shield;
	private CarteE Armor;
	private CarteE Accessory;
	private StatsJ player;
	
	

	public StatsJoueur(Player player) {
		gridPane = new GridPane();
		
		this.Weapon = new CarteE(player.getAccessory().getNom(), EnumEquipment.Weapon);
		this.Shield = new CarteE(player.getShield().getNom(), EnumEquipment.Shield);
		this.Armor = new CarteE(player.getArmor().getNom(), EnumEquipment.Armor);
		this.Accessory = new CarteE(player.getAccessory().getNom(), EnumEquipment.Accessory);
		this.player = new StatsJ(player);
		
		gridPane.add(this.Weapon, 0, 1);
		gridPane.add(this.Shield, 1, 1);
		gridPane.add(this.Armor, 2, 1);
		gridPane.add(this.Accessory, 3, 1);
		gridPane.add(this.player,4,1);
		
		this.getChildren().add(gridPane);
	}



	public CarteE getWeapon() {
		return Weapon;
	}



	public CarteE getShield() {
		return Shield;
	}



	public CarteE getArmor() {
		return Armor;
	}



	public CarteE getAccessory() {
		return Accessory;
	}



	public void setPlayer(Player player) {
		this.player.maj(player);
		this.Weapon.maj(player,EnumEquipment.Weapon);
		this.Shield.maj(player,EnumEquipment.Shield);
		this.Armor.maj(player,EnumEquipment.Armor);
		this.Accessory.maj(player,EnumEquipment.Accessory);
	}
	
	
}
