package com.gathergrid.service;

import com.gathergrid.entities.User;
import com.gathergrid.exceptions.costums.AlreadyExistsException;
import com.gathergrid.exceptions.costums.DoNotExistsException;
import com.gathergrid.exceptions.costums.NotMatchedException;
import com.gathergrid.helpers.user.UserValidationHelper;
import com.gathergrid.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

public class UserService extends UserValidationHelper {

    public UserService() {
        super(new UserRepository());
    }

    public void registerUser(User user) {

        validateObject(user);

        if (emailAlreadyExists(user.getEmail().getAddressEmail())) {
            throw new AlreadyExistsException("Email is already exists");
        }

        if (userNameAlreadyExists(user.getName().getUserName())) {
            throw new AlreadyExistsException("Username is already exists");
        }

        addAccount(user);
    }

    public void loginUser(User givenUser, HttpServletRequest request) {

        validateObject(givenUser.getEmail());

        if (noUserHasThisEmail(givenUser.getEmail().getAddressEmail())) {
            throw new DoNotExistsException("This Email Do Not Exist");
        }

        validateObject(givenUser.getPassword());

        User fetchedUser = getUserByEmail(givenUser.getEmail().getAddressEmail());

        if (passwordsAreNotMatched(givenUser, fetchedUser)) {
            throw new NotMatchedException("Password Is Incorrect");
        }

        storeLoggedUserInSession(fetchedUser, request);

    }

}
