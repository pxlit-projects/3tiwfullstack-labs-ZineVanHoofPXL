package be.pxl.services.controller;

import be.pxl.services.domain.Notification;
import be.pxl.services.service.INotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final INotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> addNotification(@RequestBody Notification notification) {
        notificationService.addNotification(notification);
        return ResponseEntity.created(URI.create("/notification")).build();
    }
}
