package school.sorokin.notificationmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sorokin.notificationmanager.dto.NotificationDto;
import school.sorokin.notificationmanager.dto.NotificationsIdDto;
import school.sorokin.notificationmanager.mapper.NotificationDtoMapper;
import school.sorokin.notificationmanager.security.jwt.JwtTokenManager;
import school.sorokin.notificationmanager.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationDtoMapper notificationDtoMapper;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping
    public ResponseEntity<Void> markAsRead(@RequestBody NotificationsIdDto notificationsIdDto) {
        notificationService.markAsRead(notificationsIdDto.notificationIds());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> getAllUnreadNotifications(
            @RequestHeader("Authorization") String auth
    ) {
        String jwt = auth.substring(7);
        String login = jwtTokenManager.getLoginFromToken(jwt);
        return ResponseEntity.ok()
                .body(notificationService.getAllUnreadNotifications(login)
                        .stream()
                        .map(notificationDtoMapper::toDto)
                        .toList());
    }
}
