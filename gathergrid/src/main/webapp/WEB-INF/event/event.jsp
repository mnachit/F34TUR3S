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
<jsp:include page="../util/taglibs.jsp" />
<main id="main" class="flexbox-col">
<div class="container">
    <div class="row flex-lg-nowrap">
        <div class="col-12 col-lg-auto mb-3" style="width: 200px;">
        </div>
    </div>
</div>
<div class="col">
    <div class="e-tabs mb-3 px-3">
        <ul class="nav nav-tabs">
            <li class="nav-item"><a class="nav-link active" href="#">Evenements</a></li>
        </ul>
    </div>

    <div class="row flex-lg-nowrap">
        <div class="col mb-3">
            <div class="e-panel card">
                <div class="card-body">
                    <div class="card-title">
                        <h6 class="mr-2"><span>Evenements</span><small class="px-1">....</small></h6>
                    </div>
                    <div class="e-table">
                        <div class="table-responsive table-lg mt-3">
                            <table class="table table-bordered">
                                <thead>
                                <tr>

                                    <th>nom</th>
                                    <th class="max-width">date</th>
                                    <th class="sortable">lieu</th>
                                    <th>Catégorie</th>
                                    <th>description</th>
                                    <th>reserve</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${events}" var="Event">
                                    <tr>

                                        <td class="align-middle text-center">
                                                ${Event.name}
                                        </td>
                                        <td class="text-nowrap align-middle">${Event.date}</td>
                                        <td class="text-nowrap align-middle"><span><c:out value="${ Event.location}"></c:out></span></td>
                                        <td class="text-center align-middle">
                                            <div class="btn-group align-top">
                                                    ${Event.categorie.name}
                                            </div>
                                        </td>
                                        <td class="text-center align-middle">
                                            <div class="btn-group align-top">
                                                ${Event.description}
                                            </div>
                                        </td>
                                        <td class="text-center align-middle">
                                            <div class="btn-group align-top">
                                                <button class="btn btn-sm btn-outline-secondary badge" type="button"
                                                        data-toggle="modal" data-target="#user-form-modal">confirmation de réservation</button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-0 border" style="background-color: #f0f2f5;">
                <div class="card-body p-4">

                    <div class="card mb-4">
                        <div class="card-body">
                            <p>Type your note, and hit enter to add it</p>

                            <div class="d-flex justify-content-between">
                                <div class="d-flex flex-row align-items-center">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(4).webp"
                                         alt="avatar" width="25" height="25" />
                                    <p class="small mb-0 ms-2" style="margin-left: 0.2cm;">Martha</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body">
                            <p>Type your note, and hit enter to add it</p>

                            <div class="d-flex justify-content-between">
                                <div class="d-flex flex-row align-items-center">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(4).webp"
                                         alt="avatar" width="25" height="25" />
                                    <p class="small mb-0 ms-2" style="margin-left: 0.2cm;">Martha</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body">
                            <p>Type your note, and hit enter to add it</p>

                            <div class="d-flex justify-content-between">
                                <div class="d-flex flex-row align-items-center">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(4).webp"
                                         alt="avatar" width="25" height="25" />
                                    <p class="small mb-0 ms-2" style="margin-left: 0.2cm;">Martha</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
