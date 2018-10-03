package querymachine;

public class Utils {

	String outputString ="";
	
	public Utils () {

	}
	
	public String removeID(String inputString) {
		String introString = "";
		String endString = "";
		introString = inputString.substring(0, 2);
		endString = inputString.substring(51);
		outputString = (introString + endString);
		outputString.trim();
		return outputString;
	}
	
	public String removeDocHeader(String inputString) {
		outputString = inputString.replace("Document", "");
		return outputString;
	}
	
	public String removeBraces(String inputString) {
		outputString = inputString.replace("}}", "}");
		outputString = outputString.replace("{{", "{");
		return outputString;
	}
	
	public String addQuotes(String inputString) {
		
		return outputString;
	}
	
	public String formatString(String inputString) {
		outputString = removeID(inputString);
		return outputString;
	}
}
