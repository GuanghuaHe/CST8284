// File:             [Result.java]
// Author:           [Guanghua He 040909700]
// Course:           [CST8284 OOP] 
// Assignment:       [2]
// Date:             $Apr.16 2018$
// Professor:        [SOUHAIL ABDALA]
// Purpose:          [To store the methods to output the trivia quiz details]        
//

package cst8284.triviatime;

import java.util.AbstractQueue;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 Result class is designed to store the methods 
 to output the trivia quiz details.
 Aim to summarize the results of the quiz by listing each question number 
 and whether it was correct or not, along with the final score.
 @author Guanghua He
 @version 1.00, 16 Apr 2018
 @see java.util.AbstractQueue
 @see java.util.ArrayList
 @see javafx.geometry.Insets
 @see javafx.scene.layout.GridPane
 @see javafx.scene.layout.VBox
 @see javafx.scene.text.Text
 @since version 1.0
 */

@SuppressWarnings("unused")
public class Result {
	private static int total;
	private static int score;
	private static int correctAns;
	public static int getScore() {
		return score;
	}
	public static void setScore(int points) {
		score += points;
		
	}
	public static void resetResult() {
		score = 0;
		total = 0;
		correctAns = 0;
	}

	/**
	 *
	 showResult method
	 The method is used for showing the results. 
	 using result Pane to
	 to display the question with number, answer, difficulty and points u get.
	 Summarize your total correct answers and scores.
	 */

	public static void showResult() {
		
		VBox resultPane = new VBox();
		resultPane.setPadding(new Insets(60, 12, 15, 12));
		resultPane.setSpacing(20);
		resultPane.getChildren().add(new Text("Your result:"));
		
		ArrayList<QA> qaAL = new ArrayList<>();
		qaAL = FileUtils.getQAArrayList();
		
		for(int i=0; i<qaAL.size(); i++ ) {
			
			if (qaAL.get(i).isCorrect()==true) {
				total += qaAL.get(i).getPoints();
				correctAns++;
				resultPane.getChildren().add(new Text("Question " + (i+1) + ": right, difficulty: " +  qaAL.get(i).getDifficulty() +", Topic: " + qaAL.get(i).getCategory() +", " + qaAL.get(i).getPoints() +" points added"));
			} 
			else {
				total += qaAL.get(i).getPoints();
				resultPane.getChildren().add(new Text("Question " + (i+1) + ": wrong, difficulty: "  +  qaAL.get(i).getDifficulty() +", topic: " + qaAL.get(i).getCategory() + ", " + qaAL.get(i).getPoints() +" points lost"));

			}
		}
		resultPane.getChildren().add(new Text("The nubmer of correct answers is " + correctAns +" out of " + qaAL.size() +". Your final score: "
		+ score + " out of " + total + ". Click File > New Game to restart!"));
		TriviaTimeLaunch.getRootPane().setCenter(resultPane);
		
	}	
}
