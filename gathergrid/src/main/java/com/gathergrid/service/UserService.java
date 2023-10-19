package com.gathergrid.service;

import com.gathergrid.entities.User;
import com.gathergrid.helpers.user.UserValidationHelper;
import com.gathergrid.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

public class UserService extends UserValidationHelper {

    public UserService() {
        super(new UserRepository());
    }

    public void registerUser(User user) {

        validateUser(user);

        addAccount(user);
    }

    public void loginUser(User givenUser, HttpServletRequest request) {

        validateEmail(givenUser.getEmail());

        User fetchedUser = getUserByEmail(givenUser.getEmail().getAddressEmail());

        validatePassword(givenUser, fetchedUser);

        storeLoggedUserInSession(fetchedUser, request);

    }

}
