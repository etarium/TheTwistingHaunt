import java.io.IOException;

import gui.classes.CommandListener;

public class clientest {
	public static void main(String args[]) throws IOException {
		CommandListener compile = new CommandListener();
		String instance_id = "DN001";
		compile.loadInstance(instance_id);
		
	}
}
