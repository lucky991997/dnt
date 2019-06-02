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
            <title>Order Details</title>

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
                            <li><a href="#"><i class="fa fa-shopping-cart"></i> Sale</a></li>
                            <li class="active">Order Details</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="invoice">
                        <!-- title row -->
                        <div class="row">
                            <div class="col-xs-12">
                                <h2 class="page-header">
                                    <i class="fa fa-globe"></i> DNTShop
                                    <small class="pull-right">Date: <fmt:formatDate value="<%= new java.util.Date()%>" pattern="dd/MM/yyyy"/></small>
                            </h2>
                        </div><!-- /.col -->
                    </div>
                    <!-- info row -->
                    <div class="row invoice-info">
                        <div class="col-sm-4 invoice-col">
                            From
                            <address>
                                <strong>DNTShop</strong><br>
                                590 CMT8 Road, District 3, Ho Chi Minh City<br>
                                <b>Phone:</b> (098) 765-4321<br/>
                                <b>Email:</b> dntshop@email.com
                            </address>
                        </div><!-- /.col -->
                        <div class="col-sm-4 invoice-col">
                            To
                            <address>
                                <strong>${order.shipName}</strong><br>
                                ${order.shipAddress}<br>
                                <b>Phone:</b> ${order.shipPhone}<br/>
                                <b>Email:</b> ${order.customerID.email}
                            </address>
                        </div><!-- /.col -->
                        <div class="col-sm-4 invoice-col">
                            <br/>
                            <br/>
                            <br/>
                            <b>Order ID:</b> ${order.orderID}<br/>                               
                            <b>Account:</b> ${order.customerID.email}
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                    <!-- Table row -->
                    <div class="row">
                        <div class="col-xs-12 table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Qty</th>
                                        <th>Product Name</th>
                                        <th>Serial #</th>
                                        <th>Price</th>
                                        <th>Subtotal</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="d" items="${orderdetail}">
                                        <tr>
                                            <td>${d.quantity}</td>
                                            <td>${d.productID.productName}</td>
                                            <td>${d.productID.productID}</td>
                                            <td>$${d.sellingPrice}</td>
                                            <td>$${d.sellingPrice*d.quantity}</td>
                                        </tr>
                                    </c:forEach>                                                                      
                                </tbody>
                            </table>
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                    <div class="row">
                        <!-- accepted payments column -->
                        <div class="col-xs-6">
                            <p class="lead"><b>Payment Methods:</b> ${order.paymentMethod}</p>
              
                            <c:if test="${not empty order.shipNote}">
                                <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
                                    Ship Note: ${order.shipNote}
                                </p>
                            </c:if>
                        </div><!-- /.col -->
                        <div class="col-xs-6">
                            <p class="lead">Amount Due <fmt:formatDate value="<%= new java.util.Date()%>" pattern="dd/MM/yyyy"/></p>
                            <div class="table-responsive">
                                <table class="table">
                                    <tr>
                                        <th style="width:50%">Shipping:</th>
                                        <td>Free</td>
                                    </tr>
                                    <tr>
                                        <th>Total:</th>
                                        <td>$${order.total}</td>
                                    </tr>
                                </table>
                            </div>
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                    <!-- this row will not appear when printing -->
                    <div class="row no-print">
                        <div class="col-xs-12">
                            <a href="#" target="_blank" onclick="window.print();" class="btn btn-default"><i class="fa fa-print"></i> Print</a>
                            
                            <div class="btn-group pull-right">
                                <button type="button" class="btn btn-success" data-toggle="dropdown"><i class="fa fa-credit-card"></i> Submit Payment <span class="fa fa-caret-down"></span></button>
                                <ul class="dropdown-menu">
                                    <c:if test="${order.processStatus eq 'Completed'}">
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Shipping"><span style="color: blue">Shipping</span></a></li>                                                                
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Canceled"><span style="color: red">Canceled</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Pending"><span style="color: orange">Pending</span></a></li>
                                        </c:if>
                                        <c:if test="${order.processStatus eq 'Shipping'}">                                                                                                                                                                              
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Completed"><span style="color: green">Completed</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Canceled"><span style="color: red">Canceled</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Pending"><span style="color: orange">Pending</span></a></li>
                                        </c:if>
                                        <c:if test="${order.processStatus eq 'Pending'}">
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Shipping"><span style="color: blue">Shipping</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Completed"><span style="color: green">Completed</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Canceled"><span style="color: red">Canceled</span></a></li>
                                        </c:if>
                                        <c:if test="${order.processStatus eq 'Canceled'}">
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Shipping"><span style="color: blue">Shipping</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Completed"><span style="color: green">Completed</span></a></li>
                                        <li><a href="adminUpdateSaleProcessStatus?orderid=${order.orderID}&pstatus=Pending"><span style="color: orange">Pending</span></a></li>
                                        </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </section><!-- /.content -->
                <div class="clearfix"></div><br/><br/>
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
