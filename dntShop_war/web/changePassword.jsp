<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>DNTShop - Change password</title>
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
                            <h3 class="breadcrumb-header">My Account</h3>
                            <ul class="breadcrumb-tree">
                                <li><a href="#">Home</a></li>
                                <li class="active">Change Password</li>
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
                            <form id="PasswordForm" action="changePassword" method="post">
                                <div class="billing-details">
                                    <div class="section-title text-center">
                                        <h3 class="title">Change Password</h3>
                                    </div>
                                    <div class="form-group">
                                        <h5>CURRENT PASSWORD<span style="color: red">*</span></h5>
                                        <input class="input" type="password" id="curpass" name="curpass" placeholder="Enter current Password">
                                        <input class="hidden" type="password" id="oldpass" name="oldpass" value="${sessionScope.login_account.password}">
                                    </div>
                                    <div class="form-group">
                                        <h5>NEW PASSWORD<span style="color: red">*</span></h5>
                                        <input class="input" type="hidden" id="cusid" name="cusid" value="${sessionScope.login_account.customerID}">
                                    <input class="input" type="password" id="pass" name="pass" placeholder="Enter new Password">
                                </div>
                                <div class="form-group">
                                    <h5>CONFIRM PASSWORD<span style="color: red">*</span></h5>
                                    <input class="input" type="password" id="confirmpass" name="confirmpass" placeholder="Confirm Password">
                                </div>
                                <input type="submit" class="input order-submit" style="font-weight: bold; color: red;" value="CHANGE">
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
                $("#PasswordForm").validate({
                    onfocusout: false,
                    onkeyup: false,
                    onclick: false,
                    rules: {
                        "curpass": {
                            required: true,
                            equalTo: "#oldpass"
                        },
                        "pass": {
                            required: true,
                            minlength: 6,
                            maxlength: 30
                        },
                        "confirmpass": {
                            required: true,
                            equalTo: "#pass",
                            minlength: 6
                        }
                    },
                    messages: {
                        "curpass": {
                            required: "Please enter a current password",
                            equalTo: "current password incorrect"
                        },
                        "pass": {
                            required: "Please provide a new password",
                            minlength: "Your password must consist of at least 6 characters",
                            maxlength: "Your password must be maximum 30 characters"
                        },
                        "confirmpass": {
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
