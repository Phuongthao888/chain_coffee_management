<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cập nhật thông tin khách hàng</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h3 class="mt-4">Cập nhật thông tin khách hàng</h3>
        <form method="post" action="UpdateKhachHangServlet">
            <div class="form-group">
                <label for="tenKhachHang">Tên khách hàng</label>
                <input type="text" class="form-control" id="tenKhachHang" name="TenKhachHang" value="${khachHang.tenKhachHang}" >
            </div>
            <div class="form-group">
                <label for="soLanThanhToan">Số lần thanh toán</label>
                <input type="text" class="form-control" id="soLanThanhToan" name="SoLanThanhToan" value="${khachHang.soLanThanhToan}" >
            </div>
            <div class="form-group">
                <label for="sdt">Số điện thoại</label>
                <input type="text" class="form-control" id="sdt" name="SDT" value="${khachHang.SDT}" >
            </div>
            <div class="form-group">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" class="form-control" id="diaChi" name="DiaChi" value="${khachHang.diaChi}" >
            </div>
            <input type="hidden" name="IDKhachHang" value="${khachHang.IDKhachHang}">
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies (if needed) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
