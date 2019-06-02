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
                checkout = "login.jsp";
            } else {
                checkout = "checkout.jsp";
            }
        %>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <jsp:include  page="client-navigation.jsp"></jsp:include>
            <!-- /NAVIGATION -->

            <!-- /BREADCRUMB -->

            <!-- SECTION -->
            <section class="solid_banner_area">
                <div class="container">
                    <div class="solid_banner_inner">
                        <h3>empty cart</h3>
                    </div>
                </div>
            </section>
            <section class="emty_cart_area p_100">
                <div class="container">
                    <div class="emty_cart_inner">
                        <i class="icon-handbag icons"></i>
                        <h3>Your Cart is Empty</h3>
                        <h4>back to <a href="AllProduct">shopping</a></h4>
                    </div>
                </div>
            </section>
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
                var qt1 = $('#qt' + productid).val();
                if (qt1 > 9) {
                    swal("Quantity isn't more than 9");
                } else
                {
                    $.ajax({
                        url: "EditCartServlet?productID=" + productid + "&quantity=" + qt1,
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
