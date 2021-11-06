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

import static vn.grooo.constant.SystemConstant.DEFAULT_MAX_ITEM_IN_PAGE;

@WebServlet(urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");
        try {
            int totalItem = productService.getTotalItemByCategoryId(id);

            // number of item in a page
            int totalPage = (int) Math.ceil((double) totalItem / DEFAULT_MAX_ITEM_IN_PAGE);
            int currentPage = 1;
            //check if request have any currentPage param
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }

            int offset = (currentPage - 1) * DEFAULT_MAX_ITEM_IN_PAGE;

            List<Product> productList = productService.findByCategoryId(id,offset,DEFAULT_MAX_ITEM_IN_PAGE );
            List<Category> categories = categoryService.findAll();

            request.setAttribute("totalPage", totalPage);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("categories", categories);
            request.setAttribute("productList", productList);
            request.setAttribute("id", id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/product-in-category.jsp");
            dispatcher.forward(request, response);
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
