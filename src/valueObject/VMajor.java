package valueObject;

import java.io.Serializable;

public class VMajor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	private String fileName;
	
	public VMajor() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
