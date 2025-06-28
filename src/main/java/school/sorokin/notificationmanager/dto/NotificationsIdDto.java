package school.sorokin.notificationmanager.dto;

import java.util.List;

public record NotificationsIdDto(
        List<Long> notificationIds
) {
}