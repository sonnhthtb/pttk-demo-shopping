package vn.grooo.controller;

import vn.grooo.constant.SystemConstant;
import vn.grooo.entity.Category;
import vn.grooo.entity.Product;
import vn.grooo.service.CategoryService;
import vn.grooo.service.ProductService;
import vn.grooo.service.impl.CategoryServiceImpl;
import vn.grooo.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCartController extends HttpServlet {

    private final CategoryService categoryService = new CategoryServiceImpl();

    private final ProductService productService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String cookieCartValue = "";
            Cookie[] cookies = request.getCookies();

            //get cookie to add item to cart
            for (Cookie cookie : cookies) {
                //get cookie cart value and delete cookie cart
                if (cookie.getName().equals("cart")) {
                    cookieCartValue = cookieCartValue + cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

            String id = request.getParameter("id");
            int quantity = 0;
            try {
                quantity = Integer.parseInt(request.getParameter("quantity"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            //check product id is correct
            if (productService.findById(Long.parseLong(id)) != null) {

                // add id of product to cookie cart
                for (int i = 0; i < quantity; i++) {

                    if (cookieCartValue.isEmpty()) {
                        cookieCartValue = id;
                    } else {
                        cookieCartValue = cookieCartValue + "/" + id;
                    }
                }
            } else {
                response.sendRedirect("/cart");
            }

            //reset cookie cart
            Cookie cookieCart = new Cookie("cart", cookieCartValue);
            cookieCart.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
            response.addCookie(cookieCart);
            response.sendRedirect("/cart");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
