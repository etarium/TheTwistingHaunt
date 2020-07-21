package gameplay.commandServices.utilities;

public class SelectUtility {
	
	public boolean isInteger (String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    }
	    catch (NumberFormatException e) {
	        return false;
	    }
	}
}
