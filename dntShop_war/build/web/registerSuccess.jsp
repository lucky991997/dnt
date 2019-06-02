<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="client-layout.jsp"/>
        <title>Registered</title>

    </head>
    <body>
        <!-- HEADER -->
        <jsp:include page="client-header.jsp"/>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <jsp:include page="client-navigation.jsp"/>
        <!-- /NAVIGATION -->

        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="breadcrumb-header">Registered</h3>

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
                    <div class="col-md-10 col-md-offset-1 text-center">
                        <span class="icon"><i class="fa fa-check-circle-o" style="font-size: 100px; color: #31b131;"></i></span>
                        <h2>You have been successfully registered!</h2>
                        <p>
                            <a href="login.jsp" class="newsletter-btn">Go back to Login</a>
                        </p>
                    </div>
                </div>


            </div>
            <!-- /row -->
        </div>
        <!-- /container -->

        <!-- /SECTION -->



        <!-- FOOTER -->
        <jsp:include page="client-footer.jsp"/>
        <!-- /FOOTER -->


    </body>
</html>
