package com.gathergrid.service;

import com.gathergrid.entities.User;
import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.repository.UserRepository;

import jakarta.persistence.EntityExistsException;

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

        System.out.println(user.toString());
        if (!violations.isEmpty()) {

            System.out.println("In Validation");

            List<String> errors = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());

            errors.forEach(error -> System.out.println(error));

            throw new ValidationException(errors);
        }

        try {
            userRepository.saveUser(user);
        } catch (EntityExistsException e) {
            throw new EntityExistsException();
        }

    }

}
