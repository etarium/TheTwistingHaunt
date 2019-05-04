package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Statblock {

	int hp;
	int sp;
	int atk;
	int def;
	int spatk;
	int spdef;
	int eva;
	int intel;
	int cha;
	int sta;
	int agi;
	int acc;
}
