<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="AllProduct">All Products</a></li>
                    <c:forEach items="${sessionScope.categoriesList}" var="c">
                    <li><a href="AllProductByCategory?cateid=${c.categoryID}">${c.categoryName}</a></li>
                    </c:forEach>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->