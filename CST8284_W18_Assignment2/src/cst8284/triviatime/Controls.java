// File:              Controls.java 
// Author:            Guanghua He 040909700 
// Course:            CST8284 OOP  
// Assignment:        2 
// Date:             $Apr.16 2018$
// Professor:         SOUHAIL ABDALA 
// Purpose:           The controls contains static methods related mostly to the menus,
//                    as well as the ‘Next Question’ button that appears in the bottom right corner 
//                    of the display when the questions are loaded.
//                    add three features to the Settings menu:
//                    Randomize Questions
//                    Increasing Difficulty
//                    By Topic
//                    Add Accelerator keys to the menu          
//


package cst8284.triviatime;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 Controls class contain Generic Menu/Menu Item Properties, MenuBar, MenuItems
 This class illustrates how to add SplashScreen Animation
 @author Guanghua He
 @version 1.00, 16 Apr 2018
 @see   java.io.File 
 @see   java.util.Collections 
 @see   java.util.Comparator 
 @see   javafx.application.Platform 
 @see   javafx.event.ActionEvent 
 @see   javafx.geometry.Insets 
 @see   javafx.geometry.Pos 
 @see   javafx.scene.control.Alert 
 @see   javafx.scene.control.Alert.AlertType 
 @see   javafx.scene.control.Button 
 @see   javafx.scene.control.Menu 
 @see   javafx.scene.control.MenuBar 
 @see   javafx.scene.control.MenuItem 
 @see   javafx.scene.input.KeyCode 
 @see   javafx.scene.input.KeyCodeCombination 
 @see   javafx.scene.input.KeyCombination 
 @see   javafx.scene.layout.HBox 
 @see   javafx.scene.layout.VBox 
 @see   javafx.stage.Stage 
 @since version 1.0
 */

public class Controls {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;
	private static Stage stage;
	private static int currentQuestion = 0;

	/***************** MenuBar *****************/
	/**
	 *
	 getMenuBar method. 
	 The method sets a MenuBar 
	 @param primaryStage  Stage to be displayed
	 @return MenuBar  Three MenuBar File Setting Help
	 */

	public static MenuBar getMenuBar(Stage primaryStage) {
		setStage(primaryStage);
		MenuBar mnBar = new MenuBar();
		mnBar.getMenus().addAll(getMnu("File"), getMnu("Settings"), getMnu("Help"));
		return mnBar;
	}

	/***************** MenuBar *****************/
	/**
	 *
	 getMnu method. 
	 The method sets a Menu 
	 @param name  String to be displayed
	 */

	private static Menu getMnu(String name) {
		mnu=new Menu("_"+name);
		if("file".equalsIgnoreCase(name)) {
			mnu.getItems().addAll(getMnuItm("New Game"),getMnuItm("Exit"));
		}else if("settings".equalsIgnoreCase(name)) {
			mnu.getItems().addAll(getMnuItm("Randomize Questions"),getMnuItm("Increasing Difficulty"),getMnuItm("Topic"));
		}else if("help".equalsIgnoreCase(name)) {
			mnu.getItems().addAll(getMnuItm("About"));
		}
		return mnu;
	}


	/***************** MenuItems *****************/
	/**
	 *
	  getMnuItm method. 
	 The method sets a MenuItem.
	 Bonus: add an accelerator key to every menu item.
	 @param name String to be displayed
	 * 
	 */
	

