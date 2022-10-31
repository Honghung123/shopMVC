<%@include file="components/header.jsp"%>
<%@include file="components/sidebar.jsp"%>
<div class="grid_10">
    <div class="box round first grid">
        <h2>Edit Product</h2>
        <div class="block">               
         <form action="editPro" method="post" >
            <table class="form">
                <p class="text-center update-notice text-${msg.endsWith('successfully')? 'success' : 'danger'}">${msg}</p>
                <tr>
                    <td>
                        <label>Name</label>
                    </td>
                    <td>
                        <input type="text" placeholder="Enter Product Name..." class="medium" name="name" value="${product.name}" required/>
                    </td>
                </tr>
				<tr>
                    <td>
                        <label>Category</label>
                    </td>
                    <td>
                        <select id="selects" name="category" required>
                            <option>Select Category</option>
                            <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}" ${category.id==product.category?"selected":""}>${category.categoryName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
				<tr>
                    <td>
                        <label>Brand</label>
                    </td>
                    <td>
                        <select id="select2"  name="brand">
                            <option>Select Brand</option>
                            <c:forEach items="${listBrand}" var="brand">
                                <option value="${brand.id}" ${brand.id==product.brand?"selected":""}>${brand.brandName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
				
				<tr>
                    <td>
                        <label>Upload Image</label>
                    </td>
                    <td>
                        <input type="text"placeholder="Enter Image.link" class="medium" name="image" value="${product.image}" required/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label>Price</label>
                    </td>
                    <td>
                        <input type="text" placeholder="Enter Price..." class="medium" name="price" value="${product.price}" required/>
                    </td>
                </tr>

                <tr>
                    <td style="vertical-align: top; padding-top: 9px;">
                        <label>Short description</label>
                    </td>
                    <td>
                        <textarea class="tinymce w-50" rows="2" name="short_desc">${product.short_desc}</textarea>
                    </td>
                </tr>
                <tr>
                    <td style="vertical-align: top; padding-top: 9px;">
                        <label>Detail description</label>
                    </td>
                    <td>
                        <textarea class="tinymce w-50" name="detail_desc">${product.detail_desc}</textarea>
                    </td>
                </tr>

                <tr>
                    <td>
                        <label>Discount</label>
                    </td>
                    <td>
                        <input type="number" name="discount" value="${product.discount}" min="0" max="99"/>
                        <input type="hidden" name="proId" value="${product.id}"  />
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td >
                        <input type="submit" class="btn btn-success mt-2  p-1 text-white btn-centered" name="submit " Value="Save" />
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<!-- Load TinyMCE -->
<script src="js/tiny-mce/jquery.tinymce.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        setupTinyMCE();
        setDatePicker('date-picker');
        $('input[type="checkbox"]').fancybutton();
        $('input[type="radio"]').fancybutton();
    });
</script>
<!-- Load TinyMCE -->
<%@include file="components/footer.jsp"%>


