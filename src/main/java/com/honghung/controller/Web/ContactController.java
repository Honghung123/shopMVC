package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Category;
import com.honghung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ContactController", urlPatterns = {"/contact"})
public class ContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
//        int catId = Integer.parseInt(req.getParameter("catId"));
//        List<Product> productListbyCat = new DAOProduct().getProductsByCatId(catId);
//        Category category = new DAOCategory().getCatById(catId);
//        req.setAttribute("category",category);
//        req.setAttribute("productListbyCat",productListbyCat);
        req.getRequestDispatcher("View/Web/contact.jsp").forward(req,resp);

    }
}
