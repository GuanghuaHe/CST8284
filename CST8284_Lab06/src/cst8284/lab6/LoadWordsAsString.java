package cst8284.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.text.Text;

public class LoadWordsAsString extends LoadWords {

	
	@Override
	public Text getFileContents(File f) {
		// TODO Auto-generated method stub
		String str = "";
		
		Counters.resetCtr();
		try {
			
		Scanner inputTxt =	new Scanner(f);
		while(inputTxt.hasNext()) {
			str +=inputTxt.next();
			str +="\n";
			Counters.getNextCtr();
			
		}
		
		return new Text(str);
			
		}catch(FileNotFoundException e) {
			return null;
		}
		
	}

}
