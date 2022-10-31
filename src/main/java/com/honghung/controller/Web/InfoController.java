package com.honghung.controller.Web;

import com.honghung.dao.inplements.DAOUser;
import com.honghung.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="infoController", urlPatterns = {"/info"})
public class InfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        int userId = Integer.parseInt(req.getParameter("uid"));
        UserModel user = new DAOUser().getUserById(userId);
        req.getSession().setAttribute("user",user);
        req.getRequestDispatcher("View/Web/info.jsp").forward(req,resp);

    }
}
