<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>

<div class="container">



    <c:choose>
        <c:when test="${successChangingPassword}">
            <div class="message-container" style="height: 100px; overflow-y: auto;">

                <div class="alert alert-success" role="alert">
                    Password Has Been Changed Successfully
                </div>

            </div>

            <c:remove var="successChangingPassword" scope="session"/>

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


    <h2>Changing Password</h2>
    
    <form action="changePassword" method="post">
        
        
        <!-- Current Password -->
        <div class="form-group">
            <label for="current-password">Current Password:</label>
            <input type="password" class="form-control" id="current-password" name="current-password" required>
        </div>
        
        <!-- New Password -->
        <div class="form-group">
            <label for="new-password">New Password:</label>
            <input type="password" class="form-control" id="new-password" name="new-password" required>
        </div>
        
        <!-- Repeat New Password -->
        <div class="form-group">
            <label for="repeat-new-password">Repeat New Password:</label>
            <input type="password" class="form-control" id="repeat-new-password" name="repeat-new-password" required>
        </div>
 
        <button type="submit" class="btn btn-primary">Update Profile</button>
    </form>
 
</div>


