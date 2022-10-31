package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOUser;
import com.honghung.model.UserModel;
import com.honghung.session.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerController" , urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String province = req.getParameter("province");
        String image = req.getParameter("image");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String password  = req.getParameter("password");
        DAOUser daoUser = new DAOUser();
        UserModel userModel = new DAOUser().getUserByUsernameAndPass(username,email);
        if(userModel!=null){
            req.setAttribute("masages","Dang ki that bai vi username hoac email da su dung. Vui long thu ten khac");
            resp.sendRedirect("login");
        }else{
            boolean isInserted =  daoUser.insertUserRegister(username,name,province,image,email,address,country,phone,password);
            if(isInserted){
                Session.session = req.getSession();
                userModel = new DAOUser().getUserRegisterByUsernameAndPass(username,password);
                req.getSession().setAttribute("userId",userModel.getId());
                req.getSession().setAttribute("sendCode",true);
                req.getSession().setAttribute("email",email);
                resp.sendRedirect("email");
            }else{
                req.setAttribute("masages","Co loi xay ra , Vui long thu lai");
                resp.sendRedirect("login");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
