package folderCleaner.organize;

import java.io.File;

public class DirectoryMapper {

	public KeyValue map(File file) {				
		return new KeyValue("directory", file);
	}
}
