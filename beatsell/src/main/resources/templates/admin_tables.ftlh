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
                <h3 class="text-dark mb-4">Beats</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Beats Info</p>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive table mt-2" id="dataTable" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0" id="dataTable">
                                <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Tags</th>
                                    <th>BPM</th>
                                    <th>Booked</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list beatsList as beat>
                                    <tr>
                                        <td>${beat.title}</td>
                                        <td>${beat.tags}</td>
                                        <td>${beat.bpm}</td>
                                        <td>${beat.getBookingSize()}</td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing
                                    1 to 10 of 27</p>
                            </div>
                            <div class="col-md-6">
                                <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                    <ul class="pagination">
                                        <li class="page-item disabled"><a class="page-link" href="#"
                                                                          aria-label="Previous"><span
                                                        aria-hidden="true">«</span></a></li>
                                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span
                                                        aria-hidden="true">»</span></a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid" style="margin-top: 16px;">
                <h3 class="text-dark mb-4">Licenses</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Licenses Info</p>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive table mt-2" id="dataTable-1" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0" id="dataTable">
                                <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Copies</th>
                                    <th>Price</th>
                                    <th>isForProfit</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list licensesList as license >
                                    <tr>
                                        <td>${license.title}</td>
                                        <td>${license.distributionCopiesCount}</td>
                                        <td>${license.price}</td>
                                        <td>${license.getProfitStatus()}</td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing
                                    1 to 10 of 27</p>
                            </div>
                            <div class="col-md-6">
                                <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                    <ul class="pagination">
                                        <li class="page-item disabled"><a class="page-link" href="#"
                                                                          aria-label="Previous"><span
                                                        aria-hidden="true">«</span></a></li>
                                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span
                                                        aria-hidden="true">»</span></a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12" style="margin-top: 24px;">
                        <h1 class="text-center">Add Beat</h1>
                        <form name="save_beat" method="post">
                            <div class="form-group"><label>Title </label><input name="title" class="form-control"
                                                                                type="text" placeholder="Title"></div>
                            <div class="form-group"><label>BPM</label><input name="bpm" class="form-control"
                                                                             type="number" placeholder="BPM"></div>
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
                                                                                       type="number" placeholder="ID">
                            </div>
                            <div class="form-group">
                                <label>Mood </label>
                                <select class="form-control" name="state" size="1">
                                    <option value="Free">Free</option>
                                    <option value="Sold">Sold</option>
                                </select>
                            </div>
                            <div class="form-group"><label>Tags </label><input name="tags" class="form-control"
                                                                               type="text" placeholder="Tags"></div>
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

                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12" style="margin-top: 24px;">
                        <h1 class="text-center">Add License</h1>
                        <form name="save_license" method="post">
                            <div class="form-group"><label>Title </label>
                                <input class="form-control" type="text" name="title" placeholder="Title">
                            </div>
                            <div class="form-group"><label>Price </label>
                                <input class="form-control" type="number" name="price" placeholder="Price">
                            </div>
                            <div class="form-group"><label>Profit </label>
                                <input class="form-control" type="checkbox" name="profit" placeholder="Profit">
                            </div>
                            <div class="form-group"><label>Music Recording </label>
                                <input class="form-control" type="checkbox" name="musicRecording" placeholder="Music Recording">
                            </div>
                            <div class="form-group"><label>Audio Streams Count</label>
                                <input class="form-control" type="number" name="audioStreamsCount" placeholder="Audio Streams Count">
                            </div>
                            <div class="form-group"><label>Distribution Copies Count</label>
                                <input class="form-control" type="number" name="distributionCopiesCount" placeholder="Distribution Copies Count">
                            </div>
                            <div class="form-group"><label>Music Video Count</label>
                                <input class="form-control" type="number" name="musicVideoCount" placeholder="Music Video Count">
                            </div>
                            <div class="form-group"><label>Radio Stations Count</label>
                                <input class="form-control" type="number" name="radioStationsCount" placeholder="Radio Stations Count">
                            </div>
                            <div class="form-group"><label>Track File</label>
                                <select class="form-control" name="trackFile" size="1">
                                        <option value="TAGGED_MP3">Tagged Mp3</option>
                                        <option value="MP3">Mp3</option>
                                        <option value="WAV">Wav</option>
                                        <option value="MP3_and_WAV">Mp3 and Wav</option>
                                        <option value="Trackout">Trackout</option>
                                </select>
                            </div>
                            <button class="btn btn-dark" type="submit">Save</button>

                            <#if _licenseFlag??>
                                <div class="alert alert-danger">
                                    Invalid data!
                                </div>
                            </#if>
                            <#if licenseFlag??>
                                <div class="alert alert-success">
                                    License has been added!
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