package com.qa.service;

public interface SoloService {
	String createAccount(String account);

	String readAccounts();

	String updateAccount(String id, String account);

	String deleteAccount(String id);
	
	String createCreature(String creature);

	String readCreatures();

	String updateCreature(Long id, String creature);

	String deleteCreature(Long id);
	
	String createItem(String item);

	String readItems();

	String updateItem(Long id, String item);

	String deleteItem(Long id);
}