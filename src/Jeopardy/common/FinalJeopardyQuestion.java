package Jeopardy.common;

public class FinalJeopardyQuestion extends Question {

	private String category;
	
	public FinalJeopardyQuestion(String categoryIn, String answerIn, String questionIn) {
		
		
		super(answerIn, questionIn, 0);
		category = categoryIn;
		
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

}
