package com.qa.persistence.repository;

public interface SoloRepository {
	String createAccount(String account);

	String readAccounts();

	String updateAccount(Long id, String account);

	String deleteAccount(Long id);
	
	String createCreature(String creature);

	String readCreature();

	String updateCreature(Long id, String creature);

	String deleteCreature(Long id);
}
