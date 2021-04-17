<!DOCTYPE html>
<html>
<#import "macro/ui.ftlh" as ui/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.home.css">
</head>
<body id="page-top">
<@ui.navbar/>
<header class="masthead" style="background-image: url('assets/img/beats.jpg');">
    <div class="intro-body">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mx-auto"><h1 class="brand-heading">HEY, ${user.email}</h1>
                    <p class="intro-text">${beatsCount} beats is available now for purchasing!<br>You have ${user.getBookingCount()} booked beats now!</p>
                </div>
            </div>
        </div>
    </div>
</header>
<section class="text-center content-section" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto"><h2>About shop</h2>
                <p>All my beats for you booking are available on <a
                            href="/shop">the shop page</a> , where you can find all detail information about purchasing</p>
                <p>On &nbsp<a href="/beats">the beats page</a>&nbsp; are located all you booked beats
                <p>Also , just for fun , you can click on "Random" button and it will be displayed a random musical genre for you :)</p>
        </div>
    </div>
</section>
<@ui.footer/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="assets/js/script.min.home.js"></script>
</body>
</html>