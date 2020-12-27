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
import com.project.model.SMSMessage;
import com.project.service.MessageService;

@RestController // connect to browser 
@CrossOrigin("*")
public class SMSController {

	@Autowired
	private MessageService service;
	
	@GetMapping("messages")
	public List<SMSMessage> getAllMessage(){
		return service.getAllMessages();
	}
	
	@GetMapping("message/{id}")
	public Optional<SMSMessage> getAllMessage(@PathVariable Long id){
		return service.getMessage(id);
	}
	
	@PostMapping("message")
	public SMSMessage createMessage(@RequestBody SMSMessage message){
		return service.createMessaeg(message);
	}
	
	@DeleteMapping("message/{id}")
	public void deleteMessage(@PathVariable("id") Long id) {
		service.deleteMessage(id);
	}
	
	@PutMapping("message")
	public SMSMessage updateMessage(@RequestBody SMSMessage message) {
		return service.updateMessage(message);
	}
	
}
