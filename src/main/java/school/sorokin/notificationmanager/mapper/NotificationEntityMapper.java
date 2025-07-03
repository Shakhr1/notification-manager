package school.sorokin.notificationmanager.mapper;

import org.springframework.stereotype.Component;
import school.sorokin.notificationmanager.entity.NotificationEntity;
import school.sorokin.notificationmanager.model.EventNotification;
import school.sorokin.notificationmanager.model.EventStatus;
import school.sorokin.notificationmanager.model.FieldChange;

@Component
public class NotificationEntityMapper {
    public NotificationEntity toEntity(EventNotification notification){
        NotificationEntity notificationEntity = new NotificationEntity();

        notificationEntity.setEventId(notificationEntity.getEventId());
        notificationEntity.setChangerId(notificationEntity.getChangerId());
        notificationEntity.setOwnerId(notificationEntity.getOwnerId());
        notificationEntity.setSubscribersLogins(notification.getSubscribersLogins());
        notificationEntity.setIsRead(false);

        if (notification.getName() != null){
            notificationEntity.setOldName(notification.getName().getOldField());
            notificationEntity.setNewName(notification.getName().getNewField());
        }

        if (notification.getCost() != null){
            notificationEntity.setOldCost(notification.getCost().getOldField());
            notificationEntity.setNewCost(notification.getCost().getNewField());
        }

        if (notification.getDuration() != null){
            notificationEntity.setOldDuration(notification.getDuration().getOldField());
            notificationEntity.setNewDuration(notification.getDuration().getNewField());
        }

        if (notification.getLocationId() != null){
            notificationEntity.setOldLocationId(notification.getLocationId().getOldField());
            notificationEntity.setNewLocationId(notification.getLocationId().getNewField());
        }

        if (notification.getStatus() != null){
            notificationEntity.setOldEventStatus(notification.getStatus().getOldField().name());
            notificationEntity.setNewEventStatus(notification.getStatus().getNewField().name());
        }



        return notificationEntity;
    }

    public EventNotification toDomain(NotificationEntity notificationEntity){
        EventNotification eventNotification = new EventNotification();

        if (notificationEntity.getNewName() != null)
            eventNotification.setName(new FieldChange<>(notificationEntity.getOldName(), notificationEntity.getNewName()));

        if (notificationEntity.getNewMaxPlaces() != null)
            eventNotification.setMaxPlaces(new FieldChange<>(notificationEntity.getOldMaxPaces(), notificationEntity.getNewMaxPlaces()));

        if (notificationEntity.getNewDate() != null)
            eventNotification.setDate(new FieldChange<>(notificationEntity.getOldDate(), notificationEntity.getNewDate()));

        if (notificationEntity.getNewCost() != null)
            eventNotification.setCost(new FieldChange<>(notificationEntity.getOldCost(), notificationEntity.getNewCost()));

        if (notificationEntity.getNewDuration() != null)
            eventNotification.setDuration(new FieldChange<>(notificationEntity.getOldDuration(), notificationEntity.getNewDuration()));

        if (notificationEntity.getNewLocationId() != null)
            eventNotification.setLocationId(new FieldChange<>(notificationEntity.getOldLocationId(), notificationEntity.getNewLocationId()));

        if (notificationEntity.getNewEventStatus() != null)
            eventNotification.setStatus(new FieldChange<>(EventStatus.valueOf(notificationEntity.getOldEventStatus()), EventStatus.valueOf(notificationEntity.getNewEventStatus())));

        eventNotification.setEventId(notificationEntity.getId());
        eventNotification.setChangerId(notificationEntity.getChangerId());
        eventNotification.setOwnerId(notificationEntity.getOwnerId());
        eventNotification.setSubscribersLogins(notificationEntity.getSubscribersLogins());

        return eventNotification;
    }
}