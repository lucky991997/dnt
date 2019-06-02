<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>DNTShop</title>
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
        <jsp:include  page="client-header.jsp"></jsp:include>
            <!-- /HEADER -->

            <!-- NAVIGATION -->
        <jsp:include  page="client-navigation.jsp"></jsp:include>   
            <!-- /NAVIGATION -->
            <!-- BREADCRUMB -->
            <div id="breadcrumb" class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="breadcrumb-tree">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">All Categories</a></li>
                                <li><a href="#">${pro.categoryID.categoryName}</a></li>
                            <li class="active">${pro.productName}</li>
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
                    <!-- Product main img -->
                    <div class="col-md-5 col-md-push-2">
                        <div id="product-main-img">
                            <div class="product-preview">
                                <img src="images/Products/${pro.image1}" alt="">
                            </div>
                            <c:if test="${not empty pro.image2}">
                                <div class="product-preview">
                                    <img src="images/Products/${pro.image2}" alt="">
                                </div>
                            </c:if>
                            <c:if test="${not empty pro.image3}">
                                <div class="product-preview">
                                    <img src="images/Products/${pro.image3}" alt="">
                                </div>
                            </c:if>
                            <c:if test="${not empty pro.image4}">
                                <div class="product-preview">
                                    <img src="images/Products/${pro.image4}" alt="">
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <!-- /Product main img -->

                    <!-- Product thumb imgs -->
                    <div class="col-md-2  col-md-pull-5">
                        <div id="product-imgs">
                            <div class="product-preview">
                                <img src="images/Products/${pro.image1}" alt="">
                            </div>
                            <c:if test="${not empty pro.image2}">
                                <div class="product-preview">
                                    <img src="images/Products/${pro.image2}" alt="">
                                </div>
                            </c:if>
                            <c:if test="${not empty pro.image3}">
                                <div class="product-preview">
                                    <img src="images/Products/${pro.image3}" alt="">
                                </div>
                            </c:if>
                            <c:if test="${not empty pro.image4}">
                                <div class="product-preview">
                                    <img src="images/Products/${pro.image4}" alt="">
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <!-- /Product thumb imgs -->

                    <!-- Product details -->
                    <div class="col-md-5">
                        <div class="product-details">
                            <h2 class="product-name" style="background-color: white">${pro.productName}</h2>
                            <div>
                                <div class="product-rating">
                                    <c:choose>
                                        <c:when test="${empty avgStar}">
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                            <i class="fa fa-star-o"></i>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach begin="1" end="${avgStar}">
                                                <i class="fa fa-star"></i>
                                            </c:forEach>
                                            <c:forEach begin="1" end="${5-avgStar}">
                                                <i class="fa fa-star-o"></i>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <a class="review-link" href="#">${ratingListCount} Review(s)</a>
                            </div>
                            <div>
                                <h3 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${pro.price*(100-pro.discountProduct)/100}"/> 
                                    <c:if test="${pro.discountProduct ne 0}">
                                        <del class="product-old-price">$${pro.price}</del>
                                    </c:if>
                                </h3>
                                <span class="product-available">In Stock</span>
                            </div>
                            <p>${pro.descriptions}</p>                       

                            <ul class="product-links">
                                <li>ID:</li>
                                <li><a href="#">${pro.productID}</a></li>
                            </ul>
                            <ul class="product-links">
                                <li>Category:</li>
                                <li><a href="AllProductByCategory?cateid=${pro.categoryID.categoryID}">${pro.categoryID.categoryName}</a></li>
                            </ul>
                            <ul class="product-links">
                                <li>Brand:</li>
                                <li><a href="AllProductByBrand?brandid=${pro.brandID.brandID}">
                                        <c:choose>
                                            <c:when test="${not empty pro.brandID.brandImages}">
                                                <img class="img-circle" src="${pro.brandID.brandImages}" width="30px" height="30px">
                                            </c:when>
                                            <c:otherwise>
                                                ${pro.brandID.brandName}
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </li>
                            </ul>
                            <br/>
                            <div class="add-to-cart">
                                <div class="qty-label">
                                    Qty
                                    <div class="input-number">
                                        <input id="quantity" type="number" value="1" min="1" max="9">
                                        <span class="qty-up">+</span>
                                        <span class="qty-down">-</span>
                                    </div>
                                </div>
                                <button class="add-to-cart-btn" onclick='addProductToCartWithQuantity("${pro.productID}")'><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>

                            <ul class="product-btns">
                                <c:choose>
                                    <c:when test="${sessionScope.wishlist.contains(pro) eq true}">
                                        <li><a href="#" onclick='removeProductWishlist("${pro.productID}", "${sessionScope.login_account.customerID}")'><i class="fa fa-heart" style="color: red"></i> remove from wishlist</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="#" onclick='addProductWishlist("${pro.productID}", "${sessionScope.login_account.customerID}")'><i class="fa fa-heart" ></i> add to wishlist</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                <li><a href="#" onclick='addProductToCompare("${pro.productID}")'><i class="fa fa-exchange"></i> add to compare</a></li>
                            </ul>



                        </div>
                    </div>
                    <!-- /Product details -->

                    <!-- Product tab -->
                    <div class="col-md-12">
                        <div id="product-tab">
                            <!-- product tab nav -->
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                                <li><a data-toggle="tab" href="#tab2">Details</a></li>
                                <li><a data-toggle="tab" href="#tab3">Reviews (${ratingListCount})</a></li>
                            </ul>
                            <!-- /product tab nav -->

                            <!-- product tab content -->
                            <div class="tab-content">
                                <!-- tab1  -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p>${pro.descriptions}</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab1  -->

                                <!-- tab2  -->
                                <div id="tab2" class="tab-pane fade in">
                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8">
                                            <div class="compare_table">
                                                <div class="table-responsive-md">
                                                    <table class="table">                                                   
                                                        <tbody>
                                                            <c:if test="${not empty prodetail.cpu}">
                                                                <tr>
                                                                    <th scope="row"><span>CPU</span></th>
                                                                    <td><h6>${prodetail.cpu}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.memory}">
                                                                <tr>
                                                                    <th scope="row"><span>Memory</span></th>
                                                                    <td><h6>${prodetail.memory}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.vga}">
                                                                <tr>
                                                                    <th scope="row"><span>VGA</span></th>
                                                                    <td><h6>${prodetail.vga}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.hdd}">
                                                                <tr>
                                                                    <th scope="row"><span>HDD</span></th>
                                                                    <td><h6>${prodetail.hdd}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.camera}">
                                                                <tr>
                                                                    <th scope="row"><span>Camera</span></th>
                                                                    <td><h6>${prodetail.camera}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.display}">
                                                                <tr>
                                                                    <th scope="row"><span>Display</span></th>
                                                                    <td><h6>${prodetail.display}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.battery}">
                                                                <tr>
                                                                    <th scope="row"><span>Battery</span></th>
                                                                    <td><h6>${prodetail.battery}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                            <c:if test="${not empty prodetail.weights}">
                                                                <tr>
                                                                    <th scope="row"><span>Weight</span></th>
                                                                    <td><h6>${prodetail.weights}</h6></td>   
                                                                </tr>
                                                            </c:if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2"></div>
                                    </div>
                                </div>
                                <!-- /tab2  -->

                                <!-- tab3  -->
                                <div id="tab3" class="tab-pane fade in">
                                    <div class="row">
                                        <!-- Rating -->
                                        <div class="col-md-3">
                                            <div id="rating">
                                                <div class="rating-avg">
                                                    <span>
                                                        <c:choose>
                                                            <c:when test="${empty avgRating}">
                                                                0.0
                                                            </c:when>
                                                            <c:otherwise>
                                                                <fmt:formatNumber type="number" minFractionDigits="1" maxFractionDigits="1" value="${avgRating}"/>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </span>
                                                    <div class="rating-stars">
                                                        <c:choose>
                                                            <c:when test="${empty avgStar}">
                                                                <i class="fa fa-star-o"></i>
                                                                <i class="fa fa-star-o"></i>
                                                                <i class="fa fa-star-o"></i>
                                                                <i class="fa fa-star-o"></i>
                                                                <i class="fa fa-star-o"></i>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:forEach begin="1" end="${avgStar}">
                                                                    <i class="fa fa-star"></i>
                                                                </c:forEach>
                                                                <c:forEach begin="1" end="${5-avgStar}">
                                                                    <i class="fa fa-star-o"></i>
                                                                </c:forEach>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                                <ul class="rating">
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: ${ratingListCountR5/ratingListCount*100}%;"></div>
                                                        </div>
                                                        <span class="sum">${ratingListCountR5}</span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: ${ratingListCountR4/ratingListCount*100}%;"></div>
                                                        </div>
                                                        <span class="sum">${ratingListCountR4}</span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: ${ratingListCountR3/ratingListCount*100}%;"></div>
                                                        </div>
                                                        <span class="sum">${ratingListCountR3}</span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: ${ratingListCountR2/ratingListCount*100}%;"></div>
                                                        </div>
                                                        <span class="sum">${ratingListCountR2}</span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: ${ratingListCountR1/ratingListCount*100}%;"></div>
                                                        </div>
                                                        <span class="sum">${ratingListCountR1}</span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!-- /Rating -->

                                        <!-- Reviews -->
                                        <div class="col-md-6">
                                            <div id="reviews">
                                                <ul class="reviews">
                                                    <c:forEach var="r" items="${ratingList}">
                                                        <li class="contentPage">
                                                            <div class="review-heading">
                                                                <h5 class="name">${r.customerID.firstName} ${r.customerID.lastName}</h5>
                                                                <p class="date"><fmt:formatDate value="${r.ratingDate}" pattern="dd-MM-yyyy" /></p>
                                                                <div class="review-rating">
                                                                    <c:forEach begin="1" end="${r.rate}">
                                                                        <i class="fa fa-star"></i>
                                                                    </c:forEach>
                                                                    <c:forEach begin="1" end="${5-r.rate}">
                                                                        <i class="fa fa-star-o empty"></i>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                            <div class="review-body">
                                                                <p>${r.content}</p>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                                <ul id="pagination">
                                                </ul>
                                            </div>
                                        </div>
                                        <!-- /Reviews -->

                                        <!-- Review Form -->
                                        <div class="col-md-3">
                                            <div id="review-form">
                                                <c:choose>
                                                    <c:when test="${empty sessionScope.login_account}">
                                                        <form id="LoginForm" class="review-form" method="post">                                                           
                                                            <input class="input" type="email" id="email" name="email" placeholder="Your Email">
                                                            <input class="input" type="password" id="password" name="password" placeholder="Your Password">
                                                            <c:if test="${not empty sessionScope.login_msgReview}">
                                                                ${sessionScope.login_msgReview}
                                                            </c:if>
                                                            <input type="button" class="primary-btn" onclick="loginToReview()" value="Login"/>
                                                        </form>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <form id="ReviewForm" class="review-form" method="post">
                                                            <input class="input" type="text" value="${sessionScope.login_account.firstName} ${sessionScope.login_account.lastName}" placeholder="Your Name" disabled="true">
                                                            <input class="input" type="email" value="${sessionScope.login_account.email}" placeholder="Your Email" disabled="true">
                                                            <textarea class="input" id="content" name="content" placeholder="Your Review" required="true"></textarea>
                                                            <span id="content-result"></span>
                                                            <div class="input-rating">
                                                                <span>Your Rating: </span>
                                                                <div class="stars">
                                                                    <input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
                                                                    <input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
                                                                    <input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
                                                                    <input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
                                                                    <input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
                                                                </div>
                                                                <span id="rating-result"></span>
                                                            </div>
                                                            <input type="button" class="primary-btn" onclick="addNewReview()" value="Submit">
                                                        </form>
                                                    </c:otherwise>
                                                </c:choose>

                                            </div>
                                        </div>
                                        <!-- /Review Form -->
                                    </div>
                                </div>
                                <!-- /tab3  -->
                            </div>
                            <!-- /product tab content  -->
                        </div>
                    </div>
                    <!-- /product tab -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- Section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h3 class="title">New Products</h3>
                        </div>
                    </div>

                    <c:forEach var="p" items="${sessionScope.newProductList}" begin="0" end="3">
                        <!-- product -->
                        <jsp:include page="ProductStarByProID?proid=${p.productID}"/>
                        <div class="col-md-3 col-xs-6">
                            <div class="product">
                                <div class="product-img">
                                    <img src="images/Products/${p.image1}" alt="">
                                    <div class="product-label">
                                        <c:if test="${p.discountProduct ne 0}">
                                            <span class="sale">-${p.discountProduct}%</span>
                                        </c:if>
                                        <c:if test="${p.feature ne '--'}">
                                            <span class="new">${p.feature}</span>
                                        </c:if> 
                                    </div>
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${p.categoryID.categoryName}</p>
                                    <h3 class="product-name"><a href="ProductDetail?proid=${p.productID}">${p.productName}</a></h3>
                                    <h4 class="product-price">$<fmt:formatNumber type="number" maxFractionDigits="0" value="${p.price*(100-p.discountProduct)/100}"/>
                                        <c:if test="${p.discountProduct ne 0}">
                                            <del class="product-old-price">$${p.price}</del>
                                        </c:if>
                                    </h4>
                                    <div class="product-rating">
                                        <c:choose>
                                            <c:when test="${empty avgStars}">
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach begin="1" end="${avgStars}">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                                <c:forEach begin="1" end="${5-avgStars}">
                                                    <i class="fa fa-star-o"></i>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="product-btns">
                                        <c:choose>
                                            <c:when test="${sessionScope.wishlist.contains(p) eq true}">
                                                <button class="add-to-wishlist" onclick='removeProductWishlist("${p.productID}", "${sessionScope.login_account.customerID}")'><i class="fa fa-heart" style="color: red"></i><span class="tooltipp">remove from wishlist</span></button>
                                                    </c:when>
                                                    <c:otherwise>
                                                <button class="add-to-wishlist" onclick='addProductWishlist("${p.productID}", "${sessionScope.login_account.customerID}")'><i class="fa fa-heart-o" ></i><span class="tooltipp">add to wishlist</span></button>
                                                    </c:otherwise>
                                                </c:choose>

                                        <button class="add-to-compare" onclick='addProductToCompare("${p.productID}")'><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                        <button class="quick-view" onclick="location.href = 'ProductDetail?proid=${p.productID}'"><i class="fa fa-eye"></i><span class="tooltipp">view</span></button>
                                    </div>
                                </div>
                                <div class="add-to-cart">
                                    <button class="add-to-cart-btn" onclick='addProductToCart("${p.productID}")'><i class="fa fa-shopping-cart"></i> add to cart</button>
                                </div>
                            </div>
                        </div>
                        <!-- /product -->
                    </c:forEach>     

                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /Section -->



        <!-- FOOTER -->
        <jsp:include page="client-footer.jsp"/>
        <!-- /FOOTER -->
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
            function addProductToCompare(productid)
            {
                $.ajax({
                    url: "ProductCompareAddServlet?productID=" + productid,
                    type: "POST",
                    //data: {name: name1, price: price1, product_id: id, number: number, registerid: 75, waiter: waiterID},
                    success: function()
                    {

                        location.href = 'compare.jsp';
                    },
                    error: function(jqXHR, textStatus, errorThrown)
                    {
                        alert("error");
                    }
                });
            }
            function addProductToCompare(productid)
            {
                $.ajax({
                    url: "ProductCompareAddServlet?productID=" + productid,
                    type: "POST",
                    //data: {name: name1, price: price1, product_id: id, number: number, registerid: 75, waiter: waiterID},
                    success: function()
                    {

                        location.href = 'compare.jsp';
                    },
                    error: function(jqXHR, textStatus, errorThrown)
                    {
                        alert("error");
                    }
                });
            }

            function addProductToCartWithQuantity(productid)
            {
                var quantity = $("#quantity").val();
                $.ajax({
                    url: "AddProductToCartWithQuatityServlet?command=plus&productID=" + productid + "&quantity=" + quantity,
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

            function addNewReview()
            {
                var content = $('#content').val();
                var rating = $('input:radio[name="rating"]:checked').val();
                if (content.trim() === "") {
                    $("#rating-result").html('<label class="control-label" style="color: red; font-weight: normal;">You need review product</label>');
                    event.preventDefault();
                }
                else if (rating === undefined) {
                    $("#rating-result").html('<label class="control-label" style="color: red; font-weight: normal;">You need rating product</label>');
                    event.preventDefault();
                } else {
                    $.ajax({
                        url: "AddYourReview?proid=" + '${pro.productID}' + "&cusid=" + '${sessionScope.login_account.customerID}' + "&content=" + content + "&rating=" + rating,
                        type: "POST",
                        //data: {name: name1, price: price1, product_id: id, number: number, registerid: 75, waiter: waiterID},
                        success: function()
                        {
                            location.reload();
                        },
                        error: function(jqXHR, textStatus, errorThrown)
                        {
                            //
                        }
                    });
                }
            }
            function loginToReview(productid, customerId)
            {
                var email = $('#email').val();
                var pass = $('#password').val();
                $.ajax({
                    url: "LoginToReview?email=" + email + "&password=" + pass,
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
            function addProductWishlist(productid, customerId)
            {
                $.ajax({
                    url: "AddProductToWishlist?productId=" + productid + "&cusId=" + customerId,
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

            function removeProductWishlist(productid, customerId)
            {
                $.ajax({
                    url: "RemoveProductoutWislist?productId=" + productid + "&cusId=" + customerId,
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
        <script type="text/javascript">
            $(function() {
                var pageSize = 3; // Hiển thị 6 sản phẩm trên 1 trang
                showPage = function(page) {
                    $(".contentPage").hide();
                    $(".contentPage").each(function(n) {
                        if (n >= pageSize * (page - 1) && n < pageSize * page)
                            $(this).show();
                    });
                };
                showPage(1);
                ///** Cần truyền giá trị vào đây **///
                var totalRows = ${ratingListCount}; // Tổng số sản phẩm hiển thị
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
