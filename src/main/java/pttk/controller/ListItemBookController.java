package pttk.controller;

import pttk.model.book.ItemBook;
import pttk.service.ItemBookService;
import pttk.service.impl.ItemBookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/list-itemBook"})
public class ListItemBookController extends HttpServlet {
    private final ItemBookService itemBookService = new ItemBookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try {

                try {
                    List<ItemBook> listItemBook = itemBookService.findAll();
                    request.setAttribute("listItemBook", listItemBook);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/listItemBook.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    String view = "views/web/home.jsp";
                    response.sendRedirect(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}