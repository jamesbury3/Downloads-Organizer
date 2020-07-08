package folderCleaner.organize;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class FileReducer {
	
	private static HashMap<String, ArrayList<File>> result = new HashMap<String, ArrayList<File>>();

	public static void reduce(KeyValue file) {
		if (!result.containsKey(file.getKey())) {
			ArrayList<File> new_file_list = new ArrayList<File>();
			result.put(file.getKey(), new_file_list);
		}
		result.get(file.getKey()).add(file.getValue());
	}
	
	public static HashMap<String, ArrayList<File>> getResult() {
		return result;
	}
}
