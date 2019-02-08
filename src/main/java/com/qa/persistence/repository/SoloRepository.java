package com.qa.persistence.repository;

public interface SoloRepository {
	String createEntry(String input, String path);

	String readEntries(String path);

	String updateEntry(Long id, String input, String path);

	String deleteEntry(Long id, String path);

}
