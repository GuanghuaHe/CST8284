// File:             [TriviaTimeLaunch.java]
// Author:           [Guanghua He 040909700]
// Course:           [CST8284 OOP] 
// Assignment:       [2]
// Date:             $Apr.16 2018$
// Professor:        [SOUHAIL ABDALA]
// Purpose:          [The main point of entry for program with a SplashScreen Animation.]
//

package cst8284.triviatime;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 TriviaTimeLaunch class contain setters and getters for the rootPane object
 The class illustrates how to add SplashScreen Animation
 @author Guanghua
 @version 1.00, 16 Apr 2018
 @see javafx.animation.PauseTransition
 @see javafx.animation.RotateTransition
 @see javafx.animation.ScaleTransition
 @see javafx.animation.SequentialTransition
 @see javafx.application.Application
 @see javafx.scene.Scene
 @see javafx.scene.effect.DisplacementMap
 @see javafx.scene.effect.DropShadow
 @see javafx.scene.effect.FloatMap
 @see javafx.scene.effect.Reflection
 @see javafx.scene.layout.BorderPane
 @see javafx.scene.paint.Color
 @see javafx.scene.text.Font
 @see javafx.scene.text.FontWeight
 @see javafx.scene.text.Text
 @see javafx.stage.Stage
 @see javafx.util.Duration
 @since version 1.0
 **/
@SuppressWarnings("unused")
public class TriviaTimeLaunch extends Application {

	private static BorderPane rootPane;

	/**
	 *
	 Start method
	 The method displays a welcome message 
	 @param primaryStage Stage to be displayed
	 */

	@Override
	public void start(Stage primaryStage){	
		// Display Splash Screen
		setRootPane("Welcome to Trivial Time");
		getRootPane().setTop(Controls.getMenuBar(primaryStage));
		Scene scene =  new Scene(getRootPane(), 1024, 512);
		primaryStage.setTitle("Trivia Time");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	/**
	 
	  main method
	  The method is used for launch.
	  @param args String array.
	 */

	public static void main(String[] args){
		Application.launch(args);
	}


	/**
	 *
	 setRootPane method.
	 The method is used for setting root pane. 
	 using DropShadow and Reflection to
	 provide Effect with Transition.
	 @param logo String.
	 */


	public static void setRootPane(String logo) {
		rootPane = new BorderPane();
		rootPane.setStyle("-fx-background-color: linear-gradient(to right,#f5fffa,#ffffed);  -fx-font: 15px \"Gafata\"; -fx-type:Gafata;");

		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0);
		ds.setOffsetX(3.0);
		ds.setColor(Color.GRAY);
		Text welcomeMessage = new Text(logo);
		welcomeMessage.setEffect(ds);
		welcomeMessage.setCache(true);
		welcomeMessage.setFill(Color.SEAGREEN);
		welcomeMessage.setFont((Font.font("Verdana", FontWeight.BOLD, 30)));

		int width = 220;
		int height = 100;

		FloatMap floatMap = new FloatMap();
		floatMap.setWidth(width);
		floatMap.setHeight(height);

		Reflection reflection = new Reflection();
		reflection.setFraction(0.7);

		welcomeMessage.setX(10.0);
		welcomeMessage.setY(50.0);
		welcomeMessage.setCache(true);
		welcomeMessage.setEffect(reflection);

		RotateTransition rt = new RotateTransition(Duration.millis(1500), welcomeMessage);
		rt.setByAngle(360);
		rt.setCycleCount(1);
		rt.setAutoReverse(true);

		PauseTransition pt = new PauseTransition(Duration.millis(500));

		ScaleTransition st = new ScaleTransition(Duration.millis(1000), welcomeMessage);
		st.setByX(1.0f);
		st.setByY(1.0f);
		st.setCycleCount(2);
		st.setAutoReverse(true);

		SequentialTransition seqT = new SequentialTransition (welcomeMessage,rt, pt, st);
		seqT.play();

		rootPane.setCenter(welcomeMessage);
	}

	/**
	 *
	 getRootPane method.
	 @return BorderPane
	 */
	public static BorderPane getRootPane() {
		return rootPane;
	}

}