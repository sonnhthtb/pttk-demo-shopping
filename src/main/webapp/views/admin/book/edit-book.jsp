<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang quản trị</title>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
    <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
</head>
<body class="no-skin">
    <!-- header -->
    <jsp:include page="../../../common/admin/header.jsp"/>
    <!-- header -->

    <div class="main-container" id="main-container">
        <script type="text/javascript">
            try{ace.settings.check('main-container' , 'fixed')}catch(e){}
        </script>
        <!-- header -->
        <jsp:include page="../../../common/admin/menu.jsp"/>
        <!-- header -->

        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="/admin">Trang chủ</a>
                        </li>
                        <li>
                            <a href="/admin-product?type=list">Danh sách sản phẩm</a>
                        </li>
                    </ul>
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <c:if test="${not empty messageResponse}">
                                <div class="alert alert-${alert}">
                                        ${messageResponse}
                                </div>
                            </c:if>
                            <form id="formSubmit" action="/admin-book" method="post">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Tên sách:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="title" name="title"
                                               value="${book.title}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="type" name="type"
                                               value="${book.type}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Giá</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="price"
                                               name="price" value="${book.price }" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Ngôn ngữ</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="language"
                                               name="language" value="${book.language}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Số lượng</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="quantity"
                                               name="quantity" value="${book.quantity}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Số trang</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="pageNumber"
                                               name="pageNumber" value="${book.pageNumber}" />
                                    </div>
                                </div>
                                <br />

                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Tên Nhà Xuất Bản</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="publisherName"
                                               name="publisherName" value="${book.publisher.name}" />
                                    </div>
                                </div>
                                <br />

                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Địa chỉ NXB:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="publisherAddress"
                                               name="publisherAddress" value="${book.publisher.address}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Tác giả</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="authorName"
                                               name="authorName" value="${book.author.name}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Biography tác giả</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="authorBiography"
                                               name="authorBiography" value="${book.author.biography}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Quốc tịch tác giả</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="authorNation"
                                               name="authorNation" value="${book.author.nation}" />
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Mô tả sản phẩm</label>
                                    <div class="col-sm-9">
                                                <textarea rows="" cols="" id="description" name="description"
                                                          style="width: 820px;height: 175px">${book.description}</textarea>
                                    </div>
                                </div>
                                <br />
                                <br />
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <c:if test="${not empty book.id}">
                                            <button type="submit" class="btn btn-white btn-warning btn-bold"
                                                   id="btnAddOrUpdateNew"> Cập nhật sản phẩm== </button>
                                        </c:if>
                                        <c:if test="${empty book.id}">
                                            <button type="submit" class="btn btn-white btn-warning btn-bold"
                                                    id="btnAddOrUpdateNew"> Thêm sản phẩm </button>
                                        </c:if>
                                    </div>
                                </div>
                                <input type="hidden" value="${book.id}" id="id" name="id" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <jsp:include page="../../../common/admin/footer.jsp"/>
        <!-- footer -->
        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div>
    <script>
        let editor = '';
        $(document).ready(function () {
            editor = CKEDITOR.replace('description');
        });
    </script>

    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

    <script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>
