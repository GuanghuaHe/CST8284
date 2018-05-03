// File:             [QARequirements.java]
// Author:           [Guanghua He 040909700]
// Course:           [CST8284 OOP] 
// Assignment:       [2]
// Date:             $Apr.16 2018$
// Professor:        [SOUHAIL ABDALA]
// Purpose:          [QARequirements is an abstract class that contains
//                    numerous abstract setters and getters 
//                    related to the QA objects that store the features.]        
//
package cst8284.triviatime;

import java.io.Serializable;


/**
 QARequirements class contains abstract setters and getters.
 related to the QA objects that store the features.
 @author Guanghua He
 @version 1.00, 16 Apr 2018
 @see java.io.Serializable
 @since version 1.0
 */


public abstract class QARequirements implements Serializable {
	
	public static final long serialVersionUID = 1L;
	

	/**
	 *
	 getQuestion method
	 The method gets a String for Question. 
	 @return String
	 */
	
	public abstract String getQuestion();
	
	/**
	 *
	 setQuestion method
	 The method sets a Question. 
	 @param question  String to be set
	 */
	
	public abstract void setQuestion(String question);
	
	/**
	 *
	 getAnswers method
	 The method gets a String array for Answer. 
	 @return String[]
	 */
	
	public abstract String[] getAnswers();
	
	/**
	 *
	 setAnswers method
	 The method sets Answers. 
	 @param answers  String array to be set
	 */
	
	public abstract void setAnswers(String[] answers);
	
	/**
	 *
	 getExplanation method
	 The method gets a String for Explanation. 
	 @return String
	 */
	
	public abstract String getExplanation();
	
	/**
	 *
	 setExplanation method
	 The method sets Explanation. 
	 @param question  String to be set
	 */
	
	public abstract void setExplanation(String question);
	
	/**
	 *
	 getCategory method
	 The method gets a String for Category. 
	 @return String
	 */
	
	public abstract String getCategory();
	
	/**
	 *
	 setCategory method
	 The method sets Category. 
	 @param category  String to be set
	 */
		
	public abstract void setCategory(String category);
	
	/**
	 *
	 getDifficulty method
	 The method gets a INT for Difficulty. 
	 @return int
	 */
	
	
	public abstract int getDifficulty();
	
	/**
	 *
	 setDifficulty method
	 The method sets Difficulty. 
	 @param difficulty INT to be set
	 */
	
	public abstract void setDifficulty(int difficulty);
	
	/**
	 *
	 getPoints method
     The method gets a INT for Points. 
     @return INT
	 */
	
	public abstract int getPoints();
	
	/**
	 *
	 setPoints method
     The method sets Points. 
	 @param points INT to be set
	 */
	
	public abstract void setPoints(int points);
	
	/**
	 *
	 getCorrectAnswerNumber method
	 The method gets a INT for CorrectAnswerNumber. 
	 @return INT
	 */
	
	public abstract int getCorrectAnswerNumber();
	
	/**
	 *
	 setCorrectAnswerNumber method
	 The method sets CorrectAnswerNumber. 
	 @param correctAnswer INT to be set
	 */
	
	public abstract void setCorrectAnswerNumber(int correctAnswer);	
	
	/**
	 *
	 isCorrect method
	 The method indicates a boolean for your choice. 
	 @return boolean
	 */
	
	public abstract boolean isCorrect();
	
	/**
	 *
	 setResult method
	 The method sets Result. 
	 @param b boolean to be set
	 */
	
	public abstract void setResult(boolean b);

}
