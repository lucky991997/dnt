<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
            <title>Add New Customer</title>
            <style>
                label.error{
                    color: red;
                    font-weight: normal;
                }
            </style>
        </head>
        <!--
        BODY TAG OPTIONS:
        =================
        Apply one or more of the following classes to get the
        desired effect
        |---------------------------------------------------------|
        | SKINS         | skin-blue                               |
        |               | skin-black                              |
        |               | skin-purple                             |
        |               | skin-yellow                             |
        |               | skin-red                                |
        |               | skin-green                              |
        |---------------------------------------------------------|
        |LAYOUT OPTIONS | fixed                                   |
        |               | layout-boxed                            |
        |               | layout-top-nav                          |
        |               | sidebar-collapse                        |
        |               | sidebar-mini                            |
        |---------------------------------------------------------|
        -->
        <body class="skin-blue sidebar-mini">
        <%
            session.setAttribute("currentAdminPage", "customer");
            session.setAttribute("currentAdminPageChild", "addCustomer");
        %>
        <div class="wrapper">

            <!-- Main Header -->
            <jsp:include page="admin-main-header.jsp"></jsp:include>
                <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="admin-main-sidebar.jsp"></jsp:include>

                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>
                            Customer Manager                            
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-users"></i>Customer Account</a></li>
                            <li class="active">Create</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-default">
                            <form id="AddCusForm" action="adminAddCustomer" method="post" enctype="multipart/form-data">
                                <div class="box-header with-border">
                                    <h3 class="box-title">CREATE NEW CUSTOMER</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputFName">First Name<span style="color:red">*</span></label>
                                                <input type="text" class="form-control" id="exampleInputFName" name="fName" placeholder="Enter first name" required="true">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputLName">Last Name<span style="color:red">*</span></label>
                                                <input type="text" class="form-control" id="exampleInputLName" name="lName" placeholder="Enter last name" required="true">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail">Email<span style="color:red">*</span></label>
                                                <span id="email-result"></span>
                                                <input type="email" class="form-control" id="exampleInputEmail" name="email" placeholder="Enter email" required="true">
                                            </div>                                           
                                        </div><!-- /.col -->
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Gender<span style="color:red">*</span></label>
                                                <select class="form-control" name="gender" required="true">
                                                    <option value="">--</option>
                                                    <option value="Male">Male</option>
                                                    <option value="Female">Female</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPhone">Phone<span style="color:red">*</span></label>
                                                <input type="text" class="form-control" id="phone" name="phone" data-inputmask='"mask": "(999) 999-9999"' data-mask />
                                            </div>  
                                            <div class="form-group">
                                                <label for="exampleInputAddress">Address</label>
                                                <input type="text" class="form-control" id="exampleInputAddress" name="address" placeholder="Enter address">
                                            </div>       
                                        </div><!-- /.col -->       
                                    </div><!-- /.row -->
                                    <div class="row">                                   
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputPass">Password<span style="color:red">*</span></label>
                                                <input type="password" class="form-control" id="exampleInputPassword" name="password" placeholder="Enter password" required="true">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputRepass">Re-password<span style="color:red">*</span></label>
                                                <input type="password" class="form-control" id="exampleInputRepass" name="repassword" placeholder="Enter re-password" required="true">
                                            </div>
                                        </div>
                                    </div>             
                                    <div class="row">                                   
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputFile">Avatar</label>
                                                <input type="file" id="exampleInputFile" name="inputImage" onchange="readURL(this);" style="display: none;" accept="image/*">
                                                <input type="button" value="Choose image" onclick="document.getElementById('exampleInputFile').click();"/>
                                                <p class="help-block"><img id="blah" src="#" alt="" class="img-circle" width="80px" height="80px"/></p>
                                            </div>
                                        </div>                  
                                    </div>
                                </div><!-- /.box-body -->
                                <div class="box-footer">
                                    <div class="box-tools pull-right">
                                        <button type="submit" class="btn btn-primary">Create</button>
                                    </div>                           
                                </div>
                            </form>
                        </div><!-- /.box -->                    
                    </section><!-- /.content -->
                </div><!-- /.content-wrapper -->

                <!-- Main Footer -->
            <jsp:include page="admin-main-footer.jsp"></jsp:include>

        </div><!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->
        <script type="text/javascript">
            function readURL(input) {
                /*************** check image **********/
                var fileInput = document.getElementById('exampleInputFile');
                var filePath = fileInput.value;
                var allowedExtensions = /(\.jpg|\.png|\.jpeg|\.gif)$/i;
                if (!allowedExtensions.exec(filePath)) {
                    alert('Please upload file having extensions .jpg/.png/.jpeg/.gif only.');
                    fileInput.value = '';
                    $('#blah').attr('src', '#');
                    return false;
                } else {
                    //Image preview
                    if (fileInput.files && fileInput.files[0]) {
                        var reader = new FileReader();
                        reader.onload = function(e) {
                            $('#blah')
                                    .attr('src', e.target.result)
                                    .width(80)
                                    .height(80);
                        };
                        reader.readAsDataURL(input.files[0]);
                    }
                }
            }
            /*************** check Email unique **********/
            $(document).ready(function() {
                var x_timer;
                $("#exampleInputEmail").keyup(function(e) {
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
            $('#AddCusForm').submit(function(event) {
                var errors = $('#email-resultError').attr('value');
                if (errors === 'false' || errors === null) {
                    $('#exampleInputEmail').focus();
                    event.preventDefault();
                }
            });
        </script>
        <script type="text/javascript">
            $().ready(function() {
                $("#AddCusForm").validate({
                    onfocusout: false,
                    onkeyup: false,
                    onclick: false,
                    rules: {
                        "fName": {
                            required: true,
                            maxlength: 50
                        },
                        "lName": {
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
                        "repassword": {
                            required: true,
                            equalTo: "#exampleInputPassword",
                            minlength: 6
                        },
                        "address": {
                            required: true,
                            validateAddress: true
                        },
                        "phone": {
                            required: true,
                            validatePhone: true
                        },
                        "gender": {
                            required: true
                        }
                    },
                    messages: {
                        "fName": {
                            required: "Please enter a first name",
                            maxlength: "Your first name must be maximum 50 characters"
                        },
                        "lName": {
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
                        "repassword": {
                            required: "Please provide a password",
                            equalTo: "Please enter the same password as above",
                            minlength: "Your password must consist of at least 6 characters"
                        },
                        "address": {
                            required: "Please enter a your address"
                        },
                        "phone": {
                            required: "Please enter a phone number"
                        },
                        "gender": {
                            required: "Please choose a gender"
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
