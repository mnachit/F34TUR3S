package com.gathergrid.helpers.user;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.gathergrid.embeddables.AddressEmail;
import com.gathergrid.entities.User;
import com.gathergrid.exceptions.costums.AlreadyExistsException;
import com.gathergrid.exceptions.costums.DoNotExistsException;
import com.gathergrid.exceptions.costums.NotMatchedException;
import com.gathergrid.exceptions.costums.ValidationException;
import com.gathergrid.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class UserValidationHelper {

    private UserRepository userRepository;
    private Validator validator;

    public UserValidationHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    protected User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    protected User getUserById(Long id) {
        return userRepository.findById(id);
    }

    protected void addAccount(User user) {
        userRepository.save(user);
    }

    protected void updateAccount(User user) {
        userRepository.update(user);
    }

    protected void storeLoggedUserInSession(User user, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("LoggedUser", user);
    }

    protected User getStoredLoggedUserFromSession(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("LoggedUser");
    }

    protected void validateEmail(AddressEmail addressEmail) {

        validateObject(addressEmail);

        if (noUserHasThisEmail(addressEmail.getAddressEmail())) {
            throw new DoNotExistsException("This Email Do Not Exist");
        }
    }

    protected void validateUser(User user) {

        validateObject(user);

        if (emailAlreadyExists(user.getEmail().getAddressEmail())) {
            throw new AlreadyExistsException("Email is already exists");
        }

        if (userNameAlreadyExists(user.getName().getUserName())) {
            throw new AlreadyExistsException("Username is already exists");
        }

    }

    protected void validatePassword(User givenUser, User fetchedUser) {

        validateObject(givenUser.getPassword());

        String givedPassword = givenUser.getPassword().getPassword();

        String fetchedPassword = fetchedUser.getPassword().getPassword();

        if (passwordsAreNotMatched(givedPassword, fetchedPassword)) {
            throw new NotMatchedException("Password Is Incorrect");
        }
    }

    protected <O> void validateObject(O object) {

        Set<ConstraintViolation<O>> violations = validator.validate(object);

        if (!violations.isEmpty()) {
            List<String> errors = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            throw new ValidationException(errors);
        }
    }

    protected boolean noUserHasThisEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    protected boolean passwordsAreNotMatched(String givedPassword, String fetchedPassword) {
        return !givedPassword.equals(fetchedPassword);
    }

    protected boolean userNameAlreadyExists(String userName) {
        return userRepository.existsByUsername(userName);
    }

    protected boolean emailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

}
