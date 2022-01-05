package pttk.controller;

import pttk.logic.application.bookDAO.ItemBookDAO;
import pttk.logic.application.bookDAO.impl.ItemBookDAOImpl;
import pttk.model.book.ItemBook;

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

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<ItemBook> listItemBook = itemBookDAO.findAll();
            request.setAttribute("listItemBook", listItemBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/home.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
