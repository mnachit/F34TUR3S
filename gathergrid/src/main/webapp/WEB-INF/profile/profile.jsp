<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>

<div class="container">
    <h2>Edit Profile</h2>
    
    <form action="updateProfileServlet" method="post">
        <!-- First Name -->
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="<c:out value='${user.firstName}' />" required>
        </div>
        
        <!-- Last Name -->
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="<c:out value='${user.lastName}' />" required>
        </div>
        
        <!-- Username -->
        <div class="form-group">
            <label for="userName">Username:</label>
            <input type="text" class="form-control" id="userName" name="userName" value="<c:out value='${user.userName}' />" required>
        </div>
        
        <!-- Email -->
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="<c:out value='${user.email}' />" required>
        </div>
        
        <!-- Password (You should handle this securely in your backend) -->
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Update Profile</button>
    </form>
</div>

<!-- Include Bootstrap JS and jQuery -->
<script src
