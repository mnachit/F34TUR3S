package com.gathergrid.helpers.user;

import com.gathergrid.entities.User;
import com.gathergrid.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserValidationHelper {

    private UserRepository userRepository;

    public UserValidationHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected boolean userNameAlreadyExists(String userName) {
        return userRepository.existsByUsername(userName);
    }

    protected boolean emailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void storeLoggedUserInSession(User user, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("LoggedUser", user);
    }

    protected User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    protected void addAccount(User user) {
        userRepository.save(user);
    }

    protected boolean noUserHasThisEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    protected boolean passwordsAreNotMatched(User givedUser, User fetchedUser) {

        String givedPassword = givedUser.getPassword().getPassword();

        String fetchedPassword = fetchedUser.getPassword().getPassword();

        return !givedPassword.equals(fetchedPassword);
    }
}
