package Bean;

import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class Answer {

	private boolean confirm;
	private int answer;
	private JFrame fr;
	
	public Answer(){}
	
	public Answer(Boolean c, int ans, JFrame f) {
		
		confirm = c;
		answer = ans;
		fr = f;
		
	}
	
	public boolean getConfirm() {
		return confirm;
	}
	
	public int getAnswer() {
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
	
	public void setAnswer(int x) {
		this.answer = x;
	}

	
	
}
