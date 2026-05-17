package com.apoio.apoio_api.dto.user;

import com.apoio.apoio_api.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

// Outgoing data returned to the user or client
public record UserResponse(
    UUID id,
    String name,
    String username,
    String email,
    String phone,
    String profession,
    LocalDate birthDate,
    String role,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getUsername(),
            user.getEmail(),
            user.getPhone(),
            user.getProfession(),
            user.getBirthDate(),
            user.getRole(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
    }
}
