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

@WebServlet(name="AddBrand", urlPatterns = "/admin/addBrand")
public class AddBrand extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("../View/admin/brandadd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String brandName = req.getParameter("brandName");
        String brandLogo = req.getParameter("brandLogo");
        if(brandName.length()>2) {
            brandName = brandName.substring(0, 1).toUpperCase() + brandName.substring(1).toLowerCase();
        }
        DAOBrand daoCat = new DAOBrand();
        Brand brand = daoCat.getBrandByName( brandName);
        if(brand != null){
            req.setAttribute("msg","Error to add brand, Brand name already exists");
        }else if(daoCat.insertBrand(brandName,brandLogo)){
            req.setAttribute("msg","Add brand successfully");
        }else{
            req.setAttribute("msg","Error to add brand, Try again!");
        }
        doGet(req, resp);
    }

}
