package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ListProController", urlPatterns = {"/product"})
public class ListProController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int start ;
        int limit = 5;
        if(req.getParameter("page") == null){
            start = 1;
        }else{
            start = Integer.parseInt(req.getParameter("page"));
            System.out.println(start);
        }
        List<Product> productList = new DAOProduct().getAllProductLimit((start - 1)*limit,limit);
        int totalProduct = new DAOProduct().getAmountProduct();
        int max_page = (int) Math.ceil((double) totalProduct/limit);
        req.setAttribute("max_page",max_page);
        req.setAttribute("productList",productList);
        req.setAttribute("cur_page",start);
        req.getRequestDispatcher("View/Web/products.jsp").forward(req,resp);
    }
}
