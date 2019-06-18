package Jeopardy.common;

public class Question {
	
	private String answer;
	private String question;
	private int value;
	
	
	public Question (String answerIn, String questionIn, int valueIn)
	{
		answer = answerIn;
		question = questionIn;
		value = valueIn;
	}
	
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	public String toString(){
		
		String s = "";
		s += answer + "\t";
		s += question + "\t";
		s += value;
		return s;
		
		
	}
	

}
