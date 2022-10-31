<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
<div class="grid_10">
    <div class="box round grid" style="height: 45rem;  overflow: hidden; overflow-y: scroll;">
        <h2>Post List</h2>
        <div class="block">  
            <table class="data display datatable" id="example">
			<thead>
				<tr>
					<th>STT</th>
					<th>Product Name</th>
					<th>Image</th>
					<th>Price</th>
					<th>Discount</th>
					<th>Short Desc</th>
					<th>Detail Desc</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<% int index=1;%>
			<c:forEach items="${listProduct}" var="product">
				<tr class="odd gradeX">
					<td><% out.println(index++);%></td>
					<td>${product.name}</td>
					<td><img src="${product.image}" width="100px"></td>
					<td>${product.price} VND</td>
					<td>${product.discount} %</td>
					<td> ${product.short_desc}</td>
					<td> ${product.detail_desc}</td>
					<td><a href="editPro?proId=${product.id}">Edit</a> || <a href="delPro?proId=${product.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

       </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        setupLeftMenu();
        $('.datatable').dataTable();
		setSidebarHeight();
    });
</script>
<%@include file="components/footer.jsp"%>
