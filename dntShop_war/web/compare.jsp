<%@page import="entity.ComparedDetailProduct"%>
<%@page import="entity.ProductsDetails"%>
<%@page import="entity.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="entity.Items"%>
<%@page import="entity.ComparedProduct"%>
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
    <style type="text/css">
        div.comparisontable{
            display: flex;
            flex-direction: column;
        }

        div.comparisontable img{
            max-width: 100%;
            width: auto;
            height: auto;
        }


        div.comparisontable ul.row{
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
            flex: 1;
            width: 100%;
            flex-wrap: wrap;
        }

        div.comparisontable ul.row li{
            background: white;
            flex: 1;
            padding: 10px;
            border-bottom: 1px solid gray;
        }

        div.comparisontable ul.row li.legend{
            background: #6640d8;
            color: white;
            font-weight: bold;
            border: none;
            width: 200px;
            border-bottom: 1px solid white;
        }

        div.comparisontable ul.row li:last-of-type{
        }

        /* very first row */
        div.comparisontable ul.row:first-of-type li{
            text-align: center;
        }

        /* very last row */
        div.comparisontable ul.row:last-of-type li{
            text-align: center;
            border-bottom: none;
            box-shadow: 0 6px 6px rgba(0,0,0,0.23);
        }

        div.comparisontable a.calltoaction{
            color: white;
            background: #e12525;
            display: inline-block;
            padding: 8px 10px;
            text-decoration: none;
            border-radius: 8px;
            margin: .1em auto;
        }

        div.comparisontable a.calltoaction:hover{
            background: #d11212;
        }


        /* first and last cell within legend column */
        div.comparisontable ul.row:first-of-type li.legend.legend,
        div.comparisontable ul.row:last-of-type li.legend{
            background: transparent;
            box-shadow: none;
        }

        @media screen and (max-width:650px){

            div.comparisontable ul.row{
                flex-direction: column;
            }

            div.comparisontable img{
                width: auto;
                height: auto;
            }

            div.comparisontable ul.row li{
                margin-right: 0;
                flex: auto;
                width: auto;
            }

            /* first and last cell within legend column */
            div.comparisontable ul.row:first-of-type li.legend.legend,
            div.comparisontable ul.row:last-of-type li.legend{
                display: none;
            }

            div.comparisontable ul.row li.legend{
                width: auto;
            }
        }
    </style>
    <body>
        <!-- HEADER -->
        <jsp:include  page="client-header.jsp"></jsp:include>
        <%
            ComparedProduct compare = (ComparedProduct) session.getAttribute("compare");
            ComparedDetailProduct detailProduct = (ComparedDetailProduct) session.getAttribute("details");
            if (compare == null) {
                compare = new ComparedProduct();
                session.setAttribute("compare", compare);
            }
            if (detailProduct == null) {
                detailProduct = new ComparedDetailProduct();
                session.setAttribute("details", detailProduct);
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
                            <h3 style="text-align: center">Compare Product</h3>                       
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /BREADCRUMB -->

            <!-- SECTION -->
            <div class="comparisontable">


                <ul class="row">
                    <li class="legend">Item</li>
                    <% for (Products p : compare.getComparedProducts()) {%>
                <li><img src="images/Products/<%= p.getImage1()%>" />
                    <br/>
                    <a href="#" class="closed" onclick='RemoveCompare("<%=p.getProductID()%>")'><i class="fa fa-trash-o"></i></a>
                </li>
                    <%}%>
            </ul>
            <ul class="row">
                    <li class="legend">Name</li>
                    <% for (Products p : compare.getComparedProducts()) {%>
                    <li><a href="ProductDetail?proid=<%= p.getProductID() %>"><%= p.getProductName()%></a>
                </li>
                    <%}%>
            </ul>

            <ul class="row">
                <li class="legend">CPU</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getCpu()%></li>
                    <%}%>

            </ul>

            <ul class="row">
                <li class="legend">Display</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getDisplay()%></li>
                    <%}%>
            </ul>

            <ul class="row">
                <li class="legend">Camera</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getCamera()%></li>
                    <%}%>
            </ul>

            <ul class="row">
                <li class="legend">HDD</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getHdd()%></li>
                    <%}%>
            </ul>
            <ul class="row">
                <li class="legend">Memory</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getMemory()%></li>
                    <%}%>
            </ul>
            <ul class="row">
                <li class="legend">Weights</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getWeights()%></li>
                    <%}%>
            </ul>
            <ul class="row">
                <li class="legend">Vga</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li><%= pd.getVga()%></li>
                    <%}%>
            </ul>

            <ul class="row">
                <li class="legend" >Price</li>
                    <% for (ProductsDetails pd : detailProduct.getDetailsProducts()) {%>
                <li style="color: red">$<%= pd.getProductID().getPrice()*(100-pd.getProductID().getDiscountProduct())/100 %></li>
                <%}%>          
            </ul>
            <ul class="row">        
            </ul>

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
            function RemoveCompare(productid)
            {
                $.ajax({
                    url: "ProductCompareRemoveServlet?productID=" + productid,
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
                if (qt1 > 99) {
                    swal("Quantity isn't more than 99");
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
