<div class="header_bottom d-flex">
    <div class="header_bottom_left p-0">
        <div class="content_top w-100">
            <div class="text-info">
                <h3>Newest Products</h3>
            </div>
        </div>
        <div class="d-flex flex-wrap row-gap-1 justify-content-around ">
            <c:forEach items="${top4newestPro}" var="product">
                <div class="listview_1_of_2 images_1_of_2 visibility-visible-item" style="height: 170px;margin: 0;">
                    <div class="listimg listimg_2_of_1">
                        <a href="detail?proId=${product.id}"> <img src="${product.image}" alt=""/></a>
                    </div>
                    <div class="d-flex flex-wrap list_2_of_1">
                        <a href="detail?proId=${product.id}"><h2 class="line-clamp-2 ">${product.name}</h2></a>
                        <p class="line-clamp-2 ">${product.short_desc}</p>
                        <div class="d-flex-center align-self-end flex-wrap visibility-hidden">
                            <div class="btn btn-danger bg-transparent text-danger favourite-items" title="Add your favourite"
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
                            <div class="btn btn-warning bg-transparent text-warning vote-items" title="Vote this item"
                                 style="margin: 0 .3rem;">  <i  class="fa-regular fa-star"></i> </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="clear"></div>
    </div>
    <div class="w-50">
        <!-- FlexSlider -->
        <div class="content_top">
            <div class="text-info">
                <h3>Maybe you like</h3>
            </div>
        </div>
        <section class="bg-colorful p-2 rounded-3">

            <div id="carousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carousel" data-bs-slide-to="0" class="active"
                            aria-current="true"></button>
                    <button type="button" data-bs-target="#carousel" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#carousel" data-bs-slide-to="2"></button>
                    <button type="button" data-bs-target="#carousel" data-bs-slide-to="3"></button>
                </div>
                <div class="carousel-inner">
                    <% int isActive = 0; %>
                    <c:forEach items="${randBanner}" var="banner">
                        <div class="carousel-item <%= (isActive==0)? "active":""  %>">
                            <% isActive++; %>
                            <img src="${banner.catBanner}" class="d-block w-100 slide-image h-21"
                                 alt="${banner.catBanner}">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>First slide label</h5>
                                <p>Some representative placeholder content for the first slide.</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </section>
        <!-- FlexSlider -->
    </div>
    <div class="clear"></div>
</div>