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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="HomeController", urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        List<Product> top4newestPro = new DAOProduct().getNewestProducts(4);
        List<Category> randBanner = new DAOCategory().randomBanner(4);
        req.setAttribute("top4newestPro",top4newestPro);
        req.setAttribute("randBanner",randBanner);
        req.getRequestDispatcher("View/Web/index.jsp").forward(req,resp);

    }
}
