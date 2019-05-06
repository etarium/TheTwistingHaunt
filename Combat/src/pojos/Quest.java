package pojos;

import java.util.List;

import pojos.entity.Entity;
import pojos.environment.Location;
import pojos.items.Item;

public class Quest {

	String _id;
	String name;
	String description;
	List<Item> questItems;
	List<Item> questRewards;
	List<Entity> questEntities;
	Location coordinatesOfQuest;
	Location coordinatesOfNPC;
	String npcDialogueForQuest;
	String npcDialogueForQuestCompletion;
	String npcDialogueForQuestAbandonment;
	int minLevel;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Item> getQuestItems() {
		return questItems;
	}
	public void setQuestItems(List<Item> questItems) {
		this.questItems = questItems;
	}
	public List<Item> getQuestRewards() {
		return questRewards;
	}
	public void setQuestRewards(List<Item> questRewards) {
		this.questRewards = questRewards;
	}
	public List<Entity> getQuestEntities() {
		return questEntities;
	}
	public void setQuestEntities(List<Entity> questEntities) {
		this.questEntities = questEntities;
	}
	public Location getCoordinatesOfQuest() {
		return coordinatesOfQuest;
	}
	public void setCoordinatesOfQuest(Location coordinatesOfQuest) {
		this.coordinatesOfQuest = coordinatesOfQuest;
	}
	public Location getCoordinatesOfNPC() {
		return coordinatesOfNPC;
	}
	public void setCoordinatesOfNPC(Location coordinatesOfNPC) {
		this.coordinatesOfNPC = coordinatesOfNPC;
	}
	public String getNpcDialogueForQuest() {
		return npcDialogueForQuest;
	}
	public void setNpcDialogueForQuest(String npcDialogueForQuest) {
		this.npcDialogueForQuest = npcDialogueForQuest;
	}
	public String getNpcDialogueForQuestCompletion() {
		return npcDialogueForQuestCompletion;
	}
	public void setNpcDialogueForQuestCompletion(String npcDialogueForQuestCompletion) {
		this.npcDialogueForQuestCompletion = npcDialogueForQuestCompletion;
	}
	public String getNpcDialogueForQuestAbandonment() {
		return npcDialogueForQuestAbandonment;
	}
	public void setNpcDialogueForQuestAbandonment(String npcDialogueForQuestAbandonment) {
		this.npcDialogueForQuestAbandonment = npcDialogueForQuestAbandonment;
	}
	public int getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}
	
	@Override
	public String toString() {
		return "Quest [_id=" + _id + ", name=" + name + ", description=" + description + ", questItems=" + questItems
				+ ", questRewards=" + questRewards + ", questEntities=" + questEntities + ", coordinatesOfQuest="
				+ coordinatesOfQuest + ", coordinatesOfNPC=" + coordinatesOfNPC + ", npcDialogueForQuest="
				+ npcDialogueForQuest + ", npcDialogueForQuestCompletion=" + npcDialogueForQuestCompletion
				+ ", npcDialogueForQuestAbandonment=" + npcDialogueForQuestAbandonment + ", minLevel=" + minLevel + "]";
	}
	
}
