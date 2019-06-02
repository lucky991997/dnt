<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
            <title>Products Manager</title>

        </head>
        <!--
        BODY TAG OPTIONS:
        =================
        Apply one or more of the following classes to get the
        desired effect
        |---------------------------------------------------------|
        | SKINS         | skin-blue                               |
        |               | skin-black                              |
        |               | skin-purple                             |
        |               | skin-yellow                             |
        |               | skin-red                                |
        |               | skin-green                              |
        |---------------------------------------------------------|
        |LAYOUT OPTIONS | fixed                                   |
        |               | layout-boxed                            |
        |               | layout-top-nav                          |
        |               | sidebar-collapse                        |
        |               | sidebar-mini                            |
        |---------------------------------------------------------|
        -->
        <body class="skin-blue sidebar-mini">
        <%
            session.setAttribute("currentAdminPage", "product");
            session.setAttribute("currentAdminPageChild", "viewProduct");
        %>
        <div class="wrapper">

            <!-- Main Header -->
            <jsp:include page="admin-main-header.jsp"></jsp:include>
                <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="admin-main-sidebar.jsp"></jsp:include>

                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>
                            Products Manager                       
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-archive"></i> Product</a></li>
                            <li class="active">View</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">Product List</h3>
                                    </div><!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Product ID</th>
                                                    <th>Product Name</th>
                                                    <th>Price</th>
                                                    <th>Discount(%)</th>
                                                    <th>Category</th>
                                                    <th>Brand</th>
                                                    <th style="width: 150px">Image</th>                                   
                                                    <th>Feature</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="e" items="${listPro}">
                                                <tr>
                                                    <td>${e.productID}</td>
                                                    <td>${e.productName}</td>                                                   
                                                    <td>$${e.price}</td>
                                                    <td>${e.discountProduct}%</td>
                                                    <td>${e.categoryID.categoryName}</td>
                                                    <td>${e.brandID.brandName}</td>
                                                    <td>
                                                        <c:if test="${not empty e.image1}">
                                                            <img id="blah1" src="images/Products/${e.image1}" alt="" class="user-image" width="80px" height="80px"/>
                                                        </c:if>
                                                        <c:if test="${not empty e.image2}">
                                                            <img id="blah2" src="images/Products/${e.image2}" alt="" class="user-image" width="80px" height="80px"/>
                                                        </c:if> 
                                                        <c:if test="${not empty e.image3}">
                                                            <img id="blah3" src="images/Products/${e.image3}" alt="" class="user-image" width="80px" height="80px"/>
                                                        </c:if> 
                                                        <c:if test="${not empty e.image4}">
                                                            <img id="blah4" src="images/Products/${e.image4}" alt="" class="user-image" width="80px" height="80px"/>
                                                        </c:if> 
                                                    </td>
                                                    <td>${e.feature}</td>
                                                    <td>                                                       
                                                        <c:if test="${e.isStatus eq true}">
                                                            <span class="label label-success">Enable</span>
                                                        </c:if>
                                                        <c:if test="${e.isStatus eq false}">
                                                            <span class="label label-danger">Disable</span>
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <div class="btn-group">
                                                            <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">Action <span class="fa fa-caret-down"></span></button>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="adminUpdateProduct?pro_id=${e.productID}"><i class="fa fa-edit"></i>Edit</a></li>
                                                                <li><a href="adminPrintBarCode?barcode=${e.productID}" target="_blank"><i class="fa fa-barcode"></i>Barcode</a></li>
                                                                <li class="divider"></li>
                                                                <c:if test="${e.isStatus eq true}">
                                                                    <li><a href="adminDisableProduct?pro_id=${e.productID}"><span style="color: red">Disable</span></a></li>
                                                                    </c:if>
                                                                    <c:if test="${e.isStatus eq false}">                                                                                                                  
                                                                    <li><a href="adminEnableProduct?pro_id=${e.productID}"><span style="color: green">Enable</span></a></li>
                                                                    </c:if>
                                                            </ul>
                                                        </div>                                                       
                                                    </td>
                                                </tr>   
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    <!-- Your Page Content Here -->

                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->

            <!-- Main Footer -->
            <jsp:include page="admin-main-footer.jsp"></jsp:include>

        </div><!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->

        <script type="text/javascript">
            $(function() {
                $('#example1').DataTable({
                    "order": [[0, "desc"]],
                    dom: 'Bfrtip',
                    buttons: [
                        'copy', 'excel', 'pdf', 'print'
                    ]
                });
            });
        </script>

    </body>
</html>
