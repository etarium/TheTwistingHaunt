package pojos.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumableItem extends Item{
	int duration;
	int numOfTargets;
}
