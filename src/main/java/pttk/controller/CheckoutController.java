package pttk.controller;

import pttk.logic.application.orderDAO.ShipmentServiceDAO;
import pttk.logic.application.orderDAO.impl.ShipmentServiceDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.model.customer.Customer;
import pttk.model.order.Cart;
import pttk.model.order.ShipmentService;
import pttk.service.CartService;
import pttk.service.ItemBookService;
import pttk.service.LineItemBookService;
import pttk.service.impl.CartServiceimpl;
import pttk.service.impl.ItemBookServiceImpl;
import pttk.service.impl.LineItenBookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    private final CartService cartService = new CartServiceimpl();
    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final ShipmentServiceDAO shipmentServiceDAO = new ShipmentServiceDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId(), "active");
            if (cart == null) {
                cartService.create(customer.getId());
            }
            cart = cartService.getCartByCustomerId(customer.getId(), "active");
            List<LineItemBook> listLineBook = lineItemBookService.findByCartId(cart.getId());

            for (LineItemBook lineBook : listLineBook) {
                ItemBook itemBook = itemBookService.findById(lineBook.getItemBook().getId());
                lineBook.setItemBook(itemBook);
            }
            request.setAttribute("listLineBook", listLineBook);
            request.setAttribute("cart", cart);
            String payment = request.getParameter("payment");
            request.setAttribute("payment", payment);
            String shipmentServiceId = request.getParameter("shipmentServiceId");
            ShipmentService shipmentService = shipmentServiceDAO.findById(Integer.parseInt(shipmentServiceId));
            request.setAttribute("shipmentService", shipmentService);
            String address = request.getParameter("address");
            request.setAttribute("address", address);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/checkout.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
