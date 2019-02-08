package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.SoloRepository;

public class SoloServiceImpl implements SoloService {

	@Inject
	private SoloRepository repo;

	public void setRepo(SoloRepository repo) {
		this.repo = repo;
	}
	
	// Accounts

	public String createEntry(String input, String path) {
		return repo.createEntry(input, path);
	}

	public String readEntries(String path) {
		return repo.readEntries(path);
	}

	public String updateEntry(Long id, String input, String path) {
		return repo.updateEntry(id, input, path);
	}

	public String deleteEntry(Long id, String path) {
		return repo.deleteEntry(id, path);
	}

}
