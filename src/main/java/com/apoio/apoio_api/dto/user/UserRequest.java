package com.apoio.apoio_api.dto.user;

import com.apoio.apoio_api.entity.User;

import java.time.LocalDate;
import java.util.UUID;

// Incoming data used for entity creation or update
public record UserRequest(
    String name,
    String email,
    String password,
    String phone,
    String profession,
    LocalDate birthDate,
    String role
) {
    public User toEntity() {
        User user = new User();
        user.setName(name());
        user.setEmail(email());
        user.setPassword(password());
        user.setPhone(phone());
        user.setProfession(profession());
        user.setBirthDate(birthDate());
        user.setRole(role());

        return user;
    }

    public void toEntityUpdate(User userFromDb) {
        userFromDb.setName(name());
        userFromDb.setPhone(phone());
        userFromDb.setProfession(profession());
    }
}
