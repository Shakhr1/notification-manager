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

    @KafkaListener(topics = "${kafka.topic.event-updates}", containerFactory = "containerFactory")
    public void listenEvents(ConsumerRecord<Long, EventNotification> record) {
        log.info("Received event notification: {}", record.value());
        notificationService.saveNotification(record.value());
    }
}
