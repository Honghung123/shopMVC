<%@include file="components/header.jsp" %>

<div class="main">
    <div class="content">
        <div class="content_top">
            <div class="heading">
                <h3>All Products</h3>
            </div>
            <div class="clear"></div>
        </div>
        <div class="row row-cols-md-5 row-gap-15">
            <c:forEach items="${productList}" var="product">
                <div class="col m-0 visibility-visible-item">
                    <div class="card h-100 mt-4 bg-colorful2">
                        <a href="detail?proId=${product.id}" style="min-height: 12rem; "
                           class="d-flex justify-content-center align-items-center bg-white">
                            <img src="${product.image}" class=" " alt="${product.name}" style=" max-height: 10rem; ">
                        </a>
                        <div class="card-body text-center">
                            <a href="detail?proId=${product.id}"><h5
                                    class="card-title line-clamp-2">${product.name}</h5></a>
                            <p class="card-text line-clamp-2">${product.short_desc}</p>
                        </div>
                        <div class="text-center h-25">
                            <p class="fw-bold text-danger " style="font-size: 1.5rem">${product.price} VND</p>
                            <div class="d-flex-center align-self-end flex-wrap visibility-hidden">
                                <div class="btn btn-danger bg-transparent text-danger favourite-items"
                                     title="Add your favourite"
                                     style="margin: 0 .3rem;"><i class="fa-regular fa-heart"></i></div>
                                <div class="" title="Add to cart" style="margin: 0 .3rem;">
                                    <form action="cart" method="post">
                                        <input type="hidden" name="id" value="${product.id}">
                                        <input type="hidden" name="proName" value="${product.name}">
                                        <input type="hidden" name="proImage" value="${product.image}">
                                        <input type="hidden" name="proPrice" value="${product.price}">
                                        <input type="hidden" class="buyfield" name="quantity" value="1"/>
                                        <button type="submit" class="btn btn-info border-0 text-white"
                                                name="insertCart">
                                            <i class="fa-solid fa-cart-shopping"></i>
                                        </button>
                                    </form>
                                </div>
                                <div class="btn btn-warning bg-transparent text-warning vote-items"
                                     title="Vote this item"
                                     style="margin: 0 .3rem;"><i class="fa-regular fa-star"></i></div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <nav aria-label="Page navigation " class="mt-5">
        <ul class="pagination justify-content-center col-gap-1 display-3 my-pagination" max-page="${max_page}" cur-page="${cur_page}">
            <li class="page-item">
                <a class="page-link" href="?page=1" aria-label="Previous" cur-page="${cur_page}">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link ${cur_page==1?"bg-colorful":""}" href="?page=1" cur-page="1">1</a></li>
            <li class="page-item"><a class="page-link ${cur_page==2?"bg-colorful":""}" href="?page=2" cur-page="2">2</a></li>
            <li class="page-item"><a class="page-link ${(cur_page>2 && cur_page <= max_page-2)?"bg-colorful":""}" href="?page=3" cur-page="3">3</a></li>
            <li class="page-item"><a class="page-link ${cur_page== max_page-1?"bg-colorful":""}" href="?page=4" cur-page="4">4</a></li>
            <li class="page-item"><a class="page-link ${cur_page== max_page?"bg-colorful":""}" href="#" cur-page="5">5</a></li>
            <li class="page-item">
                <a class="page-link" href="?page=2" aria-label="Next" cur-page="${cur_page + 1}">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
<%--    <div class="d-flex-center m-4">--%>
<%--        <button class="btn btn-info rounded-pill text-white pe-2 show-more">Loadmore</button>--%>
<%--    </div>--%>
</div>
<%@include file="components/footer.jsp" %>