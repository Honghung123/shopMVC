<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
        <div class="grid_10">
            <div class="box round first grid">
                <h2>Add New Brand</h2>
               <div class="block copyblock"> 
                 <form method="post" action="addBrand">
                    <table class="form">					
                        <tr>
                            <td>
                                <h6>Your Brand name: </h6>
                                <input type="text" placeholder="Enter Category Name..." class="medium" name="brandName"/>
                                <p class="update-notice text-${msg.endsWith('successfully')? 'success' : 'danger'}">${msg}</p>
                            </td>
                            <td>
                                <h6>Your Brand Logo: </h6>
                                <input type="text" placeholder="Enter Link Logo" class="medium" name="brandLogo"/>
                                <p class="update-notice text-${msg.endsWith('successfully')? 'success' : 'danger'}">${msg}</p>
                            </td>
                        </tr>
						<tr> 
                            <td>
                                <input type="submit" name="submit" value="Add" class="mt-2" />
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
            </div>
        </div>
<%@include file="components/footer.jsp"%>