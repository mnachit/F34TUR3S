<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.css" rel="stylesheet" />
    <!-- MDB -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"></script>
</head>

<body>
<div class="container mt-4">
    <!-- Pills navs -->
    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
        <li class="nav-item" role="presentation">
            <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="#pills-login" role="tab"
               aria-controls="pills-login" aria-selected="true">Login</a>
        </li>
        <li class="nav-item" role="presentation">
            <a class="nav-link" id="tab-register" data-mdb-toggle="pill" href="#pills-register" role="tab"
               aria-controls="pills-register" aria-selected="false">Register</a>
        </li>
    </ul>
    <!-- Pills navs -->

    <!-- Pills content -->
    <div class="tab-content">
        <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
            <form>
                <!-- Email input -->
                <div class="form-outline mb-4">
                    <input type="email" id="loginName" class="form-control" />
                    <label class="form-label" for="loginName">Email or username</label>
                </div>
                <!-- Password input -->
                <div class="form-outline mb-4">
                    <input type="password" id="loginPassword" class="form-control" />
                    <label class="form-label" for="loginPassword">Password</label>
                </div>
                <!-- 2 column grid layout -->
                <div class="row mb-4">
                    <div class="col-md-6 d-flex justify-content-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-3 mb-md-0">
                            <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
                            <label class="form-check-label" for="loginCheck"> Remember me</label>
                        </div>
                    </div>
                    <div class="col-md-6 d-flex justify-content-center">
                        <!-- Simple link -->
                        <a href="#!">Forgot password?</a>
                    </div>
                </div>
                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
                <!-- Register buttons -->
                <div class="text-center">
                    <p>Not a member? <a href="#!">Register</a></p>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
            <form>
                <p class="text-center">or:</p>
                <!-- Name input -->
                <div class="form-outline mb-4">
                    <input type="text" id="registerName" class="form-control" name="Firstname" />
                    <label class="form-label" for "registerName">Firstname</label>
                </div>
                <div class="form-outline mb-4">
                    <input type="text" id="registerLastname" class="form-control" name="Lastname" />
                    <label class="form-label" for="registerName">Lastname</label>
                </div>
                <!-- Email input -->
                <div class="form-outline mb-4">
                    <input type="email" id="registerEmail" class="form-control" name="Email" />
                    <label class="form-label" for="registerEmail">Email</label>
                </div>
                <!-- Password input -->
                <div class="form-outline mb-4">
                    <input type="password" id="registerPassword" class="form-control" name="Password" />
                    <label class="form-label" for="registerPassword">Password</label>
                </div>
                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-3">Sign in</button>
            </form>
        </div>
    </div>
    <!-- Pills content -->
</div>
</body>

</html>