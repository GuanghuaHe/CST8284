package cst8284.lab6;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class LoadFileDemo extends Application {
	
	private Stage stage;
        
	@Override
	public void start(Stage pStage) {	
		setStage(pStage);
		
		BorderPane rootPane = new BorderPane();
		/* TODO: Uncomment the following code once the code for the 
		 * getWordListPane() method has been completed, as described below
		 */
		rootPane.setLeft(getWordListPane("StringBuilder", new LoadWordsAsStringBuilder()));
		rootPane.setRight(getWordListPane("String", new LoadWordsAsString()));
	
		
		
		
		getStage().setScene(new Scene(rootPane));
		getStage().setTitle("Welcome to WordDump, a Scrollable List of Almost 80,000 Words");
		getStage().show();	
	}
	
	
	private VBox getWordListPane(String btnLabel, LoadWords textString) {
		
		/* TODO: instantiate a new ScrollPane object called spWords with 
		 * a preferred size of 280 by 320 pixels.  Set its horizontal and 
		 * vertical scrollbars appropriately using the ScrollBarPolicy values
		 * as described in Module 05 course notes
		 */
		
		ScrollPane spWords = new ScrollPane();
		spWords.setPrefSize(280, 320);
		spWords.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		spWords.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		/* TODO: instantiate a new TextArea object called txtAreaFileInfo
		 * with a preferred row count of 8 and a preferred Width of 280 pixels
		 */
		
		TextArea txtAreaFileInfo = new TextArea();
		txtAreaFileInfo.setPrefRowCount(8);
		txtAreaFileInfo.setPrefWidth(280); //?
		
	     

		/* TODO: instantiate a new Button object called btnLoadWords, captioned
		 * as indicated in figure 1 of the Lab 6 document, using the btnLabel 
		 * String passed as an argument to this method.  Set the minimum width 
		 * of the button equal to the preferred width of spWords.  Use the 
		 * following code, exactly as written, to capture mouse clicks on this 
		 * button:
		 */
		
		Button btnLoadWords = new Button("Load Wordlist Using " + btnLabel); 
		btnLoadWords.setMinWidth(spWords.getPrefWidth());
		
		 
		btnLoadWords.setOnAction(e -> {
			// load a word list from the file selected and display file diagnostics
			double loadTime = getLoadTime(textString, spWords);
			String diagnostics = FileInfos.getFileInfo(FileInfos.getFileHandle(), loadTime); 
			txtAreaFileInfo.clear();  // clear textarea of previous information
			txtAreaFileInfo.setText(diagnostics);
		});
		
		
		/* TODO: instantiate a new VBox object called vbxWordList.  Add the 
		 * 3 objects instantiated above, i.e. spWords, btnLoadWords, and 
		 * txtAreaFileInfo, to vbxWordList using its getChildren() method,
		 * again following the instructions in Module 05 course notes.  Finally,
		 * return vbxWordList.
		 */
		VBox vbxWordList = new VBox();
		vbxWordList.getChildren().addAll(spWords, btnLoadWords, txtAreaFileInfo);
		return vbxWordList;
	}
	
	
	
	private double getLoadTime(LoadWords inputString, ScrollPane outputNode) {
		//clear the ScrollPane of any text currently loaded
		outputNode.setContent(null);
		
		// get a handle to the file containing the word list
		File f = FileInfos.getFileHandle(getStage());
		
		// get the current time, load the word list, and return the elapsed time
		if (FileInfos.isFileReadable(f)) {
			long startTime = System.currentTimeMillis();
			outputNode.setContent(inputString.getFileContents(f)); 
			return (System.currentTimeMillis()-startTime)/1000.0;
		}
		return(-1);	
	}

	private void setStage(Stage s) {stage = s;}
	public Stage getStage() {return stage;}
	
	public static void main(String[] args) {
		Application.launch(args);
	}		
}