package com.gathergrid.service;

import com.gathergrid.entities.User;
import com.gathergrid.exceptions.costums.AlreadyExistsException;
import com.gathergrid.exceptions.costums.DoNotExistsException;
import com.gathergrid.exceptions.costums.NotMatchedException;
import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.helpers.user.UserValidationHelper;
import com.gathergrid.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserService extends UserValidationHelper {

    private Validator validator;

    public UserService() {
        super(new UserRepository());
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

        if (emailAlreadyExists(user.getEmail().getAddressEmail())) {
            throw new AlreadyExistsException("Email is already exists");
        }

        if (userNameAlreadyExists(user.getName().getUserName())) {
            throw new AlreadyExistsException("Username is already exists");
        }

        addAccount(user);
    }

    public void loginUser(User givedUser, HttpServletRequest request) {

        if (noUserHasThisEmail(givedUser.getEmail().getAddressEmail())) {
            throw new DoNotExistsException("This Email Do Not Exist");
        }

        User fetchedUser = getUserByEmail(givedUser.getEmail().getAddressEmail());

        if (passwordsAreNotMatched(givedUser, fetchedUser)) {
            throw new NotMatchedException("Password Is Incorrect");
        }

        storeLoggedUserInSession(fetchedUser, request);

    }

}
