package cst8284.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.text.Text;

public class LoadWordsAsStringBuilder extends LoadWords {

	@Override
	public Text getFileContents(File f) {
		// TODO Auto-generated method stub
		StringBuilder strBuilder = new StringBuilder();
		Counters.resetCtr();
		
		try {
			
		Scanner inputTxt =	new Scanner(f);
		while(inputTxt.hasNext()) {
			strBuilder.append(inputTxt.next());
			strBuilder.append("\n");
			Counters.getNextCtr();
		}
		
		return new Text(strBuilder.toString());
			
		}catch(FileNotFoundException e) {
			return null;
		}
		
	}

}
