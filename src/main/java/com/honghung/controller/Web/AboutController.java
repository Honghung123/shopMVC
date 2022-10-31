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

@WebServlet(name="AboutController", urlPatterns = {"/about"})
public class AboutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("View/Web/about.jsp").forward(req,resp);

    }
}
