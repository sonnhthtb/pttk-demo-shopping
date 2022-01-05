package pttk.controller;

import pttk.logic.application.bookDAO.BookDAO;
import pttk.logic.application.bookDAO.ItemBookDAO;
import pttk.logic.application.bookDAO.impl.BookDAOImpl;
import pttk.logic.application.bookDAO.impl.ItemBookDAOImpl;
import pttk.model.book.Book;
import pttk.model.book.ItemBook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-book-item", "/admin-delete-book-item"})
public class AdminItemBookController extends HttpServlet {

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();
    private final BookDAO bookDAO = new BookDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println("pttk.controller.AdminBookController.doGet()---" + type);
        String view = "views/admin/admin-book.jsp";
        try {
            //show list product
            if (type.equals("list")) {
                view = "views/admin/product/list-product.jsp";
                int totalItem = itemBookDAO.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<ItemBook> itemBookList = itemBookDAO.findAll(maxPageItem, offset);

                request.setAttribute("itemBookList", itemBookList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
            }
            //show edit product
            else if (type.equals("edit")) {
                String id = request.getParameter("id");
                if (id != null) {
                    ItemBook itemBook = itemBookDAO.findById(Integer.parseInt(id));
                    request.setAttribute("itemBook", itemBook);
                }
                List<Book> listBook = bookDAO.findAll();
                request.setAttribute("listBook", listBook);
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
        String serveletPath = request.getServletPath();
        if (serveletPath.equals("/admin-book-item")) {
            try {
                String view = "views/admin/product/edit-product.jsp";
                String id = request.getParameter("id");
                String price = request.getParameter("price");
                String imageUrl = request.getParameter("imageUrl");
                String barcode = request.getParameter("barcode");
                if (imageUrl.isEmpty() || barcode.isEmpty() || price.isEmpty()) {
                    request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                    request.setAttribute("alert", "danger");
                } else {
                    ItemBook itemBook = new ItemBook();
                    // update product if find id
                    if (!id.isEmpty() && id != null) {
                        itemBook = itemBookDAO.findById(Integer.parseInt(id));
                        itemBook.setPrice(Integer.parseInt(price));
                        itemBook.setImageUrl(imageUrl);
                        itemBook.setBarcode(barcode);
                        itemBook = itemBookDAO.update(itemBook);
                        request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công");
                        request.setAttribute("alert", "success");
                    }
                    //create product if not find id
                    else {
                        String bookId = request.getParameter("bookId");
                        Book book = new Book();
                        if (bookId != null && !bookId.isEmpty())
                            book = bookDAO.findById(Integer.parseInt(bookId));

                        if (itemBookDAO.findByBookId(Integer.parseInt(bookId)) != null) {
                            request.setAttribute("messageResponse", "Sách bạn chọn đang được trưng bày");
                            request.setAttribute("alert", "danger");
                        } else {
                            itemBook.setPrice(Integer.parseInt(price));
                            itemBook.setImageUrl(imageUrl);
                            itemBook.setBarcode(barcode);
                            itemBook.setBook(book);
                            itemBook = itemBookDAO.save(itemBook);
                            request.setAttribute("messageResponse", "Thêm sản phẩm thành công");
                            request.setAttribute("alert", "success");
                            request.setAttribute("id", itemBook.getId());
                        }
                    }
                    request.setAttribute("itemBook", itemBook);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        } else {
            try {
                String[] ids = request.getParameterValues("checkbox");
                for (String id : ids) {
                    itemBookDAO.delete(Integer.parseInt(id));
                }
                String view = "views/admin/product/list-product.jsp";
                request.setAttribute("messageResponse", "Xoá thành công");
                request.setAttribute("alert", "success");

                int totalItem = itemBookDAO.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<ItemBook> itemBookList = itemBookDAO.findAll(maxPageItem, offset);

                request.setAttribute("itemBookList", itemBookList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        }
    }

}
