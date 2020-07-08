package folderCleaner.organize;

import java.io.File;

public class MapperFactory {
	
	private static final FileTypeMapper file_mapper = new FileTypeMapper();
	private static final DirectoryMapper directory_mapper = new DirectoryMapper();

	public static KeyValue map(File file) {
		if (file.isDirectory()) {
			return directory_mapper.map(file);
		} else {
			return file_mapper.map(file);
		}
	}
}
