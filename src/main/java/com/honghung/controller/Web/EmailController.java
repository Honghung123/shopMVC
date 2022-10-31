package com.honghung.controller.Web;


import com.honghung.dao.inplements.DAOUser;
import com.honghung.model.UserModel;
import com.honghung.services.emailUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "emailController", urlPatterns = "/email")
public class EmailController extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    @Override
    public void init() throws ServletException {
        this.host = getServletContext().getInitParameter("host");
        this.port = getServletContext().getInitParameter("port");
        this.user = getServletContext().getInitParameter("user");
        this.pass = getServletContext().getInitParameter("pass");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if ( req.getSession().getAttribute("sendCode")!=null) {

            String codeRegister = String.valueOf((int) (Math.random() * 859432) + 123456);
            System.out.println(codeRegister);
            String recipient = (String) req.getSession().getAttribute("email");
            System.out.println( recipient);
            String subject = "Ma kich hoat tai khoan Shopping Online";
            String content = "Tuyet doi khong de ma cua ban cho ai do. Vui long xac nhan trong thoi gian som nhat."
                    + " Ma cua ban la: " + codeRegister;
            try {
                emailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
                req.getSession().setAttribute("codeRegister", codeRegister);
                req.setAttribute("userId" , req.getSession().getAttribute("userId"));
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
        req.getRequestDispatcher("View/Web/confirm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getParameter("userCodeRegister") != null) {
            req.getSession().removeAttribute("sendCode");
            int userCode = Integer.parseInt(req.getParameter("userCode"));
            String serverCode = (String) req.getSession().getAttribute("codeRegister");
            System.out.println(userCode + "  " + serverCode);
            if (serverCode == null) {
                doGet(req, resp);
            } else if (Integer.parseInt(serverCode) == userCode) {
                HttpSession session = req.getSession();;
                int userId = Integer.parseInt(req.getParameter("userId"));
                UserModel user = new DAOUser().getUserRegisterById(userId);
                new DAOUser().insertUser(user.getUsername(), user.getName(), user.getProvince(),user.getImage(),user.getEmail(),user.getAddress(),
                        user.getCountry(),user.getPhone(),user.getPassword());
                session.setAttribute("isLogin", true);
                session.removeAttribute("userId");
                new DAOUser().deleteUserRegister();
                resp.sendRedirect("login");
            } else {
                req.setAttribute("massages","Ma so ban nhap khong khop, Vui long thu lai");
                doGet(req, resp);
            }
        }
        if (req.getParameter("resendCodeRegister") != null) {
            if(  req.getSession().getAttribute("sendCode")==null){
                req.getSession().setAttribute("sendCode",true);
            }
            doGet(req, resp);
        }
    }
}
