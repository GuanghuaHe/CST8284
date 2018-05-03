// File:             [QA.java]
// Author:           [Guanghua He 040909700]
// Course:           [CST8284 OOP] 
// Assignment:       [2]
// Date:             $Apr.16 2018$
// Professor:        [SOUHAIL ABDALA]
// Purpose:          [overriding all of QARequirements abstract methods.]        
//


package cst8284.triviatime;
import java.util.Arrays;


/**
 * QA class QA, which extends QARequirements. 
 * used for overriding all of QARequirements abstract methods.
 * The QA object’s signature is fairly precise in the UML.
 * The private variables in QA constructor 
 * match the variable names indicated in the UML.
 * @author Guanghua He
 * @version 1.00, 16 Apr 2018
 * @see java.util.Arrays
 * @since version 1.0
 */

@SuppressWarnings({ "unused", "serial" })
public class QA extends QARequirements {
	
	private  String question;
	private  String[] answers;
	private  String category;
	private  String explanation;
	private  int difficulty;
	private  int points;
	private  int correctAnswer;
	private boolean result;
		
	public QA(
			String question,
			String[] answers,
			String category,
			String explanation,
			int difficulty,
			int points,
			int correctAnswer
			) {
		setQuestion(question);
		setAnswers(answers);
		setExplanation(explanation);
		setCategory(category);
		setDifficulty(difficulty);
		setPoints(points);
		setCorrectAnswerNumber(correctAnswer);	
	}

	
	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void setQuestion(String question) {
		this.question = question; 
	}

	@Override
	public String[] getAnswers() {
		return answers;
	}

	@Override
	public void setAnswers(String[] answ) {
		this.answers=answ;
	}

	@Override
	public String getExplanation() {
		return explanation;
	}

	@Override
	public void setExplanation(String expl) {
		this.explanation=expl;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String categ) {
		this.category=categ;

	}

	@Override
	public int getDifficulty() {
		return difficulty;
	}

	@Override
	public void setDifficulty(int diff) {
		this.difficulty=diff;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int poi) {

		this.points=poi;
	}

	@Override
	public int getCorrectAnswerNumber() {
		return correctAnswer;
	}

	@Override
	public void setCorrectAnswerNumber(int correctA) {
		this.correctAnswer=correctA;
	}

	@Override
	public boolean isCorrect() {
		return result;
		
	}

	@Override
	public void setResult(boolean b) {
		
		result=b;
	}
	
}

