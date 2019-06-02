<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
        <title>Barcode</title>
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
            session.setAttribute("currentAdminPage", "barcode");
            session.setAttribute("currentAdminPageChild", "barcode");
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
                            BARCODE
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-barcode"></i> Barcode</a></li>
                            <li class="active">Print</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="example-modal">
                            <div class="modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form id="BarcodeForm" method="post" action="adminPrintBarCode" target="_blank">
                                            <div class="modal-header">                                             
                                                <h4 class="modal-title">PRINT BARCODE</h4>
                                            </div>                                        
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="exampleInputCateName">Code<span style="color:red">*</span></label>
                                                    <input type="text" class="form-control" id="barcode" name="barcode" placeholder="Input barcode">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-default"><i class="fa fa-print"></i>Print</button>
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

        <!-- REQUIRED JS SCRIPTS -->
        <script type="text/javascript">
            $().ready(function() {
                $("#BarcodeForm").validate({
                    onfocusout: false,
                    onkeyup: false,
                    onclick: false,
                    rules: {
                        "barcode": {
                            required: true
                        }
                    },
                    messages: {
                        "barcode": {
                            required: "Please enter a barcode"
                        }
                    }
                });
            });
        </script>
    </body>
</html>
