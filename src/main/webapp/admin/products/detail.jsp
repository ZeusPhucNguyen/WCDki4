<%@ page import="com.food.drfood.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product)request.getAttribute("product");
%>
<jsp:include page="../includes/header.jsp">
    <jsp:param name="title" value="Product detail"/>
</jsp:include>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Food Management</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="card-title">Product Detail</h3>
                                <br>
                                <p class="text-warning fs-6">Product Id: <%=product.getId()%></p>
                                <p class="text-warning fs-6">Product Name: <%=product.getName()%></p>
                                <p class="text-warning fs-6">Category Id: <%=product.getCategoryId()%></p>
                                <p class="text-warning fs-6">Price: <%=product.getPrice()%></p>
                                <p class="text-warning fs-6">Description: <%=product.getDescription()%></p>
                                <p class="text-warning fs-6">Details: <%=product.getDetail()%></p>
                                <p class="text-warning fs-6">Status: <%=product.getStatus()%></p>

                                <img src="<%=product.getThumbnail()%>" alt="" class="img-fluid" style="width: 250px;height: auto;display: block"/>
                                <a href="/admin/products/create" class="btn btn-light mt-4">Create new student</a>
                                <a href="/admin/products/list" class="btn btn-light mt-4">Back to list</a>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>

