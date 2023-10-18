package com.gathergrid.service;

import com.gathergrid.entities.User;
import com.gathergrid.exceptions.costums.AlreadyExistsException;
import com.gathergrid.exceptions.costums.DoNotExistsException;
import com.gathergrid.exceptions.costums.NotMatchedException;
import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.repository.UserRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserService {

    private UserRepository userRepository;
    private Validator validator;

    public UserService() {
        this.userRepository = new UserRepository();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public void registerUser(User user) {

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            List<String> errors = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());

            throw new ValidationException(errors);
        }

        if (userRepository.existsByEmail(user.getEmail().getAddressEmail())) {
            throw new AlreadyExistsException("Email is already exists");
        }

        if (userRepository.existsByUsername(user.getName().getUserName())) {
            throw new AlreadyExistsException("Username is already exists");
        }

        userRepository.save(user);
    }

    public void loginUser(User givedUser) {

        if (noUserHasThisEmail(givedUser.getEmail().getAddressEmail())) {
            throw new DoNotExistsException("This Email Do Not Exist");
        }

        User fetchedUser = getUserByEmail(givedUser.getEmail().getAddressEmail());

        if (passwordsAreNotMatched(givedUser, fetchedUser)) {
            throw new NotMatchedException("Password Is Incorrect");
        }

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
