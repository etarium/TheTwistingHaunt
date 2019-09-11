package utilities;

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
}
