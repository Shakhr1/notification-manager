package school.sorokin.notificationmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "notifications")
@Data
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Long changerId;
    private Long ownerId;

    @ElementCollection
    private List<String> subscribersLogins;

    private String oldName;
    private String newName;
    private Integer oldMaxPaces;
    private Integer newMaxPlaces;

    private LocalDateTime oldDate;
    private LocalDateTime newDate;
    private Integer oldCost;
    private Integer newCost;
    private Integer oldDuration;
    private Integer newDuration;
    private Long oldLocationId;
    private Long newLocationId;
    private String oldEventStatus;
    private String newEventStatus;

    private Boolean isRead;
}
