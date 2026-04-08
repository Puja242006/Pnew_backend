package com.klu.repository;

import com.klu.entity.NotificationSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationSettingsRepository extends JpaRepository<NotificationSettings, Long> {

    List<NotificationSettings> findAllByUserId(Long userId);

    // ✅ ADD THIS (for email sending)
    List<NotificationSettings> findByEmailNotificationsTrue();
}