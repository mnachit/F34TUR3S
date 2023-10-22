package com.gathergrid.repository;

import com.gathergrid.entities.User;

public class UserRepository extends BaseRepository<User> {

    public User findByEmail(String email) {
        return findBy(User.class, "email.addressEmail", email);
    }

    public User findById(Long id) {
        return findBy(User.class, "id", id);
    }

    public boolean existsByEmail(String email) {
        return existsByField(User.class, "email.addressEmail", email);
    }

    public boolean existsByUsername(String username) {
        return existsByField(User.class, "name.userName", username);
    }

}
