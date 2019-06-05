package db.api;

import java.util.List;

import db.repository.DBConnector;
import pojos.entity.EntityClassObject;
import pojos.environment.Cell;
import utilities.Logs;

public class DbAPI {
	DBConnector db = new DBConnector();
	
	//gets all Cells from database that share the same instance value
	//send through the instance.name as parameter
	public List<Cell> getCellsFromInstance(String instance) {
		List<Cell> activeCells = db.getAllCellsFromInstance(instance);
		Logs.LOGGER.info(DbAPI.class + " called getCellsFromInstance("+instance+")");
		return activeCells;
	}

	public List<EntityClassObject> getActiveClasses() {
		List<EntityClassObject> activeClasses = db.getAllAvailableClasses();
		Logs.LOGGER.info(DbAPI.class + " called getActiveClasses()");
		return activeClasses;
	}
}
