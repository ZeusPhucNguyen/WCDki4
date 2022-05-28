<!DOCTYPE html>
<html lang="en">
<jsp:include page="../inlclude/head.jsp"/>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <jsp:include page="../inlclude/navbar.jsp"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_sidebar.html -->
        <jsp:include page="../inlclude/sidebar.jsp"/>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Form elements </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Forms</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Form elements</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Default form</h4>
                                <p class="card-description"> Basic form layout </p>
                                <form class="forms-sample">
                                    <div class="form-group">
                                        <label for="exampleInputUsername1">Username</label>
                                        <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputConfirmPassword1">Confirm Password</label>
                                        <input type="password" class="form-control" id="exampleInputConfirmPassword1" placeholder="Password">
                                    </div>

                                    <button type="submit" class="btn btn-primary me-2">Submit</button>
                                    <button class="btn btn-light">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="../inlclude/footer.jsp"/>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<jsp:include page="../inlclude/scripts.jsp"/>
</body>
</html>