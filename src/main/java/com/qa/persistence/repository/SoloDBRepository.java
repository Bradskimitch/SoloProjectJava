package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Creature;
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
	public String updateAccount(Long id, String account) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
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

}
