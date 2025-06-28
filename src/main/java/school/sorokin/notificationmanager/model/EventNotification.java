package school.sorokin.notificationmanager.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventNotification {
    private Long eventId;
    private Long changerId;
    private Long ownerId;
    private List<String> subscribersLogins;

    FieldChange<String> name;
    FieldChange<Integer> maxPlaces;
    FieldChange<LocalDateTime> date;
    FieldChange<Integer> cost;
    FieldChange<Integer> duration;
    FieldChange<Long> locationId;
    FieldChange<EventStatus> status;
}
