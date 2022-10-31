package com.honghung.controller.Admin.Brand;

import com.honghung.dao.inplements.DAOBrand;
import com.honghung.model.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ListBrand", urlPatterns = "/admin/listBrand")
public class ListBrand extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Brand> listBrand = new DAOBrand().getAllBrand();
        req.setAttribute("listBrand",listBrand);
        req.getRequestDispatcher("../View/admin/brandlist.jsp").forward(req,resp);
    }
}
