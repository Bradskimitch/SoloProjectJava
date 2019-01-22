package com.qa.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Creature {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String creatureHP;
	private String creatureAC;
	private String creatureSpeed;
	private int creatureStr;
	private int creatureDex;
	private int creatureCon;
	private int creatureInt;
	private int creatureWis;
	private int creatureCha;
	private String creatureSavingThrows;
	private String creatureSkills;
	private String creatureDamageRes;
	private String creatureDamageImmune;
	private String creatureDamageVulnerable;
	private String creatureConditionImmune;
	private String creatureSenses;
	private String creatureLanguage;
	private int creatureCR;
	private String creatureAbilities;
	private String creatureActions;
	private String creatureReactions;
	private String creatureLegendary;
	private String creatureEquipment;
}
