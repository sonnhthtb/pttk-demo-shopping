package pttk.controller;

import pttk.logic.application.bookDAO.BookDAO;
import pttk.logic.application.bookDAO.impl.BookDAOImpl;
import pttk.model.book.Author;
import pttk.model.book.Book;
import pttk.model.book.Publisher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-book", "/admin-delete-book"})
public class AdminBookController extends HttpServlet {

    private final BookDAO bookDAO = new BookDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println("pttk.controller.AdminBookController.doGet()---" + type);
        String view = "views/admin/admin-book.jsp";
        try {
            //show list product
            if (type.equals("list")) {
                view = "views/admin/book/list-book.jsp";
                int totalItem = bookDAO.getCount();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<Book> bookList = bookDAO.findAll(maxPageItem, offset);

                request.setAttribute("bookList", bookList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
            }
            //show edit product
            else if (type.equals("edit")) {
                String id = request.getParameter("id");
                if (id != null) {
                    Book book = bookDAO.findById(Integer.parseInt(id));
                    request.setAttribute("book", book);
                }
                view = "views/admin/book/edit-book.jsp";
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
        if (serveletPath.equals("/admin-book")) {
            try {
                String view = "views/admin/book/edit-book.jsp";
                String id = request.getParameter("id");
                String title = request.getParameter("title");
                String price = request.getParameter("price");
                String type = request.getParameter("type");
                String quantity = request.getParameter("quantity");
                String language = request.getParameter("language");
                String pageNumber = request.getParameter("pageNumber");
                String publisherName = request.getParameter("publisherName");
                String publisherAddress = request.getParameter("publisherAddress");
                String authorName = request.getParameter("authorName");
                String authorBiography = request.getParameter("authorBiography");
                String authorNation = request.getParameter("authorNation");
                String description = request.getParameter("description");
                // validate input
                if (title.isEmpty() || language.isEmpty() || price.isEmpty() ||
                        type.isEmpty() || quantity.isEmpty() || pageNumber.isEmpty() || publisherName.isEmpty() ||
                        authorName.isEmpty() || description.isEmpty()) {
                    request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                    request.setAttribute("alert", "danger");
                } else {
                    Book book = new Book();
                    // update product if find id
                    if (!id.isEmpty() && id != null) {
                        book = bookDAO.findById(Integer.parseInt(id));
                        book.setTitle(title);
                        book.setPrice(Integer.parseInt(price));
                        book.setType(type);
                        book.setQuantity(Integer.parseInt(quantity));
                        book.setLanguage(language);
                        book.setPageNumber(Integer.parseInt(pageNumber));
                        book.setDescription(description);
                        Publisher publisher = new Publisher();
                        publisher.setId(book.getPublisher().getId());
                        publisher.setName(publisherName);
                        publisher.setAddress(publisherAddress);
                        book.setPublisher(publisher);
                        Author author = new Author();
                        author.setId(book.getAuthor().getId());
                        author.setName(authorName);
                        author.setBiography(authorBiography);
                        author.setNation(authorNation);
                        book.setAuthor(author);
                        book.setDescription(description);

                        bookDAO.update(book);
                        request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công");
                        request.setAttribute("alert", "success");
                    }
                    //create product if not find id
                    else {
                        book.setTitle(title);
                        book.setPrice(Integer.parseInt(price));
                        book.setType(type);
                        book.setQuantity(Integer.parseInt(quantity));
                        book.setLanguage(language);
                        book.setPageNumber(Integer.parseInt(pageNumber));
                        book.setDescription(description);
                        Publisher publisher = new Publisher();
                        publisher.setName(publisherName);
                        publisher.setAddress(publisherAddress);
                        book.setPublisher(publisher);
                        Author author = new Author();
                        author.setName(authorName);
                        author.setBiography(authorBiography);
                        author.setNation(authorNation);
                        book.setAuthor(author);
                        book.setDescription(description);
                        bookDAO.save(book);
                        request.setAttribute("messageResponse", "Thêm sản phẩm thành công");
                        request.setAttribute("alert", "success");
                        request.setAttribute("id", book.getId());
                    }
                    request.setAttribute("book", book);
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
                    bookDAO.delete(Integer.parseInt(id));
                }
                String view = "views/admin/book/list-book.jsp";
                request.setAttribute("messageResponse", "Xoá thành công");
                request.setAttribute("alert", "success");

                int totalItem = bookDAO.getCount();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<Book> bookList = bookDAO.findAll(maxPageItem, offset);

                request.setAttribute("bookList", bookList);
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
