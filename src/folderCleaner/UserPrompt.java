package folderCleaner;

import java.io.File;
import java.util.Scanner;

public class UserPrompt {

	public String prompt() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your Windows username.");
		String response = scan.next().toLowerCase();
		
		File testUser = new File("C:\\Users\\" + response);
		
		if (testUser.exists()) {
			return response;
		} else {
			System.out.println("Could not find folder in Users/ for " + response);
			return prompt();
		}
	}
}
