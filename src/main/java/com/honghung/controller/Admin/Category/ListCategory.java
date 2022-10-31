package com.honghung.controller.Admin.Category;

import com.honghung.dao.inplements.DAOCategory;
import com.honghung.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ListCategory", urlPatterns = "/admin/listCat")
public class ListCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Category> listCategory = new DAOCategory().getAllCategory();
        req.setAttribute("listCategory",listCategory);
        req.getRequestDispatcher("../View/admin/catlist.jsp").forward(req,resp);
    }
}
