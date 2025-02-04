package com.abbos.notification.service;

import com.abbos.notification.dto.NotificationResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aliabbos Ashurov
 * @since 21/January/2025  11:54
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    @Transactional
    @RabbitListener(queues = "notification.queue")
    public NotificationResponseDTO save(String message) {
        log.info("Message received: ::::::::: {} :::::::::", message);
        // Add debug logs or breakpoints to check the message and any processing logic.
        return new NotificationResponseDTO("id", message, -1L);
    }
}
