package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Creature;
import com.qa.persistence.domain.Item;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class SoloDBRepository implements SoloRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	// Accounts

	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	private Creature findCreature(Long id) {
		return manager.find(Creature.class, id);
	}

	private Item findItem(Long id) {
		return manager.find(Item.class, id);
	}

	@Transactional(REQUIRED)
	public String createEntry(String input, String path) {
		String message = " successfully added.";
		switch (path) {
		case "account":
			Account anEntry = util.getObjectForJSON(input, Account.class);
			manager.persist(anEntry);
			message = "Account" + message;
			break;
		case "creature":
			Creature aCreature = util.getObjectForJSON(input, Creature.class);
			manager.persist(aCreature);
			message = "Creature" + message;
			break;
		case "item":
			Item anItem = util.getObjectForJSON(input, Item.class);
			manager.persist(anItem);
			message = "Item" + message;
			break;
		}
		return message;
	}

	public String readEntries(String path) {
		switch (path) {
		case "account":
			Query accountQuery = manager.createQuery("Select a FROM Account a");
			List<Account> accounts = (List<Account>) accountQuery.getResultList();
			return util.getJSONForObject(accounts);
		case "creature":
			Query creatureQuery = manager.createQuery("Select a FROM Creature a ORDER BY creatureName");
			List<Creature> creatures = (List<Creature>) creatureQuery.getResultList();
			return util.getJSONForObject(creatures);
		case "item":
			Query itemQuery = manager.createQuery("Select a FROM Item a ORDER BY equipmentName");
			List<Item> equipment = (List<Item>) itemQuery.getResultList();
			return util.getJSONForObject(equipment);
		}
		return "";

	}

	@Transactional(REQUIRED)
	public String updateEntry(Long id, String input, String path) {
		String message = " successfully added.";
		switch (path) {
		case "account":
			Account accountInDB = findAccount(id);
			if (accountInDB != null) {
				manager.remove(accountInDB);
			}
			Account anAccount = util.getObjectForJSON(input, Account.class);
			manager.persist(anAccount);
			message = "Account" + message;
			break;
		case "creature":
			Creature creatureInDB = findCreature(id);
			Creature aCreature = util.getObjectForJSON(input, Creature.class);
			if (creatureInDB != null) {
				if (aCreature.getCreatureName().length() < 1) {
					aCreature.setCreatureName(creatureInDB.getCreatureName());
				}
				if (aCreature.getCreatureRace().length() < 1) {
					aCreature.setCreatureRace(creatureInDB.getCreatureRace());
				}
				if (aCreature.getCreatureSubRace().length() < 1) {
					aCreature.setCreatureSubRace(creatureInDB.getCreatureSubRace());
				}
				if (aCreature.getCreatureAllignment().length() < 1) {
					aCreature.setCreatureAllignment(creatureInDB.getCreatureAllignment());
				}
				if (aCreature.getCreatureHP().length() < 1) {
					aCreature.setCreatureHP(creatureInDB.getCreatureHP());
				}
				if (aCreature.getCreatureAC().length() < 1) {
					aCreature.setCreatureAC(creatureInDB.getCreatureAC());
				}
				if (aCreature.getCreatureSpeed().length() < 1) {
					aCreature.setCreatureSpeed(creatureInDB.getCreatureSpeed());
				}
				if (aCreature.getCreatureStr() < 1) {
					aCreature.setCreatureStr(creatureInDB.getCreatureStr());
				}
				if (aCreature.getCreatureDex() < 1) {
					aCreature.setCreatureDex(creatureInDB.getCreatureDex());
				}
				if (aCreature.getCreatureCon() < 1) {
					aCreature.setCreatureCon(creatureInDB.getCreatureCon());
				}
				if (aCreature.getCreatureInt() < 1) {
					aCreature.setCreatureInt(creatureInDB.getCreatureInt());
				}
				if (aCreature.getCreatureWis() < 1) {
					aCreature.setCreatureWis(creatureInDB.getCreatureWis());
				}
				if (aCreature.getCreatureCha() < 1) {
					aCreature.setCreatureCha(creatureInDB.getCreatureCha());
				}
				if (aCreature.getCreatureSavingThrows().length() < 1) {
					aCreature.setCreatureSavingThrows(creatureInDB.getCreatureSavingThrows());
				}
				if (aCreature.getCreatureSkills().length() < 1) {
					aCreature.setCreatureSkills(creatureInDB.getCreatureSkills());
				}
				if (aCreature.getCreatureDamageRes().length() < 1) {
					aCreature.setCreatureDamageRes(creatureInDB.getCreatureDamageRes());
				}
				if (aCreature.getCreatureDamageImmune().length() < 1) {
					aCreature.setCreatureDamageImmune(creatureInDB.getCreatureDamageImmune());
				}
				if (aCreature.getCreatureDamageVulnerable().length() < 1) {
					aCreature.setCreatureDamageVulnerable(creatureInDB.getCreatureDamageVulnerable());
				}
				if (aCreature.getCreatureConditionImmune().length() < 1) {
					aCreature.setCreatureConditionImmune(creatureInDB.getCreatureConditionImmune());
				}
				if (aCreature.getCreatureSenses().length() < 1) {
					aCreature.setCreatureSenses(creatureInDB.getCreatureSenses());
				}
				if (aCreature.getCreatureLanguage().length() < 1) {
					aCreature.setCreatureLanguage(creatureInDB.getCreatureLanguage());
				}
				if (aCreature.getCreatureCR().length() < 1) {
					aCreature.setCreatureCR(creatureInDB.getCreatureCR());
				}
				if (aCreature.getCreatureAbilities().length() < 1) {
					aCreature.setCreatureAbilities(creatureInDB.getCreatureAbilities());
				}
				if (aCreature.getCreatureActions().length() < 1) {
					aCreature.setCreatureActions(creatureInDB.getCreatureActions());
				}
				if (aCreature.getCreatureReactions().length() < 1) {
					aCreature.setCreatureReactions(creatureInDB.getCreatureReactions());
				}
				if (aCreature.getCreatureLegendary().length() < 1) {
					aCreature.setCreatureLegendary(creatureInDB.getCreatureLegendary());
				}
				if (aCreature.getCreatureEquipment().length() < 1) {
					aCreature.setCreatureEquipment(creatureInDB.getCreatureEquipment());
				}
				manager.remove(creatureInDB);
			}
			//aCreature.setId(id);
			manager.persist(aCreature);
			break;
		case "item":
			Item equipmentInDB = findItem(id);
			Item anItem = util.getObjectForJSON(input, Item.class);
			if (equipmentInDB != null) {
				if (anItem.getEquipmentName().length() < 1) {
					anItem.setEquipmentName(equipmentInDB.getEquipmentName());
				}
				if (anItem.getEquipmentType().length() < 1) {
					anItem.setEquipmentType(equipmentInDB.getEquipmentType());
				}
				if (anItem.getEquipmentRarity().length() < 1) {
					anItem.setEquipmentRarity(equipmentInDB.getEquipmentRarity());
				}
				if (anItem.getEquipmentAttunement().length() < 1) {
					anItem.setEquipmentAttunement(equipmentInDB.getEquipmentAttunement());
				}
				if (anItem.getEquipmentDescription().length() < 1) {
					anItem.setEquipmentDescription(equipmentInDB.getEquipmentDescription());
				}
				manager.remove(equipmentInDB);
			}
			//anItem.setEquipmentId(id);
			manager.persist(anItem);
			break;
		}
		return message;
	}

	@Transactional(REQUIRED)
	public String deleteEntry(Long id, String path) {
		String message = " successfully deleted.";
		switch (path) {
		case "account":
			Account accountInDB = findAccount(id);
			if (accountInDB != null) {
				manager.remove(accountInDB);
			}
			message = "Account" + message;
			break;
		case "creature":
			Creature creatureInDB = findCreature(id);
			if (creatureInDB != null) {
				manager.remove(creatureInDB);
			}
			message = "Creature" + message;
			break;
		case "item":
			Item equipmentInDB = findItem(id);
			if (equipmentInDB != null) {
				manager.remove(equipmentInDB);
			}
			message = "Item" + message;
			break;
		}
		return message;

	}
}
