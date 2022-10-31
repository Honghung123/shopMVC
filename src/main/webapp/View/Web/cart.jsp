<%@include file="components/header.jsp" %>

<div class="main">
    <div class="content">
        <div class="cartoption">
            <div class="cartpage">
                <h2 class="w-100 text-danger">Your Cart</h2>
                <table class="tblone">
                    <tr>
                        <th width="20%">Product Name</th>
                        <th width="10%">Image</th>
                        <th width="15%">Price</th>
                        <th width="25%">Quantity</th>
                        <th width="20%">Total Price</th>
                        <th width="10%">Action</th>
                    </tr>

                    <c:if test="${listCart != []}">
                        <c:forEach items="${listCart}" var="cart">
                            <tr>
                                <td><a href="detail?proId=${cart.proId}">${cart.proName}</a></td>
                                <td><a href="detail?proId=${cart.proId}"><img src="${cart.proImage}"
                                                                              alt="${cart.proName}" class="w-auto"
                                                                              style="height: 120px;"/></a></td>
                                <td>${cart.proPrice} VND</td>
                                <td>
                                    <form action="cart" method="post">
                                        <input type="hidden" name="id" value="${cart.id}">
                                        <input type="hidden" name="proId" value="${cart.proId}">
                                        <input type="hidden" name="proName" value="${cart.proName}">
                                        <input type="hidden" name="proImage" value="${cart.proImage}">
                                        <input type="hidden" name="proPrice" value="${cart.proPrice}">
                                        <input type="number" name="quantity" value="${cart.quantity}" min="1"/>
                                        <input type="submit" name="updateQuantity" value="Update"/>
                                    </form>
                                </td>
                                <td>${cart.proPrice * cart.quantity} VND</td>
                                <td><a href="cart?delId=${cart.id}">Delete</a></td>
                            </tr>

                        </c:forEach>
                    </c:if>
                    <c:if test="${listCart == []}">
                        <tr>
                            <td colspan="6"><p class="text-center">Your cart is empty!</p></td>
                        </tr>
                    </c:if>
                </table>
                <table style="float:right;text-align:left;" width="40%">
                    <tr>
                        <th>Sub Total :</th>
                        <td>${sumPrice } VND</td>
                    </tr>
                    <tr>
                        <th>VAT :</th>
                        <td>${vat} VND</td>
                    </tr>
                    <tr>
                        <th>Grand Total :</th>
                        <td>${sumPrice + vat} VND</td>
                    </tr>
                </table>
            </div>
            <div class="shopping">
                <div class="shopleft">
                    <a href="trang-chu"> <img src="images/shop.png" alt=""/></a>
                </div>
                <div class="shopright">
                    <form action="ordered" method="post">
                        <c:if test="${listCart != []}">
                            <c:forEach items="${listCart}" var="cart">
                                <input type="hidden" name="cartId" value="${cart.id}">
                                <input type="hidden" name="proId" value="${cart.proId}">
                                <input type="hidden" name="proName" value="${cart.proName}">
                                <input type="hidden" name="proImage" value="${cart.proImage}">
                                <input type="hidden" name="proPrice" value="${cart.proPrice}">
                                <input type="hidden" name="quantity" value="${cart.quantity}"/>
                            </c:forEach>
                        </c:if>
                        <button type="submit" name="insertOrder" class=" border-0 text-danger fw-bold display-3">Buy now!</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<%@include file="components/footer.jsp" %>