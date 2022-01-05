package pttk.controller;

import pttk.logic.application.bookDAO.ItemBookDAO;
import pttk.logic.application.bookDAO.LineItemBookDAO;
import pttk.logic.application.bookDAO.impl.ItemBookDAOImpl;
import pttk.logic.application.bookDAO.impl.LineItemBookDAOImpl;
import pttk.logic.application.orderDAO.CartDAO;
import pttk.logic.application.orderDAO.impl.CartDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.model.order.Cart;
import pttk.model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/change-quantity"})
public class ChangeQuantiyController extends HttpServlet {

    private final LineItemBookDAO lineItemBookDAO = new LineItemBookDAOImpl();
    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();
    private final CartDAO cartDAO = new CartDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            User customer = (User) session.getAttribute("customer");
            Cart cart = cartDAO.getCartByCustomerId(customer.getId(), "active");
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            String type = request.getParameter("type");
            int quantity = Integer.parseInt(request.getParameter("quantity"));


            // increase quantity of item in cart
            if (action.equals("inc")) {
                LineItemBook lineItemBook = lineItemBookDAO.findById(id);
                ItemBook itemBook = itemBookDAO.findById(lineItemBook.getItemBook().getId());
                if (quantity >= itemBook.getBook().getQuantity()) {
                    request.setAttribute("messageResponse", "Kho không đủ hàng");
                    request.setAttribute("alert", "danger");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
                    dispatcher.forward(request, response);
                    return;
                } else {
                    quantity++;
                    lineItemBookDAO.updateQuantity(quantity, id);
                    cart.setTotalPrice(cart.getTotalPrice() + itemBook.getPrice());
                    cartDAO.update(cart);
                }
            }
            //decrease quantity of item in cart
            else if (action.equals("dec")) {
                quantity--;
                switch (type) {
                    case "book":
                        LineItemBook lineItemBook = lineItemBookDAO.findById(id);
                        ItemBook itemBook = itemBookDAO.findById(lineItemBook.getItemBook().getId());
                        cart.setTotalPrice(cart.getTotalPrice() - itemBook.getPrice());
                        cartDAO.update(cart);
                        if (quantity == 0) {
                            lineItemBookDAO.deleteLineItemBook(id);
                        } else {
                            lineItemBookDAO.updateQuantity(quantity, id);
                        }
                        break;
                    default:
                        break;
                }
            }
            // delete item from cart
            else if (action.equals("del")) {
                switch (type) {
                    case "book":
                        LineItemBook lineItemBook = lineItemBookDAO.findById(id);
                        ItemBook itemBook = itemBookDAO.findById(lineItemBook.getItemBook().getId());
                        cart.setTotalPrice(cart.getTotalPrice() - quantity * itemBook.getPrice());
                        cartDAO.update(cart);
                        lineItemBookDAO.deleteLineItemBook(id);
                        break;
                    default:
                        break;
                }
            }
            response.sendRedirect("/cart");
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
