package pttk.controller;

import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.model.customer.Customer;
import pttk.model.order.Cart;
import pttk.service.CartService;
import pttk.service.ItemBookService;
import pttk.service.LineItemBookService;
import pttk.service.impl.CartServiceimpl;
import pttk.service.impl.ItemBookServiceImpl;
import pttk.service.impl.LineItenBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/change-quantity"})
public class ChangeQuantiyController extends HttpServlet {

    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final CartService cartService = new CartServiceimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId(), "active");
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            String type = request.getParameter("type");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            // increase quantity of item in cart
            if (action.equals("inc")) {
                quantity++;
                switch (type) {
                    case "book":
                        lineItemBookService.updateQuantity(quantity, id);
                        LineItemBook lineItemBook = lineItemBookService.findById(id);
                        ItemBook itemBook = itemBookService.findById(lineItemBook.getItemBook().getId());
                        cart.setTotalPrice(cart.getTotalPrice() + itemBook.getPrice());
                        cartService.update(cart);
                        break;
                    default:
                        break;
                }
            }
            //decrease quantity of item in cart
            else if (action.equals("dec")) {
                quantity--;
                switch (type) {
                    case "book":
                        LineItemBook lineItemBook = lineItemBookService.findById(id);
                        ItemBook itemBook = itemBookService.findById(lineItemBook.getItemBook().getId());
                        cart.setTotalPrice(cart.getTotalPrice() - itemBook.getPrice());
                        cartService.update(cart);
                        if (quantity == 0) {
                            lineItemBookService.deleteLineItemBook(id);
                        } else {
                            lineItemBookService.updateQuantity(quantity, id);
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
                        LineItemBook lineItemBook = lineItemBookService.findById(id);
                        ItemBook itemBook = itemBookService.findById(lineItemBook.getItemBook().getId());
                        cart.setTotalPrice(cart.getTotalPrice() - quantity * itemBook.getPrice());
                        cartService.update(cart);
                        lineItemBookService.deleteLineItemBook(id);
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
