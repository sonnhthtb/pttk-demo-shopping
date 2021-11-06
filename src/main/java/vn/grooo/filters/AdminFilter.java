package vn.grooo.filters;

import vn.grooo.entity.UserEntity;
import vn.grooo.service.UserService;
import vn.grooo.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin", "/admin-home.jsp", "/admin-product","/list-product.jsp"})
public class AdminFilter implements Filter{

    private ServletContext context;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        UserEntity model = (UserEntity) session.getAttribute("user");
        if (model != null) {
            if(model.getRole().equals("ADMIN")){
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                response.sendRedirect(request.getContextPath()+"/home");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/home");
        }
    }

    @Override
    public void destroy() {

    }
}