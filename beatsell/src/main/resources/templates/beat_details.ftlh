<!DOCTYPE html>
<#import "macro/ui.ftlh" as ui/>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Details</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cabin:700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/styles.min.details.css">
</head>

<body id="page-top">
<@ui.navbar/>
<section class="text-center content-section" id="about" style="background: url(/assets/img/shop.png);">
    <#if beat??>
        <h1>${beat.title}</h1>
        <div>

            <div style="margin-left: 30px;margin-right: 30px">
                <@ui.soundcloud_beat trackid="${beat.soundCloudId}"/>
            </div>

            <div class="block-heading" style="padding-top: 15px;">
                <div class="row justify-content-center" style="margin: 12px;">
                    <div class="col-sm-6 col-lg-5" style="padding-right: 0px;padding-left: 0px;padding: 36px;">
                        <div class="card clean-card text-center">
                            <div class="card-body info">
                                <div class="row" style="height: 30px;margin: 12px;">
                                    <div class="col" style="padding-bottom: 6px;">
                                        <p style="color: rgb(0,0,0);">BPM</p>
                                    </div>
                                    <div class="col">
                                        <p style="color: rgb(0,0,0);">${beat.bpm}</p>
                                    </div>
                                </div>
                                <div class="row" style="height: 30px;margin: 12px;">
                                    <div class="col" style="padding-bottom: 6px;">
                                        <p style="color: rgb(0,0,0);">Mood</p>
                                    </div>
                                    <div class="col">
                                        <p style="color: rgb(0,0,0);">${beat.mood}</p>
                                    </div>
                                </div>
                                <div class="row" style="height: 30px;margin: 12px;">
                                    <div class="col" style="padding-bottom: 6px;">
                                        <p style="color: rgb(0,0,0);">Booked</p>
                                    </div>
                                    <div class="col">
                                        <p style="color: rgb(0,0,0);">${bookingCount} times</p>
                                    </div>
                                </div>
                                <#list beat.licenses as license>
                                    <div class="row" style="height: 30px;margin: 12px;">
                                        <div class="col" style="padding-bottom: 6px;">
                                            <p style="color: rgb(0,0,0);">${license.trackFile}</p>
                                        </div>
                                        <div class="col">
                                            <p style="color: rgb(0,0,0);">${license.price}$</p>
                                        </div>
                                    </div>
                                </#list>
                            </div>

                        </div>
                            <#if bookingStatus>
                                <a href="/beats/unbook/${beat.id}" class="btn btn-danger" type="button\" style="margin-top: 32px;">unbook</a>
                            <#else>
                                <a href="/beats/book/${beat.id}" class="btn btn-primary" type="button" style="margin-top: 32px;">book</a>
                            </#if>
                    </div>
                </div>
            </div>
        </div>
    </#if>
</section>
<div class="map-clean"></div>
<@ui.footer/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="/assets/js/script.min.details.js"></script>
</body>

</html>