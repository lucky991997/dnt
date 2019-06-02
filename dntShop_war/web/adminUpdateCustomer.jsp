<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
            <title>Add Edit Customer</title>
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
                            <li class="active">Edit</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="box box-default">
                            <form id="UpdateCusForm" action="adminUpdateCustomer" method="post" enctype="multipart/form-data">
                                <div class="box-header with-border">
                                    <h3 class="box-title">EDIT CUSTOMER</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputFName">First Name<span style="color:red">*</span></label>
                                                <input type="text" class="form-control" id="exampleInputFName" name="fName" value="${cus.firstName}" placeholder="Enter first name" required="true">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputLName">Last Name<span style="color:red">*</span></label>
                                            <input type="text" class="form-control" id="exampleInputLName" name="lName" value="${cus.lastName}" placeholder="Enter last name" required="true">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail">Email</label>
                                            <input type="email" class="form-control" id="exampleInputEmail" name="email" value="${cus.email}" placeholder="Enter email" disabled="true" required="true">
                                        </div>                                           
                                    </div><!-- /.col -->
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Gender<span style="color:red">*</span></label>
                                            <select class="form-control" name="gender" required="true">                             
                                                <c:choose>
                                                    <c:when test="${cus.gender eq true}">
                                                        <option value="Male" selected="true">Male</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="Male">Male</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${cus.gender eq false}">
                                                        <option value="Female" selected="true">Female</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="Female">Female</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPhone">Phone<span style="color:red">*</span></label>
                                            <input type="text" class="form-control" id="phone" name="phone" value="${cus.phone}" data-inputmask='"mask": "(999) 999-9999"' data-mask />
                                        </div>  
                                        <div class="form-group">
                                            <label for="exampleInputAddress">Address<span style="color:red">*</span></label>
                                            <input type="text" class="form-control" id="exampleInputAddress" name="address" value="${cus.address}" placeholder="Enter address">
                                        </div>       
                                    </div><!-- /.col -->       
                                </div><!-- /.row -->        
                                <div class="row">                                   
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="exampleInputFile">Avatar</label>
                                            <input type="file" id="exampleInputFile" name="inputImage" onchange="readURL(this);" style="display: none;" accept="image/*">
                                            <input type="button" value="Choose image" onclick="document.getElementById('exampleInputFile').click();"/>
                                            <p class="help-block"><img id="blah" src="${cus.avatar}" alt="" class="img-circle" width="80px" height="80px"/></p>
                                        </div>
                                    </div>                  
                                </div>
                            </div><!-- /.box-body -->
                            <div class="box-footer">
                                <div class="box-tools pull-right">
                                    <button type="submit" class="btn btn-primary">Save changes</button>
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
                        $('#blah').attr('src', '${cus.avatar}');
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
        </script>
        <script type="text/javascript">
            $().ready(function() {
                $("#UpdateCusForm").validate({
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
