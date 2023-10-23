package com.gathergrid.service;

import com.gathergrid.embeddables.Password;
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

    public void updateProfile(User givenUser, HttpServletRequest request) {

        validateUserOnUpdate(givenUser, request);

        User fetchedUser = getUserById(getStoredLoggedUserFromSession(request).getId());

        validatePassword(givenUser, fetchedUser);

        User updatedUser = updateAccount(givenUser, request);

        updateLoggedUserInSession(updatedUser, request);
    }

    public void changePassword(String currentPassword, String newPassword, String repeatNewPassword,
            HttpServletRequest request) {

        User user = getUserById(getStoredLoggedUserFromSession(request).getId());

        validatePasswords(user.getPassword().getPassword(), currentPassword, newPassword, repeatNewPassword);

        user.setPassword(new Password(newPassword));

        updateAccount(user, request);
    }

    public void logoutUser(HttpServletRequest request) {
        request.getSession().removeAttribute("LoggedUser");
    }

}
