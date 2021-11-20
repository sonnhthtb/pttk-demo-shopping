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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    private final CartService cartService = new CartServiceimpl();
    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final ItemBookService itemBookService = new ItemBookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = cartService.getCartByCustomerId(customer.getId());
        if(cart == null) {
            Long ans = cartService.create(customer.getId());
        }
        cart = cartService.getCartByCustomerId(customer.getId());
        List<LineItemBook> listLineBook = lineItemBookService.findByCartId(cart.getId());

        for ( LineItemBook lineBook : listLineBook ) {
            ItemBook itemBook = itemBookService.findById(lineBook.getItemBook().getId());
            lineBook.setItemBook(itemBook);
            System.out.println(lineBook.getItemBook().toString());
        }
        System.out.println(listLineBook.size());
        request.setAttribute("listLineBook", listLineBook);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
