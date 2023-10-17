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


  <title>bs4 crud users - Bootdey.com</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
    body {
      margin-top: 20px;
      background: #f8f8f8
    }
  </style>
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
  <div class="row flex-lg-nowrap">
    <div class="col-12 col-lg-auto mb-3" style="width: 200px;">
    </div>
  </div>
</div>
<div class="col">
  <div class="e-tabs mb-3 px-3">
    <ul class="nav nav-tabs">
      <li class="nav-item"><a class="nav-link active" href="#">
        <div class="input-group rounded">
          <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                 aria-describedby="search-addon" />
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
                  <th class="align-top">
                    <div
                            class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0">
                      <input type="checkbox" class="custom-control-input" id="all-items">
                      <label class="custom-control-label" for="all-items"></label>
                    </div>
                  </th>
                  <th>nom</th>
                  <th class="max-width">date</th>
                  <th class="sortable">lieu</th>
                  <th>Catégorie</th>
                  <th>description</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td class="align-middle">
                    <div
                            class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0 align-top">
                      <input type="checkbox" class="custom-control-input" id="item-1">
                      <label class="custom-control-label" for="item-1"></label>
                    </div>
                  </td>
                  <td class="align-middle text-center">
                    Adam Cotter
                  </td>
                  <td class="text-nowrap align-middle">09 Dec 2017</td>
                  <td class="text-nowrap align-middle"><span>sss</span></td>
                  <td class="text-center align-middle">
                    <div class="btn-group align-top">
                      hhhhhh
                    </div>
                  </td>
                  <td class="text-center align-middle">
                    <div class="btn-group align-top">
                      <h1>jjj</h1>
                    </div>
                  </td>
                  <td class="text-center align-middle">
                    <div class="btn">
                      <button class="btn btn-sm btn-outline-secondary badge"
                              type="button">
                        <a href="show_details.html">afficher les détails</a>
                      </button>
                    </div>
                  </td>

                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="row flex-lg-nowrap">
    <div class="col mb-3">
      <div class="e-panel card">
        <div class="card-body">
          <div class="card-title">
            <h6 class="mr-2"><span>Événements réservés</span><small class="px-1"></small></h6>
          </div>
          <div class="e-table">
            <div class="table-responsive table-lg mt-3">
              <table class="table table-bordered">
                <thead>
                <tr>
                  <th class="align-top">
                    <div
                            class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0">
                      <input type="checkbox" class="custom-control-input" id="all-items">
                      <label class="custom-control-label" for="all-items"></label>
                    </div>
                  </th>
                  <th>nom</th>
                  <th class="max-width">date</th>
                  <th class="sortable">lieu</th>
                  <th>Catégorie</th>
                  <th>description</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td class="align-middle">
                    <div
                            class="custom-control custom-control-inline custom-checkbox custom-control-nameless m-0 align-top">
                      <input type="checkbox" class="custom-control-input" id="item-1">
                      <label class="custom-control-label" for="item-1"></label>
                    </div>
                  </td>
                  <td class="align-middle text-center">
                    Adam Cotter
                  </td>
                  <td class="text-nowrap align-middle">09 Dec 2017</td>
                  <td class="text-nowrap align-middle"><span>sss</span></td>
                  <td class="text-center align-middle">
                    <div class="btn-group align-top">
                      hhhhhh
                    </div>
                  </td>
                  <td class="text-center align-middle">
                    <div class="btn-group align-top">
                      <h1>jjj</h1>
                    </div>
                  </td>

                </tr>
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
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

</script>
</body>

</html>
