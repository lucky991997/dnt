<%@page import="entity.Customers"%>
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
        <title>DTNShop</title>
        <style>
            label.error{
                color: red;
                font-weight: normal;
            }
        </style>
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include  page="client-header.jsp"></jsp:include>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            Customers cus = (Customers) session.getAttribute("login_account");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>

        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <jsp:include  page="client-navigation.jsp"></jsp:include>
            <!-- /NAVIGATION -->

            <!-- SECTION -->

            <!-- /SECTION -->
            <!--================End Categories Banner Area =================-->

            <!--================Shopping Cart Area =================-->
            <div id="breadcrumb" class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="breadcrumb-header">Checkout</h3>
                            <ul class="breadcrumb-tree">
                                <li><a href="#">Home</a></li>
                                <li class="active">Checkout</li>
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
                        <div class="row row-pb-md">
                                    <div class="col-md-10 col-md-offset-1">
                                        <div class="process-wrap">
                                            <div class="process text-center active">
                                                <p><span>01</span></p>
                                                <h3>Shopping Cart</h3>
                                            </div>
                                            <div class="process text-center active">
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
                        <form id="PlaceOrderForm" action="PlaceOrderServlet" method="post">
                            <div class="col-md-7">
                                <!-- Billing Details -->
                                <div class="billing-details">

                                    <div class="section-title">
                                        <h3 class="title">Billing address</h3>
                                    </div>
                                    <div class="form-group">
                                        <input class="input" type="text" name="first-name" placeholder="First Name" value="<%= cus.getFirstName()%>">
                                </div>
                                <div class="form-group">
                                    <input class="input" type="text" name="last-name" placeholder="Last Name" value="<%= cus.getLastName()%>">
                                </div>
                                <div class="form-group">
                                    <input class="input" type="email" name="email" placeholder="Email" value="<%= cus.getEmail()%>" disabled="true">
                                </div>
                                <div class="form-group">
                                    <input class="input" type="text" name="address" placeholder="Address" value="<%= cus.getAddress()%>">
                                </div>
                                <div class="form-group">
                                    <input class="input" type="text" id="tel" name="tel" placeholder="Telephone" value="<%= cus.getPhone()%>" data-inputmask='"mask": "(999) 999-9999"' data-mask />
                                </div>
                            </div>
                            <!-- /Billing Details -->


                            <!-- Order notes -->
                            <div class="order-notes">
                                <textarea class="input" name="shipnote" placeholder="Order Notes"></textarea>
                            </div>
                            <!-- /Order notes -->
                        </div>

                        <!-- Order Details -->
                        <div class="col-md-5 order-details">
                            <div class="section-title text-center">
                                <h3 class="title">Your Order</h3>
                            </div>
                            <div class="order-summary">
                                <div class="order-col">
                                    <div><strong>PRODUCT</strong></div>
                                    <div><strong>TOTAL</strong></div>
                                </div>
                                <div class="order-products">
                                    <% for (Map.Entry<String, Items> list : cart.getCartItems().entrySet()) {%>
                                    <div class="order-col">
                                        <div><%=list.getValue().getQuantity()%>x <%=list.getValue().getProduct().getProductName()%></div>
                                        <div>$<%=list.getValue().getProduct().getPrice() * (100 - list.getValue().getProduct().getDiscountProduct()) / 100 * list.getValue().getQuantity()%></div>
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                                <div class="order-col">
                                    <div>Shipped</div>
                                    <div><strong>FREE</strong></div>
                                </div>
                                <div class="order-col">
                                    <div><strong>TOTAL</strong></div>
                                    <div><strong class="order-total">$<%=cart.totalCart()%></strong></div>
                                </div>
                            </div>
                            <div class="payment-method">
                                <div class="input-radio">
                                    <input type="radio" name="payment" value="Cash On Delivery" id="payment-3" checked="true">
                                    <label for="payment-3">
                                        <span></span>
                                        Cash On Delivery
                                    </label>
                                    <div class="caption">
                                        <p>Payment method in which ordered goods are carried to the buyer's place but are handed over only upon full payment. Also called collect on delivery.</p>
                                    </div>
                                </div>
                            </div>
                            <input type="submit" class="primary-btn order-submit" value="Place order">
                        </div>
                        <!-- /Order Details -->
                    </form>
                </div>

                <!-- /row -->
            </div>
            <!-- /container -->
        </div>

        <!-- /SECTION -->


        <!-- FOOTER -->

        <!-- /top footer -->

        <!-- bottom footer -->
        <jsp:include page="client-footer.jsp"/>
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
        $().ready(function() {
            $("#PlaceOrderForm").validate({
                onfocusout: false,
                onkeyup: false,
                onclick: false,
                rules: {
                    "first-name": {
                        required: true,
                        maxlength: 50
                    },
                    "last-name": {
                        required: true,
                        maxlength: 50
                    },
                    "email": {
                        required: true,
                        email: true,
                        maxlength: 100
                    },
                    "address": {
                        required: true,
                        validateAddress: true
                    },
                    "tel": {
                        required: true,
                        validatePhone: true
                    }
                },
                messages: {
                    "first-name": {
                        required: "Please enter a first name",
                        maxlength: "Your first name must be maximum 50 characters"
                    },
                    "last-name": {
                        required: "Please enter a last name",
                        maxlength: "Your last name must be maximum 50 characters"
                    },
                    "email": {
                        required: "Please enter a valid email address",
                        email: "Please enter a valid email address",
                        maxlength: "Your email must be maximum 100 characters"
                    },
                    "address": {
                        required: "Please enter a your address"
                    },
                    "tel": {
                        required: "Please enter a phone number"
                    }
                }
            });
            $.validator.addMethod("validatePhone", function(value, element) {
                return this.optional(element) || /^[(]{1}[0]{1}[0-9\-\s\)\+]{12}$/i.test(value);
            }, "Please enter a valid phone number");
            $.validator.addMethod("validateAddress", function(value, element) {
                return this.optional(element) || /^\d+[ |/](?:[/A-Za-z0-9-]+[ ]?)+(?:,)+(?:[ A-Za-z0-9-]+[ ]?)+(?:,)+(?:[A-Za-z0-9 -]+[ ]?)?(?:,)?(?:[A-Za-z -]+[ ]?)$/i.test(value);
            }, "Please enter a valid address (ex: 50 Vo Van Kiet, district 1, Ho Chi Minh city)");
        });
        $(function() {
            $("[data-mask]").inputmask();
        });
    </script>
    </body> 
</html>
