<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>My Orders</title>
        <style>
            /* CSS căn id pagination ra góc phải màn hình */
            #pagination {
                display: flex;
                display: -webkit-flex; /* Safari 8 */
                flex-wrap: wrap;
                -webkit-flex-wrap: wrap; /* Safari 8 */
                justify-content: center;
                -webkit-justify-content: center;
            }
        </style>
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include page="client-header.jsp"/>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <jsp:include page="client-navigation.jsp"/>
        <!-- /NAVIGATION -->

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="breadcrumb-header">My Orders</h3>
                        <ul class="breadcrumb-tree">
                            <li><a href="#">Home</a></li>
                            <li class="active">My Orders</li>
                        </ul>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="breadcrumb-header" style="text-align: center;">My Orders</h3>                       
                    </div>
                </div>
                <div class="row">
                    <div class="colorlib-shop p_100">
                        <div class="container">                              
                            <div class="row row-pb-md">
                                <div class="col-md-10 col-md-offset-1">
                                    <c:forEach var="o" items="${orList}">
                                        <div class="contentPage">
                                            <div class="col-md-10">
                                                <h3 style="color: blue">#${o.orderID}</h3>
                                                <h5><fmt:formatDate value="${o.orderDate}" pattern="dd-MM-yyyy" /> / 
                                                    <c:choose>
                                                        <c:when test="${o.processStatus eq 'Pending'}">
                                                            <span style="color: orange">${o.processStatus}</span>
                                                            <a href="CanceledMyOrders?orderid=${o.orderID}&cusid=${sessionScope.login_account.customerID}" class="closed" onclick="return confirm('Are You Sure?')"><i class="fa fa-trash-o"></i></a>
                                                        </c:when>
                                                        <c:when test="${o.processStatus eq 'Completed'}">
                                                            <span style="color: green">${o.processStatus}</span>
                                                        </c:when>
                                                            <c:when test="${o.processStatus eq 'Shipping'}">
                                                            <span style="color: blue">${o.processStatus}</span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span style="color: red">${o.processStatus}</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </h5>
                                            </div>
                                            <div class="productname">
                                                <div class="one-forth text-center">
                                                    <span>Product Details</span>
                                                </div> 
                                                <div class="one-eight text-center">
                                                    <span>Price</span>
                                                </div>
                                                <div class="one-eight text-center">
                                                    <span>Quantity</span>
                                                </div>
                                                <div class="one-eight text-center">
                                                    <span>Total</span>
                                                </div>
                                            </div>
                                            <c:forEach var="c" items="${orDetailList}">
                                                <c:if test="${o.orderID eq c.orderID.orderID}">
                                                    <div class="product-cart">
                                                        <div class="one-forth">
                                                            <img class="product-img" src="images/Products/${c.productID.image1}">
                                                            </img>
                                                            <div class="display-tc">
                                                                <a href="ProductDetail?proid=${c.productID.productID}"><h3>${c.productID.productName}</h3></a>
                                                            </div>
                                                        </div>
                                                        <div class="one-eight text-center">
                                                            <div class="display-tc">
                                                                <span class="price">$${c.sellingPrice}</span>
                                                            </div>
                                                        </div>
                                                        <div class="one-eight text-center">
                                                            <div class="display-tc">
                                                                <span class="price">${c.quantity}</span>
                                                            </div>
                                                        </div>
                                                        <div class="one-eight text-center">
                                                            <div class="display-tc">
                                                                <span class="price">$${c.sellingPrice*c.quantity}</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                            <div class="product-cart">
                                                <div class="one-forth">
                                                    <div class="display-tc">
                                                        <h3></h3>
                                                    </div>
                                                </div>
                                                <div class="one-eight text-center">
                                                    <div class="display-tc">
                                                        <span class="price"></span>
                                                    </div>
                                                </div>
                                                <div class="one-eight text-center">
                                                    <div class="display-tc">
                                                        <span class="price"></span>
                                                    </div>
                                                </div>
                                                <div class="one-eight text-center">
                                                    <div class="display-tc">
                                                        <span class="price"><b style="color: red">$${o.total}</b></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="store-filter clearfix">
                                <span class="store-qty"></span>
                                <ul id="pagination" >                               
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->



        <!-- FOOTER -->
        <jsp:include page="client-footer.jsp"/>
        <!-- /FOOTER -->
        <script type="text/javascript">
            $(function() {
                var pageSize = 3; // Hiển thị 6 sản phẩm trên 1 trang
                showPage = function(page) {
                    $(".contentPage").hide();
                    $(".contentPage").each(function(n) {
                        if (n >= pageSize * (page - 1) && n < pageSize * page)
                            $(this).show();
                    });
                }
                showPage(1);
                ///** Cần truyền giá trị vào đây **///
                var totalRows = ${orListCount}; // Tổng số sản phẩm hiển thị
                var btnPage = 5; // Số nút bấm hiển thị di chuyển trang
                var iTotalPages = Math.ceil(totalRows / pageSize);

                var obj = $('#pagination').twbsPagination({
                    totalPages: iTotalPages,
                    visiblePages: btnPage,
                    onPageClick: function(event, page) {
                        /* console.info(page); */
                        showPage(page);
                    }
                });
                /*console.info(obj.data());*/
            });
        </script>

    </body>
</html>
