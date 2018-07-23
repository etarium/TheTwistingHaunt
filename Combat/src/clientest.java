import java.io.IOException;

import querymachine.InstanceCompiler;

public class clientest {
	public static void main(String args[]) throws IOException {
		InstanceCompiler compile = new InstanceCompiler();
		String instance_id = "DN001";
		compile.loadGameDataFromDB(instance_id);
		
	}
}
