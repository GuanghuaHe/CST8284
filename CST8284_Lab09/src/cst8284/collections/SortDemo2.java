package cst8284.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SortDemo2 extends Application implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String wordFileName="ShortWordList.txt";
	//private static String wordFileName="LongWordList.txt";

	// Note: Only of use if you are attempting Bonus B:
	private static final char[] scrabbleValues = {
			1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10
	};  // value of each letter in the game Scrabble, i.e. 'a'=1, 'b'=3, etc.

	@SuppressWarnings("unused")
	private static final Stage primaryStage = null;


	public static String getFileName() {
		return wordFileName;
	}

	public void setFileName(String f) {
		SortDemo2.wordFileName = f;
	}

	@SuppressWarnings("resource")
	public static String getStringFromFile() {
		String strList = "";

		try {
			File f = new File(getFileName());

			Scanner data = new Scanner(f);

			if (f.exists()) {
				while(data.hasNext()) {
					if (strList!="")	{
						strList = strList +  "\n  " + data.next();
					} else {
						strList = "  "+data.next();
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strList;
	}

	@SuppressWarnings("resource")
	public static StringBuilder getStringBuilderFromFile() {
		StringBuilder strList = new StringBuilder();

		try {
			File f = new File(getFileName());
			Scanner data = new Scanner(f);

			if (f.exists()) {
				while(data.hasNext()) {
					strList.append(data.next());
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strList;
	}
	@SuppressWarnings("resource")
	public static ArrayList<String> getArrayListFromFile() {
		ArrayList<String> strList = new ArrayList<String>();

		try {
			File f = new File(getFileName());
			Scanner data = new Scanner(f);

			if (f.exists()) {
				while(data.hasNext()) {
					strList.add(data.next());
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strList;
	}

	@Override
	public void start(Stage primaryStage) {

		setFileName(wordFileName);

		ListView<String> list = new ListView<String>();
		ObservableList<String> objItem = FXCollections.observableList(getArrayListFromFile());

		list.setItems(objItem);

		Text text = new Text();

		BorderPane pane = new BorderPane();

		ScrollPane sp = new ScrollPane();

		VBox vbox = new VBox(10);

		Button seqBtn = new Button("Alphabetical Order");
		Button lenBtn = new Button("     Word Length    ");
		Button descBtn = new Button("   Reverse Order    ");
		Button scrabbleBtn = new Button("   Scrabble Order    ");

		vbox.getChildren().addAll(seqBtn,lenBtn, descBtn, scrabbleBtn);

		seqBtn.setOnMouseClicked(e -> 
		FXCollections.sort((ObservableList<String>) objItem)
				);

		/*	
	    lenBtn.setOnMouseClicked(e->{objItem.sort(( o1, o2) -> o1.length()-o2.length());});
		*/
		lenBtn.setOnMouseClicked(e -> 
		FXCollections.sort((ObservableList<String>) objItem, Comparator.comparingInt(String::length))
				);

		descBtn.setOnMouseClicked(e -> 
		FXCollections.reverse((ObservableList<String>) objItem)
				);

		scrabbleBtn.setOnMouseClicked(e->{objItem.sort((o1,o2)->scrabValue(o1)-scrabValue(o2));});


		sp.setContent(text);
		sp.setPrefSize(200, 480);
		pane.setLeft(list);	
		pane.setRight(vbox);
		Scene scene = new Scene(pane, 640, 480);

		primaryStage.setTitle("Welcome to WordSort");
		primaryStage.setScene(scene);
		primaryStage.show();

	}


	public static int scrabValue(String s){
		int wordValue =0;
		// cut off leading and trailing white-space;
		// eliminate  non-alphabetic and non-printable characters'
		String pureString = s.trim().replaceAll("[^\\w\\.@-]", "");
		//loop to sum up the total value of a word by assigning Scrabble value correspondingly
		for(char c : pureString.toCharArray()) wordValue +=scrabbleValues[c-97];
		return wordValue;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
