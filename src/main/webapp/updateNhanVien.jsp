<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Chỉnh sửa nhân viên</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h3 class="mt-4">Chỉnh sửa thông tin nhân viên</h3>
        <form method="post" action="UpdateNhanVienServlet">
            <div class="form-group">
                <label for="TenNhanVien">Tên nhân viên:</label>
                <input type="text" class="form-control" id="TenNhanVien" name="TenNhanVien" value="${nhanVien.tenNhanVien}">
            </div>
            <div class="form-group">
                <label for="NgaySinh">Ngày sinh:</label>
                <input type="date" class="form-control" id="NgaySinh" name="NgaySinh" value="${nhanVien.ngaySinh}">
            </div>
            <div class="form-group">
                <label for="SDT">Số điện thoại:</label>
                <input type="text" class="form-control" id="SDT" name="SDT" value="${nhanVien.SDT}">
            </div>
            <div class="form-group">
                <label for="User">User:</label>
                <input type="text" class="form-control" id="User" name="User" value="${nhanVien.user}">
            </div>
            <div class="form-group">
                <label for="Password">Password:</label>
                <input type="password" class="form-control" id="Password" name="Password" value="${nhanVien.password}">
            </div>
            <div class="form-group">
                <label for="ChucVu">Chức vụ:</label>
                <input type="text" class="form-control" id="ChucVu" name="ChucVu" value="${nhanVien.chucVu}">
            </div>
            <input type="hidden" name="IDNhanVien" value="${nhanVien.IDNhanVien}" />
            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
        </form>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>