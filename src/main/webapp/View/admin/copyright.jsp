<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
<div class="grid_10">
    <div class="box round first grid">
        <h2>Update Copyright Text</h2>
        <div class="block copyblock"> 
         <form>
            <table class="form">					
                <tr>
                    <td>
                        <input type="text" placeholder="Enter Copyright Text..." name="copyright" class="large" />
                    </td>
                </tr>
				
				 <tr> 
                    <td>
                        <input type="submit" name="submit" Value="Update" />
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<%@include file="components/footer.jsp"%>