package school.sorokin.notificationmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        NotificationEntity that = (NotificationEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
