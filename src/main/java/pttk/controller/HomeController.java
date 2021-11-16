package pttk.controller;

import pttk.entity.book.ItemBook;
import pttk.entity.clothes.ItemClothes;
import pttk.service.ItemBookService;
import pttk.service.ItemClothesService;
import pttk.service.impl.ItemBookServiceImpl;
import pttk.service.impl.ItemClothesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final ItemClothesService itemClothesService = new ItemClothesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<ItemBook> listItemBook = itemBookService.findAll();
            request.setAttribute("listItemBook", listItemBook);
            List<ItemClothes> listItemClothes = itemClothesService.findAllItemClothes();
            request.setAttribute("listItemClothes", listItemClothes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home.jsp");
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
