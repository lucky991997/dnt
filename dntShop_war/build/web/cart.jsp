<%@page import="entity.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="entity.Items"%>
<%@page import="entity.Cart"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/> 
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Client/css/elegant-icon/style.css">
        <link rel="stylesheet" href="Client/css/line-icon/css/simple-line-icons.css">
        <link type="text/css" rel="stylesheet" href="Client/css/responsive.css"/>
        <title>DNTShop - Shopping Cart</title>
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include  page="client-header.jsp"></jsp:include>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            String checkout = "";
            Customers cus = (Customers) session.getAttribute("login_account");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            if (cus == null) {
                checkout = "loginCheckout.jsp";
            } else {
                checkout = "checkout.jsp";
            }
        %>
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
                            <h3 class="breadcrumb-header">Shopping cart</h3>                       
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
                        <div class="colorlib-shop p_100">
                            <div class="container">
                                <div class="row row-pb-md">
                                    <div class="col-md-10 col-md-offset-1">
                                        <div class="process-wrap">
                                            <div class="process text-center active">
                                                <p><span>01</span></p>
                                                <h3>Shopping Cart</h3>
                                            </div>
                                            <div class="process text-center">
                                                <p><span>02</span></p>
                                                <h3>Checkout</h3>
                                            </div>
                                            <div class="process text-center">
                                                <p><span>03</span></p>
                                                <h3>Order Complete</h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row row-pb-md">
                                    <div class="col-md-10 col-md-offset-1">
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
                                            <div class="one-eight text-center">
                                                <span>Remove</span>
                                            </div>
                                        </div>
                                    <% for (Map.Entry<String, Items> list : cart.getCartItems().entrySet()) {%>
                                    <div class="product-cart">
                                        <div class="one-forth">
                                            <img class="product-img" src="images/Products/<%=list.getValue().getProduct().getImage1()%>">
                                            </img>
                                            <div class="display-tc">
                                                <h3><%=list.getValue().getProduct().getProductName()%></h3>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <span class="price">$<%=list.getValue().getProduct().getPrice()*(100-list.getValue().getProduct().getDiscountProduct())/100%></span>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <input type="number" id="qt<%=list.getValue().getProduct().getProductID()%>" onchange='edit_posale("<%=list.getValue().getProduct().getProductID()%>")' name="quantity" class="form-control input-number text-center" value="<%=list.getValue().getQuantity()%>" min="1" max="99">
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <span class="price">$<%=list.getValue().getProduct().getPrice() * list.getValue().getQuantity()%></span>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <a href="#" class="closed" onclick='RemoveCart("<%=list.getValue().getProduct().getProductID()%>")'></a>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-10 col-md-offset-1">
                                    <div class="total-wrap">
                                        <div class="row">
                                            <div class="col-md-8">
                                            </div>
                                            <div class="col-md-3 col-md-push-1 text-center">
                                                <div class="total">
                                                    <div class="grand-total">
                                                        <p><span><strong>Total:</strong></span> <span>$<%=cart.totalCart()%></span></p>
                                                    </div>
                                                    <div class="col-md-12" style="padding: 40px 0px;">
                                                        <input type="submit" onclick="location.href='<%=checkout%>'" value="Check out" class="btn btn-primary">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
        <jsp:include  page="client-footer.jsp"></jsp:include>
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
            function RemoveCart(productid)
            {
                $.ajax({
                    url: "AddProductToCart?command=remove&productID=" + productid,
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
            function edit_posale(productid)
            {
                var qt1 = $('#qt' +  productid).val();
                if (qt1 > 99) {
                    swal("Quantity isn't more than 99");
                } else
                {
                    $.ajax({
                        url: "EditCartServlet?productID="+productid+"&quantity="+qt1,
                        type: "POST",
                        success: function()
                        {
                            location.reload();
                        },
                        error: function(jqXHR, textStatus, errorThrown)
                        {
                            alert(orderid + "\n" + qt1 + "\n" + productid);
                        }
                    });

                }

            }

        </script>
    </body>
</html>
