package com.honghung.controller.Admin.Product;

import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DeleteProduct", urlPatterns = "/admin/delPro")
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("proId"));
        new DAOProduct().deleteProduct( id);
        resp.sendRedirect("listPro");
    }
}

