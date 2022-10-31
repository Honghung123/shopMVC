package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOUser;
import com.honghung.model.UserModel;
import com.honghung.session.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("View/Web/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username== null || password==null){
            req.getRequestDispatcher("View/Web/login.jsp").forward(req, resp);
        }else{
            UserModel  userModel = new DAOUser().getUserByUsernameAndPass(username,password);
            if(userModel == null){
                doGet(req, resp);
            }else{
                req.getSession().setAttribute("user",userModel);
                Session.session = req.getSession();
                Session.setSession("isLogin", true);
                resp.sendRedirect("trang-chu");
            }
        }
    }
}
