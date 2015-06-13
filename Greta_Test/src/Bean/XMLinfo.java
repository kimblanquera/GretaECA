package Bean;

public class XMLinfo {

	private String xmlFileName;
	private int typeNum;
	
public XMLinfo(){}
	
	public XMLinfo(String s, int n) {
		
		xmlFileName = s;
		typeNum = n;
		
	}
	
	public String getFileName() {
		return xmlFileName;
	}
	
	public int getCurrType() {
		return typeNum;
	}
	
	public void setFileName(String s) {
		this.xmlFileName = s;
	}
	
	public void setCurrType(int n) {
		this.typeNum = n;
	}
	
}
