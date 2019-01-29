package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	public String readCreature() {
		Query query = manager.createQuery("Select a FROM Creature a");
		Collection<Creature> creatures = (Collection<Creature>) query.getResultList();
		return util.getJSONForObject(creatures);
	}

	@Transactional(REQUIRED)
	public String updateCreature(Long id, String creature) {
		Creature creatureInDB = findCreature(id);
		if (creatureInDB != null) {
			manager.remove(creatureInDB);
		}
		Creature aCreature = util.getObjectForJSON(creature, Creature.class);
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
