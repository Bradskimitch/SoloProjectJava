package com.qa.service;

public interface SoloService {
	String createAccount(String account);

	String readAccounts();

	String updateAccount(Long id, String account);

	String deleteAccount(Long id);
	
	String createCreature(String creature);

	String readCreatures();

	String updateCreature(Long id, String creature);

	String deleteCreature(Long id);
}