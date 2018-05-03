package cst8284.triviatime;


import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TriviaTimeLaunch extends Application {
	/**  @Copyright Dave Houtman 2018.  For use in Winter 2018 - CST8284 classes only */

	private static BorderPane rootPane;

	@Override
	public void start(Stage primaryStage){	
		// Display Splash Screen
		setRootPane("Welcome to Trivial Time");
		getRootPane().setTop(Controls.getMenuBar(primaryStage));
		Scene scene =  new Scene(getRootPane(), 1150, 512, Color.TRANSPARENT);
		//primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.setTitle("Trivia Time");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	public static void main(String[] args){
		Application.launch(args);
	}

	public static void setRootPane(String logo) {
		rootPane = new BorderPane();
		rootPane.setStyle("-fx-background-color: linear-gradient(to right,#f5fffa,#ffffed);  -fx-font: 15px \"Gafata\"; -fx-type:Gafata;");
		rootPane.setCenter(setLogo(logo));
		rootPane.setLeft(new VBox(100) );
		rootPane.setRight(new VBox(100) );
		rootPane.setBottom(new HBox(50) );
		rootPane.setTop(new HBox(50) ); 
	}

	public static BorderPane getRootPane() {
		if(rootPane==null) {
			rootPane=new BorderPane();
		}
		return rootPane;
	}
	
	private static Text setLogo(String text) {
		Text t = new Text();
		t.setFill(Color.DARKSEAGREEN);
		t.setText(text);
		t.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 30));
		return t;
	}


}