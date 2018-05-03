// File:             [QAPane.java]
// Author:           [Guanghua He 040909700]
// Course:           [CST8284] 
// Assignment:       [2]
// Date:             $Apr.16 2018$
// Professor:        [SOUHAIL ABDALA]
// Purpose:          [Part of the Controls are handled in the QAPane. 
//                    Each QAPane object is instantiated with a QA object.]
//

package cst8284.triviatime;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 TriviaTimeLaunch class handles each displayed question, set of answers, 
 ‘That’s my choice’ button, along with the explanation 
 for why the answer chosen was right of wrong.
 @author Guanghua He
 @version 1.00, 16 Apr 2018
 @see javafx.event.ActionEvent
 @see javafx.event.EventHandler
 @see javafx.geometry.Insets
 @see javafx.geometry.Pos
 @see javafx.scene.control.Button
 @see javafx.scene.control.Label
 @see javafx.scene.control.RadioButton
 @see javafx.scene.control.TextArea
 @see javafx.scene.control.ToggleGroup
 @see javafx.scene.layout.GridPane
 @see javafx.scene.layout.HBox
 @see javafx.scene.layout.VBox
 @see javafx.scene.text.Text
 @since version 1.0
 */

@SuppressWarnings("unused")
public class QAPane {
	private RadioButton[] rbAr;
	private VBox qaPane;


	/**
	 *
	 QAPane method.
	 The method displays a welcome message 
	 @param qa object
	 */
	
	public QAPane(QA qa) {
		qaPane= new VBox();
		qaPane.setPadding(new Insets(60, 12, 15, 12));
		qaPane.setSpacing(30);
		HBox checkAnswer = new HBox();

		checkAnswer.setPadding(new Insets(15, 12, 15, 12));

		checkAnswer.setSpacing(10);
		Button myAnswer = new Button("That's my answer");
		TextArea expTxt = new TextArea();
		expTxt.setWrapText(true);		
		qaPane.getChildren().addAll(new Text(qa.getQuestion()), getAnswerPane(qa.getAnswers()), checkAnswer, Controls.getNextQuestionPane());
		myAnswer.setOnAction((ActionEvent e) ->{
			expTxt.setVisible(true);
			String explanation;

			if(getRadioButtonSelected()==0) {
				explanation = "Please select an option";
			}

			else if (qa.getCorrectAnswerNumber()==getRadioButtonSelected()-1) {
				explanation = "Right! " + qa.getExplanation();
				qa.setResult(true);
				Result.setScore(qa.getPoints());
				((HBox)qaPane.getChildren().get(3)).getChildren().get(0).setDisable(false);

				myAnswer.setDisable(true);
			}
			else {
				explanation = "Wrong! " + qa.getExplanation();
				qa.setResult(false);

				((HBox)qaPane.getChildren().get(3)).getChildren().get(0).setDisable(false);
				myAnswer.setDisable(true);
			}
			expTxt.setText(explanation);

		});
		expTxt.setPrefColumnCount(20);
		expTxt.setPrefRowCount(6);
		expTxt.setVisible(false);

		checkAnswer.getChildren().addAll(expTxt, myAnswer);

	}


	public VBox getAnswerPane(String[] ansStrAr) {


		VBox ansPane = new VBox();
		ToggleGroup ansGroup = new ToggleGroup();
		rbAr = new RadioButton[ansStrAr.length];
		for(int i=0; i<ansStrAr.length; i++) {
			rbAr[i]= new RadioButton(ansStrAr[i]);
			rbAr[i].setToggleGroup(ansGroup);
			ansPane.getChildren().add(rbAr[i]);

		}

		return ansPane;
	}


	public int getRadioButtonSelected() {


		while (true) {
			int i=0;
			while(i<rbAr.length) {
				if(rbAr[i].isSelected()==true) {

					return i+1;
				}
				i++;
			}


			return 0;
		}

	}

	public void setQAPane(VBox vb) {this.qaPane = vb;}
	public VBox getQAPane() {return qaPane;}
}
