<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý nguyên liệu</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Left column for navigation -->
            <div class="col-md-2">
                <div id="sidebar"></div>
		        <script>
		            // Sử dụng JavaScript để nhúng nội dung từ một trang HTML
		            fetch('./sidebar.jsp')
		                .then(response => response.text())
		                .then(html => {
		                    document.getElementById('sidebar').innerHTML = html;
		                });
		        </script>
            </div>

            <!-- Right column for content -->
            <div class="col-md-9">
                <!-- Content goes here -->
                <h3>Danh sách nguyên liệu</h3>

                <!-- Biểu mẫu tìm kiếm -->
                <div class="mb-3">
                    <h3>Tìm kiếm nguyên liệu</h3>
                    <form method="get" action="${pageContext.request.contextPath}/SearchNguyenLieuServlet" class="form-inline">
                        <div class="form-group">
                            <label for="searchName" class="sr-only">Tên nguyên liệu:</label>
                            <input type="text" class="form-control" id="searchName" name="searchName" placeholder="Nhập tên nguyên liệu">
                        </div>
                        <button type="submit" class="btn btn-primary ml-2">Tìm kiếm</button>
                    </form>
                </div>

                <!-- Biểu mẫu thêm nguyên liệu -->
                <div class="mb-3">
                    <h3>Thêm nguyên liệu</h3>
                    <form method="post" action="${pageContext.request.contextPath}/AddNguyenLieuServlet" class="form">
                        <div class="form-group">
                            <label for="tenNguyenLieu">Tên Nguyên Liệu:</label>
                            <input type="text" class="form-control" id="tenNguyenLieu" name="TenNguyenLieu" required>
                        </div>
                        <div class="form-group">
                            <label for="soLuongNhap">Số Lượng Nhập:</label>
                            <input type="number" class="form-control" id="soLuongNhap" name="SoLuongNhap" required>
                        </div>
                        <div class="form-group">
                            <label for="donGiaNhap">Đơn Giá Nhập:</label>
                            <input type="number" step="0.01" class="form-control" id="donGiaNhap" name="DonGiaNhap" required>
                        </div>
                        <div class="form-group">
                            <label for="ngayNhap">Ngày Nhập:</label>
                            <input type="date" class="form-control" id="ngayNhap" name="NgayNhap" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm</button>
                    </form>
                </div>

                <!-- Danh sách nguyên liệu -->
                <table class="table table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID Nguyên Liệu</th>
                            <th>Tên Nguyên Liệu</th>
                            <th>Số Lượng Nhập</th>
                            <th>Đơn Giá Nhập</th>
                            <th>Tổng Tiền Nhập</th>
                            <th>Ngày Nhập</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="nguyenLieu" items="${nguyenLieuList}">
                            <tr>
                                <td>${nguyenLieu.IDNguyenLieu}</td>
                                <td>${nguyenLieu.tenNguyenLieu}</td>
                                <td>${nguyenLieu.soLuongNhap}</td>
                                <td>${nguyenLieu.donGiaNhap}</td>
                                <td>${nguyenLieu.tongTienNhap}</td>
                                <td>${nguyenLieu.ngayNhap}</td>
                                <td>
                                    <form method="post" action="${pageContext.request.contextPath}/DeleteNguyenLieuServlet">
                                        <input type="hidden" name="IDNguyenLieu" value="${nguyenLieu.IDNguyenLieu}">
                                        <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                                    </form>
                                    <a href="${pageContext.request.contextPath}/UpdateNguyenLieuServlet?IDNguyenLieu=${nguyenLieu.IDNguyenLieu}" class="btn btn-warning btn-sm">Cập nhật</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <c:if test="${not empty errorString}">
                    <p style="color: red;">${errorString}</p>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
