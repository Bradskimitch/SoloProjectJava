package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Creature {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String creatureName;
	private String creatureRace;
	private String creatureSubRace;
	private String creatureAllignment;
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
	private String creatureCR;
	private String creatureAbilities;
	private String creatureActions;
	private String creatureReactions;
	private String creatureLegendary;
	private String creatureEquipment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatureHP() {
		return creatureHP;
	}

	public void setCreatureHP(String creatureHP) {
		this.creatureHP = creatureHP;
	}

	public String getCreatureAC() {
		return creatureAC;
	}

	public void setCreatureAC(String creatureAC) {
		this.creatureAC = creatureAC;
	}

	public String getCreatureSpeed() {
		return creatureSpeed;
	}

	public void setCreatureSpeed(String creatureSpeed) {
		this.creatureSpeed = creatureSpeed;
	}

	public int getCreatureStr() {
		return creatureStr;
	}

	public void setCreatureStr(int creatureStr) {
		this.creatureStr = creatureStr;
	}

	public int getCreatureDex() {
		return creatureDex;
	}

	public void setCreatureDex(int creatureDex) {
		this.creatureDex = creatureDex;
	}

	public int getCreatureCon() {
		return creatureCon;
	}

	public void setCreatureCon(int creatureCon) {
		this.creatureCon = creatureCon;
	}

	public int getCreatureInt() {
		return creatureInt;
	}

	public void setCreatureInt(int creatureInt) {
		this.creatureInt = creatureInt;
	}

	public int getCreatureWis() {
		return creatureWis;
	}

	public void setCreatureWis(int creatureWis) {
		this.creatureWis = creatureWis;
	}

	public int getCreatureCha() {
		return creatureCha;
	}

	public void setCreatureCha(int creatureCha) {
		this.creatureCha = creatureCha;
	}

	public String getCreatureSavingThrows() {
		return creatureSavingThrows;
	}

	public void setCreatureSavingThrows(String creatureSavingThrows) {
		this.creatureSavingThrows = creatureSavingThrows;
	}

	public String getCreatureSkills() {
		return creatureSkills;
	}

	public void setCreatureSkills(String creatureSkills) {
		this.creatureSkills = creatureSkills;
	}

	public String getCreatureDamageRes() {
		return creatureDamageRes;
	}

	public void setCreatureDamageRes(String creatureDamageRes) {
		this.creatureDamageRes = creatureDamageRes;
	}

	public String getCreatureDamageImmune() {
		return creatureDamageImmune;
	}

	public void setCreatureDamageImmune(String creatureDamageImmune) {
		this.creatureDamageImmune = creatureDamageImmune;
	}

	public String getCreatureDamageVulnerable() {
		return creatureDamageVulnerable;
	}

	public void setCreatureDamageVulnerable(String creatureDamageVulnerable) {
		this.creatureDamageVulnerable = creatureDamageVulnerable;
	}

	public String getCreatureConditionImmune() {
		return creatureConditionImmune;
	}

	public void setCreatureConditionImmune(String creatureConditionImmune) {
		this.creatureConditionImmune = creatureConditionImmune;
	}

	public String getCreatureSenses() {
		return creatureSenses;
	}

	public void setCreatureSenses(String creatureSenses) {
		this.creatureSenses = creatureSenses;
	}

	public String getCreatureLanguage() {
		return creatureLanguage;
	}

	public void setCreatureLanguage(String creatureLanguage) {
		this.creatureLanguage = creatureLanguage;
	}

	public String getCreatureCR() {
		return creatureCR;
	}

	public void setCreatureCR(String creatureCR) {
		this.creatureCR = creatureCR;
	}

	public String getCreatureAbilities() {
		return creatureAbilities;
	}

	public void setCreatureAbilities(String creatureAbilities) {
		this.creatureAbilities = creatureAbilities;
	}

	public String getCreatureActions() {
		return creatureActions;
	}

	public void setCreatureActions(String creatureActions) {
		this.creatureActions = creatureActions;
	}

	public String getCreatureReactions() {
		return creatureReactions;
	}

	public void setCreatureReactions(String creatureReactions) {
		this.creatureReactions = creatureReactions;
	}

	public String getCreatureLegendary() {
		return creatureLegendary;
	}

	public void setCreatureLegendary(String creatureLegendary) {
		this.creatureLegendary = creatureLegendary;
	}

	public String getCreatureEquipment() {
		return creatureEquipment;
	}

	public void setCreatureEquipment(String creatureEquipment) {
		this.creatureEquipment = creatureEquipment;
	}

	public String getCreatureName() {
		return creatureName;
	}

	public void setCreatureName(String creatureName) {
		this.creatureName = creatureName;
	}

	public String getCreatureRace() {
		return creatureRace;
	}

	public void setCreatureRace(String creatureRace) {
		this.creatureRace = creatureRace;
	}

	public String getCreatureSubRace() {
		return creatureSubRace;
	}

	public void setCreatureSubRace(String creatureSubRace) {
		this.creatureSubRace = creatureSubRace;
	}

	public String getCreatureAllignment() {
		return creatureAllignment;
	}

	public void setCreatureAllignment(String creatureAllignment) {
		this.creatureAllignment = creatureAllignment;
	}

}
