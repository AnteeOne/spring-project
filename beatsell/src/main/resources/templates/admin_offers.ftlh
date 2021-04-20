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
            <div class="container-fluid">
                <h3 class="text-dark mb-4">Offers</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Offers Info</p>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive table mt-2" id="dataTable" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0" id="dataTable">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list offersList as offer>
                                    <tr class="active">
                                        <td>${offer.id}</td>
                                        <td>${offer.title}</td>
                                        <td>${offer.description}</td>
                                        <form action="/admin/offers/${offer.id}?deleteoffer" method="post">
                                        <td>
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                            <button type="submit" class="btn btn-danger">Delete</button>
                                        </td>
                                        </form>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="margin-top: 24px;">
                        <h1 class="text-center">Add Offer</h1>
                        <form action="/admin/offers?saveoffer" name="save_offer" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                            <div class="form-group"><label>Title</label>
                                <input name="title" class="form-control"
                                       type="text" placeholder="Title">
                            </div>

                            <div class="form-group"><label>Description</label>
                                <input name="description" class="form-control"
                                       type="text" placeholder="Description">
                            </div>

                            <div class="form-group">
                                <button class="btn btn-dark" type="submit">Save</button>
                            </div>

                            <#if _descriptionFlag??>
                                <div class="alert alert-danger">
                                    Invalid data!
                                </div>
                            </#if>
                            <#if descriptionFlag??>
                                <div class="alert alert-success">
                                    Offer has been added!
                                </div>
                            </#if>

                        </form>
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