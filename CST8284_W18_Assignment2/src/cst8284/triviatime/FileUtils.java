// File:              FileUtils.java
// Author:            Guanghua He 040909700
// Course:            CST8284 
// Assignment:        2
// Date:             $Apr.16 2018$
// Professor:         SOUHAIL ABDALA
// Purpose:           FileUtils contains static methods for loading an array of QA objects 
//                    from the designated file.
//

package cst8284.triviatime;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


/**
FileUtils contains static methods for loading an array of QA objects
from the designated file. Once called setQAArray(), call getQAArray() 
and return this to an array of QA objects. 
 @author Guanghua He
 @version 1.00, 16 Apr 2018
 @see java.io.EOFException
 @see java.io.File
 @see java.io.FileInputStream
 @see java.io.IOException
 @see java.io.ObjectInputStream
 @see java.util.ArrayList
 @see javafx.stage.FileChooser
 @see javafx.stage.FileChooser.ExtensionFilter
 @see javafx.stage.Stage
 @since version 1.0
*/

public class FileUtils {
	
	
    /*
     * Replace the QA array with an ArrayList of QA objects
     */
	private static ArrayList<QA> qaAL;
	private static File fileHandle;
	
	public static void setFileHandle(File f){
		fileHandle = f;
	}
	

	
	public static File getFileHandle(Stage stage) {
		// Based on source code from: 
		// Redko, Alla.  Using JavaFX UI Control: 26 File Chooser.
		// https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("c:\\TriviaTime"));
		fileChooser.setTitle("Open Trivia File");
		fileChooser.getExtensionFilters().addAll(
		     new ExtensionFilter("Trivia Files", "*.trivia"),
		     new ExtensionFilter("All Files", "*.*"));
		File f = fileChooser.showOpenDialog(stage);
		setFileHandle(f);
		return f;		
	}
	
	public static File getFileHandle() {
		return fileHandle;
	}
		
	/**
	 *
	 setQAArrayList method.
     Next rename setQAArray() to setQAArrayList(), 
     and change all references in code from the former to the latter method.
     To read in QA files of any size, alter the try…catch block.
     Load the QA objects from the trivia file into the array list (inside the while loop)	 
     @param f File to be set
	 */
	
	public static void setQAArrayList(File f) {
		qaAL = new ArrayList<QA> ();
		if (f!=null&&fileExists(f)) {
			FileInputStream fis=null;
			ObjectInputStream ois=null;
			try {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				while (true) {
					qaAL.add((QA) (ois.readObject()));
				}
					
			} catch (EOFException e) {}
			 catch
			(IOException | ClassNotFoundException e) {} 
			finally {
				if(ois!=null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else 
			qaAL = null;
	}
	
	public static ArrayList<QA> getQAArrayList() {return qaAL;}

	public static boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead() && (f.length() > 2));
	}

	public static boolean fileExists(String s) {
		return (fileExists(new File(s)));
	}
	
	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

}
