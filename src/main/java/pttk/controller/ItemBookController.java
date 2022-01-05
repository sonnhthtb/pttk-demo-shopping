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

@WebServlet(urlPatterns = {"/detailItemBook"})
public class ItemBookController extends HttpServlet {

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try {
                String id = request.getParameter("id");
                try {
                    ItemBook itemBook = itemBookDAO.findById(Integer.parseInt(id));
                    request.setAttribute("itemBook", itemBook);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/book-detail.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("/list-itemBook");
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
