package hof.graphic.terrain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Control extends Parent  {

	Terrain terrain ;
	
	public Control(Terrain terrain) {
		
		this.terrain=terrain;
		
		GridPane gridPane = new GridPane();
	
		Button flecheHaut = new Button();
		Button flecheBas = new Button();
		Button flecheDroite = new Button();
		Button flecheGauche = new Button();
		Button action1 = new Button();
		Button action2 = new Button();
		
		flecheHaut.setText("↑");
		flecheBas.setText("↓");
		flecheDroite.setText("→");
		flecheGauche.setText("←");
		action1.setText("Action 1");
		action2.setText("Action 2");
        
      
        
        /*---------------------------------------------------------------*/
        
        flecheHaut.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
             
                
                if(terrain.gety() != 0) {
                	if(terrain.getGameMaster().getMap(terrain.getx(), terrain.gety()-1).getType() != null) {
                		System.out.println("Hello World");
                		terrain.sety(terrain.gety()-1);
                		terrain.maj(terrain.getx(), terrain.gety());
                    	terrain.playCarte(terrain.getx(), terrain.gety());
                    	terrain.getCarte(terrain.getx(), terrain.gety()).joue();
                	}
                }
                
            }
        });
        
        /*---------------------------------------------------------------*/
        
        /*---------------------------------------------------------------*/
        
        flecheDroite.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World3");
                if(terrain.getx() != 5) {
                	if(terrain.getGameMaster().getMap(terrain.getx()+1, terrain.gety()).getType() != null) {
                		terrain.setx(terrain.getx()+1);
                		terrain.maj(terrain.getx(), terrain.gety());
                    	terrain.playCarte(terrain.getx(), terrain.gety());
                    	terrain.getCarte(terrain.getx(), terrain.gety()).joue();
                	}
                }
            }
        });
        
        /*---------------------------------------------------------------*/
        
        /*---------------------------------------------------------------*/
        
        flecheGauche.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World4");
                if(terrain.getx() != 0) {
                	if(terrain.getGameMaster().getMap(terrain.getx()-1, terrain.gety()).getType()!= null) {
                		terrain.setx(terrain.getx()-1);
                		terrain.maj(terrain.getx(), terrain.gety());
                    	terrain.playCarte(terrain.getx(), terrain.gety());
                    	terrain.getCarte(terrain.getx(), terrain.gety()).joue();
                	}
                }
            }
        });
        
        /*---------------------------------------------------------------*/
        
        /*---------------------------------------------------------------*/
        
        action1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World5");
                terrain.setchoix(1);
            }
        });
        
        /*---------------------------------------------------------------*/
        
        /*---------------------------------------------------------------*/
        
        action2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World6");
                terrain.setchoix(2);
            }
        });
        
        /*---------------------------------------------------------------*/
        
        
        /*---------------------------------------------------------------*/
        
        flecheBas.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World2");
                if(terrain.gety() != 5) {
                	if(terrain.getGameMaster().getMap(terrain.getx(), terrain.gety()+1).getType() != null) {
                    	terrain.sety(terrain.gety()+1);
                    	terrain.maj(terrain.getx(), terrain.gety());
                    	terrain.playCarte(terrain.getx(), terrain.gety());
                    	terrain.getCarte(terrain.getx(), terrain.gety()).joue();
                    	
                	}
                }
            }
        });
        
        /*---------------------------------------------------------------*/
        
        gridPane.add(flecheHaut, 1, 0);
        gridPane.add(flecheBas, 1, 1);
        gridPane.add(flecheDroite, 2, 1);
        gridPane.add(flecheGauche, 0, 1);
        gridPane.add(action1, 3, 1);
        gridPane.add(action2, 4, 1);
        
        
        gridPane.setLayoutX(5);
        gridPane.setLayoutY(420);
        this.getChildren().add(gridPane);
	}
	
}
