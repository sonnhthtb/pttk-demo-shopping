<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Account</title>
    <link href="<c:url value='../../template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='../../template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
    <jsp:include page="../../common/web/header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col mt-5" style="text-align: center"><h2>Thông tin tài khoản</h2> </div>
            <div class="col-lg-12 mt-5 mb-3">
                <div class="row justify-content-center">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                </div>
                <div class="row justify-content-center">
                    <p name="username"></p>
                    <form action="<c:url value='/my-account'/>" id="formLogin" method="post">
                         <div class="form-group d-flex align-items-center justify-content-around">
                            <input type="text" class="form-control mr-2" id="fullName" name="first-name"
                                   placeholder="Họ " value='<%=request.getParameter("first-name")%>'>
                            <input type="text" class="form-control mr-2" id="fullName" name="middle-name"
                                   placeholder="Tên đệm">
                            <input type="text" class="form-control" id="fullName" name="last-name"
                                   placeholder="Tên *">
                        </div>
                         <div class="form-group">
                            <input type="text" class="form-control" id="password" name="nation"
                                   placeholder="Quốc gia" >
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="password" name="city"
                                   placeholder="Thành phố " >
                        </div>
                         <div class="form-group d-flex align-items-center justify-content-around">
                            <input type="text" class="form-control mr-2" id="fullName" name="district"
                                   placeholder="Quận ">
                            <input type="text" class="form-control mr-2" id="fullName" name="street"
                                   placeholder="Đường">
                            <input type="text" class="form-control" id="fullName" name="number-house"
                                   placeholder="Số nhà">
                        </div>
                        <div class="d-flex algin-items-center justify-content-between">
                            <button type="submit" class="btn btn-danger" ><a href="/home" style="color:white; text-decoration: none">Hủy bỏ</a></button>
                            <button type="submit" class="btn btn-primary" >Chấp nhận</button>
                            
                        </div>
                    </form>
                </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.col-lg-9 -->

        </div>
    </div>
    <jsp:include page="../../common/web/footer.jsp"/>
<!-- /.row -->
    <script type="text/javascript" src="<c:url value='../../template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='../../template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>
