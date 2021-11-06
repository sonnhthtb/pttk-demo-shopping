package vn.grooo.controller;

import vn.grooo.entity.Order;
import vn.grooo.entity.Product;
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
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/admin-order"})
public class AdminOrderController extends HttpServlet {

    private final OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String view = "views/admin/order/list-order.jsp";
            int totalItem = orderService.getTotalItem();

            // number of item in a page
            int maxPageItem = 6;
            int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
            int currentPage = 1;
            //check if request have any currentPage param
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }

            int offset = (currentPage - 1) * maxPageItem;

            List<Order> orderList = orderService.findAll(offset, maxPageItem);

            request.setAttribute("orderList", orderList);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("currentPage", currentPage);
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            String id = request.getParameter("id");
            String status = request.getParameter("status");
            //
            if (!id.isEmpty()) {
                orderService.update(Long.parseLong(id), status);
                String view = "views/admin/order/list-order.jsp";
                int totalItem = orderService.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;
                //check if request have any currentPage param
                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<Order> orderList = orderService.findAll(offset, maxPageItem);

                request.setAttribute("orderList", orderList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
                request.setAttribute("messageResponse", "Cập nhật đơn hàng thành công");
                request.setAttribute("alert", "success");
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            }
        }catch (Exception e) {
            response.sendRedirect("/error");
        }
    }
}
