package school.sorokin.notificationmanager.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import school.sorokin.notificationmanager.model.EventNotification;
import school.sorokin.notificationmanager.service.NotificationService;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventNotificationConsumer {
    private final NotificationService notificationService;

    @KafkaListener(topics = "notification-topic", containerFactory = "containerFactory")
    public void listenEvents(ConsumerRecord<Long, EventNotification> record) {
        var eventNotification = record.value();
        log.info("Received event notification: {}", eventNotification);
        notificationService.saveNotification(eventNotification);
    }
}
