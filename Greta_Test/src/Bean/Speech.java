package Bean;

public class Speech {

	private int ID;
	private int step;
	private int textTypeID;
	private int intentTypeID;
	private String filText;
	private String engText;
	private String filYes;
	private String filNo;
	private String engYes;
	private String engNo;
	private int yesNext;
	private int noNext;
	private boolean confirmed;
	private int answer;
	
	public Speech(){}
	
	public Speech(int Id, int Step, int TextTypeID, int IntentTypeID, String FilText, String EngText, String FilYes, String FilNo, String EngYes, String EngNo, int YesNext, int NoNext, boolean conf, int ans) {
		
		ID = Id;
		step = Step;
		textTypeID = TextTypeID;
		intentTypeID = IntentTypeID;
		filText = FilText;
		engText = EngText;
		filYes = FilYes;
		filNo = FilNo;
		engYes = EngYes;
		engNo = EngNo;
		yesNext = YesNext;
		noNext = NoNext;
		confirmed = conf;
		answer = ans;
		
	}
	
	public int getID() {
		return ID;
	}
	
	public int getStep() {
		return step;
	}
	
	public int getTextTypeID() {
		return textTypeID;
	}
	
	public int getIntentTypeID() {
		return intentTypeID;
	}
	
	public String getFilText() {
		return filText;
	}
	
	public String getEngText() {
		return engText;
	}
	
	public String getFilYes() {
		return filYes;
	}
	
	public String getFilNo() {
		return filNo;
	}
	
	public String getEngYes() {
		return engYes;
	}
	
	public String getEngNo() {
		return engNo;
	}
	
	public int getYesNext() {
		return yesNext;
	}
	
	public int getNoNext() {
		return noNext;
	}
	
	public boolean getConfirm() {
		return confirmed;
	}
	
	public void setID(int x) {
		this.ID = x;
	}
	
	public void setStep(int x) {
		this.step = x;
	}
	
	public void setTextTypeiD(int x) {
		this.textTypeID = x;
	}
	
	public void setIntentTypeID(int x) {
		this.intentTypeID = x;
	}
	
	public void setFilText(String x) {
		this.filText = x;
	}
	
	public void setEngText(String x) {
		this.engText = x;
	}
	
	public void setFilYes(String x) {
		this.filYes = x;
	}
	
	public void setFilNo(String x) {
		this.filNo = x;
	}
	
	public void setEngYes(String x) {
		this.engYes = x;
	}
	
	public void setEngNo(String x) {
		this.engNo = x;
	}
	
	public void setYesNext(int x) {
		this.yesNext = x;
	}
	
	public void setNoNext(int x) {
		this.noNext = x;
	}
	
	public void setConfirm(boolean x) {
		this.confirmed = x;
	}
	
	
}
