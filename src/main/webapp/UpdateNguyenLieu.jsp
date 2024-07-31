<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cập nhật nguyên liệu</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Cập nhật nguyên liệu</h2>

        <form method="post" action="${pageContext.request.contextPath}/UpdateNguyenLieuServlet">
            <div class="form-group">
                <label for="IDNguyenLieu">ID Nguyên Liệu</label>
                <input type="text" class="form-control" id="IDNguyenLieu" name="IDNguyenLieu" value="${nguyenLieu.IDNguyenLieu}" readonly>
            </div>
            <div class="form-group">
                <label for="TenNguyenLieu">Tên nguyên liệu</label>
                <input type="text" class="form-control" id="TenNguyenLieu" name="TenNguyenLieu" value="${nguyenLieu.tenNguyenLieu}" required>
            </div>
            <div class="form-group">
                <label for="SoLuongNhap">Số lượng nhập</label>
                <input type="number" class="form-control" id="SoLuongNhap" name="SoLuongNhap" value="${nguyenLieu.soLuongNhap}" required>
            </div>
            <div class="form-group">
                <label for="DonGiaNhap">Đơn giá nhập</label>
                <input type="text" class="form-control" id="DonGiaNhap" name="DonGiaNhap" value="${nguyenLieu.donGiaNhap}" required>
            </div>
            <div class="form-group">
                <label for="NgayNhap">Ngày nhập</label>
                <input type="date" class="form-control" id="NgayNhap" name="NgayNhap" value="${nguyenLieu.ngayNhap}" required>
            </div>
            <!-- Các trường và thuộc tính khác cần thiết -->

            <button type="submit" class="btn btn-primary">Cập nhật nguyên liệu</button>
        </form>

        <a href="${pageContext.request.contextPath}/NguyenLieuServlet" class="btn btn-secondary mt-3">Quay lại danh sách nguyên liệu</a>
    </div>
</body>
</html>
