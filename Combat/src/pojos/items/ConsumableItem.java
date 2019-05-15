package pojos.items;

public class ConsumableItem extends Item{
	int duration;
	int numOfTargets;
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNumOfTargets() {
		return numOfTargets;
	}
	public void setNumOfTargets(int numOfTargets) {
		this.numOfTargets = numOfTargets;
	}
	
	@Override
	public String toString() {
		return "ConsumableItem [duration=" + duration + ", numOfTargets=" + numOfTargets + ", name=" + name + ", type="
				+ type + ", description=" + description + ", usedDescription=" + usedDescription + ", stats=" + stats
				+ ", minLevel=" + minLevel + "]";
	}
	
}
