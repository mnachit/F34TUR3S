<%--
  Created by IntelliJ IDEA.
  User: mnachit
  Date: 2023/10/16
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">


    <title>GatherGrid</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            margin-top: 20px;
            background: #f8f8f8
        }



    </style>
    <jsp:include page="./WEB-INF/util/taglibs.jsp" />
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<!-- Navbar -->
<jsp:include page="WEB-INF/util/nav.jsp" />
<!-- Main -->
<main id="main" class="flexbox-col">
    <div class="col">
        <div class="e-tabs mb-3 px-3">
            <ul class="nav nav-tabs">
                <li class="nav-item"><a class="nav-link active" href="#">
                    <div class="input-group rounded">
                        <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                               aria-describedby="search-addon" />
                        <button type="button" class="btn btn-black bg-black ms-2 "><i class="bi bi-binoculars"></i></button>
                    </div>
                </a></li>
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
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${events}" var="event">
                                        <tr>

                                            <td class="align-middle text-center">
                                                    ${event.name}
                                            </td>
                                            <td class="text-nowrap align-middle">${event.date}</td>
                                            <td class="text-nowrap align-middle"><span><c:out value="${ event.location}"></c:out></span></td>
                                            <td class="text-center align-middle">
                                                <div class="btn-group align-top">
                                                        ${event.categorie.name}
                                                </div>
                                            </td>
                                            <td class="text-center align-middle">
                                                <div class="btn-group align-top">
                                                        ${event.description}
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
