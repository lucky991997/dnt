<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
            <title>Reset Password</title>

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
                            <li><a href="#"><i class="fa fa-users"></i> Customer Account</a></li>
                            <li class="active">Reset Password</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="example-modal">
                            <div class="modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form id="resetPass" action="adminResetPasswordCustomer" method="post">
                                            <div class="modal-header">                                           
                                                <h4 class="modal-title">Reset Password</h4>
                                            </div>
                                            <div class="modal-body">                                             
                                                <div class="form-group">
                                                    <label for="exampleInputPassword">New Password<span style="color:red">*</span></label>
                                                    <input type="password" class="form-control" id="exampleInputPassword" name="password" placeholder="Enter New Password" required="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputPassword">Confirm Password<span style="color:red">*</span></label>
                                                    <input type="password" class="form-control" id="exampleInputRePassword" name="repassword" placeholder="Enter Confirm Password" required="true">
                                                </div> 
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-primary">Save</button>
                                            </div>
                                        </form>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->
                        </div><!-- /.example-modal -->
                    </section><!-- /.content -->
                </div><!-- /.content-wrapper -->

                <!-- Main Footer -->
            <jsp:include page="admin-main-footer.jsp"></jsp:include>

        </div><!-- ./wrapper -->   
        <script type="text/javascript">
            $().ready(function() {
                $("#resetPass").validate({
                    onfocusout: false,
                    onkeyup: false,
                    onclick: false,
                    rules: {
                        "password": {
                            required: true,
                            minlength: 6,
                            maxlength: 30
                        },
                        "repassword": {
                            required: true,
                            equalTo: "#exampleInputPassword",
                            minlength: 6
                        }
                    },
                    messages: {
                        "password": {
                            required: "Please provide a password",
                            minlength: "Your password must consist of at least 6 characters",
                            maxlength: "Your password must be maximum 30 characters"
                        },
                        "repassword": {
                            required: "Please provide a password",
                            equalTo: "Please enter the same password as above",
                            minlength: "Your password must consist of at least 6 characters"
                        }
                    }
                });
            });
        </script>
    </body>
</html>
