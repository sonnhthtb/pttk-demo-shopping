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

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCartController extends HttpServlet {


    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();
    private final CartDAO cartDAO = new CartDAOImpl();
    private final LineItemBookDAO lineItemBookDAO = new LineItemBookDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User customer = (User) session.getAttribute("customer");
            if (customer == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home.jsp");
                dispatcher.forward(request, response);
            }
            Cart cart = cartDAO.getCartByCustomerId(customer.getId(), "active");
            if (cart == null) {
                Long ans = cartDAO.create(customer.getId());
                cart = cartDAO.getCartByCustomerId(customer.getId(), "active");
            }
            int itemBookId = Integer.parseInt(request.getParameter("id"));
            ItemBook itemBook = itemBookDAO.findById(itemBookId);

            int quantity = Integer.parseInt(request.getParameter("quantity"));
            LineItemBook lineItemBook = lineItemBookDAO.findByCartIdAndItemBookId(cart.getId(), itemBookId);
            if (lineItemBook == null) {
                lineItemBookDAO.create(cart.getId(), itemBookId, quantity);
                cart.setTotalPrice(cart.getTotalPrice() + itemBook.getPrice() * quantity);
                cartDAO.update(cart);
            } else {
                if (quantity + lineItemBook.getQuantity() <= itemBook.getBook().getQuantity()) {
                    lineItemBookDAO.updateQuantity(lineItemBook.getQuantity() + quantity, lineItemBook.getId());
                    cart.setTotalPrice(cart.getTotalPrice() + itemBook.getPrice() * quantity);
                    cartDAO.update(cart);
                } else {
                    request.setAttribute("messageResponse", "Kho không đủ hàng");
                    request.setAttribute("alert", "danger");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
                    dispatcher.forward(request, response);
                    return;
                }
            }

            response.sendRedirect("/cart");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
