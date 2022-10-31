<%@include file="components/header.jsp" %>

<div class="main">
    <div class="content">
        <div class="cartoption">
            <div class="cartpage">
                <h2 class="w-100 text-danger">Your Order</h2>
                <table class="tblone">
                    <tr>
                        <th width="5%">STT</th>
                        <th width="10%">Product Name</th>
                        <th width="10%">Image</th>
                        <th width="10%">Price</th>
                        <th width="5%">Quantity</th>
                        <th width="10%">Total Price</th>
                        <th width="10%">Action</th>
                    </tr>

                    <c:if test="${listOrder != []}">
                        <% int stt = 1; %>
                        <c:forEach items="${listOrder}" var="order">
                            <tr>
                                <td><% out.println(stt++); %></td>
                                <td><a href="detail?proId=${order.proId}">${order.proName}</a></td>
                                <td><a href="detail?proId=${order.proId}"><img src="${order.proImage}"
                                                                               alt="${order.proName}" class="w-auto"
                                                                               style="height: 120px;"/></a></td>
                                <td>${order.proPrice} VND</td>
                                <td><span>${order.quantity}</span></td>
                                <td>${order.proPrice * order.quantity} VND</td>
                                <td><a href="ordered?delId=${order.id}">Delete</a></td>
                            </tr>

                        </c:forEach>
                    </c:if>
                    <c:if test="${listOrder == []}">
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

        </div>
        <div class="clear"></div>
    </div>
</div>
<%@include file="components/footer.jsp" %>