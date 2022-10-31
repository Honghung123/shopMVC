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

@WebServlet(name="ListProduct", urlPatterns = "/admin/listPro")
public class ListProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DAOProduct daoProduct = new DAOProduct();
        List<Product> listProduct = daoProduct.getAllProduct();
        req.setAttribute("listProduct",listProduct);
        req.getRequestDispatcher("../View/admin/prolist.jsp").forward(req,resp);
    }
}
