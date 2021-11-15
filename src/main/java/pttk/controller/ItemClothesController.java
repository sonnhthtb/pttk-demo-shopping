package pttk.controller;

import pttk.entity.ItemBook;
import pttk.entity.ItemClothes;
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

@WebServlet(urlPatterns = {"/itemClothes"})
public class ItemClothesController extends HttpServlet {
    private final ItemClothesService itemClothesService = new ItemClothesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           try {
               String id = request.getParameter("id");
               try {
                   ItemClothes itemClothes = itemClothesService.findClothesById(Integer.parseInt(id));
                   request.setAttribute("itemClothes", itemClothes);
                   RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/detailItemClothes.jsp");
                   dispatcher.forward(request, response);
               } catch (Exception e) {
                   e.printStackTrace();
                   String view = "views/web/itemClothes.jsp";
                   response.sendRedirect(view);
               }
           }catch (Exception e) {
               e.printStackTrace();
               response.sendRedirect("/error");
           }
       }catch(Exception e){
           System.out.println(e);
       }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}