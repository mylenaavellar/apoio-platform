package com.apoio.apoio_api.dto.user;

import com.apoio.apoio_api.entity.User;

import java.time.LocalDate;
import java.util.UUID;

// Incoming data used for entity creation or update
public record UserRequest(
    String name,
    String username,
    String password,
    String email,
    String phone,
    String profession,
    LocalDate birthDate,
    String role
) {
    public User toEntity() {
        User user = new User();
        user.setName(this.name());
        user.setUsername(this.username());
        user.setPassword(this.password());
        user.setEmail(this.email());
        user.setPhone(this.phone());
        user.setProfession(this.profession());
        user.setBirthDate(this.birthDate());
        user.setRole(this.role());

        return user;
    }

    public void toEntityUpdate(User userFromDb) {
        userFromDb.setName(this.name());
        userFromDb.setPhone(this.phone());
        userFromDb.setProfession(this.profession());
    }
}
