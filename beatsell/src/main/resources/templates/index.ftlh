<!DOCTYPE html>
<#import "macro/ui.ftlh" as ui/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Antee Beats</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.index.css">
    <@ui.favicon/>

</head>
<body id="page-top">
<@ui.navbar_index/>
<header class="masthead" style="background-image: url('assets/img/ableton.jpg');">
    <div class="intro-body">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mx-auto"><h1 class="brand-heading">antee prod.</h1>
                    <p class="intro-text">Different beat variations for you .<br>Created with soul.<br>Created with
                        love.</p><a class="btn btn-link btn-circle" role="button" href="#about"><i
                                class="fa fa-angle-double-down animated"></i></a></div>
            </div>
        </div>
    </div>
</header>
<section class="text-center content-section" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto"><h2>About me</h2>
                <p>Grayscale includes full HTML, CSS, and custom JavaScript files along with SASS and LESS files for
                    easy customization!</p></div>
        </div>
    </div>
</section>
<section class="text-center download-section content-section" id="download"
         style="background-image: url('assets/img/beats.jpg');">
    <div class="container">
        <div class="col-lg-8 mx-auto"><h1>some of beats</h1>
        <@ui.soundcloud_beat trackid="993863203"/>
        <@ui.soundcloud_beat trackid="993863203"/>
        <@ui.soundcloud_beat trackid="993863203"/>
    </div>
    <div class="container">
        <div class="intro"></div>
    </div>
</section>
<@ui.footer/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="assets/js/script.min.index.js"></script>
</body>
</html>