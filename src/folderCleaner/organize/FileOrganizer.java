package folderCleaner.organize;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import folderCleaner.Config;

public class FileOrganizer {

	final File dir = new File(Config.DIRECTORY);
	private Optional<File> directory;
	private HashMap<String, ArrayList<File>> reduced;
	
	public FileOrganizer() {
		directory = Optional.of(dir);
		reduced = new HashMap<String, ArrayList<File>>();
	}
	
	public HashMap<String, ArrayList<File>> getFiles() {
		
		for (File fileEntry : directory.get().listFiles()) {
			FileReducer.reduce(MapperFactory.map(fileEntry));
	    }
		
		reduced = FileReducer.getResult();
		return reduced;
	}
	
	public String toString() {
		return reduced.keySet().stream().map(item -> {
			return item + "\n\t" + reduced.get(item).stream().map(file -> { 
				return file.getName(); 
			}).collect(Collectors.toList()) + "\n";
		}).collect(Collectors.toList()).toString();
	}
}
