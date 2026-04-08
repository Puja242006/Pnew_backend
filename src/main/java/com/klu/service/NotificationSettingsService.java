package com.klu.service;

import com.klu.entity.NotificationSettings;
import com.klu.repository.NotificationSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationSettingsService {

    @Autowired
    private NotificationSettingsRepository repo;

    // ✅ GET SETTINGS (SAFE)
    public NotificationSettings getSettings(Long userId) {
        List<NotificationSettings> list = repo.findAllByUserId(userId);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    // ✅ SAVE / UPDATE (NO DUPLICATES)
    public NotificationSettings saveSettings(NotificationSettings settings) {

        List<NotificationSettings> list = repo.findAllByUserId(settings.getUserId());

        if (!list.isEmpty()) {
            NotificationSettings existing = list.get(0);

            existing.setEmailNotifications(settings.isEmailNotifications());
            existing.setIssueAlerts(settings.isIssueAlerts());
            existing.setReportUpdates(settings.isReportUpdates());
            existing.setDiscussionReplies(settings.isDiscussionReplies());

            return repo.save(existing);
        }

        return repo.save(settings);
    }
}