package com.abbos.user.service;

import com.abbos.user.client.NotificationClient;
import com.abbos.user.config.RabbitMQConfig;
import com.abbos.user.dto.UserCreateDTO;
import com.abbos.user.dto.UserResponseDTO;
import com.abbos.user.entity.User;
import com.abbos.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aliabbos Ashurov
 * @since 21/January/2025  11:31
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final NotificationClient notificationClient;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public UserResponseDTO save(UserCreateDTO dto) {
        final var userNew = new User().toBuilder()
                .username(dto.username())
                .fullName(dto.fullName())
                .email(dto.email())
                .password(dto.password())
                .build();

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.NOTIFICATION_EXCHANGE,
                RabbitMQConfig.NOTIFICATION_ROUTING_KEY,
                "Hello from rabbit template"
        );

        log.info("Message sent successfully");
        return new UserResponseDTO(userNew.getId(), userNew.getFullName(), userNew.getUsername(), userNew.getEmail());
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new UserResponseDTO(user.getId(), user.getFullName(), user.getUsername(), user.getEmail());
    }
}
