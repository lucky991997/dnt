<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>DNTShop - Create New Account</title>
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
                            <h3 class="breadcrumb-header">Register Page</h3>
                            <ul class="breadcrumb-tree">
                                <li><a href="#">Home</a></li>
                                <li class="active">Register</li>
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

                        <!-- Register -->
                        <div class="col-md-6 order-details">
                            <!-- Register Account -->
                            <form id="formRegis" action="Register" method="post">
                                <div class="billing-details">
                                    <div class="section-title text-center">
                                        <h3 class="title">Register</h3>
                                    </div>                            
                                    <div class="form-group">
                                        <label>FIRST NAME<span style="color: red">*</span></label>
                                        <input class="input" type="text" name="first-name" placeholder="First Name">
                                    </div>
                                    <div class="form-group">
                                        <label>LAST NAME<span style="color: red">*</span></label>
                                        <input class="input" type="text" name="last-name" placeholder="Last Name">
                                    </div>
                                    <div class="form-group">
                                        <label>EMAIL<span style="color: red">*</span></label>
                                        <span id="email-result"></span>
                                        <input class="input" type="email" id="email" name="email" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label>PASSWORD<span style="color: red">*</span></label>
                                        <input class="input" type="password" id="password" name="password" placeholder="Password">
                                    </div>  
                                    <div class="form-group">
                                        <label>CONFIRM PASSWORD<span style="color: red">*</span></label>
                                        <input class="input" type="password" name="confirmpass" placeholder="Confirm Password">
                                    </div>
                                    <div class="form-group">
                                        <label>ADDRESS<span style="color: red">*</span></label>
                                        <input class="input" type="text" name="address" placeholder="Address">
                                    </div>                           
                                    <div class="form-group">
                                        <label>PHONE<span style="color: red">*</span></label>
                                        <input class="input" type="text" id="tel" name="tel" placeholder="Telephone" data-inputmask='"mask": "(999) 999-9999"' data-mask />
                                    </div>
                                    <div class="form-group">
                                        <label>GENDER<span style="color: red">*</span></label>
                                        <select class="input" name="gender">
                                            <option value="">Choose a gender</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                        </select>
                                    </div>
                                    <input type="submit" class="input order-submit" style="font-weight: bold; color: red;" value="REGISTER">
                                    <br/>
                                    <div class="form-group" style="float: right">
                                        <span>Already have an account?</span> 
                                        <a href="login.jsp"><span style="color: blue">Login</span></a>
                                    </div>
                                </div>
                            </form>                       
                            <!-- /Register Account -->
                        </div>
                        <!-- /Register-->

                        <div class="col-md-3">                        
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
                $("#formRegis").validate({
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
                        "password": {
                            required: true,
                            minlength: 6,
                            maxlength: 30
                        },
                        "confirmpass": {
                            required: true,
                            equalTo: "#password",
                            minlength: 6
                        },
                        "address": {
                            required: true,
                            validateAddress: true
                        },
                        "tel": {
                            required: true,
                            validatePhone: true
                        },
                        "gender": {
                            required: true
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
                        "password": {
                            required: "Please provide a password",
                            minlength: "Your password must consist of at least 6 characters",
                            maxlength: "Your password must be maximum 30 characters"
                        },
                        "confirmpass": {
                            required: "Please provide a password",
                            equalTo: "Please enter the same password as above",
                            minlength: "Your password must consist of at least 6 characters"
                        },
                        "address": {
                            required: "Please enter a your address"
                        },
                        "tel": {
                            required: "Please enter a phone number"
                        },
                        "gender": {
                            required: "Please choose a gender"
                        }
                    }
                });
                $.validator.addMethod("validatePhone", function(value, element) {
                    return this.optional(element) || /^[(]{1}[0]{1}[0-9\-\s\)\+]{12}$/i.test(value);
                },"Please enter a valid phone number");
                $.validator.addMethod("validateAddress", function(value, element) {
                    return this.optional(element) || /^\d+[ |/](?:[/A-Za-z0-9-]+[ ]?)+(?:,)+(?:[ A-Za-z0-9-]+[ ]?)+(?:,)+(?:[A-Za-z0-9 -]+[ ]?)?(?:,)?(?:[A-Za-z -]+[ ]?)$/i.test(value);
                },"Please enter a valid address (ex: 50 Vo Van Kiet, district 1, Ho Chi Minh city)");
            });
            $(function() {
                $("[data-mask]").inputmask();
            });
            
            /*************** check Email unique **********/
            $(document).ready(function() {
                var x_timer;
                $("#email").keyup(function(e) {
                    clearTimeout(x_timer);
                    var email = $(this).val();
                    x_timer = setTimeout(function() {
                        check_email_ajax(email);
                    }, 1000);
                });

                function check_email_ajax(email) {
                    $("#email-result").html('<label id="email-resultError" class="control-label pull-right" value="false" style="color: orange"><i class="fa fa-bell-o"></i> Waiting ...</label>');
                    $.post('adminCheckAddEmailCustomer', {'email': email}, function(data) {
                        $("#email-result").html(data);
                    });
                }
            });
            /*************** focus Email error  **********/
            $('#formRegis').submit(function(event) {
                var errors = $('#email-resultError').attr('value');
                if (errors === 'false' || errors === null) {
                    $('#email').focus();
                    event.preventDefault();
                }
            });
        </script>
    </body>
</html>
