package pttk.controller;

import pttk.model.book.ItemBook;
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

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCartController extends HttpServlet {

    private final CartService cartService = new CartServiceimpl();
    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId(), "active");
            if (cart == null) {
                Long ans = cartService.create(customer.getId());
            }
            cart = cartService.getCartByCustomerId(customer.getId(), "active");
            String type = request.getParameter("type");
            Long ans = 0L;
            switch (type) {
                case "book":
                    int itemBookId = Integer.parseInt(request.getParameter("id"));
                    int quantityB = Integer.parseInt(request.getParameter("quantity"));
                    ans = lineItemBookService.create(cart.getId(), itemBookId, quantityB);
                    ItemBook itemBook = itemBookService.findById(itemBookId);
                    cart.setTotalPrice(cart.getTotalPrice() + itemBook.getPrice() * quantityB);
                default:
                    break;
            }
            cartService.update(cart);
            response.sendRedirect("/cart");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
