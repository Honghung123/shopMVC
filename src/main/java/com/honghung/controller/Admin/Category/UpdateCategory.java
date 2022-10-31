package com.honghung.controller.Admin.Category;

import com.honghung.dao.inplements.DAOCategory;
import com.honghung.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="UpdateCat", urlPatterns = "/admin/updateCat")
public class UpdateCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        String catName = req.getParameter("catName");
        String catBanner = req.getParameter("catBanner");
        new DAOCategory().updateCategory(catName,catBanner,id);
        resp.sendRedirect("listCat");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

