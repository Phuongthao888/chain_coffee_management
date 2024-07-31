<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm tiêu đề</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<style>
.custom-small-input {
	font-size: 12px; /* Điều chỉnh kích thước phù hợp */
	padding: 0.25rem 0.5rem; /* Điều chỉnh khoảng cách nếu cần */
}
</style>
</head>
<body>
<div class="row">
    <div class="col-md-2">
        <div class="list-group mt-5">
            <a href="index.jsp" class="list-group-item list-group-item-action active">Trang Chủ</a>
            <a href="MenuServlet" class="list-group-item list-group-item-action">Quản lý món nước</a> 
            <a href="HoaDonServlet" class="list-group-item list-group-item-action">Quản lý hóa đơn</a>
            <a href="NhanVienServlet" class="list-group-item list-group-item-action">Quản lý nhân viên</a> 
            <a href="KhachHangServlet" class="list-group-item list-group-item-action">Thông Tin Khách Hàng</a> 
            <a href="NguyenLieuServlet" class="list-group-item list-group-item-action">Quản lý Nguyên Liệu</a> 
            <a href="showadminblog" class="list-group-item list-group-item-action">Quản lý Blog</a>
        </div>
    </div>
    <div class="col-md-10">
        <div class="col-md-12">
        <div class="col">
	    	<nav class="navbar navbar-expand-lg bg-light">
			    <div class="container-fluid">
			       <div class="collapse navbar-collapse" id="navbarSupportedContent">
			           <form class="d-flex ml-auto" role="search" action="${pageContext.request.contextPath}/searchblog" method="post">
			               <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="title">
			               <button class="btn btn-outline-success" type="submit">Tìm</button>
			           </form>
			       </div>
			   </div>
			</nav>
	    </div>
            <table class="table table-striped">
                <tr>
                    <th>Tiêu đề</th>
                    <th>Mô tả</th>
                    <th>Hình ảnh</th>
                    <th>Hành động</th>
                </tr>
                <c:forEach items="${blL}" var="x">
                    <tr>
                        <td>${x.title}</td>
                        <td>${x.description}</td>
                        <td>${x.imgurl}</td>
                        <td>
                        	<a href="${pageContext.request.contextPath}/updatebl?id=${x.id}" class="edit-icon" style="color:black; text-decoration:none;">
							  <i class="fas fa-edit"></i> Sửa
							</a>
							<a href="${pageContext.request.contextPath}/deletebl?id=${x.id}" class="delete-icon" style="color:black; text-decoration:none;">
							  <i class="fas fa-trash-alt"></i> Xóa
							</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="blog/add.jsp" class="btn btn-outline-secondary"
		role="button"><i class="fas fa-plus"></i> Thêm</a>
	<a href="index.jsp" class="btn btn-outline-secondary"><i
		class="fas fa-arrow-left"></i> Quay lại</a>
        </div>
    </div>
</div>

	
</body>
</html>