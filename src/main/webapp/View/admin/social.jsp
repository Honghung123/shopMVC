﻿<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
<div class="grid_10">
    <div class="box round first grid">
        <h2>Update Social Media</h2>
        <div class="block">               
         <form>
            <table class="form">					
                <tr>
                    <td>
                        <label>Facebook</label>
                    </td>
                    <td>
                        <input type="text" name="facebook" placeholder="Facebook link.." class="medium" />
                    </td>
                </tr>
				 <tr>
                    <td>
                        <label>Twitter</label>
                    </td>
                    <td>
                        <input type="text" name="twitter" placeholder="Twitter link.." class="medium" />
                    </td>
                </tr>
				
				 <tr>
                    <td>
                        <label>LinkedIn</label>
                    </td>
                    <td>
                        <input type="text" name="linkedin" placeholder="LinkedIn link.." class="medium" />
                    </td>
                </tr>
				
				 <tr>
                    <td>
                        <label>Google Plus</label>
                    </td>
                    <td>
                        <input type="text" name="googleplus" placeholder="Google Plus link.." class="medium" />
                    </td>
                </tr>
				
				 <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="submit" Value="Update" />
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<div class="grid_10">
    <div class="box round first grid">
        <h2>Update Site Title and Description</h2>
        <div class="block sloginblock">
            <form>
                <table class="form">
                    <tr>
                        <td>
                            <label>Website Title</label>
                        </td>
                        <td>
                            <input type="text" placeholder="Enter Website Title..."  name="title" class="medium" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Website Slogan</label>
                        </td>
                        <td>
                            <input type="text" placeholder="Enter Website Slogan..." name="slogan" class="medium" />
                        </td>
                    </tr>


                    <tr>
                        <td>
                        </td>
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