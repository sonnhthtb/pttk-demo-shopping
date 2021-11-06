package vn.grooo.controller;

import vn.grooo.entity.Category;
import vn.grooo.entity.Order;
import vn.grooo.entity.Product;
import vn.grooo.entity.UserEntity;
import vn.grooo.service.CategoryService;
import vn.grooo.service.OrderService;
import vn.grooo.service.ProductService;
import vn.grooo.service.impl.CategoryServiceImpl;
import vn.grooo.service.impl.OrderServiceImpl;
import vn.grooo.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns =  {"/list-order"})
public class ListOrderController extends HttpServlet {

    private final OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            UserEntity user = (UserEntity) session.getAttribute("user");
            List<Order> orders = orderService.findByUserId(user.getId());

            request.setAttribute("orders", orders);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/order-list.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
