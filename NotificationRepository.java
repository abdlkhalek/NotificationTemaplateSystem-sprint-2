package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.NotificationModel;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long>{

}
