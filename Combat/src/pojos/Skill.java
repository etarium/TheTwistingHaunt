package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.enums.Attribute;

@JsonIgnoreProperties
public class Skill {

	String name;
	String description;
	Attribute attribute;
	int hpCost;
	int spCost;
	int accuracy;
	int duration;
	int numOfTargets;
	int minLevel;
	int damage;
	int healing;
}
