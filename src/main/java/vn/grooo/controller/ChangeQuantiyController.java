package vn.grooo.controller;

import vn.grooo.constant.SystemConstant;
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

@WebServlet(urlPatterns = {"/change-quantity"})
public class ChangeQuantiyController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = request.getParameter("action");
            String id = request.getParameter("id");
            Cookie[] cookies = request.getCookies();
            String cookieValue = "";

            // increase quantity of item in cart
            if (action.equals("inc")) {
                cookieValue = id;

                // add id of item to cookie cart
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cart")) {
                        cookieValue = cookie.getValue() + "/" + cookieValue;
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }

                Cookie cookieCart = new Cookie("cart", cookieValue);
                cookieCart.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(cookieCart);
            }
            //decrease quantity of item in cart
            else if (action.equals("dec")) {
                int index = -1;

                //remove last id of item from cookie cart
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cart")) {
                        String[] ids = cookie.getValue().split("/");

                        //find last index of id
                        for (int i = ids.length - 1; i >= 0; i--) {
                            if (id.equals(ids[i])) {
                                index = i;
                                break;
                            }
                        }

                        // create a new cookie cart when remove a id
                        for (int i = 0; i < ids.length; i++) {
                            if (i == index) {
                                continue;
                            }
                            if (cookieValue.isEmpty()) {
                                cookieValue += ids[i];
                            } else {
                                cookieValue = cookieValue + "/" + ids[i];
                            }
                        }
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }

                Cookie cookieCart = new Cookie("cart", cookieValue);
                cookieCart.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
                response.addCookie(cookieCart);
            }
            // delete item from cart
            else if (action.equals("del")) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cart")) {
                        String[] ids = cookie.getValue().split("/");
                        // create a new cookie cart to without id
                        for (int i = ids.length - 1; i >= 0; i--) {
                            if (!id.equals(ids[i])) {
                                if (cookieValue.isEmpty()) {
                                    cookieValue += ids[i];
                                } else {
                                    cookieValue = cookieValue + "/" + ids[i];
                                }
                            }
                        }
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }


                Cookie cookieCart = new Cookie("cart", cookieValue);
                cookieCart.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
                response.addCookie(cookieCart);
            }
            response.sendRedirect("/cart");
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
