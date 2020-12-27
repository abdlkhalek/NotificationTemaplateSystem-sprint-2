package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MailMessage;
import com.project.repository.MailRepository;

@Service
public class MailService {

	@Autowired // refer for singleton
	private MailRepository repo;

	public List<MailMessage> getAllMails() { // read All
		return repo.findAll();
	}

	public Optional<MailMessage> getMail(Long id) { // read by id
		return repo.findById(id);
	}

	public MailMessage createMail(MailMessage mail) {
		return repo.save(mail);
	}

	public MailMessage updateMail(MailMessage mail) {
		return repo.save(mail);
	}

	public void deleteMail(Long id) {
		repo.deleteById(id);
	}
	
	
	
	
	
}
