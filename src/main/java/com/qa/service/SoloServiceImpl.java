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

	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(Long id) {
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

}
