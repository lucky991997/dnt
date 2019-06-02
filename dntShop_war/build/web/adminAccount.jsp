<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
    <head>
        <jsp:include page="admin-main-layout.jsp"></jsp:include>
            <title>Admin Account</title>

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
            session.setAttribute("currentAdminPageChild", "viewAccount");
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
                            <li class="active">View</li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">Admin List</h3>
                                    </div><!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Full Name</th>
                                                    <th>Email</th>                                                                                                       
                                                    <th>Created Date</th>
                                                    <th>Avatar</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="e" items="${listEmp}">
                                                <tr>
                                                    <td>${e.adminID}</td>
                                                    <td>${e.fullName}</td>
                                                    <td>${e.email}</td>                                                              
                                                    <td><fmt:formatDate value="${e.createdDate}" pattern="dd-MM-yyyy" /></td>
                                                    <td><img src="${e.avatar}" class="img-circle" width="80px" height="80px" alt="User Image"/></td>
                                                    <td>                                                       
                                                        <c:if test="${e.isStatus eq true}">
                                                            <span class="label label-success">Active</span>
                                                        </c:if>
                                                        <c:if test="${e.isStatus eq false}">
                                                            <span class="label label-danger">Banned</span>
                                                        </c:if>
                                                    </td>
                                                    <td><c:if test="${sessionScope.admin_login.adminID ne e.adminID}">
                                                            <div class="btn-group">
                                                                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">Action <span class="fa fa-caret-down"></span></button>
                                                                <ul class="dropdown-menu">
                                                                    <li><a href="adminUpdateAccount?admin_id=${e.adminID}">Edit Profile</a></li>
                                                                        <c:if test="${e.isStatus eq true}">
                                                                        <li><a href="adminDisableAccount?admin_id=${e.adminID}"><span style="color: red">Banned</span></a></li>
                                                                        </c:if>
                                                                        <c:if test="${e.isStatus eq false}">                                                                                                                  
                                                                        <li><a href="adminEnableAccount?admin_id=${e.adminID}"><span style="color: green">Active</span></a></li>
                                                                        </c:if>
                                                                </ul>
                                                            </div>
                                                        </c:if>                                                                                                                                                             
                                                    </td>
                                                </tr>   
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    <!-- Your Page Content Here -->

                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->

            <!-- Main Footer -->
            <jsp:include page="admin-main-footer.jsp"></jsp:include>            
        </div><!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->       
        <script type="text/javascript">
            $(function() {
                $('#example1').DataTable({
                    "order": [[0, "desc"]],
                    dom: 'Bfrtip',
                    buttons: [
                        'copy', 'excel', 'pdf', 'print'
                    ]
                });
            });
        </script>

    </body>
</html>
