package vn.grooo.controller;

import vn.grooo.entity.CartItem;
import vn.grooo.entity.Product;
import vn.grooo.service.ProductService;
import vn.grooo.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Product> productList = new ArrayList<>();
            List<CartItem> cartItems = new ArrayList<>();
            Cookie[] cookies = request.getCookies();
            // get cookie cart from cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    if (!cookie.getValue().isEmpty()) {
                        String[] ids = cookie.getValue().split("/");
                        for (String id : ids) {
                            productList.add(productService.findById(Long.parseLong(id)));
                        }
                    }
                }
            }

            float totalPrice = 0;
            // get totalPrice of cart and add product to cart
            for (Product product : productList) {

                totalPrice += product.getPrice();


                if (cartItems.isEmpty()) {
                    cartItems.add(new CartItem(product, 1));
                } else {
                    boolean isExits = false;

                    // add quantity item to cart if item exits
                    for (CartItem cartItem : cartItems) {
                        if (cartItem.getProduct().getId() == product.getId()) {
                            cartItem.setQuantity(cartItem.getQuantity() + 1);
                            isExits = true;
                            break;
                        }
                    }
                    // add new item to cart
                    if (!isExits) {
                        cartItems.add(new CartItem(product, 1));
                    }
                }
            }

            request.setAttribute("totalPrice", totalPrice);
            request.setAttribute("totalAmount", productList.size());
            request.setAttribute("cartItems", cartItems);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/cart.jsp");
            dispatcher.forward(request, response);
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
