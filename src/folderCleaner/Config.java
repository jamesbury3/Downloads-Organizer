package folderCleaner;

public class Config {

	public static String USER;
	public static String DIRECTORY;
	public static String ORGANIZED;
	
	public static void setUser(String user) {
		USER = user;
		DIRECTORY = "C:\\Users\\" + USER  + "\\Documents\\organizer";
		ORGANIZED = DIRECTORY + "\\" + ".organized";
	}
}
