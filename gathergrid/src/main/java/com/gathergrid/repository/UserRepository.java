package com.gathergrid.repository;

import java.util.List;

import com.gathergrid.entities.User;

public class UserRepository extends BaseRepository<User> {

    public User findByEmail(String email) {
        return findBy(User.class, "email.addressEmail", email);
    }

    public User findById(String email) {
        return findBy(User.class, "id", email);
    }

    public boolean existsByEmail(String email) {
        return existsByField(User.class, "email.addressEmail", email);
    }

    public boolean existsByUsername(String username) {
        return existsByField(User.class, "name.userName", username);
    }

}
