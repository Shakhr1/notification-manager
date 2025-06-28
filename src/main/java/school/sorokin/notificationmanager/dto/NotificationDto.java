package school.sorokin.notificationmanager.dto;

import school.sorokin.notificationmanager.model.FieldChange;

import java.time.LocalDateTime;

public record NotificationDto(
        Long eventId,
        FieldChange<String> name,
        FieldChange<Integer> maxPlaces,
        FieldChange<LocalDateTime> date,
        FieldChange<Integer> cost,
        FieldChange<Integer> duration,
        FieldChange<Long> locationId,
        FieldChange<String> status
){
}
