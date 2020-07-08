package folderCleaner.arrange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import folderCleaner.Config;

public class FileArranger {
	
	public void arrange(HashMap<String, ArrayList<File>> file_map) {
		
		for (String file_type : file_map.keySet()) {
			
			String dir_name = Config.DIRECTORY + "\\" + file_type;
			File new_dir = new File(dir_name);
			
			if (!new_dir.mkdir()) {
				System.out.println("Could not make directory for " + file_type);
			} else {
				moveFiles(file_map.get(file_type), new_dir, dir_name);
			}
		}
		
		finalize();
	}
	
	public void finalize() {
		File done = new File(Config.DIRECTORY + "\\" + ".organized");
		try {
			done.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not create .organized file");
		}
	}
	
	public void moveFiles(ArrayList<File> files, File new_dir, String dir_name) {
		for (File file : files) {
			if (new_dir.exists()) {
				File new_file = new File(dir_name + "\\" + file.getName());
				renameFile(file, new_file);
			} else {
				System.out.println("Directory " + dir_name + " does not exist");
			}
		}
	}
	
	public void renameFile(File old_file, File new_file) {
		if (!old_file.renameTo(new_file)) {
			System.out.println("Could not rename " + old_file.getName() + " to " + new_file.getName());
		} else {
			System.out.println("Moved " + old_file.getName() + " to " + new_file.getName());
		}
	}
}
