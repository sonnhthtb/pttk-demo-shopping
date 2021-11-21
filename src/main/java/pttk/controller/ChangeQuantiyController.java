package pttk.controller;

import pttk.constant.SystemConstant;
import pttk.service.LineItemBookService;
import pttk.service.LineItemClothesService;
import pttk.service.impl.LineItemClothesServiceImpl;
import pttk.service.impl.LineItenBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/change-quantity"})
public class ChangeQuantiyController extends HttpServlet {

    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final LineItemClothesService lineItemClothesService = new LineItemClothesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            String type = request.getParameter("type");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            // increase quantity of item in cart
            if (action.equals("inc")) {
                quantity++;
                switch (type) {
                    case "book" :
                        lineItemBookService.updateQuantity(quantity, id);
                    case "clothes" :
                        lineItemClothesService.updateQuantity(quantity,id);
                }
            }
            //decrease quantity of item in cart
            else if (action.equals("dec")) {
                quantity--;
                switch (type) {
                    case "book" :
                        lineItemBookService.updateQuantity(quantity, id);
                    case "clothes" :
                        lineItemClothesService.updateQuantity(quantity,id);
                }
            }
            // delete item from cart
            else if (action.equals("del")) {
                switch (type) {
                    case "book" :
                    case "clothes" :
                }
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
