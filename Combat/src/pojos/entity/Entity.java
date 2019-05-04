package pojos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.entity.enums.Species;
import pojos.entity.enums.Temperament;
import pojos.items.Item;

@JsonIgnoreProperties
public class Entity {

	String name;
	String description;
	Temperament temperament;
	Species species;
	List<Item> inventory;
	int level;
}
