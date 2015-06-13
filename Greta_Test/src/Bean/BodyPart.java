package Bean;

public class BodyPart {

	private String part;
	private boolean used;
	
	public BodyPart(){}
	
	public BodyPart(String p, boolean u) {
		
		part = p;
		used = u;
		
	}
	
	public String getPart() {
		
		return part;
		
	}
	
	public boolean getUsed() {
		
		return used;
		
	}
	
	public void setPart(String p) {
		
		this.part = p;
		
	}
	
	public void setUsed(boolean u) {
		
		this.used = u;
		
	}
	
	
}
