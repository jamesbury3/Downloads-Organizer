package folderCleaner.organize;

import java.io.File;

public class KeyValue {

	private String key;
	private File value;
	
	public KeyValue(String key, File value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public File getValue() {
		return value;
	}
}
