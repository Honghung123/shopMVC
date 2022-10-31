<%@include file="components/header.jsp" %>
<div class="main">
    <div class="content">
        <h1 class="text-center text-purple display-4">Vui long nhap ma cua ban</h1>
        <div class="d-flex-center">
            <form action="email" method="post">
                <input type="hidden" name="serverCode" value="${codeRegister}">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" >
                    <button type="submit" name="userCodeRegister" class="btn btn-info">Confirm</button>
                   <div class="mt-5 w-100">
                       <p class="text-gray " >Van chua nhan duoc code . Vui long gui lai: </p>
                       <button type="submit" name="resendCodeRegister" class="btn btn-info">Gui lai</button>
                   </div>
                </div>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</div>
<%@include file="components/footer.jsp" %>