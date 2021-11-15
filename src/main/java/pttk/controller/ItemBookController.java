package pttk.controller;

import pttk.entity.Book;
import pttk.entity.ItemBook;
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
import java.util.Locale;

@WebServlet(urlPatterns = {"/itemBook"})
public class ItemBookController extends HttpServlet {

    private final ItemBookService itemBookService = new ItemBookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            try {
                String id = request.getParameter("id");
                try {
                    ItemBook itemBook = itemBookService.findById(Integer.parseInt(id));
                    request.setAttribute("itemBook", itemBook);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/book-detail.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("/home");
                }
            }catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
