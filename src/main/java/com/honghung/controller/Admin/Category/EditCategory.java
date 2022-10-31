package com.honghung.controller.Admin.Category;

import com.honghung.dao.inplements.DAOCategory;
import com.honghung.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="EditCat", urlPatterns = "/admin/editCat")
public class EditCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int catId = Integer.parseInt(req.getParameter("id")) ;
        Category category = new DAOCategory().getCatById(catId);
        req.setAttribute("category",category);
        req.getRequestDispatcher("../View/admin/catedit.jsp").forward(req,resp);
    }
}

