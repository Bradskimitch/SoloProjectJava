package com.qa.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.SoloRepository;
import com.qa.util.JSONUtil;

public class SoloServiceImpl implements SoloService {

	@Inject
	private SoloRepository repo;

	@Inject
	private JSONUtil util;

	public void setRepo(SoloRepository repo) {
		this.repo = repo;
	}
	
	// Accounts

	public String createAccount(String account) {
		return repo.createAccount(account);
	}

	public String readAccounts() {
		return repo.readAccounts();
	}

	public String updateAccount(String id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(String id) {
		return repo.deleteAccount(id);
	}

	// Creatures
	
	public String createCreature(String creature) {
		return repo.createCreature(creature);
	}

	public String readCreatures() {
		return repo.readCreature();
	}

	public String updateCreature(Long id, String creature) {
		return repo.updateCreature(id, creature);
	}

	public String deleteCreature(Long id) {
		return repo.deleteCreature(id);
	}

	// Equipment
	
	public String createItem(String item) {
		return repo.createItem(item);
	}

	public String readItems() {
		return repo.readItems();
	}

	public String updateItem(Long id, String item) {
		return repo.updateItem(id, item);
	}

	public String deleteItem(Long id) {
		return repo.deleteItem(id);
	}

}
