package com.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.SMSMessage;
import com.project.repository.SMSRepository;

@Service
public class MessageService {

	@Autowired
	private SMSRepository repo;
	public List<SMSMessage> getAllMessages() {
		return repo.findAll();
	}

	public Optional<SMSMessage> getMessage(Long id) {
		return repo.findById(id);
	}

	public SMSMessage createMessaeg(SMSMessage message) {
		return repo.save(message);
	}

	public void deleteMessage(Long id) {
		repo.deleteById(id);
	}

	public SMSMessage updateMessage(SMSMessage message) {
		return repo.save(message);
	}

}
