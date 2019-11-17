package utilities;

import general.Ability;
import uiView.UIMain;

public class InputParser {
    /**
     * Parses input into an array with the format {verb},{object}. If no
     * parameter is present, that field will be null.
     *
     * @param input
     * @return String array with command and parameter.
     */
    public static String[] parse(String input) {

        String[] stringArray = new String[2];

        input = input.trim().toLowerCase();

        boolean containsSpace = input.contains(" ");

        //will be -1 if no space present
        int indexOfSpace = input.indexOf(" ");

        stringArray[0] = (containsSpace) ? input.substring(0, input.indexOf(" ")) : input;
        stringArray[1] = (containsSpace) ? input.substring(indexOfSpace + 1) : null;

        return stringArray;
    }
    
    public static String[] parseMultiWordSkills(String input) {
        String[] stringArray = new String[2];
        int indexOfSpace = -1;
        input = input.trim().toLowerCase();

        for(Ability ability : UIMain.player.getSkills()) {
        	if(input.contains(ability.getName().toLowerCase())) {
        		//will be -1 if no space present
        		indexOfSpace = ability.getName().toLowerCase().length() + 1;
        		String inputSubstring = input.substring(indexOfSpace);
        		boolean containsSpace = inputSubstring.contains(" ");

                stringArray[0] = (containsSpace) ? input.substring(0, indexOfSpace) : input;
                stringArray[1] = (containsSpace) ? input.substring(indexOfSpace + 1) : null;
                return stringArray;
        	}
        }
        return stringArray;
    }
}