	private static MenuItem getMnuItm(String name) {
		mnuItm = new MenuItem("_"+name);
		if("New Game".equalsIgnoreCase(name)) {
			mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
			mnuItm.setOnAction((ActionEvent e) -> {
				newGameAction(e);
			});
		}else if("Exit".equalsIgnoreCase(name)) {
			mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
			mnuItm.setOnAction((ActionEvent e) -> {
				exitAction(e);
			});
		}else if("Randomize Questions".equals(name)) {
			mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
			mnuItm.setOnAction((ActionEvent e) -> {
				randQuestionAction(e);
			});
		}else if("Increasing Difficulty".equalsIgnoreCase(name)) {
			mnuItm.setOnAction((ActionEvent e) -> {
				increDif(e);
			});
			mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
		}else if("Topic".equalsIgnoreCase(name)) {
			mnuItm.setOnAction((ActionEvent e) -> {
				topicAction(e);
			});
			mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN));
		}else if("About".equals(name)) {
			mnuItm.setOnAction((ActionEvent e) -> {
				aboutAction(e);
			});
			mnuItm.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
		}
		return mnuItm;
	}

	/**
	 *
	 newGameAction method. 
	 The method results in action being performed for event driven.
	 The ActionEvent is newGameAction.
	 @param ActionEvent e
	 * 
	 */
	
	private static void newGameAction(ActionEvent e) {
		Result.resetResult();
		currentQuestion =0;
		File file = FileUtils.getFileHandle(stage);
		if(file==null) {
			return;
		}
		FileUtils.setQAArrayList(file);

		QAPane qaPane= new QAPane(FileUtils.getQAArrayList().get(currentQuestion));
		VBox lBuf = new VBox();
		HBox bBuf= new HBox();
		bBuf.setPrefHeight(100);
		lBuf.setPrefWidth(200);
		TriviaTimeLaunch.getRootPane().setLeft(lBuf);
		TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
		TriviaTimeLaunch.getRootPane().setBottom(bBuf);
	}
	
	/**
	 *
	 exitAction method. 
	 The method results in action being performed for exit.
	 The ActionEvent is exitAction.
	 @param ActionEvent e
	 * 
	 */

	private static void exitAction(ActionEvent e) {
		Platform.exit();
	}
	
	/**
	 *
	 randQuestionAction method. 
	 The method results in action being performed for click on 
	 randQuestion.
	 The ActionEvent is randQuestionAction.
	 @param ActionEvent e
	 * 
	 */

	private static void randQuestionAction(ActionEvent e) {
		if(FileUtils.getQAArrayList()==null) {
			return;
		}
		Result.resetResult();
		currentQuestion =0;
		Collections.shuffle(FileUtils.getQAArrayList());;
		QAPane qaPane= new QAPane(FileUtils.getQAArrayList().get(currentQuestion));
		VBox lBuf = new VBox();
		HBox bBuf= new HBox();
		bBuf.setPrefHeight(100);
		lBuf.setPrefWidth(200);
		TriviaTimeLaunch.getRootPane().setLeft(lBuf);
		TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
		TriviaTimeLaunch.getRootPane().setBottom(bBuf);
	}
	
	/**
	 *
	 increDif method. 
	 The method results in action being performed for click on 
	 increasing difficulty.
	 The ActionEvent is increDif.
	 @param ActionEvent e
	 * 
	 */

	private static void increDif(ActionEvent e) {
		if(FileUtils.getQAArrayList()==null) {
			return;
		}
		Result.resetResult();
		currentQuestion =0;
		Collections.sort(FileUtils.getQAArrayList(), new Comparator<QA>() {
			public int compare(QA qa1,QA qa2){
				if(qa1.getDifficulty() < qa2.getDifficulty())
					return -1;
				else if (qa1.getDifficulty() > qa2.getDifficulty())
					return 1;
				else 
					return 0;// Write your logic here.
			}			
		});
		QAPane qaPane= new QAPane(FileUtils.getQAArrayList().get(currentQuestion));
		VBox lBuf = new VBox();
		HBox bBuf= new HBox();
		bBuf.setPrefHeight(100);
		lBuf.setPrefWidth(200);
		TriviaTimeLaunch.getRootPane().setLeft(lBuf);
		TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
		TriviaTimeLaunch.getRootPane().setBottom(bBuf);
	}
	
	/**
	 *
	 topicAction method. 
	 The method results in action being performed for click on 
	 choosing the topic.
	 The ActionEvent is topicAction.
	 @param ActionEvent e
	 * 
	 */	

	private static void topicAction(ActionEvent e) {
		if(FileUtils.getQAArrayList()==null) {
			return;
		}
		Result.resetResult();
		currentQuestion =0;
		Collections.sort(FileUtils.getQAArrayList(), new Comparator<QA>() {
			public int compare(QA qa1,QA qa2){

				return qa1.getCategory().compareTo(qa2.getCategory());// Write your logic here.
			}			
		});
		QAPane qaPane= new QAPane(FileUtils.getQAArrayList().get(currentQuestion));
		VBox lBuf = new VBox();
		HBox bBuf= new HBox();
		bBuf.setPrefHeight(100);
		lBuf.setPrefWidth(200);
		TriviaTimeLaunch.getRootPane().setLeft(lBuf);
		TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
		TriviaTimeLaunch.getRootPane().setBottom(bBuf);
	}
	
	/**
	 *
	 aboutAction method. 
	 The method will indicates the author, the name of the project and the year.
	 @param ActionEvent e
	 * 
	 */	

	private static void aboutAction(ActionEvent e) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("About Trivia Time");
		alert.setContentText("Author: Guanghua He\nYear: 2018");
		alert.showAndWait();
	}


	private static void setStage(Stage s) {stage= s;}
	@SuppressWarnings("unused")
	private static Stage getStage() {return stage;}

	/**
	 *
	 getNextQuestionPane method. 
	 The method will produce a pane for displaying the 
	 Next Question. And the position of the button.
	 @return nxtQP HBox
	 * 
	 */	
	
	public  static HBox getNextQuestionPane() {
		HBox nxtQP = new HBox();
		nxtQP.setMinHeight(50);

		nxtQP.setAlignment(Pos.CENTER_RIGHT);
		Button nxtQB = new Button("Next Question");
		nxtQB.setDisable(true);
		nxtQB.setOnAction((ActionEvent e) ->{
			nxtQB.setDisable(true);
			if (++currentQuestion<FileUtils.getQAArrayList().size()) {
				QAPane qaPane = new QAPane((FileUtils.getQAArrayList().get(currentQuestion)));
				TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
			}else {
				Result.showResult();
			}
		});
		nxtQP.getChildren().add(nxtQB);
		HBox.setMargin(nxtQB, new Insets(15, 100, 15, 15));

		return nxtQP;

	}


}
