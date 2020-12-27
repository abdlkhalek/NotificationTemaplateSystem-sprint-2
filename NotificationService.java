package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.MailMessage;
import com.project.model.NotificationModel;
import com.project.model.SMSMessage;
import com.project.repository.MailRepository;
import com.project.repository.NotificationRepository;
import com.project.repository.SMSRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	@Autowired
	private MailRepository repoMail;
	@Autowired
	private SMSRepository repoMessage;
	
	public List<NotificationModel> getAllNotifications() { // read All
		return repository.findAll();
	}
	public Optional<NotificationModel> getNotifications(Long id) { // read by id
		return repository.findById(id);
	}
	public NotificationModel createNotification(NotificationModel notifiction) {
		SMSMessage message = new SMSMessage();
		MailMessage mail = new MailMessage();
		if(notifiction.getSubject().toLowerCase().contains("mail")) {
			mail.setContent(notifiction.getContent());
			repoMail.save(mail);
		}else if(notifiction.getSubject().toLowerCase().contains("sms")) {
			message.setContent(notifiction.getContent());
			repoMessage.save(message);
		}else {
			return null;
		}
		return repository.save(notifiction);
	}
	public void deleteNotification(Long id) {// here user should decide what type of notification 
											// to be able to handled 
		repository.deleteById(id);
	}
	public NotificationModel updateNotification(NotificationModel notification) {
		return repository.save(notification);
	}

}
