package com.honghung.controller.Admin.Product;

import com.honghung.dao.inplements.DAOBrand;
import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Brand;
import com.honghung.model.Category;
import com.honghung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="EditProduct", urlPatterns = "/admin/editPro")
public class EditProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        List<Category> listCategory = new DAOCategory().getAllCategory();
        List<Brand> listBrand = new DAOBrand().getAllBrand();
        int proId = Integer.parseInt(req.getParameter("proId"));
        Product product = new DAOProduct().getProductById(proId);
        req.setAttribute("listCategory",listCategory);
        req.setAttribute("listBrand",listBrand);
        req.setAttribute("product",product);
        req.getRequestDispatcher("../View/admin/proedit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int proId = Integer.parseInt(req.getParameter("proId"));
        String name = req.getParameter("name");
        int category = Integer.parseInt(req.getParameter("category"));
        int brand = Integer.parseInt(req.getParameter("brand"));
        String image = req.getParameter("image");
        String price = req.getParameter("price");
        String short_desc = req.getParameter("short_desc");
        String detail_desc = req.getParameter("detail_desc");
        int discount = Integer.parseInt(req.getParameter("discount"));
        boolean isUpdate = new DAOProduct().updateProduct(proId,name ,category, brand, image, price, short_desc, detail_desc, discount);
        System.out.println(isUpdate);
        if(isUpdate){
            resp.sendRedirect("listPro");
        }else{
            doGet(req, resp);
        }
    }

}
