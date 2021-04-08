<#macro soundcloud_beat trackid="1000319851" >
    <div>
        <iframe width="100%"
                height="136"
                scrolling="no"
                frameborder="no"
                allow="autoplay"
                src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/${trackid}&color=%231bc98f&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true">
        </iframe>
    </div>
</#macro>

<#macro soundcloud_beat_box track_id>
    <iframe width="180px"
            height="180px"
            scrolling="no"
            frameborder="no"
            allow="autoplay"
            src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/${track_id}&color=%231bc98f&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true"></iframe>
</#macro>

<#macro beat_card title tags trackid beatid>
    <div class="col-lg-4">
        <div class="card mb-4 box-shadow">
            <div class="card-body">
                <@soundcloud_beat_box track_id=trackid/>
                <h4 class="text-black-50 card-title mb-2">${title}</h4>
                <h7 class="text-muted card-subtitle mb-2">${tags}</h7>
                <a class="btn btn-primary"
                   type="button"
                   href="/beats/${beatid}"
                   role="button" style="width: 70%;margin-top: 16px;">details</a>
            </div>
        </div>
    </div>
</#macro>

<#macro favicon>
    <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
    <link rel="manifest" href="/site.webmanifest">
    <link rel="mask-icon" href="/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
</#macro>

<#macro logo>
    <img src="/assets/img/antee_logo.png" width="70px" height="70px">
</#macro>

<#macro footer>
    <section class="text-center content-section" id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 mx-auto"><h2>Contact me</h2>
                    <ul class="list-inline banner-social-buttons">
                        <li class="list-inline-item">&nbsp;
                            <a href="https://soundcloud.com/anteeone">
                                <button class="btn btn-primary btn-lg btn-default"
                                        type="button">
                                    <i class="fa fa-soundcloud fa-fw"></i><span class="network-name">&nbsp; scloud</span>
                                </button>
                            </a>

                        </li>
                        <li class="list-inline-item">&nbsp;
                            <a href="https://www.instagram.com/antee1ne/">
                                <button class="btn btn-primary btn-lg btn-default"
                                        type="button">
                                    <i class="fa fa-instagram fa-fw"></i><span class="network-name">&nbsp;insta</span>
                                </button>
                            </a>

                        </li>
                        <li class="list-inline-item">&nbsp;
                            <a href="mailto:anteeprod@gmail.com">
                                <button class="btn btn-primary btn-lg btn-default"
                                        type="button">
                                    <i class="fa fa-envelope-o fa-fw"></i><span class="network-name">&nbsp;email</span>
                                </button>
                            </a>

                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <div class="map-clean"></div>
    <footer>
        <div class="container text-center"><p>Copyright © Antee 2021</p></div>
    </footer>
</#macro>

<#macro navbar>
    <nav class="navbar navbar-light navbar-expand-md fixed-top" id="mainNav">
        <div class="container">
            <@logo/>
            <a class="navbar-brand js-scroll-trigger" href="/home">antee</a>
            <button data-toggle="collapse" class="navbar-toggler navbar-toggler-right" data-target="#navbarResponsive"
                    type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"
                    value="Menu"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item nav-link js-scroll-trigger"><a class="nav-link" href="/shop">shop</a></li>
                    <li class="nav-item nav-link js-scroll-trigger"><a class="nav-link" href="/beats">my beats</a></li>
                    <li class="nav-item nav-link js-scroll-trigger"><a class="nav-link" href="/chat">chat</a></li>
                    <li class="nav-item nav-link js-scroll-trigger">
                        <a class="btn btn-primary" role="button" type="button" href="/logout">sign out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</#macro>

<#macro navbar_index>
    <nav class="navbar navbar-light navbar-expand-md fixed-top" id="mainNav">
        <div class="container">
            <@logo/>
            <a class="navbar-brand js-scroll-trigger" href="">antee</a>
            <button data-toggle="collapse" class="navbar-toggler navbar-toggler-right" data-target="#navbarResponsive"
                    type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"
                    value="Menu"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item nav-link js-scroll-trigger"><a class="nav-link active js-scroll-trigger"
                                                                       href="#about">About</a></li>
                    <li class="nav-item nav-link js-scroll-trigger"><a class="nav-link js-scroll-trigger"
                                                                       href="#download">beats</a>
                    </li>
                    <li class="nav-item nav-link js-scroll-trigger"><a class="nav-link js-scroll-trigger"
                                                                       href="#contact">contact</a>
                    </li>
                    <li class="nav-item nav-link js-scroll-trigger"></li>
                    <li class="nav-item nav-link js-scroll-trigger">
                        <a class="btn btn-primary" type="button" role="button" href="/signin">SIGN IN/UP</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</#macro>

<#macro navbar_error>
    <nav class="navbar navbar-light navbar-expand-md fixed-top" id="mainNav">
        <div class="container">
            <@logo/>
            <a class="navbar-brand js-scroll-trigger" href="/home">antee</a>
            <button data-toggle="collapse" class="navbar-toggler navbar-toggler-right" data-target="#navbarResponsive"
                    type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"
                    value="Menu"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">

            </div>
        </div>
    </nav>
</#macro>