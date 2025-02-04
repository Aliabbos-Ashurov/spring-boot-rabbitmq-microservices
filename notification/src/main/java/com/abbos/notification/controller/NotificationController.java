package com.abbos.notification.controller;

import com.abbos.notification.dto.NotificationCreateDTO;
import com.abbos.notification.dto.NotificationResponseDTO;
import com.abbos.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 21/January/2025  11:58
 **/
@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/save")
    public ResponseEntity<NotificationResponseDTO> save(@RequestBody NotificationCreateDTO dto) {
        return ResponseEntity.ok(notificationService.save("Hi"));
    }
}
