<%@include file="components/header.jsp" %>
<div class="main">
    <div class="content">
        <div class="section group">
            <div class="cont-desc span_1_of_2">
                <div class="grid images_3_of_2">
                    <img src="${product.image}" alt="${product.image}" style="width: initial;"/>
                </div>
                <div class="desc span_3_of_2">
                    <h2>${product.name}</h2>
                    <p>${product.short_desc}</p>
                    <div class="price">
                        <p>Price: <span>${product.price} VND</span></p>
                        <p>Category: <a href="">${productCat.categoryName}</a></p>
                        <p>Brand:<a href="">${productBrand.brandName}</a></p>
                    </div>
                    <div class="add-cart">
                        <form action="cart" method="post">
                            <input type="hidden" name="id" value="${product.id}">
                            <input type="hidden" name="proName" value="${product.name}">
                            <input type="hidden" name="proImage" value="${product.image}">
                            <input type="hidden" name="proPrice" value="${product.price}">
                            <input type="number" class="buyfield" name="quantity" value="1" min="1"/>
                            <input type="submit" class="buysubmit" name="insertCart" value="Buy Now"/>
                        </form>
                    </div>
                </div>
                <div class="product-desc">
                    <h2>Product Details</h2>
                    <p>${product.detail_desc}</p>
                </div>

            </div>
            <div class="rightsidebar span_3_of_1">
                <h2>CATEGORIES</h2>
                <ul>
                    <c:forEach items="${listCategory}" var="category">
                        <li><a href="prolistbycat?catId=${category.id}">${category.categoryName}</a></li>
                    </c:forEach>
                </ul>

            </div>
        </div>
    </div>

    <div class="content_top">
        <div class="heading">
            <h3>Comments</h3>
        </div>
    </div>
    <div class="card-footer mt-3 " style="background-color: #f8f9fa;">
        <div class="d-flex-center w-100 flex-wrap">
            <img class="rounded-circle shadow-1-strong me-3 align-self-start" src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar" width="40" height="40" style="">
            <div class="form-outline w-75" style="">
                <h3 class""="">Your comment</h3>
                <textarea class="form-control" rows="2" style="background: #fff;" placeholder="Enter your comment"></textarea>

            </div>
            <div class="w-75 mt-3 mb-3" style="align-self: baseline;">
                <button type="button" class="btn btn-primary btn-sm">Post comment</button>

            </div>
        </div>

    </div>
    <div class="container ">
        <div class="row d-flex justify-content-center w-100">
            <div class="col-md-12 ">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-start align-items-center">
                            <img class="rounded-circle shadow-1-strong me-3"
                                 src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar"
                                 width="60"
                                 height="60"/>
                            <div>
                                <h6 class="fw-bold text-primary mb-1">Lily Coleman</h6>
                                <p class="text-muted small mb-0">
                                    Shared publicly - Jan 2020
                                </p>
                            </div>
                        </div>

                        <p class="mt-3 mb-3">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                        </p>

                        <div class="small d-flex justify-content-start">
                            <button class="d-flex align-items-center me-3 btn bg-transparent text-info">
                                <i class="far fa-thumbs-up me-2"></i>
                                <p class="mb-0">Like</p>
                            </button>
                            <button class="d-flex align-items-center me-3 btn bg-transparent text-info">
                                <i class="far fa-comment-dots me-2"></i>
                                <p class="mb-0">Comment</p>
                            </button>
                            <button class="d-flex align-items-center me-3 btn bg-transparent text-info">
                                <i class="fas fa-share me-2"></i>
                                <p class="mb-0">Share</p>
                            </button>
                        </div>
                    </div>
                    <div class="container pl-8rem">
                        <div class="row d-flex justify-content-center w-100">
                            <div class="col-md-12 ">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-start align-items-center">
                                            <img class="rounded-circle shadow-1-strong me-3"
                                                 src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp"
                                                 alt="avatar" width="60"
                                                 height="60"/>
                                            <div>
                                                <h6 class="fw-bold text-primary mb-1">Lily Coleman</h6>
                                                <p class="text-muted small mb-0">
                                                    Shared publicly - Jan 2020
                                                </p>
                                            </div>
                                        </div>

                                        <p class="mt-3 mb-3">
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                                        </p>

                                        <div class="small d-flex justify-content-start">
                                            <button class="d-flex align-items-center me-3 btn bg-transparent text-info">
                                                <i class="far fa-thumbs-up me-2"></i>
                                                <p class="mb-0">Like</p>
                                            </button>
                                            <button class="d-flex align-items-center me-3 btn bg-transparent text-info">
                                                <i class="far fa-comment-dots me-2"></i>
                                                <p class="mb-0">Comment</p>
                                            </button>
                                            <button class="d-flex align-items-center me-3 btn bg-transparent text-info">
                                                <i class="fas fa-share me-2"></i>
                                                <p class="mb-0">Share</p>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container pl-8rem  mt-3" style="background-color: #f8f9fa;">
                        <div class="d-flex flex-start w-100">
                            <img class="rounded-circle shadow-1-strong me-3"
                                 src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp"
                                 alt="avatar" width="40"
                                 height="40"/>
                            <div class="form-outline w-100">
                                            <textarea class="form-control" placeholder="Enter your comment" rows="2"
                                                      style="background: #fff;"></textarea>
                            </div>
                        </div>
                        <div class="float-end mt-2 pt-1">
                            <button type="button" class="btn btn-primary btn-sm">Post comment</button>
                            <button type="button" class="btn btn-outline-primary btn-sm">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="components/footer.jsp" %>