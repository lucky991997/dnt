<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
        <title>Add Account</title>
        
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
            session.setAttribute("currentAdminPage", "admin");
            session.setAttribute("currentAdminPageChild", "addAccount");
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
                            Admin Manager                        
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-user"></i> Admin Account</a></li>
                            <li class="active">Create</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="example-modal">
                            <div class="modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form id="addAccount" action="adminAddAccount" method="post" enctype="multipart/form-data">
                                            <div class="modal-header">                                           
                                                <h4 class="modal-title">CREATE NEW ACCOUNT</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="exampleInputFullName">Full name<span style="color:red">*</span></label>
                                                    <input type="text" class="form-control" id="exampleInputName" name="fullName" placeholder="Enter fullname" required="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputEmail">Email address<span style="color:red">*</span></label>
                                                    <span id="email-result"></span>
                                                    <input type="email" class="form-control" id="exampleInputEmail" name="email" placeholder="Enter email" required="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputPassword">Password<span style="color:red">*</span></label>
                                                    <input type="password" class="form-control" id="exampleInputPassword" name="password" placeholder="Password" required="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputRePassword">Re-password<span style="color:red">*</span></label>
                                                    <input type="password" class="form-control" id="exampleInputRePassword" name="repassword" placeholder="Password" required="true">
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputFile">Image input</label>
                                                    <input type="file" id="exampleInputFile" name="inputImage" accept="image/*" onchange="readURL(this);" style="display: none;">
                                                    <input type="button" value="Choose image" onclick="document.getElementById('exampleInputFile').click();"/>
                                                    <p class="help-block"><img id="blah" src="#" alt="" class="img-circle" width="80px" height="80px"/></p>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-primary">Create</button>
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
                    $.post('adminCheckAddEmailAccount', {'email': email}, function(data) {
                        $("#email-result").html(data);
                    });
                }
            });
            /*************** focus Email error  **********/
            $('#addAccount').submit(function(event) {
                var errors = $('#email-resultError').attr('value');
                if (errors === 'false' || errors === null) {
                    $('#exampleInputEmail').focus();
                    event.preventDefault();
                }
            });
        </script>
        <script type="text/javascript">
            $().ready(function() {
                $("#addAccount").validate({
                    onfocusout: false,
                    onkeyup: false,
                    onclick: false,
                    rules: {
                        "fullName": {
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
                        }
                    },
                    messages: {
                        "fullName": {
                            required: "Please enter a full name",
                            maxlength: "Your full name must be maximum 50 characters"
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
                        }
                    }
                });
            });
        </script>
    </body>
</html>
