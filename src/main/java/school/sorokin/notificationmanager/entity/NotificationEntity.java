package school.sorokin.notificationmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "changer_id")
    private Long changerId;
    @Column(name = "owner_id")
    private Long ownerId;

    @ElementCollection
    private List<String> subscribersLogins;

    @Column(name = "old_name")
    private String oldName;
    @Column(name = "new_name")
    private String newName;
    @Column(name = "old_max_places")
    private Integer oldMaxPaces;
    @Column(name = "new_max_places")
    private Integer newMaxPlaces;

    @Column(name = "old_date")
    private LocalDateTime oldDate;
    @Column(name = "new_date")
    private LocalDateTime newDate;
    @Column(name = "old_cost")
    private Integer oldCost;
    @Column(name = "new_cost")
    private Integer newCost;
    @Column(name = "old_duration")
    private Integer oldDuration;
    @Column(name = "new_duration")
    private Integer newDuration;
    @Column(name = "old_location_id")
    private Long oldLocationId;
    @Column(name = "new_location_id")
    private Long newLocationId;
    @Column(name = "old_event_status")
    private String oldEventStatus;
    @Column(name = "new_event_status")
    private String newEventStatus;

    @Column(name = "is_read")
    private Boolean isRead;
}
