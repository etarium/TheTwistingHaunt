package game;

import java.io.Serializable;
import java.util.Date;

public class Instance implements Serializable 
{
	private String instanceID;
	private String description;
	private Date updated;
	private boolean isComplete;

	public Instance() {
		//empty constructor
	}
	
	public Instance(String instanceID, String description, Date updated, boolean isComplete) {
		this.instanceID = instanceID;
		this.description = description;
		this.updated = updated;
		this.isComplete = isComplete;
	}

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
}
