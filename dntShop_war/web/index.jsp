<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>DNTShop - Home</title>
    </head>
    <body>       
        <!-- HEADER -->
        <jsp:include  page="client-header.jsp"></jsp:include>
            <!-- /HEADER -->

            <!-- NAVIGATION -->
        <jsp:include  page="client-navigation.jsp"></jsp:include>  
            <!-- /NAVIGATION -->

            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">

                    <c:forEach var="cat" items="${categoriesList}">
                        <!-- shop -->
                        <div class="col-md-4 col-xs-6">
                            <div class="shop">
                                <div class="shop-img">
                                    <img src="${cat.categoryImage}" height="240px">
                                </div>
                                <div class="shop-body">
                                    <h3>${cat.categoryName}<br>Collection</h3>
                                    <a href="AllProductByCategory?cateid=${cat.categoryID}" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /shop -->  
                    </c:forEach>                                         

                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->
        <!-- HOT DEAL SECTION -->
        <div id="hot-deal" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="hot-deal">
                            <br>
                            <br>
                            <br>
                            <h2 class="text-uppercase">hot deal this week</h2>
                            <p>New Collection Up to 50% OFF</p>
                            <br>
                            <br>
                            <br>
                            <a class="primary-btn cta-btn" href="AllProduct">Shop now</a>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /HOT DEAL SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-4 col-xs-6">
                        <div class="section-title">
                            <h4 class="title">Top selling</h4>
                            <div class="section-nav">
                                <div id="slick-nav-3" class="products-slick-nav"></div>
                            </div>
                        </div>

                        <div class="products-widget-slick" data-nav="#slick-nav-3">
                            <div>
                                <c:forEach var="n" items="${sessionScope.topSellingList}" begin="0" end="2">
                                    <!-- product widget -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="images/Products/${n.image1}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${n.categoryName}</p>
                                            <h3 class="product-name"><a href="ProductDetail?proid=${n.productID}">${n.productName}</a></h3>
                                            <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${n.price*(100-n.discountProduct)/100}"/>
                                                <c:if test="${n.discountProduct ne 0}">
                                                    <del class="product-old-price">$${n.price}</del>
                                                </c:if> 
                                            </h4>
                                        </div>
                                    </div>
                                    <!-- /product widget -->
                                </c:forEach>
                            </div>

                            <div>
                                <c:forEach var="n" items="${sessionScope.topSellingList}" begin="3" end="5">
                                    <!-- product widget -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="images/Products/${n.image1}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${n.categoryName}</p>
                                            <h3 class="product-name"><a href="ProductDetail?proid=${n.productID}">${n.productName}</a></h3>
                                            <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${n.price*(100-n.discountProduct)/100}"/>
                                                <c:if test="${n.discountProduct ne 0}">
                                                    <del class="product-old-price">$${n.price}</del>
                                                </c:if> 
                                            </h4>
                                        </div>
                                    </div>
                                    <!-- /product widget -->
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-xs-6">
                        <div class="section-title">
                            <h4 class="title">Top Rating</h4>
                            <div class="section-nav">
                                <div id="slick-nav-4" class="products-slick-nav"></div>
                            </div>
                        </div>

                        <div class="products-widget-slick" data-nav="#slick-nav-4">
                            <div>
                                <c:forEach var="n" items="${sessionScope.topRatingList}" begin="0" end="2">
                                    <!-- product widget -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="images/Products/${n.image1}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${n.categoryName}</p>
                                            <h3 class="product-name"><a href="ProductDetail?proid=${n.productID}">${n.productName}</a></h3>
                                            <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${n.price*(100-n.discountProduct)/100}"/>
                                                <c:if test="${n.discountProduct ne 0}">
                                                    <del class="product-old-price">$${n.price}</del>
                                                </c:if> 
                                            </h4>
                                        </div>
                                    </div>
                                    <!-- /product widget -->
                                </c:forEach>
                            </div>

                            <div>
                                <c:forEach var="n" items="${sessionScope.topRatingList}" begin="3" end="5">
                                    <!-- product widget -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="images/Products/${n.image1}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${n.categoryName}</p>
                                            <h3 class="product-name"><a href="ProductDetail?proid=${n.productID}">${n.productName}</a></h3>
                                            <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${n.price*(100-n.discountProduct)/100}"/>
                                                <c:if test="${n.discountProduct ne 0}">
                                                    <del class="product-old-price">$${n.price}</del>
                                                </c:if> 
                                            </h4>
                                        </div>
                                    </div>
                                    <!-- /product widget -->
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <div class="clearfix visible-sm visible-xs"></div>

                    <div class="col-md-4 col-xs-6">
                        <div class="section-title">
                            <h4 class="title">Top New</h4>
                            <div class="section-nav">
                                <div id="slick-nav-5" class="products-slick-nav"></div>
                            </div>
                        </div>

                        <div class="products-widget-slick" data-nav="#slick-nav-5">
                            <div>
                                <c:forEach var="n" items="${sessionScope.newProductList}" begin="0" end="2">
                                    <!-- product widget -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="images/Products/${n.image1}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${n.categoryID.categoryName}</p>
                                            <h3 class="product-name"><a href="ProductDetail?proid=${n.productID}">${n.productName}</a></h3>
                                            <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${n.price*(100-n.discountProduct)/100}"/> 
                                                <c:if test="${n.discountProduct ne 0}">
                                                    <del class="product-old-price">$${n.price}</del>
                                                </c:if> 
                                            </h4>
                                        </div>
                                    </div>
                                    <!-- /product widget -->
                                </c:forEach>
                            </div>

                            <div>
                                <c:forEach var="n" items="${sessionScope.newProductList}" begin="3" end="5">
                                    <!-- product widget -->
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="images/Products/${n.image1}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${n.categoryID.categoryName}</p>
                                            <h3 class="product-name"><a href="ProductDetail?proid=${n.productID}">${n.productName}</a></h3>
                                            <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${n.price*(100-n.discountProduct)/100}"/> 
                                                <c:if test="${n.discountProduct ne 0}">
                                                    <del class="product-old-price">$${n.price}</del>
                                                </c:if> 
                                            </h4>
                                        </div>
                                    </div>
                                    <!-- /product widget -->
                                </c:forEach>
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


    </body>

    <script type="text/javascript">
        function addProductToCart(productid)
        {
            $.ajax({
                url: "AddProductToCart?command=plus&productID=" + productid,
                type: "POST",
                //data: {name: name1, price: price1, product_id: id, number: number, registerid: 75, waiter: waiterID},
                success: function()
                {

                    location.reload();
                },
                error: function(jqXHR, textStatus, errorThrown)
                {
                    alert("error");
                }
            });
        }

    </script>
</html>
