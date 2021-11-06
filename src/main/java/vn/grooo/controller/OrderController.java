package vn.grooo.controller;

import vn.grooo.entity.*;
import vn.grooo.service.CategoryService;
import vn.grooo.service.OrderService;
import vn.grooo.service.ProductService;
import vn.grooo.service.impl.CategoryServiceImpl;
import vn.grooo.service.impl.OrderServiceImpl;
import vn.grooo.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Product> productList = new ArrayList<>();
            List<OrderItem> orderItems = new ArrayList<>();
            Order order = new Order();
            Cookie[] cookies = request.getCookies();

            //get all item from cookie cart
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    if (!cookie.getValue().isEmpty()) {
                        String[] ids = cookie.getValue().split("/");
                        for (String id : ids) {
                            productList.add(productService.findById(Long.parseLong(id)));
                        }
                    }
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

            // push item from cookie cart to order when have any cart item
            if (!productList.isEmpty()) {
                float totalPrice = 0;
                for (Product product : productList) {
                    totalPrice += product.getPrice();
                    if (orderItems.isEmpty()) {
                        orderItems.add(new OrderItem(product, 1));
                    } else {
                        boolean isExits = false;
                        for (OrderItem orderItem : orderItems) {
                            if (orderItem.getProduct().getId() == product.getId()) {
                                orderItem.setQuantity(orderItem.getQuantity() + 1);
                                isExits = true;
                                break;
                            }
                        }
                        if (!isExits) {
                            orderItems.add(new OrderItem(product, 1));
                        }
                    }
                }

                // set user for order
                HttpSession session = request.getSession();
                UserEntity user = (UserEntity) session.getAttribute("user");

                order.setOrderItems(orderItems);
                order.setTotalAmount(productList.size());
                order.setTotalPrice(totalPrice);
                order.setUser(user);


                if (order != null) {
                    Order newOrder = orderService.save(order);
                    request.setAttribute("order", newOrder);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/order-detail.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("/home");
                }
            } else {
                response.sendRedirect("/home");
            }
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
