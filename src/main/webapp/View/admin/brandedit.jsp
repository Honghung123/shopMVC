<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
        <div class="grid_10">
            <div class="box round first grid">
                <h2>Edit Brand</h2>
               <div class="block copyblock"> 
                 <form action="updateBrand" method="post">
                    <table class="form">					
                        <tr>
                            <td>
                                <p>Old Brand name: </p>
                                <input type="text" value="${brand.brandName}" class="medium"  disabled/>
                                <input type="hidden" value="${brand.id}" class="medium"  name="id"/>
                                <p>Old Logo:  <img src="${brand.brandLogo}" width="120px"></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>New Brand name: </p>
                                <input type="text" placeholder="Enter Category Name..." class="medium" name="brandName"/>
                            </td>
                            <td>
                                <p>New Logo: </p>
                                <input type="text" placeholder="Enter Link Logo" class="medium" name="brandLogo" value="${brand.brandLogo}"/>
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