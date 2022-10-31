<%@include file="components/header.jsp" %>

<div class="main">
    <div class="content">
        <div class="content_top">
            <div class="heading">
                <h3>List Product: ${category.categoryName}</h3>
            </div>
            <div class="clear"></div>
        </div>

        <div class="row row-cols-md-5 row-gap-15">
            <c:forEach items="${productListbyCat}" var="product">
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
                                <div class="btn btn-danger bg-transparent text-danger" title="Add your favourite"
                                     style="margin: 0 .3rem;"><span class="favourite-item"> <i
                                        class="fa-regular fa-heart"></i></span></div>
                                <div class="" title="Add to cart" style="margin: 0 .3rem;">
                                    <form action="cart" method="post">
                                        <input type="hidden" name="id" value="${product.id}">
                                        <input type="hidden" name="proName" value="${product.name}">
                                        <input type="hidden" name="proImage" value="${product.image}">
                                        <input type="hidden" name="proPrice" value="${product.price}">
                                        <input type="hidden" class="buyfield" name="quantity" value="1"/>
                                        <button type="submit" class="btn btn-info border-0 text-white" name="insertCart">
                                            <i class="fa-solid fa-cart-shopping"></i>
                                        </button>
                                    </form>
                                </div>
                                <div class="btn btn-warning bg-transparent text-warning" title="Vote this item"
                                     style="margin: 0 .3rem;"><span class="vote-item"> <i
                                        class="fa-regular fa-star"></i></span></div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<%@include file="components/footer.jsp" %>