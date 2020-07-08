package folderCleaner.organize;

import java.io.File;

public class FileTypeMapper {

	public KeyValue map(File file) {
		
		String[] split_name = file.getName().split("\\.");
		
		String key = split_name.length > 1 && !split_name[1].contains("\\d+") ? 
				split_name[split_name.length - 1] : "notype";
				
		return new KeyValue(key, file);
	}
}
