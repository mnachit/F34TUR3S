<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>

<div class="container">



    <c:choose>
        <c:when test="${successUpdationAccount}">
            <div class="message-container" style="height: 100px; overflow-y: auto;">

                <div class="alert alert-success" role="alert">
                    Account Updated Successfully
                </div>

            </div>

            <c:remove var="successUpdationAccount" scope="session"/>

        </c:when>

        <c:when test="${not empty errors}">
            <div class="error-container" style="height: 100px; overflow-y: auto;">
               <c:forEach var="error" items="${errors}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:forEach>
            </div>
            <c:remove var="errors" scope="session"/>
        </c:when>
    </c:choose>


    <h2>Edit Profile ssss</h2>
    
    <form action="profile" method="post">
        <!-- First Name -->
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="<c:out value='${user.name.firstName}' />" required>
        </div>
        
        <!-- Last Name -->
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="<c:out value='${user.name.lastName}' />" required>
        </div>
        
        <!-- Username -->
        <div class="form-group">
            <label for="userName">Username:</label>
            <input type="text" class="form-control" id="userName" name="userName" value="<c:out value='${user.name.userName}' />" required>
        </div>
        
        <!-- Email -->
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="<c:out value='${user.email.addressEmail}' />" required>
        </div>
        
        <!-- Password (You should handle this securely in your backend) -->
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
 
        <button type="submit" class="btn btn-primary">Update Profile</button>
    </form>

    <form action="changePassword" method="get">
        <button type="submit" class="btn btn-primary">Change Password</button>
    </form>

    
</div>


