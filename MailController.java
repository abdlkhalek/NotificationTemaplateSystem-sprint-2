package com.project.conterller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.model.MailMessage;
import com.project.service.MailService;

@RestController // connect to browser 
@CrossOrigin("*")
public class MailController {

	@Autowired
	private MailService service;
	
	@GetMapping("mails")
	public List<MailMessage> getAllMails(){
		return service.getAllMails();
	}
	
	@GetMapping("mail/{id}")
	public Optional<MailMessage> getMail(@PathVariable Long id){
		return service.getMail(id);
	}
	
	@PostMapping("mail")
	public MailMessage createMail(@RequestBody MailMessage mail){
		return service.createMail(mail);
	}
	
	@DeleteMapping("mail/{id}")
	public void deleteMail(@PathVariable("id") Long id) {
		service.deleteMail(id);
	}
	
	@PutMapping("mail") // url of api
	public MailMessage updateMail(@RequestBody MailMessage mail) {
		return service.updateMail(mail);
	}
}
