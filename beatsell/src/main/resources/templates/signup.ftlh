<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.auth.css">
</head>
<body>
<section class="login-dark">
    <form method="post" action="/signup"><h2 class="sr-only">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
        <div class="form-group">
            <input class="form-control ${(emailError??)?string('is-invalid','')}" type="email" name="email" placeholder="Email">
            <#if emailError??>
                <div class="invalid-feedback">
                    ${emailError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input class="form-control ${(passwordError??)?string('is-invalid','')}" type="password" name="password" placeholder="Password">
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input class="form-control ${(passwordMatchError?? || usernameError??)?string('is-invalid','')}" type="password" name="password2"
                                       placeholder="Repeat password">
            <#if passwordMatchError??>
                <div class="invalid-feedback">
                    ${passwordMatchError}
                </div>
            </#if>
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
        </div>

        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Register</button>
        </div>
        <a class="forgot" href="#">Already have an account?</a></form>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>