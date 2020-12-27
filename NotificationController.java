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

import com.project.model.NotificationModel;
import com.project.service.NotificationService;

@RestController
@CrossOrigin("*")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("notifications")
	public List<NotificationModel> getAllNotifications(){
		return notificationService.getAllNotifications();
	}
	
	@GetMapping("notification/{id}")
	public Optional<NotificationModel> getAllNotifications(@PathVariable Long id){
		return notificationService.getNotifications(id);
	}
	
	@PostMapping("notification")
	public NotificationModel createNotification(@RequestBody NotificationModel notifiction){
		return notificationService.createNotification(notifiction);
	}
	
	@DeleteMapping("notification/{id}")
	public void deleteNotification(@PathVariable("id") Long id) {
		notificationService.deleteNotification(id);
	}
	
	@PutMapping("notification")
	public NotificationModel updateNotification(@RequestBody NotificationModel notification) {
		return notificationService.updateNotification(notification);
	}
	
}
