package com.honghung.controller.Admin.Category;

import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOUser;
import com.honghung.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AddCategory", urlPatterns = "/admin/addCat")
public class AddCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("../View/admin/catadd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String catName = req.getParameter("catName");
        String catBanner = req.getParameter("catBanner");
        if(catName.length()>2) {
            catName = catName.substring(0, 1).toUpperCase() + catName.substring(1).toLowerCase();
        }
        DAOCategory daoCat = new DAOCategory();
        Category category = daoCat.getCatByName(catName);
        if(category != null){
            req.setAttribute("msg","Error to add category, Category name already exists");
        }else if(daoCat.insertCategory(catName,catBanner)){
            req.setAttribute("msg","Add category successfully");
        }else{
            req.setAttribute("msg","Error to add category, Try again!");
        }
        doGet(req, resp);
    }

}
