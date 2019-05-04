package pojos.entity;

import java.util.List;

import pojos.entity.enums.Species;
import pojos.entity.enums.Temperament;
import pojos.items.Item;

public class Entity {

	String name;
	String description;
	Temperament temperament;
	Species species;
	List<Item> inventory;
	int level;
}
