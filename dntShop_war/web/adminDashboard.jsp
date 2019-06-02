<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
            <title>Admin | Dashboard</title>
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
            session.setAttribute("currentAdminPage", "dashboard");
            session.setAttribute("currentAdminPageChild", "dashboard");
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
                            Dashboard
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                            <li class="active">Dashboard</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <!-- Small boxes (Stat box) -->
                        <div class="row">
                            <div class="col-lg-3 col-xs-6">
                                <!-- small box -->
                                <div class="small-box bg-aqua">
                                    <div class="inner">
                                        <h3>${totalProducts}</h3>
                                    <p>Product (in ${totalCategories} Categories)</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-bag"></i>
                                </div>                                  
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3>${totalUserRegis}</h3>
                                    <p>User Registrations</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-person-add"></i>
                                </div>                                    
                            </div>
                        </div><!-- ./col -->
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3>${totalOrders}</h3>
                                    <p>Total Orders</p>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-shopping-cart"></i>
                                </div>

                            </div>
                        </div><!-- ./col -->                           
                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">
                                    <h3>$<fmt:formatNumber type="number" minFractionDigits="0" value="${totalProfit}"/></h3>
                                    <p>Total Profit (this month's)</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>                                   
                            </div>
                        </div><!-- ./col -->
                    </div><!-- /.row -->

                    <!-- Main row -->
                    <div class="row">
                        <!-- Left col -->
                        <div class="col-md-8">                           
                            <!-- TABLE: LATEST ORDERS -->
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Latest Orders</h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <div class="table-responsive">
                                        <table class="table no-margin">
                                            <thead>
                                                <tr>
                                                    <th>Order ID</th>
                                                    <th>Customer</th>
                                                    <th>Status</th>
                                                    <th>Total Order</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="o" items="${orderList}" begin="0" end="6">
                                                    <tr>
                                                        <td><a href="adminViewOrderDetails?orderid=${o.orderID}">${o.orderID}</a></td>
                                                        <td>${o.customerID.firstName} ${o.customerID.lastName}</td>
                                                        <c:if test="${o.processStatus eq 'Completed'}">
                                                            <td><span class="label label-success">${o.processStatus}</span></td>
                                                            </c:if>
                                                            <c:if test="${o.processStatus eq 'Shipping'}">
                                                            <td><span class="label label-info">${o.processStatus}</span></td>
                                                            </c:if>
                                                            <c:if test="${o.processStatus eq 'Pending'}">
                                                            <td><span class="label label-warning">${o.processStatus}</span></td>
                                                            </c:if>
                                                            <c:if test="${o.processStatus eq 'Canceled'}">
                                                            <td><span class="label label-danger">${o.processStatus}</span></td>
                                                            </c:if>
                                                        <td>$<fmt:formatNumber type="number" minFractionDigits="0" value="${o.total}"/></td>
                                                    </tr>   
                                                </c:forEach>                                                                                        
                                            </tbody>
                                        </table>
                                    </div><!-- /.table-responsive -->
                                </div><!-- /.box-body -->
                                <div class="box-footer clearfix">
                                    <a href="adminViewSale" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
                                </div><!-- /.box-footer -->
                            </div><!-- /.box -->
                            
                            <!-- BAR CHART -->
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Top Selling This Year Chart</h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="bar-chart" style="height: 300px;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div><!-- /.col -->

                        <div class="col-md-4">
                            <div class="info-box bg-red">
                                <span class="info-box-icon"><i class="fa fa-trash-o"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">Canceled Orders</span>
                                    <span class="info-box-number">${totalCanceled}</span>
                                    <div class="progress">
                                        <div class="progress-bar" style="width: ${totalCanceled/totalOrders*100}%"></div>
                                    </div>
                                    <span class="progress-description">
                                        <fmt:formatNumber type="number" maxFractionDigits="0" value="${totalCanceled/totalOrders*100}"/>% Increase
                                    </span>
                                </div><!-- /.info-box-content -->
                            </div><!-- /.info-box -->
                            <!-- Info Boxes Style 2 -->
                            <div class="info-box bg-yellow">
                                <span class="info-box-icon"><i class="fa fa-cart-arrow-down"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">Pending Orders</span>
                                    <span class="info-box-number">${totalPending}</span>
                                    <div class="progress">
                                        <div class="progress-bar" style="width: ${totalPending/totalOrders*100}%"></div>
                                    </div>
                                    <span class="progress-description">
                                        <fmt:formatNumber type="number" maxFractionDigits="0" value="${totalPending/totalOrders*100}"/>% Increase
                                    </span>
                                </div><!-- /.info-box-content -->
                            </div><!-- /.info-box -->
                            <div class="info-box bg-green">
                                <span class="info-box-icon"><i class="fa fa-check"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">Completed Orders</span>
                                    <span class="info-box-number">${totalCompleted}</span>
                                    <div class="progress">
                                        <div class="progress-bar" style="width: ${totalCompleted/totalOrders*100}%"></div>
                                    </div>
                                    <span class="progress-description">
                                        <fmt:formatNumber type="number" maxFractionDigits="0" value="${totalCompleted/totalOrders*100}"/>% Increase
                                    </span>
                                </div><!-- /.info-box-content -->
                            </div><!-- /.info-box -->

                            <div class="info-box bg-aqua">
                                <span class="info-box-icon"><i class="fa fa-truck"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">Shipping Orders</span>
                                    <span class="info-box-number">${totalShipping}</span>
                                    <div class="progress">
                                        <div class="progress-bar" style="width: ${totalShipping/totalOrders*100}%"></div>
                                    </div>
                                    <span class="progress-description">
                                        <fmt:formatNumber type="number" maxFractionDigits="0" value="${totalShipping/totalOrders*100}"/>% Increase
                                    </span>
                                </div><!-- /.info-box-content -->
                            </div><!-- /.info-box -->

                            <!-- PRODUCT LIST -->
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Recently Added Products</h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="products-list product-list-in-box">
                                        <c:forEach var="t" items="${newProList}" begin="0" end="3">
                                            <li class="item">
                                                <div class="product-img">
                                                    <img src="images/Products/${t.image1}" alt="ProImage" />
                                                </div>
                                                <div class="product-info">
                                                    <a class="product-title">${t.productName} <span class="label label-danger pull-right">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${t.price*(100-t.discountProduct)/100}"/></span></a>
                                                    <span class="product-description">
                                                        ${t.descriptions}
                                                    </span>
                                                </div>
                                            </li><!-- /.item -->
                                        </c:forEach>
                                    </ul>
                                </div><!-- /.box-body -->
                                <div class="box-footer text-center">
                                    <a href="adminViewProduct" class="uppercase">View All Products</a>
                                </div><!-- /.box-footer -->
                            </div><!-- /.box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->

            <!-- Main Footer -->
            <jsp:include page="admin-main-footer.jsp"></jsp:include>

            </div><!-- ./wrapper -->

            <!-- REQUIRED JS SCRIPTS -->
            <script type="text/javascript">
                $(function() {
                    "use strict";
                    //BAR CHART
                    var bar = new Morris.Bar({
                        element: 'bar-chart',
                        resize: true,
                        data: [
                            {y: '${topSellList.get(0).productName}', a: ${topSellList.get(0).topSelling}},
                            {y: '${topSellList.get(1).productName}', a: ${topSellList.get(1).topSelling}},
                            {y: '${topSellList.get(2).productName}', a: ${topSellList.get(2).topSelling}},
                            {y: '${topSellList.get(3).productName}', a: ${topSellList.get(3).topSelling}},
                            {y: '${topSellList.get(4).productName}', a: ${topSellList.get(4).topSelling}},
                            {y: '${topSellList.get(5).productName}', a: ${topSellList.get(5).topSelling}}
                        ],
                        barColors: ['#00a65a', '#f56954'],
                        xkey: 'y',
                        ykeys: ['a'],
                        labels: ['Quantity'],
                        hideHover: 'auto'
                    });
                });
        </script>
    </body>
</html>
