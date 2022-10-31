package com.honghung.controller.Web;

import com.honghung.dao.inplements.*;
import com.honghung.model.Cart;
import com.honghung.model.Order;
import com.honghung.model.Product;
import com.honghung.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name="OrderController", urlPatterns = {"/ordered"})
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        DAOOrder order = new DAOOrder();
        if(req.getParameter("delId")!=null){
            int orderId = Integer.parseInt(req.getParameter("delId"));
            order.deleteOrder(orderId);
        }
        List<Order> listOrder = order.getAllOrder();
        req.setAttribute("listOrder",listOrder);
        int sumPrice =  order.getSumPrice();
        int vat = (int)(sumPrice * 0.1) ;
        req.setAttribute("sumPrice",sumPrice);
        req.setAttribute("vat",vat);
       req.getRequestDispatcher("View/Web/orders.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("insertOrder")!=null){
            String[] cartId = req.getParameterValues("cartId");
            String[] proId = req.getParameterValues("proId" );
            String[] proName = req.getParameterValues("proName");
            String[] proPrice = req.getParameterValues("proPrice");
            String[] proImage = req.getParameterValues("proImage");
            String[] quantity =  req.getParameterValues("quantity" );
            DAOOrder order = new DAOOrder();
            DAOCart cart = new DAOCart();
            DAOProduct product = new DAOProduct();
            HttpSession session = req.getSession();
            UserModel  userModel =  (UserModel) session.getAttribute("user") ;
            String username = userModel.getUsername();
            System.out.println(username);
            int id = 0;
            for (String x : proId){
                int cartid = Integer.parseInt(cartId[id]);
                int productId = Integer.parseInt(x);
                int quantities = Integer.parseInt(quantity[id]);
                Product pro= product.getProductById(productId);
                int categoryId = pro.getCategory();
                int brandId = pro.getBrand();
                order.insertOrder(productId,categoryId,brandId,proName[id],proImage[id],proPrice[id],quantities,username);
                cart.deleteCart(cartid);
                id  ++;
            }

        }
        doGet(req, resp);
    }
}
