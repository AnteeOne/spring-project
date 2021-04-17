<!DOCTYPE html>
<#import "macro/ui.ftlh" as ui/>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Shop</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.shop.css">
</head>

<body id="page-top">
<@ui.navbar/>
<section class="text-center content-section" id="about" style="background: url(assets/img/shop.png);">
    <div class="caption v-middle text-center">
        <h1 class="cd-headline clip">
            <span class="blc"></span>
            <span class="cd-words-wrapper">
			              <b class="is-visible">Beats</b>
			              <b>Shop</b>
			              <b>For You</b>
			            </span>
        </h1>
    </div>
    <section></section>
    <div class="mouse-scroll-container">
        <div class="mouse-scroll loading-spinner">
            <div class="one"></div>
            <div class="two"></div>
            <div class="three"></div>
        </div>
    </div>
</section>
<div class="map-clean"></div>
<section class="text-center content-section" id="contact">
    <h1>beats</h1>
    <@ui.pager url page/>
    <div class="container">
        <div class="row" style="padding-left: 64px;padding-right: 64px;">
            <#list page.content as beat>
                <@ui.beat_card title="${beat.title}" tags="${beat.tags}" trackid="${beat.soundCloudId}" beatid="${beat.id}"/>
            </#list>
        </div>
    </div>
</section>
<@ui.footer/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="assets/js/script.min.shop.js"></script>
</body>

</html>