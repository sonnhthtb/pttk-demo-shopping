package pttk.controller;


import pttk.constant.SystemConstant;
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

@WebServlet(urlPatterns = {"/search-product"})
public class SearchProductController extends HttpServlet {

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            List<ItemBook> listItemBook = itemBookDAO.findByName(name);
            int totalItem = 1;

            // number of item in a page
            int totalPage = (int) Math.ceil((double) totalItem / SystemConstant.DEFAULT_MAX_ITEM_IN_PAGE);
            int currentPage = 1;
            //check if request have any currentPage param
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
            if (currentPage <= 0 || (currentPage > totalPage && totalPage != 0)) {
                response.sendRedirect("/error");
            } else {
                int offset = (currentPage - 1) * SystemConstant.DEFAULT_MAX_ITEM_IN_PAGE;

                request.setAttribute("listItemBook", listItemBook);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);

                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home.jsp");
                dispatcher.forward(request, response);
            }
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
