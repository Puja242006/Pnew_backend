package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_settings")
public class NotificationSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 IMPORTANT (PREVENT MULTIPLE ROWS)
    @Column(unique = true)
    private Long userId;

    private boolean emailNotifications;
    private boolean issueAlerts;
    private boolean reportUpdates;
    private boolean discussionReplies;

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isEmailNotifications() {
        return emailNotifications;
    }

    public void setEmailNotifications(boolean emailNotifications) {
        this.emailNotifications = emailNotifications;
    }

    public boolean isIssueAlerts() {
        return issueAlerts;
    }

    public void setIssueAlerts(boolean issueAlerts) {
        this.issueAlerts = issueAlerts;
    }

    public boolean isReportUpdates() {
        return reportUpdates;
    }

    public void setReportUpdates(boolean reportUpdates) {
        this.reportUpdates = reportUpdates;
    }

    public boolean isDiscussionReplies() {
        return discussionReplies;
    }

    public void setDiscussionReplies(boolean discussionReplies) {
        this.discussionReplies = discussionReplies;
    }
}