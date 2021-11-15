package pttk.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String message = request.getParameter("message");
            if (message != null) {
                if (message.equals("username_exit")) {
                    request.setAttribute("message", "Username is already exist");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("re-password_incorrect")) {
                    request.setAttribute("message", "Password is incorrect");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("not_null")) {
                    request.setAttribute("message", "Các trường không được để rỗng");
                    request.setAttribute("alert", "danger");
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/signup.jsp");
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
