<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
        <div class="grid_10">
            <div class="box round first grid">
                <h2>Edit Category</h2>
               <div class="block copyblock"> 
                 <form action="updateCat" method="post">
                    <table class="form">					
                        <tr>
                            <td>
                                <p>Old Category name: </p>
                                <input type="text" value="${category.categoryName}" class="medium"  disabled/>
                                <input type="hidden" value="${category.id}" class="medium"  name="id"/>
                                <p>Old Banner:  <img src="${category.catBanner}" width="220px"></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>New Category name: </p>
                                <input type="text" placeholder="Enter Category Name..." class="medium" name="catName"/>
                            </td>
                            <td>
                                <p>New Banner Link: </p>
                                <input type="text" placeholder="Enter Link Banner." class="medium" name="catBanner" value="${category.catBanner}"/>
                            </td>
                        </tr>
						<tr> 
                            <td>
                                <input type="submit" name="submit" class="mt-1 bg-primary rounded text-white" Value="Save change" />
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
            </div>
        </div>
<%@include file="components/footer.jsp"%>