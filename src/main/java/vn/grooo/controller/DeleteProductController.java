package vn.grooo.controller;

import vn.grooo.entity.Product;
import vn.grooo.service.ProductService;
import vn.grooo.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/delete-product"})
public class DeleteProductController extends HttpServlet {


    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String[] ids = request.getParameterValues("checkbox");
            productService.delete(ids);
            String view = "views/admin/product/list-product.jsp";
            request.setAttribute("messageResponse", "Xoá thành công");
            request.setAttribute("alert", "success");

            //paging data
            int totalItem = productService.getTotalItem();

            // number of item in a page
            int maxPageItem = 6;
            int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
            int currentPage = 1;
            //check if request have any currentPage param
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }

            int offset = (currentPage - 1) * maxPageItem;

            List<Product> productList = productService.findAll(offset, maxPageItem);

            request.setAttribute("productList", productList);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("currentPage", currentPage);
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
