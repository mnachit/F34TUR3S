package com.gathergrid.helpers.user;

import com.gathergrid.entities.User;
import com.gathergrid.repository.UserRepository;

public class UserValidationHelper {

    private UserRepository userRepository;

    public UserValidationHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userNameAlreadyExists(String userName) {
        return userRepository.existsByUsername(userName);
    }

    public boolean emailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean noUserHasThisEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    public boolean passwordsAreNotMatched(User givedUser, User fetchedUser) {

        String givedPassword = givedUser.getPassword().getPassword();

        String fetchedPassword = fetchedUser.getPassword().getPassword();

        return !givedPassword.equals(fetchedPassword);
    }
}
