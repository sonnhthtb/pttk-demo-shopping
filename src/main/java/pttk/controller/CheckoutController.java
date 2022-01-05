package pttk.controller;

import pttk.logic.application.bookDAO.ItemBookDAO;
import pttk.logic.application.bookDAO.LineItemBookDAO;
import pttk.logic.application.bookDAO.impl.ItemBookDAOImpl;
import pttk.logic.application.bookDAO.impl.LineItemBookDAOImpl;
import pttk.logic.application.orderDAO.CartDAO;
import pttk.logic.application.orderDAO.ShipmentServiceDAO;
import pttk.logic.application.orderDAO.impl.CartDAOImpl;
import pttk.logic.application.orderDAO.impl.ShipmentServiceDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.model.order.Cart;
import pttk.model.order.ShipmentService;
import pttk.model.user.User;

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

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();
    private final LineItemBookDAO lineItemBookDAO = new LineItemBookDAOImpl();
    private final CartDAO cartDAO = new CartDAOImpl();
    private final ShipmentServiceDAO shipmentServiceDAO = new ShipmentServiceDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            User customer = (User) session.getAttribute("customer");
            Cart cart = cartDAO.getCartByCustomerId(customer.getId(), "active");
            if (cart == null) {
                cartDAO.create(customer.getId());
                cart = cartDAO.getCartByCustomerId(customer.getId(), "active");
            }
            List<LineItemBook> listLineBook = lineItemBookDAO.findByCartId(cart.getId());

            for (LineItemBook lineBook : listLineBook) {
                ItemBook itemBook = itemBookDAO.findById(lineBook.getItemBook().getId());
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
