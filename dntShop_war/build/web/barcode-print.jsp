<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Print Barcode</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.4 -->
        <link href="Admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Font Awesome Icons -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="Admin/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body onload="window.print();">
        <div class="wrapper">
            <!-- Main content -->
            <section class="invoice">

                <div class="row">
                    <!-- accepted payments column -->
                    <div class="col-xs-6">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                    </div><!-- /.col -->
                    <div class="col-xs-6">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                        <img alt="my Image" src="CreateBarCode?value=${value}">
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </section><!-- /.content -->
        </div><!-- ./wrapper -->

        <!-- AdminLTE App -->
        <script src="Admin/dist/js/app.min.js" type="text/javascript"></script>
    </body>
</html>

