package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOBrand;
import com.honghung.dao.inplements.DAOCart;
import com.honghung.dao.inplements.DAOCategory;
import com.honghung.dao.inplements.DAOProduct;
import com.honghung.model.Brand;
import com.honghung.model.Cart;
import com.honghung.model.Category;
import com.honghung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        DAOCart cart = new DAOCart();
        if(req.getParameter("delId")!=null){
            int cartId = Integer.parseInt(req.getParameter("delId"));
            cart.deleteCart(cartId);
        }
        List<Cart> listCart = cart.getAllCart();
        req.setAttribute("listCart",listCart);
        int sumPrice =  cart.getSumPrice();
        int vat = (int)(sumPrice * 0.1) ;
        req.setAttribute("sumPrice",sumPrice);
        req.setAttribute("vat",vat);
        req.getRequestDispatcher("View/Web/cart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("insertCart")!=null){
            String proName = req.getParameter("proName");
            String proPrice = req.getParameter("proPrice");
            String proImage = req.getParameter("proImage");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int proId = Integer.parseInt(req.getParameter("id"));
            new DAOCart().insertCart(proName,proImage,proPrice,quantity,proId);
        } else if(req.getParameter("updateQuantity")!=null){
            String proName = req.getParameter("proName");
            String proPrice = req.getParameter("proPrice");
            String proImage = req.getParameter("proImage");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int proId = Integer.parseInt(req.getParameter("proId"));
            int cartId = Integer.parseInt(req.getParameter("id"));
            new DAOCart().updateCart(proName,proImage,proPrice,quantity,proId,cartId);
        }
        doGet(req, resp);
    }
}
