package com.honghung.controller.Admin.Product;

import com.honghung.dao.inplements.DAOBrand;
import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Brand;
import com.honghung.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="AddProduct", urlPatterns = "/admin/addPro")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Category> listCategory = new DAOCategory().getAllCategory();
        List<Brand> listBrand = new DAOBrand().getAllBrand();
        req.setAttribute("listCategory",listCategory);
        req.setAttribute("listBrand",listBrand);
        req.getRequestDispatcher("../View/admin/proadd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int category = Integer.parseInt(req.getParameter("category"));
        int brand = Integer.parseInt(req.getParameter("brand"));
        String image = req.getParameter("image");
        String price = req.getParameter("price");
        String short_desc = req.getParameter("short_desc");
        String detail_desc = req.getParameter("detail_desc");
        int discount = Integer.parseInt(req.getParameter("discount"));
        if(new DAOProduct().insertProduct(name,category,brand,image,price,short_desc,detail_desc,discount)){
            req.setAttribute("msg","Add product successfully");
        }else{
            req.setAttribute("msg","Error to add product, Try again!");
        }
        doGet(req, resp);
    }

}
