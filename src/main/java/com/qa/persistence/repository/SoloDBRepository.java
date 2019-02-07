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

	private Account findAccount(String id) {
		return manager.find(Account.class, id);
	}

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	public String readAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String updateAccount(String id, String account) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(String id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"creature sucessfully deleted\"}";
	}

	// Creatures

	private Creature findCreature(Long id) {
		return manager.find(Creature.class, id);
	}

	@Transactional(REQUIRED)
	public String createCreature(String creature) {
		Creature aCreature = util.getObjectForJSON(creature, Creature.class);
		manager.persist(aCreature);
		return "{\"message\": \"creature has been sucessfully added\"}";
	}

	public String readCreatures() {
		Query query = manager.createQuery("Select a FROM Creature a ORDER BY creatureName");
		Collection<Creature> creatures = (Collection<Creature>) query.getResultList();
		return util.getJSONForObject(creatures);
	}

	@Transactional(REQUIRED)
	public String updateCreature(Long id, String creature) {
		Creature creatureInDB = findCreature(id);
		Creature aCreature = util.getObjectForJSON(creature, Creature.class);
		if (creatureInDB != null) {
			if (aCreature.getCreatureName().length() < 1) {
				aCreature.setCreatureName(creatureInDB.getCreatureName());
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
		aCreature.setId(id);
		manager.persist(aCreature);
		return "{\"message\": \"creature has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteCreature(Long id) {
		Creature creatureInDB = findCreature(id);
		if (creatureInDB != null) {
			manager.remove(creatureInDB);
		}
		return "{\"message\": \"creature sucessfully deleted\"}";
	}

	// Equipment

	private Item findItem(Long id) {
		return manager.find(Item.class, id);
	}

	@Transactional(REQUIRED)
	public String createItem(String item) {
		Item anItem = util.getObjectForJSON(item, Item.class);
		manager.persist(anItem);
		return "{\"message\": \"item has been sucessfully added\"}";
	}

	public String readItems() {
		Query query = manager.createQuery("Select a FROM Item a ORDER BY equipmentName");
		List<Item> equipment = (List<Item>) query.getResultList();
		return util.getJSONForObject(equipment);
	}

	@Transactional(REQUIRED)
	public String updateItem(Long id, String item) {
		Item equipmentInDB = findItem(id);
		Item anItem = util.getObjectForJSON(item, Item.class);
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
		anItem.setEquipmentId(id);
		manager.persist(anItem);
		return "{\"message\": \"item has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteItem(Long id) {
		Item equipmentInDB = findItem(id);
		if (equipmentInDB != null) {
			manager.remove(equipmentInDB);
		}
		return "{\"message\": \"item sucessfully deleted\"}";
	}

}
