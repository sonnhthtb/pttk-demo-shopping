<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
    <link href="<c:url value='../template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="<c:url value='../template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='../template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
    <link href="<c:url value='../template/login/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body id="LoginForm" style="margin-top: 56px;">
<jsp:include page="../common/login/header.jsp"/>
<div class="container" style="min-height: 900px; margin-top: 56px;">
    <h1 class="form-heading">Đăng Ký</h1>
    <div class="login-form">
        <div class="main-div">
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                        ${message}
                </div>
            </c:if>
            <form action="<c:url value='/sign-up'/>" id="formLogin" method="post">

                <div class="form-group">
                    <input type="text" class="form-control" id="fullName" name="fullName"
                           placeholder="Họ và tên *">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="Tên đăng nhập *">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Mật khẩu *">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="re-password" name="re-password"
                           placeholder="Nhập lại mật khẩu *">
                </div>
                <button type="submit" class="btn btn-primary" >Đăng ký</button>
            </form>
            <br>
            <a href="/login">Đăng nhập</a>
        </div>
    </div>
</div>
</body>
</html>
