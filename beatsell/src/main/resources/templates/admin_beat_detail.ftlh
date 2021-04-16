<!DOCTYPE html>
<#import "macro/admin_ui.ftlh" as admin_ui/>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Table - Brand</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.admin.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/fontawesome5-overrides.min.css">
</head>

<body id="page-top">
<div id="wrapper">
    <@admin_ui.navbar/>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
            </nav>
            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="margin-top: 24px;">
                        <h1 class="text-center"></h1>
                        <form action="?savebeat" name="save_beat" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <div class="form-group"><label>Title </label>
                                <input name="title" class="form-control" type="text" placeholder="Title" value="${beat.title}">
                            </div>
                            <div class="form-group"><label>BPM</label>
                                <input name="bpm" class="form-control" type="number" placeholder="BPM" value="${beat.bpm}">
                            </div>
                            <div class="form-group">
                                <label>Mood </label>
                                <select class="form-control" name="mood" size="1">
                                    <option value="Chill">Chill</option>
                                    <option value="Dark">Dark</option>
                                    <option value="Sad">Sad</option>
                                    <option value="Party">Party</option>
                                    <option value="Angry">Angry</option>
                                    <option value="Emotional">Emotional</option>
                                    <option value="Soulful">Soulful</option>
                                    <option value="Happy">Happy</option>
                                </select>
                            </div>
                            <div class="form-group"><label>SoundCloud ID</label><input name="soundCloudId"
                                                                                       class="form-control"
                                                                                       value="${beat.soundCloudId}"
                                                                                       type="number" placeholder="ID">
                            </div>
                            <div class="form-group">
                                <label>State </label>
                                <select class="form-control" name="state" size="1">
                                    <option value="FREE">Free</option>
                                    <option value="SOLD">Sold</option>
                                </select>
                            </div>
                            <div class="form-group"><label>Tags </label><input name="tags" class="form-control"
                                                                               type="text" placeholder="Tags"
                                                                               value="${beat.tags}"     ></div>
                            <div class="form-group">
                                <label>Licenses </label>
                                <select class="form-control" name="licenses" size="0" multiple="multiple">
                                    <#list licensesList as license>
                                        <option value="${license.id}">${license.title}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-dark" type="submit">Save</button>
                            </div>
                        </form>

                            <form action="?deletebeat" name="delete_beat" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <button class="btn btn-danger" type="submit">Delete</button>
                            </form>

                            <p></p>

                            <#if _beatFlag??>
                                <div class="alert alert-danger">
                                    Invalid data!
                                </div>
                            </#if>
                            <#if beatFlag??>
                                <div class="alert alert-success">
                                    Beat has been added!
                                </div>
                            </#if>
                    </div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Antee 2021</span></div>
            </div>
        </footer>
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="/assets/js/script.min.admin.js"></script>
</body>

</html>