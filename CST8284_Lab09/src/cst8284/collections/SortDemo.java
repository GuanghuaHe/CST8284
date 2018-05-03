package cst8284.collections;

import javafx.application.Application;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SortDemo extends Application {

	private static Stage pStage;

	// Note: Only of use if you are attempting Bonus B:
	private static final char[] scrabbleValues = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4,
			8, 4, 10 }; // value of each letter in the game Scrabble, i.e.
						// 'a'=1, 'b'=3, etc.

	@Override
	public void start(Stage primaryStage) {

		pStage = primaryStage;
		ObservableList<String> obsList = FXCollections.observableList(getFileContents());
		ListView<String> outputList = new ListView<String>(obsList);
		outputList.setPrefWidth(200);

		BorderPane scenePane = new BorderPane();
		scenePane.setLeft(outputList);

		// TODO: sort the observableList using Collections.sort()
		Button btnAlpha = new Button("Alphabetical Order");
		Button btnWordLength = new Button("     Word Length    ");
		Button btnScrabble = new Button("   Scrabble Order    ");
		Button btnReverse = new Button("   Reverse Order    ");
		
		btnAlpha.setOnMouseClicked(e -> 
		FXCollections.sort((ObservableList<String>) obsList)
				);
		
		btnWordLength.setOnMouseClicked(e -> 
		FXCollections.sort((ObservableList<String>) obsList, Comparator.comparingInt(String::length))
				);
		
		btnReverse.setOnMouseClicked(e -> 
		FXCollections.reverse((ObservableList<String>) obsList)
				);
		
		btnScrabble.setOnMouseClicked(e->{obsList.sort((o1,o2)->scrabValue(o1)-scrabValue(o2));});

		VBox vb = new VBox();
		vb.getChildren().addAll(btnAlpha, btnWordLength, btnReverse, btnScrabble);
		scenePane.setRight(vb);

		Scene scene = new Scene(scenePane, 640, 480);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome to WordSort");
		primaryStage.show();

	}
	/*************CALCULATOR FOR SCRABBLE WORDS****************/
	//add a method to calculate Scrabble value of each word by passing into a String as single @param
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
		Application.launch(args);
	}

	// TODO: Add the getFileContents() method, which uses a file chooser
	// to select a wordlist file from the hard drive (either ShortWordList.txt
	// or LongWordList.txt) and returns an ArrayList of type String
	private ArrayList<String> getFileContents() {
		ArrayList<String> wordsAL = new ArrayList<>();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Word File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("WordList Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		File f = fileChooser.showOpenDialog(getStage());

		try {
			final Scanner sc = new Scanner(f);

			while (sc.hasNext()) {
				wordsAL.add(sc.nextLine());

			}
			sc.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wordsAL;
	}

	// Add any additional methods/classes that are required to implement your
	// code
	public Stage getStage() {
		return pStage;
	}

	public void setStage(Stage stage) {
		pStage = stage;
	}
}
