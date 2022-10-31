package com.honghung.controller.Admin.Brand;

import com.honghung.dao.inplements.DAOBrand;
import com.honghung.dao.inplements.DAOCategory;
import com.honghung.model.Brand;
import com.honghung.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="EditBrand", urlPatterns = "/admin/editBrand")
public class EditBrand extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int brandId = Integer.parseInt(req.getParameter("id"));
    Brand brand = new DAOBrand().getBrandById(brandId);
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("../View/admin/brandedit.jsp").forward(req,resp);
    }
}

