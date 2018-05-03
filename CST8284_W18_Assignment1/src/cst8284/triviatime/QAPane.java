package cst8284.triviatime;

import java.util.function.Consumer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QAPane {
	private RadioButton[] rbAr;
	private VBox qaPane;
	private ToggleGroup group;

	public QAPane(QA qa) {
		qaPane=new VBox();
		group = new ToggleGroup();
		qaPane.getChildren().add(new Text(qa.getQuestion()));
		qaPane.setPadding(new Insets(70, 100, 10, 180));
		rbAr=new RadioButton[qa.getAnswers().length];
		getAnswerPane(qa.getAnswers());

		VBox checkAnswer = new VBox();
		HBox myAnswerBox=new HBox();
		myAnswerBox.setAlignment(Pos.CENTER_RIGHT);
		myAnswerBox.setPadding(new Insets(10, 250, 50, 50));
		Button myAnswer = new Button("That's my answer");
		myAnswer.setDisable(true);
		myAnswerBox.getChildren().add(myAnswer);
		Text expTxt = new Text();

		myAnswer.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				expTxt.setVisible(true);
				myAnswer.setDisable(true);
				String explanation=null;
				if(qa.getCorrectAnswerNumber()==getRadioButtonSelected()){
					qa.setResult(true);
					explanation = "Correct! " + qa.getExplanation();
				}else {
					qa.setResult(false);
					explanation = "Incorrect! " + qa.getExplanation();
				}

				expTxt.setText(explanation);
				Controls.getNextQuestionPane().getChildren().get(0).setDisable(false);

				group.getToggles().forEach(new Consumer<Toggle>() {
					@Override
					public void accept(Toggle t) {
						RadioButton radio=(RadioButton) t;
						radio.setDisable(true);
					}
				});
			}
		});

		group.selectedToggleProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				if(group.getSelectedToggle()!=null) {
					myAnswer.setDisable(false);
				}
			}
		});

		checkAnswer.getChildren().addAll(expTxt, myAnswerBox);
		expTxt.setVisible(false);
		qaPane.getChildren().add(checkAnswer);
	}

	public VBox getAnswerPane(String[] ansStrAr) {
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 50, 50, 0));
		gridPane.setVgap(10);
		gridPane.setHgap(20);
		Text[] ansrTxt = new Text[ansStrAr.length];
		
		for(int i=0; i<ansStrAr.length; i++) {
			rbAr[i]= new RadioButton();
			rbAr[i].setToggleGroup(group);
			ansrTxt[i] = new Text(ansStrAr[i]);
			gridPane.add(rbAr[i], 0, i);
			gridPane.add(ansrTxt[i],1,i);
		}

		qaPane.getChildren().add(gridPane);
		return qaPane;
	}

	public int getRadioButtonSelected() {
		int i=0;
		while(i<rbAr.length) {
			if(rbAr[i].isSelected()==true)
				return i+1;
			i++;
		}
		return 0;
	}

	private void setQAPane(VBox vb) {this.qaPane = vb;}
	public VBox getQAPane() {return qaPane;}
}
