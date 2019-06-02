<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>DNTShop - Reset Password</title>
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
            <!-- /HEADER -->

            <!-- NAVIGATION -->
        <jsp:include page="client-navigation.jsp"></jsp:include>
            <!-- /NAVIGATION -->

            <!-- BREADCRUMB -->
            <div id="breadcrumb" class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="breadcrumb-header">Login Page</h3>
                            <ul class="breadcrumb-tree">
                                <li><a href="#">Home</a></li>
                                <li class="active">Login</li>
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

                        <div class="col-md-3">                        
                        </div>

                        <div class="col-md-5 order-details">                      
                            <!-- Login Account -->
                            <form id="formLogin" action="resetPasswordServlet" method="post">
                                <div class="billing-details">
                                    <div class="section-title text-center">
                                        <h3 class="title">RETRIEVE YOUR PASSWORD</h3>
                                    </div>                            
                                    <div class="form-group">
                                        <h5>NEW PASSWORD</h5>
                                        <input class="input" type="password" id="password" name="password" placeholder="Enter your new Password" >
                                    </div>
                                    <div class="form-group">
                                        <h5>CONFIRM PASSWORD</h5>
                                        <input class="input" type="password" id="password_confirm" name="password_confirm"  placeholder="Confrim Password" >
                                    </div>
                                    <div id="message" class="form-group">
                                    </div>
                                    <input type="submit" class="input order-submit" style="font-weight: bold; color: red;" value="Submit">
                                </div>
                            </form>

                            <!-- /Login Account -->
                        </div>

                        <div class="col-md-4">                        
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
            $().ready(function() {
                $("#formLogin").validate({
                    onfocusout: false,
                    onkeyup: false,
                    onclick: false,
                    rules: {
                        "password": {
                            required: true,
                            minlength: 6,
                            maxlength: 30
                        },
                        "password_confirm": {
                            required: true,
                            equalTo: "#password",
                            minlength: 6
                        }
                    },
                    messages: {
                        "password": {
                            required: "Please provide a new password",
                            minlength: "Your password must consist of at least 6 characters",
                            maxlength: "Your password must be maximum 30 characters"
                        },
                        "password_confirm": {
                            required: "Please provide a new password",
                            equalTo: "Please enter the same password as above",
                            minlength: "Your password must consist of at least 6 characters"
                        }
                    }
                });
            });
        </script>
    </body>
</html>
