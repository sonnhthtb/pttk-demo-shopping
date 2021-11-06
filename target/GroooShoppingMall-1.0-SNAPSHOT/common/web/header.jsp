<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/home">Grooo Shopping Mall</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <div>
            <form class="form-inline" action="/search-product" method="get">
              <input class="form-control mr-sm-2" style="width: 400px; margin-left: 80px" type="search" placeholder="Search" aria-label="Search" name="name">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
          </div>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href='<c:url value="/cart"/>'>Cart</a>
            </li>
            <c:if test="${not empty user}">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  ${user.fullName}
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="/my-account">Tài khoản của tôi</a>
                  <a class="dropdown-item" href="/list-order">Đơn mua</a>
                  <c:if test="${user.role eq 'ADMIN'}">
                    <a class="dropdown-item" href="/admin">Quản trị viên</a>
                  </c:if>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="/logout">Đăng Xuất</a>
                </div>
              </li>
            </c:if>
            <c:if test="${empty user}">
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/login"/>'>Đăng nhập</a>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
</nav>
