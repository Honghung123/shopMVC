<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
        <div class="grid_10">
            <div class="box round first grid">
                <h2>Category List</h2>
                <div class="block">        
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>Serial No.</th>
							<th>Brand Name</th>
							<th>Brand Logo</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<% int index = 1;%>
					<c:forEach items="${listBrand}" var="brand">
						<tr class="odd gradeX">
							<td><% out.println(index++); %></td>
							<td>${brand.brandName}</td>
							<td><img src="${brand.brandLogo}" width="100px"></td>
							<td><a href="editBrand?id=${brand.id}">Edit</a> || <a href="delBrand?id=${brand.id}">Delete</a></td>
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

