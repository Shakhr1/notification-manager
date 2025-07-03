package school.sorokin.notificationmanager.mapper;

import org.springframework.stereotype.Component;
import school.sorokin.notificationmanager.dto.NotificationDto;
import school.sorokin.notificationmanager.model.EventNotification;
import school.sorokin.notificationmanager.model.FieldChange;

@Component
public class NotificationDtoMapper {
    public NotificationDto toDto(EventNotification notification) {
        return new NotificationDto(
                notification.getEventId(),
                notification.getName() != null ?
                        new FieldChange<>(notification.getName().getOldField(), notification.getName().getNewField()) : null,
                notification.getMaxPlaces() != null ?
                        new FieldChange<>(notification.getMaxPlaces().getOldField(), notification.getMaxPlaces().getNewField()) : null,
                notification.getDate() != null ?
                        new FieldChange<>(notification.getDate().getOldField(), notification.getDate().getNewField()) : null,
                notification.getCost() != null ?
                        new FieldChange<>(notification.getCost().getOldField(), notification.getCost().getNewField()) : null,
                notification.getDuration() != null ?
                        new FieldChange<>(notification.getDuration().getOldField(), notification.getDuration().getNewField()) : null,
                notification.getLocationId() != null ?
                        new FieldChange<>(notification.getLocationId().getOldField(), notification.getLocationId().getNewField()) : null,
                notification.getStatus() != null ?
                        new FieldChange<>(notification.getStatus().getOldField().name(), notification.getStatus().getNewField().name()) : null
        );
    }
}
