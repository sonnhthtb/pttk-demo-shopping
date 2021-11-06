package vn.grooo.controller;

import vn.grooo.entity.UserEntity;
import vn.grooo.service.UserService;
import vn.grooo.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/my-account"})
public class AccountController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = request.getParameter("message");
        if (message != null) {
            if (message.equals("password_incorrect")){
                request.setAttribute("message", "Mật khẩu sai");
                request.setAttribute("alert", "danger");
            }
            if (message.equals("re-password_incorrect")) {
                request.setAttribute("message", "Mật khẩu mới không khớp");
                request.setAttribute("alert", "danger");
            }
            if (message.equals("not_null")) {
                request.setAttribute("message", "Các trường không được để rỗng");
                request.setAttribute("alert", "danger");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/account.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String newPassword = request.getParameter("new-password");
        String rePassword = request.getParameter("re-password");


        try {
            // validate input
            if (password != null && rePassword != null && newPassword != null
                    && !newPassword.trim().isEmpty() && !password.trim().isEmpty() && !rePassword.trim().isEmpty()) {

                //validate re-password
                if (!newPassword.equals(rePassword)) {
                    response.sendRedirect(request.getContextPath() + "/my-account?message=re-password_incorrect");
                } else {
                    //check username exits or not
                    HttpSession session = request.getSession();
                    UserEntity user = (UserEntity) session.getAttribute("user");

                    //check password
                    if (user.getPassword().equals(password)) {
                        user.setPassword(newPassword);
                        userService.update(user);
                        session.setAttribute("user", user);
                        Cookie[] cookies = request.getCookies();

                        // reset cookie
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("password")) {
                                cookie.setValue(newPassword);
                                response.addCookie(cookie);
                            }
                        }
                        session.setAttribute("user", user);
                        request.setAttribute("message", "Đổi mật khẩu thành công");
                        request.setAttribute("alert", "success");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/account.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/my-account?message=password_incorrect");
                    }
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/my-account?message=not_null");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
