package com.honghung.controller.Web;

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

@WebServlet(name="DetailController", urlPatterns = {"/detail"})
public class DetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("proId"));
        Product product = new DAOProduct().getProductById(id);
        req.setAttribute("product",product);
        Category category = new DAOCategory().getCatById(product.getCategory());
        req.setAttribute("productCat",category);
        Brand brand = new DAOBrand().getBrandById(product.getBrand());
        req.setAttribute("productBrand",brand);
        List<Category> listCategory = new DAOCategory().getAllCategory();
        req.setAttribute("listCategory",listCategory);
        req.getRequestDispatcher("View/Web/detail.jsp").forward(req,resp);

    }
}
