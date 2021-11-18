package pttk.controller;

import pttk.model.book.ItemBook;
import pttk.service.ItemBookService;
import pttk.service.ItemComputerService;
import pttk.service.impl.ItemBookServiceImpl;
import pttk.service.impl.ItemComputerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/detailItemComputer"})
public class ItemComputerController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            try {
                String id = request.getParameter("id");
                try {
//                    ItemBook itemBook = itemBookService.findById(Integer.parseInt(id));
//                    request.setAttribute("itemBook", itemBook);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/bookDetail.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("/list-itemBook");
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
