package pttk.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import pttk.model.customer.Account;
import pttk.model.customer.Customer;
import pttk.model.customer.FullName;

import pttk.service.CustomerService;
import pttk.service.impl.CustomerServiceImpl;

@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String message = request.getParameter("message1");
            if (message != null) {
                if (message.equals("username_exit")) {
                    request.setAttribute("message1", "Username is already exist");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("re-password_incorrect")) {
                    request.setAttribute("message1", "Password is incorrect");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("not_null")) {
                    request.setAttribute("message1", "Fields not empty !");
                    request.setAttribute("alert", "danger");
                }
                if(message.equals("error-server")){
                     request.setAttribute("message1", "Server Error !");
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
