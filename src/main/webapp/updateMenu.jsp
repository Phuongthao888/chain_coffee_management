<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cập nhật món nước</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h3 class="mt-4">Cập nhật món nước</h3>
        <form method="post" action="UpdateMenuServlet">
            <div class="form-group">
                <label for="TenMon">Tên món</label>
                <input type="text" class="form-control" id="TenMon" name="TenMon" value="${menu.tenMon}">
            </div>
            <div class="form-group">
                <label for="MoTaMon">Mô tả món</label>
                <input type="text" class="form-control" id="MoTaMon" name="MoTaMon" value="${menu.moTaMon}">
            </div>
            <div class="form-group">
                <label for="GiaTien">Giá tiền</label>
                <input type="text" class="form-control" id="GiaTien" name="GiaTien" value="${menu.giaTien}">
            </div>
            <div class="form-group">
                <label for="HinhAnh">Hình ảnh</label>
                <input type="text" class="form-control" id="HinhAnh" name="HinhAnh" value="${menu.hinhAnh}">
            </div>
            <div class="form-group">
                <label for="NguyenLieuCanThiet">Nguyên liệu cần thiết</label>
                <input type="text" class="form-control" id="NguyenLieuCanThiet" name="NguyenLieuCanThiet" value="${menu.nguyenLieuCanThiet}">
            </div>
            <input type="hidden" name="maMon" value="${menu.maMon}" />
            <button type="submit" class="btn btn-primary">Cập nhật món nước</button>
        </form>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>