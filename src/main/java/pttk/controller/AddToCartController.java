package pttk.controller;

import pttk.model.order.Cart;
import pttk.model.customer.Customer;
import pttk.service.CartService;
import pttk.service.LineItemBookService;
import pttk.service.LineItemClothesService;
import pttk.service.LineItemShoesService;
import pttk.service.impl.CartServiceimpl;
import pttk.service.impl.LineItemClothesServiceImpl;
import pttk.service.impl.LineItemShoesServiceImpl;
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
    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final LineItemShoesService lineItemShoesService = new LineItemShoesServiceImpl();
    private final LineItemClothesService lineItemClothesService = new LineItemClothesServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId());
            if(cart == null) {
                Long ans = cartService.create(customer.getId());
            }
            cart = cartService.getCartByCustomerId(customer.getId());
            String type = request.getParameter("type");
            Long ans = 0L;
            switch (type) {
                case "book" :
                    int itemBookId = Integer.parseInt((String) request.getParameter("id"));
                    int quantityB = Integer.parseInt((String) request.getParameter("quantity"));
                    ans = lineItemBookService.create(cart.getId(), itemBookId, quantityB);
                    break;
                case "clothes" :
                    int itemClothesId = Integer.parseInt((String) request.getParameter("id"));
                    int quantityC = Integer.parseInt((String) request.getParameter("quantity"));
                    ans = lineItemClothesService.create(cart.getId(), itemClothesId, quantityC);
                    break;
                case "shoes" :
                    int itemShoesId = Integer.parseInt((String) request.getParameter("id"));
                    int quantityS = Integer.parseInt((String) request.getParameter("quantity"));
                    ans = lineItemShoesService.create(cart.getId(), itemShoesId, quantityS);
                    break;
            }

            response.sendRedirect("/cart");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
