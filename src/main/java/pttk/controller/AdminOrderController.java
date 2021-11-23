package pttk.controller;

import pttk.dao.order.OrderDAO;
import pttk.dao.order.impl.OrderDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin-order"})
public class AdminOrderController extends HttpServlet {

    private final OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            int id = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status");
            orderDAO.update(status,id);
            response.sendRedirect("/admin");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
