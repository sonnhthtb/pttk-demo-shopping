package pttk.controller;

import pttk.model.clothes.ItemClothes;
import pttk.model.electronic.ItemElectronic;
import pttk.service.ItemElectronicService;
import pttk.service.impl.ItemElectronicServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/list-itemElectronic"})
public class ListItemElectronicController extends HttpServlet {
    private final ItemElectronicService itemElectronicService = new ItemElectronicServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            try {

                try {
                    List<ItemElectronic> listItemElectronic = itemElectronicService.findAll();
                    request.setAttribute("listItemElectronic", listItemElectronic);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/listItemElectronic.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    String view = "views/web/home.jsp";
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