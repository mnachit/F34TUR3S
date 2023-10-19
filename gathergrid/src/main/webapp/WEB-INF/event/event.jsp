<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mnachit
  Date: 2023/10/16
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">


    <title>bs4 crud users - Bootdey.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            margin-top: 20px;
            background: #f8f8f8
        }
    </style>
    <jsp:include page="../util/taglibs.jsp" />
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<jsp:include page="../util/nav.jsp" />
<main id="main" class="flexbox-col">
<div class="container">
    <div class="row flex-lg-nowrap">
        <div class="col-12 col-lg-auto mb-3" style="width: 200px;">
        </div>
    </div>
</div>
<div class="col">
    <div class="row flex-lg-nowrap">
        <div class="col mb-3">
            <div class="e-panel card">
                <div class="card-header">
                    <h6 class="mr-2"><span>Event : </span><small class="px-1">${event.name}</small></h6>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <p><strong>Category:</strong> ${event.categorie.name}</p>
                            <p><strong>Date:</strong> ${event.date}</p>
                            <p><strong>Time:</strong> ${event.time}</p>
                            <p><strong>Location:</strong> ${event.location}</p>
                        </div>
                        <div class="col-sm-8">
                            <p><strong>Basic Price:</strong> ${event.basic_price}</p>
                            <p><strong>Regular Price:</strong> ${event.regular_price}</p>
                            <p><strong>Vip Price:</strong> ${event.vip_price}</p>
                            <p><strong>Vip Price:</strong> ${event.vip_price}</p>

                        </div>
                    </div>
                    <p><strong>Description:</strong> ${event.description}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row d-flex justify-content-left">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-0 border" style="background-color: #f0f2f5;">
                <c:forEach items="${event.comments}" var="comment">
                <div class="card-body p-2">
                    <div class="card mb-2">
                        <div class="card-body">
                            <p>${comment.text}</p>
                            <div class="d-flex justify-content-between">
                                <div class="d-flex flex-row align-items-center">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(4).webp"
                                         alt="avatar" width="25" height="25" />
                                    <p class="small mb-0 ms-2" style="margin-left: 0.2cm;">${comment.user.name}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</main>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

</script>
</body>

</html>
