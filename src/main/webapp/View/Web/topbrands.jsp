<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="components/header.jsp" %>

<div class="main">
    <div class="content">
        <c:forEach items="${listTopBrand}" var="topBrand">
            <div class="border-colorful content_banner p-0 mt-5">
                <div class="heading w-100">
                    <div class="category-banner d-flex w-100 h-15">
                        <div class="header_bottom_left p-0 bg-colorful">
                            <div class="d-flex justify-content-around">
                                <div class="spinner-grow text-primary" role="status">
                                </div>
                                <div class="spinner-grow text-purple" role="status">
                                </div>
                                <div class="spinner-grow text-success" role="status">
                                </div>
                                <div class="spinner-grow text-danger" role="status">
                                </div>
                                <div class="spinner-grow text-warning" role="status">
                                </div>
                                <div class="spinner-grow text-info" role="status">
                                </div>
                                <div class="spinner-grow text-dark" role="status">
                                </div>
                            </div>
                            <div class="d-flex w-100" style="height: calc(100% - 32px);">
                                <div class="d-flex-center w-35">
                                    <img src="${topBrand.brandLogo}" class=" h-50">
                                </div>
                                <p class="d-flex align-items-center w-65 pl-1rem text-purple"
                                   style="font-size: 6rem">${topBrand.brandName}</p>
                            </div>
                        </div>
                        <div class="w-50">
                            <section class="h-100 bg-black">
                                <img src="/images/2.jpg" class="d-block w-100 slide-image h-inherit" alt=" ">
                            </section>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="containers">
                <div class="row row-cols-md-5 row-gap-15 flex-nowrap moveCarousel">
                    <sql:setDataSource url="jdbc:mysql://localhost:3306/jdbc_shopmvc"
                                       driver="com.mysql.cj.jdbc.Driver" user="root" password="" var="conn"
                                       scope="page"/>
                    <sql:query dataSource="${conn}" var="proByBrands">
                        select * from product where brand = ${topBrand.id}
                    </sql:query>
                    <c:forEach items="${proByBrands.rowsByIndex}" var="proByBrand">
                        <div class="col m-0 carouselItem visibility-visible-item">
                            <div class="card h-100 mt-4 bg-colorful2">
                                <a href="detail?proId=${proByBrand[0]}" style="min-height: 12rem; "
                                   class="d-flex justify-content-center align-items-center bg-white">
                                    <img src="${proByBrand[4]}" class=" " alt="${proByBrand[1]}"
                                         style=" max-height: 10rem; ">
                                </a>
                                <div class="card-body text-center">
                                    <a href="detail?proId=${proByBrand[0]}"><h5
                                            class="card-title line-clamp-2">${proByBrand[1]}</h5></a>
                                    <p class="card-text line-clamp-2">${proByBrand[6]}</p>
                                </div>
                                <div class="text-center h-25">
                                    <p class="fw-bold text-danger " style="font-size: 1.5rem">${proByBrand[5]} VND</p>
                                    <div class="d-flex-center align-self-end flex-wrap visibility-hidden">
                                        <div class="btn btn-danger bg-transparent text-danger favourite-items"
                                             title="Add your favourite" style="margin: 0 .3rem;"><span
                                                class="favourite-item"> <i class="fa-regular fa-heart"></i></span></div>
                                        <div class="" title="Add to cart" style="margin: 0 .3rem;">
                                            <form action="cart" method="post">
                                                <input type="hidden" name="id" value="${proByBrand[0]}">
                                                <input type="hidden" name="proName" value="${proByBrand[1]}">
                                                <input type="hidden" name="proImage" value="${proByBrand[4]}">
                                                <input type="hidden" name="proPrice" value="${proByBrand[5]}">
                                                <input type="hidden" name="quantity" value="1"/>
                                                <button type="submit" class="btn btn-info border-0 text-white" name="insertCart">
                                                    <i class="fa-solid fa-cart-shopping"></i>
                                                </button>
                                            </form>
                                        </div>
                                        <div class="btn btn-warning bg-transparent text-warning vote-items" title="Vote this item"
                                             style="margin: 0 .3rem;">  <i class="fa-regular fa-star"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <span class="left-carousel"><i class="fa-solid fa-angles-left"></i></span>
                <span class="right-carousel"><i class="fa-solid fa-angles-right"></i></span>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="components/footer.jsp" %>
