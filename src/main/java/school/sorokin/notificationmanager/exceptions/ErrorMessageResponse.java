package school.sorokin.notificationmanager.exceptions;

import java.time.LocalDateTime;

public record ErrorMessageResponse(
        String message,
        String detailedMessage,
        LocalDateTime timestamp
) {
}
