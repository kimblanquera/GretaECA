package Bean;

import javax.swing.JFrame;

public class Answer {

	private boolean confirm;
	private String answer;
	private JFrame fr;
	
	public Answer(){}
	
	public Answer(Boolean c, String ans, JFrame f) {
		
		confirm = c;
		answer = ans;
		fr = f;
		
	}
	
	public boolean getConfirm() {
		return confirm;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public JFrame getFrame() {
		return fr;
	}
	
	public void setFrame(JFrame x) {
		this.fr = x;
	}
	
	public void setConfirm(Boolean x) {
		this.confirm = x;	
	}
	
	public void setAnswer(String x) {
		this.answer = x;
	}

	
	
}
