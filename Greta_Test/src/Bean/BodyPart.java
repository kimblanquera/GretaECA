package Bean;

public class BodyPart {

	private String part;
	private boolean used;
	private String xmlFile;

	public BodyPart(){}

	public BodyPart(String p, boolean u, String f) {

		part = p;
		used = u;
		xmlFile = f;

	}

	public String getPart() {

		return part;

	}

	public boolean getUsed() {

		return used;

	}

	public String getXMLFile() {

		return xmlFile;

	}

	public void setPart(String p) {

		this.part = p;

	}

	public void setUsed(boolean u) {

		this.used = u;

	}

	public void setXMLFile(String f) {

		this.xmlFile = f;

	}


}
