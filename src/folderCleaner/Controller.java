package folderCleaner;

import java.io.File;

import folderCleaner.arrange.FileArranger;
import folderCleaner.organize.FileOrganizer;

public class Controller {

	public void run() {
		
		UserPrompt prompter = new UserPrompt();
		String user = prompter.prompt();
		
		Config.setUser(user);
		
		File done = new File(Config.ORGANIZED);
		
		if (done.exists()) {
			System.out.println("Program has already been run on this folder. Delete \".organized\" file to run again.");
		} else {
			FileOrganizer fo = new FileOrganizer();
			FileArranger fa = new FileArranger();
			fa.arrange(fo.getFiles());
			System.out.println("Finished Successfully.");
		}
	}
}
