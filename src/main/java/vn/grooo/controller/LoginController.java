package vn.grooo.controller;


import vn.grooo.constant.SystemConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String message = request.getParameter("message");
            if (message != null) {
                if (message.equals("username_password_invalid")) {
                    request.setAttribute("message", "Username or Password is invalid !");
                    request.setAttribute("alert", "danger");
                } else if (message.equals("not_logged")) {
                    request.setAttribute("message", "Bạn chưa đăng nhập, vui lòng đăng nhập !");
                    request.setAttribute("alert", "danger");
                }

            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
