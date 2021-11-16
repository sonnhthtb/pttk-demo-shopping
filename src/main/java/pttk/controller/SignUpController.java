package pttk.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import pttk.entity.Account;
import pttk.entity.Customer;
import pttk.entity.FullName;
import pttk.service.CustomerService;
import pttk.service.impl.CustomerServiceImpl;

@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {
    private final CustomerService customerService = new CustomerServiceImpl();
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
                    request.setAttribute("message", "Fields not empty !");
                    request.setAttribute("alert", "danger");
                }
                if(message.equals("error-server")){
                     request.setAttribute("message", "Server Error !");
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
            String firstName = request.getParameter("first-name");
            String middleName = request.getParameter("middle-name");
            String lastName = request.getParameter("last-name");
            // validate input
            if (username != null && password != null && rePassword != null && lastName != null
                    && !username.trim().isEmpty() && !password.trim().isEmpty() && !rePassword.trim().isEmpty() && !lastName.trim().isEmpty()) {

                //validate re-password
                if (!password.equals(rePassword)) {
                    response.sendRedirect(request.getContextPath() + "/sign-up?message=re-password_incorrect");
                } else {
                    //check username exits or not
                    Customer customer = customerService.findByUserNameAndPassword(username,password);
                    if (customer == null) {
                        FullName fullName = new FullName(firstName, middleName, lastName);
                        Account account = new Account(username, password);
                        customer = new Customer();
                        customer.setAccount(account);
                        customer.setFullName(fullName);
                        Boolean isCreated = customerService.createNewCustomer(customer);
                        if(isCreated){
                            request.setAttribute("message", "??ng ký thành công");
                            request.setAttribute("alert", "success");
                            request.setAttribute("username", username);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
                            dispatcher.forward(request, response);
                        }
                        else{
                          response.sendRedirect(request.getContextPath() + "/sign-up?message=error-server");
                        }
                        
                    } else {
                        response.sendRedirect(request.getContextPath() + "/sign-up?message=username_exit");
                    }
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/sign-up?message=not_null");
            }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
    }
}
