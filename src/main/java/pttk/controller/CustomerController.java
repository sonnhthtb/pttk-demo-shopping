package pttk.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pttk.entity.*;

@WebServlet(urlPatterns = {"/my-account"})
public class CustomerController  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer =  (Customer)session.getAttribute("customer");
        String username = customer.getAccount().getUsername();
        FullName fullName = customer.getFullName();
        Address address= customer.getAddress();
        request.setAttribute("first-name", fullName.getFirstName());
        System.out.println(fullName);
        String message = request.getParameter("message");
        if (message != null) {
            if (message.equals("password_incorrect")){
                request.setAttribute("message", "Password wrong !");
                request.setAttribute("alert", "danger");
            }
            if (message.equals("re-password_incorrect")) {
                request.setAttribute("message", "Re-password and password don't match! ");
                request.setAttribute("alert", "danger");
            }
            if (message.equals("not_null")) {
                request.setAttribute("message", "Fiels not empty !");
                request.setAttribute("alert", "danger");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/customer-information.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        try {
        
        } catch (Exception exception) {
            exception.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}

