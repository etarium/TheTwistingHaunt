package pojos.environment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Instance {

	String name;
	String description;
	int minLevel;
}
