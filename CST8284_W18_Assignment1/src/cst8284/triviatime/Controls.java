package cst8284.triviatime;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;
import java.util.Arrays;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controls {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Stage stage;
	private static int currentQuestion = 0;
	private static HBox nxtQP=null;


	/***************** MenuBar *****************/


	public static MenuBar getMenuBar(Stage primaryStage) {
		setStage(primaryStage);
		MenuBar mnBar = new MenuBar();
		mnBar.getMenus().addAll(getMnuFile(), getMnuSettings(), getMnuHelp());
		return mnBar;
	}


	/******************* Menu ******************/


	public static Menu getMnuFile() {
		Menu mnu = new Menu("File");
		mnu.getItems().addAll(getMnuItmNewGame(), getMnuItmExit());
		return mnu;
	}


	public static Menu getMnuSettings() {
		Menu mnu = new Menu("Settings");
		mnu.setDisable(true);
		return mnu;
	}

	public static Menu getMnuHelp() {
		Menu mnu = new Menu("Help");
		mnu.getItems().addAll(getMnuItmAbout());
		return mnu;
	}


	/***************** MenuItems *****************/


	private static MenuItem getMnuItmNewGame() {
		mnuItm = new MenuItem("New Game");
		mnuItm.setOnAction((ActionEvent e) -> {
			FileUtils.setQAArray("C:/TriviaTime/ComputerTrivia_Java100.trivia", 7);
			resetGame();
			QAPane qaPane= new QAPane(FileUtils.getQAArray()[currentQuestion]);
			TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
			TriviaTimeLaunch.getRootPane().setBottom(Controls.getNextQuestionPane());
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmExit() {
		mnuItm = new MenuItem("Exit");
		mnuItm.setOnAction((ActionEvent e) -> {
			Platform.exit();
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		mnuItm = new MenuItem("About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText("Author: Guanghua He\nYear: 2018");
			alert.showAndWait();
		});
		return mnuItm;
	}

	private static void resetGame() {
		currentQuestion = 0;
		nxtQP=null;
	}

	private static void setStage(Stage s) {stage= s;}
	private static Stage getStage() {return stage;}

	public static HBox getNextQuestionPane() {
		if(nxtQP==null) {
			nxtQP = new HBox();
			nxtQP.setAlignment(Pos.CENTER_RIGHT);
			Button nxtQB = new Button("Next Question");
			nxtQP.setPadding(new Insets(0, 50, 100, 0));
			nxtQB.setDisable(true);

			nxtQB.setOnAction((ActionEvent e) ->{
				if (currentQuestion<FileUtils.getQAArray().length-1) {
					currentQuestion++;
					QAPane qaPane = new QAPane((FileUtils.getQAArray()[currentQuestion]));
					TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
					nxtQB.setDisable(true);	
					if(currentQuestion == FileUtils.getQAArray().length-1) {
						nxtQB.setText("Check Results");
						nxtQP.setPadding(new Insets(10, 200, 50, 0));
						nxtQB.setDisable(true);
					}
				} else {
					nxtQB.setVisible(false);
					String finalStr=String.format("%6s\t\t%s\n", "Question ID", "Results");
					int totalScore = 0;
					for (int i=0; i<FileUtils.getQAArray().length;i++) {
						QA results = FileUtils.getQAArray()[i];
						String str = String.format("%8d\t\t\t%s\n", i+1, results.isCorrect());
						if (results.isCorrect()== true) {
							totalScore++;
						}
						finalStr = finalStr.concat(str);
					}
					
					String total_mark = String.format("Your final score is: %d out of %d\n", totalScore, FileUtils.getQAArray().length);
					finalStr = finalStr.concat(total_mark);

					Text msg = new Text(finalStr);
					msg.setFont(Font.font ("Gafata", 30));
					msg.setFill(Color.BLACK);
					HBox hboxresult=new HBox();
					hboxresult.setAlignment(Pos.CENTER);
					hboxresult.setPadding(new Insets(30, 30, 30, 30));
					hboxresult.getChildren().addAll(msg);
					TriviaTimeLaunch.getRootPane().setCenter(hboxresult);
				}
			});
			nxtQP.getChildren().add(nxtQB);
			HBox.setMargin(nxtQB, new Insets(20));
		} 
		return nxtQP;
	}

	public static int getCurrentQuestion() {
		return currentQuestion;
	}
}
