<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add HoaDon</title>
    <!-- Bootstrap CSS or other stylesheets go here -->
    <link rel="stylesheet" href="path/to/bootstrap.min.css">
    <!-- Your custom styles go here -->

    <!-- Bootstrap JS and other scripts go here -->
    <script src="path/to/jquery.min.js"></script>
    <script src="path/to/popper.min.js"></script>
    <script src="path/to/bootstrap.min.js"></script>
    <!-- Your custom scripts go here -->
</head>
<body>
    <div class="container">
        <h2>Add HoaDon</h2>

        <!-- Your form for adding HoaDon goes here -->
        <form action="<c:url value='/AddHoaDonServlet' />" method="post">
            <div class="form-group">
                <label for="maHoaDon">Mã Hóa Đơn:</label>
                <input type="text" class="form-control" id="maHoaDon" name="maHoaDon" required>
            </div>
            <div class="form-group">
                <label for="maMon">Mã Món:</label>
                <input type="text" class="form-control" id="maMon" name="maMon" required>
            </div>
            <div class="form-group">
                <label for="soLuong">Số Lượng:</label>
                <input type="text" class="form-control" id="soLuong" name="soLuong" required>
            </div>
            <div class="form-group">
                <label for="dongia">Đơn Giá:</label>
                <input type="text" class="form-control" id="dongia" name="dongia" required>
            </div>
            <div class="form-group">
                <label for="idKhachHang">ID Khách Hàng:</label>
                <input type="text" class="form-control" id="idKhachHang" name="idKhachHang" required>
            </div>

            <!-- Add other form fields for HoaDon -->

            <!-- Add a submit button to submit the form -->
            <button type="submit" class="btn btn-primary">Thêm HoaDon</button>
        </form>
    </div>
</body>
</html>
