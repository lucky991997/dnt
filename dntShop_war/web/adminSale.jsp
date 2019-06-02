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
            <title>Sales</title>

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
            session.setAttribute("currentAdminPage", "sales");
            session.setAttribute("currentAdminPageChild", "sales");
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
                            Sales                     
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-shopping-cart"></i> Home</a></li>
                            <li class="active">Sales</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="info-box">
                                    <span class="info-box-icon bg-yellow"><i class="fa fa-cart-arrow-down"></i></span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">PENDING</span>
                                        <span class="info-box-number">${totalPending}</span>
                                    </div><!-- /.info-box-content -->
                                </div><!-- /.info-box -->
                            </div><!-- /.col -->
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="info-box">
                                    <span class="info-box-icon bg-aqua"><i class="fa fa-truck"></i></span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">SHIPPING</span>
                                        <span class="info-box-number">${totalShipping}</span>
                                    </div><!-- /.info-box-content -->
                                </div><!-- /.info-box -->
                            </div><!-- /.col -->
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="info-box">
                                    <span class="info-box-icon bg-green"><i class="fa fa-check"></i></span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">COMPLETED</span>
                                        <span class="info-box-number">${totalCompleted}</span>
                                    </div><!-- /.info-box-content -->
                                </div><!-- /.info-box -->
                            </div><!-- /.col -->                        
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="info-box">
                                    <span class="info-box-icon bg-red"><i class="fa fa-trash-o"></i></span>
                                    <div class="info-box-content">
                                        <span class="info-box-text">CANCELED</span>
                                        <span class="info-box-number">${totalCanceled}</span>
                                    </div><!-- /.info-box-content -->
                                </div><!-- /.info-box -->
                            </div><!-- /.col -->
                        </div><!-- /.row -->

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">ORDERS LIST</h3>
                                    </div><!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Customer Name</th>
                                                    <th>Ship Name</th>
                                                    <th>Phone</th>
                                                    <th>Address</th>
                                                    <th>Payment Method</th>
                                                    <th>Total</th>
                                                    <th>Order Date</th>
                                                    <th>Status</th>                                                                                      
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="e" items="${orderList}">
                                                <tr>
                                                    <td><a href="adminViewOrderDetails?orderid=${e.orderID}">${e.orderID}</a></td>
                                                    <td>${e.customerID.firstName} ${e.customerID.lastName}</td>                                                   
                                                    <td>${e.shipName}</td>
                                                    <td>${e.shipPhone}</td>
                                                    <td>${e.shipAddress}</td>
                                                    <td>${e.paymentMethod}</td>
                                                    <td>$${e.total}</td>                                           
                                                    <td><fmt:formatDate value="${e.orderDate}" pattern="dd-MM-yyyy" /></td>
                                                    <td>                                                       
                                                        <c:if test="${e.processStatus eq 'Completed'}">
                                                            <span class="label label-success">${e.processStatus}</span>
                                                        </c:if>
                                                        <c:if test="${e.processStatus eq 'Shipping'}">
                                                            <span class="label label-info">${e.processStatus}</span>
                                                        </c:if>
                                                        <c:if test="${e.processStatus eq 'Pending'}">
                                                            <span class="label label-warning">${e.processStatus}</span>
                                                        </c:if>
                                                        <c:if test="${e.processStatus eq 'Canceled'}">
                                                            <span class="label label-danger">${e.processStatus}</span>
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <div class="btn-group">
                                                            <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">Action <span class="fa fa-caret-down"></span></button>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="adminViewOrderDetails?orderid=${e.orderID}"><i class="fa fa-search"></i>Details</a></li>
                                                                <li class="divider"></li>
                                                                    <c:if test="${e.processStatus eq 'Completed'}">
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Shipping"><span style="color: blue">Shipping</span></a></li>                                                                
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Canceled"><span style="color: red">Canceled</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Pending"><span style="color: orange">Pending</span></a></li>
                                                                    </c:if>
                                                                    <c:if test="${e.processStatus eq 'Shipping'}">                                                                                                                                                                              
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Completed"><span style="color: green">Completed</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Canceled"><span style="color: red">Canceled</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Pending"><span style="color: orange">Pending</span></a></li>
                                                                    </c:if>
                                                                    <c:if test="${e.processStatus eq 'Pending'}">
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Shipping"><span style="color: blue">Shipping</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Completed"><span style="color: green">Completed</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Canceled"><span style="color: red">Canceled</span></a></li>
                                                                    </c:if>
                                                                    <c:if test="${e.processStatus eq 'Canceled'}">
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Shipping"><span style="color: blue">Shipping</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Completed"><span style="color: green">Completed</span></a></li>
                                                                    <li><a href="adminUpdateSaleProcessStatus?orderid=${e.orderID}&pstatus=Pending"><span style="color: orange">Pending</span></a></li>
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
