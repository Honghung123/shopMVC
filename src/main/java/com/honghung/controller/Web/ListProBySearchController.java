package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchController", urlPatterns = { "/search" })
public class ListProBySearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int start;
        int limit = Integer.parseInt(req.getParameter("limit"));
        if (req.getParameter("start") == null) {
            start = 1;
        } else {
            start = Integer.parseInt(req.getParameter("start"));
        }
        String search = req.getParameter("search");
        System.out.println(limit+"  "+ search +"  "+ start);
        List<Product> productList = new DAOProduct().getProductsBySearch(search, start, limit);
        PrintWriter writer = resp.getWriter();
        String result = "";
        for (Product product : productList) {
            result += " <div class='col m-0 visibility-visible-item'>" +
                    "<div class='card h-100 mt-4 bg-colorful2'>" +
                    "  <a href='detail?proId="+product.getId()+"' style='min-height: 12rem; '" +
                    "class='d-flex justify-content-center align-items-center bg-white'>" +
                    " <img src='"+product.getImage()+"'  alt='"+product.getName()+"' style=' max-height: 10rem; '></a>" +

                    " <div class='card-body text-center'>" +
                    "<a href='detail?proId="+product.getId()+"'><h5" +
                    "class='card-title line-clamp-2'>"+product.getName()+"</h5></a>" +
                    "<p class='card-text line-clamp-2'>"+product.getShort_desc()+"</p> </div>" +
                    " <div class='text-center h-25'> " +
                    "<p class='fw-bold text-danger ' style='font-size: 1.5rem'>"+product.getPrice()+" VND</p>" +
                    "<div class='d-flex-center align-self-end flex-wrap visibility-hidden'>" +
                    "  <div class='btn btn-danger bg-transparent text-danger favourite-items'  title='Add your favourite'"
                    +
                    "style='margin: 0 .3rem;'><i class='fa-regular fa-heart'></i></div>" +
                    "<div class='' title='Add to cart' style='margin: 0 .3rem;'>" +
                    "<form action='cart' method='post'>" +
                    " <input type='hidden' name='id' value='"+product.getId()+"'>" +
                    "<input type='hidden' name='proName' value='"+product.getName()+"'>" +
                    "<input type='hidden' name='proImage' value='"+product.getImage()+"'>" +
                    "<input type='hidden' name='proPrice' value='"+product.getPrice()+"'>" +
                    "<input type='hidden' class='buyfield' name='quantity' value='1'/>" +
                    "  <button type='submit' class='btn btn-info border-0 text-white'  name='insertCart'>" +
                    "       <i class='fa-solid fa-cart-shopping'></i> </button> </form>  </div>" +
                    "<div class='btn btn-warning bg-transparent text-warning vote-items' title='Vote this item'" +
                    "style='margin: 0 .3rem;'><i class='fa-regular fa-star'></i></div> </div>    </div>  </div> </div>";
        }
        writer.println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int start;
        int limit = 10;
        if (req.getParameter("page") == null) {
            start = 1;
        } else {
            start = Integer.parseInt(req.getParameter("page"));
        }
        String search = req.getParameter("search");
        List<Product> productList = new DAOProduct().getProductsBySearch(search, (start - 1) * limit, limit);
        req.setAttribute("productList", productList);
        req.setAttribute("keyword", search);
        req.getRequestDispatcher("View/Web/searchs.jsp").forward(req, resp);
    }
}
