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
    
    //WIP
    public static Object parseParameter(String parameter) {

	
//	    	Cell currentCell = player.getCurrentCell(cellList);
//	    	parameter = parameter.toLowerCase();
//	
//	    	ObjectComparator comp = new ObjectComparator();
//	    	int notFound = -1;	    	
//	    	
//	    	int usableIndex = comp.isPresentUsable(currentCell.getItem(), usableList);
//	    	int equipIndex = comp.isPresentEquipable(currentCell.getItem(), equipList);
//	    	int keyIndex = comp.isPresentKeyItem(currentCell.getKeyItem(), keyList);
//	
//	    	if(usableIndex == notFound && equipIndex == notFound && keyIndex == notFound ) {
//	    		// parameter not found
//	    	}
//	    	else {
//	    		if (usableIndex > notFound) {
//	
//	    			Usable item = usableList.get(usableIndex);
//	    			if (item.getName().toLowerCase().equals(parameter)){
//	    				return item;
//	    			}
//	    		}
//	    		if (equipIndex > notFound) {
//	
//	    			Equipable item = equipList.get(equipIndex);
//	    			if (item.getName().toLowerCase().equals(parameter)){
//	    				return item;
//	    			}
//	    		}
//	    		if (keyIndex > notFound) {
//	
//	    			KeyItems item = keyList.get(keyIndex);
//	    			if (item.getName().toLowerCase().equals(parameter)){
//	    				return item;
//	    			}
//	    		}
//	    	}
//	
	    	return null;
    }
}
