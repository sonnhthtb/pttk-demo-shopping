package pttk.controller;


import pttk.constant.SystemConstant;
import pttk.entity.Customer;
import pttk.service.CustomerService;
import pttk.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private final CustomerService customerService = new CustomerServiceImpl();

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
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String isRemember = request.getParameter("remember");
            Customer customer = customerService.findByUserNameAndPassword(username, password);
            // check user
            if (customer != null) {

                // add username and password to cookie when select remember me
                if (isRemember != null) {

                    Cookie cookieUsername = new Cookie("username", customer.getAccount().getUsername());
                    cookieUsername.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
                    response.addCookie(cookieUsername);

                    Cookie cookiePassword = new Cookie("password", customer.getAccount().getPassword());
                    cookiePassword.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
                    response.addCookie(cookiePassword);

                }
                // add user to session
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                response.sendRedirect("/home");

            } else {
                response.sendRedirect(request.getContextPath() + "/login?message=username_password_invalid");
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
