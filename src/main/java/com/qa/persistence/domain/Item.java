package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Item {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="equipmentId", insertable=true, updatable=true, unique=true, nullable=false)
	private Long equipmentId;
	private String equipmentName;
	private String equipmentType;
	private String equipmentRarity;
	private String equipmentAttunement;
	@Size(max=999)
	private String equipmentDescription;
	
	public Long getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getEquipmentRarity() {
		return equipmentRarity;
	}
	public void setEquipmentRarity(String equipmentRarity) {
		this.equipmentRarity = equipmentRarity;
	}
	public String getEquipmentAttunement() {
		return equipmentAttunement;
	}
	public void setEquipmentAttunement(String equipmentAttunement) {
		this.equipmentAttunement = equipmentAttunement;
	}
	public String getEquipmentDescription() {
		return equipmentDescription;
	}
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}
	
	
}
