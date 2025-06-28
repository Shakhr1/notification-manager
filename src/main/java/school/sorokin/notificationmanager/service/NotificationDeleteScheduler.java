package school.sorokin.notificationmanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import school.sorokin.notificationmanager.repository.NotificationRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationDeleteScheduler {

    private final NotificationRepository notificationRepository;

    @Scheduled(cron = "${notification.delete.cron}")
    public void delete() {
        log.info("Scheduling notification deletion...");
        notificationRepository.deleteAllByIsReadIsTrue();
        log.info("Notification deleted");
    }
}
