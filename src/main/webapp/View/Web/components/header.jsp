<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="/Common/taglib.jsp" %>

<!DOCTYPE HTML>
<head>
    <title>Store Website</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/css/styled.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="${pageContext.request.contextPath}/css/style3.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="https://code.jquery.com/jquery-3.6.1.js"
            integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script src="js/script.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/nav.js"></script>
    <script type="text/javascript" src="js/flexslider.js"></script>
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript" src="js/nav-hover.js"></script>
    <script src="https://kit.fontawesome.com/5d3c7c72c8.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<div class="bg-white">
    <div class="d-flex " style="background: #cccccc78;">
        <div class="w-25">
            <a href="trang-chu" class="pl-4rem"><img src="images/logo.png" alt=""/></a>
        </div>
        <div class="w-75 d-flex-center flex-wrap text-center">
            <div class="row w-100">
                <div class="col p-0">
                    <a href="download" class="rounded-3 p-2 text-decoration-none tag-hover">
                        <i class="fa-solid fa-cloud-arrow-down p-0-05rem"></i>Get on app </a>
                </div>
                <div class="col p-0">
                    <a href="be-seller" class="rounded-3 p-2 text-decoration-none tag-hover ">
                        <i class="fa-solid fa-person-walking-luggage p-0-05rem"></i>Be a seller</a>
                </div>
                <div class="col p-0">
                    <a href="service" class="rounded-3 p-2 text-decoration-none tag-hover"><i
                            class="fa-solid fa-envelope p-0-05rem"></i>Service</a>
                </div>
                <div class="col p-0">
                    <a href="customer-care" class="rounded-3 p-2 text-decoration-none tag-hover"><i
                            class="fa-solid fa-headset p-0-05rem"></i>Customer Care</a>
                </div>
                <div class="col p-0">
                    <a href="about" class="rounded-3 p-2 text-decoration-none tag-hover"><i
                            class="fa-solid fa-circle-info p-0-05rem"></i>About us</a>
                </div>
                <div class="col p-0">
                    <c:if test="${!sessionScope.isLogin}">
                        <a href="login" class="rounded-3 p-2 text-decoration-none tag-hover"><i
                                class="fa-solid fa-user-secret p-0-05rem"></i> Login</a>
                    </c:if>
                    <c:if test="${sessionScope.isLogin}">
                        <div class="d-flex justify-content-between align-items-baseline no-wrap ">
                            <span class=""><a href="info?uid=${sessionScope.user.id}" class="pl-1rem-"><i
                                    class="fa-solid fa-user-secret "></i>${sessionScope.user.username}</a>
                            </span>
                            <a href="logout" class="rounded-3 p-2 text-decoration-none tag-hover">
                                <i class="fa-solid fa-right-from-bracket p-0-05rem"></i>Logout</a>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="d-flex align-items-center justify-content-around flex-1 mb-2">
                <div class="search_box w-65">
                    <form method="post" action="search">
                        <input type="text" placeholder="Search for Products" name="search"><input type="submit" value="SEARCH">
                    </form>
                </div>
                <div class="cart-btn">
                    <a href="cart" class="btn btn-info text-white"><i class="fa-solid fa-cart-plus" ></i></a>
                    <sql:setDataSource url="jdbc:mysql://localhost:3306/jdbc_shopmvc"
                                       driver="com.mysql.cj.jdbc.Driver" user="root" password="" var="conn"
                                       scope="page"/>
                    <sql:query dataSource="${conn}" var="listCarts">
                        select * from cart order by id desc limit 3
                    </sql:query>
                    <div class="cart-info">
                        <c:if test="${listCarts.rowsByIndex[0]!=null}">
                            <ul class="p-0 m-0">
                                <c:forEach items="${listCarts.rowsByIndex}" var="carts">
                                    <li class="cart-items">
                                        <div class="row m-0 flex-nowrap h-6rem">
                                            <div class="col col-md-3 p-0">
                                                <a href="detail?proId=${carts[5]}"><img src="${carts[2]}"
                                                                                        class="h-100 obj-center-cover"></a>
                                            </div>
                                            <div class="col col-md-9">
                                                <a href="detail?proId=${carts[5]}"><p
                                                        class="line-clamp-1 m-0 text-danger"
                                                        style="font-size: 1.3rem;">${carts[1]}</p></a>
                                                <div class="row m-0 flex-nowrap">
                                                    <div class="col col-md-9 line-clamp-2 text-gray p-0">
                                                            ${carts[1]}
                                                    </div>
                                                    <div class="col col-md-3 fw-bold text-purple p-0">${carts[3]} VND
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="cart-items"><a href="cart" class="p-0-1rem">Show all</a></div>
                        </c:if>
                        <c:if test="${listCarts.rowsByIndex[0]==null}">
                            <p class="text-purple pt-3 pb-3 m-0" style="font-size: 1.5rem;">Unfortunately, Your cart is
                                empty</p>
                            <img src="/images/1.jpg" class="obj-center-cover h-100">
                        </c:if>
                    </div>
                </div>

                <div class="cart-btn">
                    <a href="cart" class="btn btn-info text-white"><i class="fa-solid fa-bell"></i></a>
                    <sql:query dataSource="${conn}" var="listCarts">
                        select * from cart order by id desc limit 3
                    </sql:query>
                    <div class="cart-info">
                        <c:if test="${listCarts.rowsByIndex[0]!=null}">
                            <ul class="p-0 m-0">
                                <c:forEach items="${listCarts.rowsByIndex}" var="carts">
                                    <li class="cart-items">
                                        <div class="row m-0 flex-nowrap h-6rem">
                                            <div class="col col-md-3 p-0">
                                                <a href="detail?proId=${carts[5]}"><img src="${carts[2]}"
                                                                                        class="h-100 obj-center-cover"></a>
                                            </div>
                                            <div class="col col-md-9">
                                                <a href="detail?proId=${carts[5]}"><p
                                                        class="line-clamp-1 m-0 text-danger"
                                                        style="font-size: 1.3rem;">${carts[1]}</p></a>
                                                <div class="row m-0 flex-nowrap">
                                                    <div class="col col-md-9 line-clamp-2 text-gray p-0">
                                                            ${carts[1]}
                                                    </div>
                                                    <div class="col col-md-3 fw-bold text-purple p-0">${carts[3]} VND
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="cart-items"><a href="cart" class="p-0-1rem">Show all</a></div>
                        </c:if>
                        <c:if test="${listCarts.rowsByIndex[0]==null}">
                            <p class="text-purple pt-3 pb-3 m-0" style="font-size: 1.5rem;">Unfortunately, No notification now</p>
                            <img src="/images/1.jpg" class="obj-center-cover h-100">
                        </c:if>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                       aria-expanded="false">Action</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">My Account</a></li>
                        <li><a class="dropdown-item" href="#">Privacy</a></li>
                        <li><a class="dropdown-item" href="#">Setting</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a href="admin/adminManager" class="dropdown-item">Go Admin page</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <div class="menu">
        <ul id="dc_mega-menu-orange" class="dc_mm-orange">
            <li><a href="trang-chu">Home</a></li>
            <li><a href="product">Products</a></li>
            <li><a href="topbrand">Top Brands</a></li>
            <li><a href="cart">Cart</a></li>
            <li><a href="ordered">Checkout</a></li>
            <li><a href="contact">Contact</a></li>

            <div class="clear"></div>
        </ul>
    </div>
    <div style="padding: 0 2rem;">
    </div>
</div>
</body>