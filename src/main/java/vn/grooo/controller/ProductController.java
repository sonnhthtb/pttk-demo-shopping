package vn.grooo.controller;

import vn.grooo.entity.Category;
import vn.grooo.entity.Product;
import vn.grooo.service.CategoryService;
import vn.grooo.service.ProductService;
import vn.grooo.service.impl.CategoryServiceImpl;
import vn.grooo.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    private final CategoryService categoryService = new CategoryServiceImpl();

    private final ProductService productService = new ProductServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            try {
                Product product = productService.findById(Long.parseLong(id));
                List<Category> categories = categoryService.findAll();

                request.setAttribute("product", product);
                request.setAttribute("categories", categories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/product-detail.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/home");
            }
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
