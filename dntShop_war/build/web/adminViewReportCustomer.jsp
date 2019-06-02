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
            <title>CUSTOMER REPORT (${dateRange})</title>

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
                            Report                    
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-bar-chart"></i> Report</a></li>
                            <li class="active">View</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">CUSTOMER REPORT (${dateRange})</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <div class="row invoice-info">
                                        <div class="col-sm-4 invoice-col">
                                            
                                            <address>                      
                                                <b>Account:</b> ${cus.email}<br/>
                                                <b>Name:</b> ${cus.firstName} ${cus.lastName}<br/>
                                                <b>ID:</b> ${cus.customerID}<br/>
                                                <b>Phone:</b> ${cus.phone}<br/>
                                                <b>Address:</b> ${cus.address}<br/>
                                            </address>
                                        </div><!-- /.col -->
                                        <div class="col-sm-4 invoice-col">
                                            
                                            <address>
                                                <img src="${cus.avatar}" class="img-circle pull-right" width="100px" height="100px"/>
                                            </address>
                                        </div><!-- /.col -->
                                        <div class="col-sm-4 invoice-col">
                                            <h1 style="color: red">Total Profit : <span>$<fmt:formatNumber value="${totalProfit}" maxFractionDigits="0"/></span></h1>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Sale No.</th>
                                                <th>Customer Name</th>
                                                <th>Order Date</th>
                                                <th>Receiver</th>
                                                <th>Phone of Receiver</th>
                                                <th>Status</th>
                                                <th>Profit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="e" items="${reportList}">
                                                <tr>
                                                    <td><a href="adminViewOrderDetails?orderid=${e.orderID}">${e.orderID}</a></td>
                                                    <td>${e.customerID.firstName} ${e.customerID.lastName}</td>
                                                    <td><fmt:formatDate value="${e.orderDate}" pattern="dd-MM-yyyy" /></td>
                                                    <td>${e.shipName}</td>
                                                    <td>${e.shipPhone}</td>
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
                                                        <c:choose>
                                                            <c:when test = "${e.processStatus eq 'Canceled'}">
                                                                $0
                                                            </c:when>
                                                            <c:otherwise>
                                                                $${e.total}
                                                            </c:otherwise>
                                                        </c:choose>    
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
