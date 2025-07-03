package school.sorokin.notificationmanager.service;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.sorokin.notificationmanager.mapper.NotificationEntityMapper;
import school.sorokin.notificationmanager.model.EventNotification;
import school.sorokin.notificationmanager.repository.NotificationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationEntityMapper notificationEntityMapper;

    @Transactional
    public void saveNotification(EventNotification notification) {
        log.info("Saving notification: {}", notification);
        notificationRepository.save(notificationEntityMapper.toEntity(notification));
    }

    @Transactional
    public void markAsRead(List<Long> id) {
        notificationRepository.findAllByIdIn(id).forEach(notification -> notification.setIsRead(true));
        log.info("Marking notification as read: {}", id);
    }

    public List<EventNotification> getAllUnreadNotifications(String login) {
        List<EventNotification> eventNotifications = notificationRepository
                .findAll().stream()
                .filter(n -> n.getSubscribersLogins().contains(login))
                .map(notificationEntityMapper::toDomain)
                .toList();
        log.info("Fetching unread notifications: {}", eventNotifications);
    return eventNotifications;
    }
}
