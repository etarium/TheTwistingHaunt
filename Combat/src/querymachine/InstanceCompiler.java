/*
 * Author: Emily Clark
 * Purpose: To abstract QueryMachine and DBConnect packages into one method for creating all
 * in game data.
 */
package querymachine;
 import java.io.IOException;
 public class InstanceCompiler {
	
	private GetCells cellCompiler = new GetCells();
	
	public void loadGameDataFromDB(String instance_id) throws IOException {
		cellCompiler.arrangeCells(cellCompiler.getCellArray(instance_id));
		
	}
	
}