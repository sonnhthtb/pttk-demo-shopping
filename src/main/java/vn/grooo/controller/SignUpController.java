package vn.grooo.controller;


import vn.grooo.entity.UserEntity;
import vn.grooo.service.UserService;
import vn.grooo.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

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

        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("re-password");
            String fullName = request.getParameter("fullName");

            // validate input
            if (username != null && password != null && rePassword != null && fullName != null
                    && !username.trim().isEmpty() && !password.trim().isEmpty() && !rePassword.trim().isEmpty() && !fullName.trim().isEmpty()) {

                //validate re-password
                if (!password.equals(rePassword)) {
                    response.sendRedirect(request.getContextPath() + "/sign-up?message=re-password_incorrect");
                } else {
                    //check username exits or not
                    UserEntity user = userService.findByUserName(username);
                    if (user == null) {
                        userService.save(username, password, fullName);
                        request.setAttribute("message", "Đăng ký thành công");
                        request.setAttribute("alert", "success");
                        request.setAttribute("username", username);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/sign-up?message=username_exit");
                    }
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/sign-up?message=not_null");
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
