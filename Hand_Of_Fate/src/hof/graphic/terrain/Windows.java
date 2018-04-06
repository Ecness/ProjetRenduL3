package hof.graphic.terrain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Windows extends Application {

	public static void main(String[] args) {
        Application.launch(Windows.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	
    	 primaryStage.setTitle("HOF");
         Group root = new Group();
         Scene scene = new Scene(root, 1240, 700, Color.ANTIQUEWHITE);

         primaryStage.setScene(scene);
         primaryStage.show();
         
         Terrain terrain = new Terrain();
         root.getChildren().add(terrain); 
         
         Control control = new Control(terrain);
         root.getChildren().add(control);   
         
    }

}
