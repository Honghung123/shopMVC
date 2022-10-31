package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOBrand;
import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Brand;
import com.honghung.model.Category;
import com.honghung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="TopBrandController", urlPatterns = {"/topbrand"})
public class TopBrandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int amount = 5;
        List<Brand> listTopBrand = new DAOBrand().getTopBrands(amount);
        req.setAttribute("listTopBrand",listTopBrand);
        List<List<Product>> listProByBrand = new ArrayList<>();
        for(Brand x: listTopBrand){
            List<Product> listsbyBrand = new DAOProduct().getProductsByBrand(x.getId());
            listProByBrand.add(listsbyBrand );
        }
        int increase = 0;
        req.setAttribute("increase",increase);
        req.setAttribute("listProByBrand",listProByBrand);
        req.getRequestDispatcher("View/Web/topbrands.jsp").forward(req,resp);
    }
}
