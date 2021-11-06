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
import java.util.Arrays;
import java.util.List;

@WebServlet("/admin-product")
public class AdminProductController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String view = "views/admin/admin-home.jsp";
        try {
            //show list product
            if (type.equals("list")) {
                view = "views/admin/product/list-product.jsp";
                int totalItem = productService.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<Product> productList = productService.findAll(offset, maxPageItem);

                request.setAttribute("productList", productList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
            }
            //show edit product
            else if (type.equals("edit")) {
                String id = request.getParameter("id");
                if (id != null) {
                    Product product = productService.findById(Long.parseLong(id));
                    request.setAttribute("product", product);
                }
                request.setAttribute("categories", categoryService.findAll());
                view = "views/admin/product/edit-product.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String view = "views/admin/product/edit-product.jsp";

        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String image = request.getParameter("image");
            String price = request.getParameter("price");
            String description = request.getParameter("description");
            String categoryId = request.getParameter("category");
            // validate input
            if (name.isEmpty() || image.isEmpty() || price.isEmpty() || description.isEmpty()) {
                request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                request.setAttribute("alert", "danger");
            } else {
                Product product = new Product();
                product.setName(name);
                product.setImage(image);
                try {
                    Long categoryid = Long.parseLong(categoryId);
                    product.setCategory(categoryService.findById(categoryid));
                    product.setPrice(Float.parseFloat(price));
                    product.setDescription(description);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // update product if find id
                if (!id.isEmpty() && id != null) {
                    product.setId(Long.parseLong(id));
                    product = productService.update(product);
                    request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công");
                    request.setAttribute("alert", "success");
                    request.setAttribute("categories", categoryService.findAll());
                }
                //create product if not find id
                else {
                    product = productService.save(product);
                    request.setAttribute("messageResponse", "Thêm sản phẩm thành công");
                    request.setAttribute("alert", "success");
                    List<Category> categories = categoryService.findAll();
                    request.setAttribute("categories", categories);
                    request.setAttribute("id", product.getId());
                }
                request.setAttribute("product", product);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

}
