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
							<th>Category Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<% int index = 1;%>
					<c:forEach items="${listCategory}" var="category">
						<tr class="odd gradeX">
							<td><% out.println(index++); %></td>
							<td>${category.categoryName}</td>
							<td><a href="editCat?id=${category.id}">Edit</a> || <a href="delCat?id=${category.id}">Delete</a></td>
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

