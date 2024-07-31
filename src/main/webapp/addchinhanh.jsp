<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý chi nhánh</title>
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
            <div class="col-md-3">
                <div class="list-group mt-5">
                    <a href="index.jsp" class="list-group-item list-group-item-action active">Trang Chủ</a>
                    <a href="chinhanhServlet" class="list-group-item list-group-item-action">Quản lý chi nhánh</a>
                     <a href="MenuServlet" class="list-group-item list-group-item-action">Quản lý món nước</a>
                     <a href="HoaDonServlet" class="list-group-item list-group-item-action">Quản lý hóa đơn</a>
                     <a href="NhanVienServlet" class="list-group-item list-group-item-action">Quản lý nhân viên</a>
                    <a href="KhachHangServlet" class="list-group-item list-group-item-action">Thông Tin Khách Hàng</a>
                    <a href="NguyenLieuServlet" class="list-group-item list-group-item-action">Quản lý Nguyên Liệu</a>
                    <a href="${pageContext.request.contextPath}/showadminblog" class="list-group-item list-group-item-action"> Quản lý Blog </a>
                </div>
            </div>

            <!-- Right column for content -->
            <div class="col-md-7">
                <!-- Content goes here -->
                
				<br>
                <h3>Thêm chi nhánh mới</h3>
                <form method="post" action="${pageContext.request.contextPath}/AddChiNhanhServlet">
                    <div class="form-group">
                        <label for="chinhanhID">Mã chi nhánh</label>
                        <input type="number" class="form-control form-control-sm" id="chinhanhID" name="chinhanhID">
                    </div>
                    <div class="form-group">
                        <label for="tenchinhanh">Tên chi nhánh</label>
                        <input type="text" class="form-control form-control-sm" id="tenchinhanh" name="tenchinhanh">
                    </div>
                    <div class="form-group">
                        <label for="diachi">Địa chỉ</label>
                        <input type="text" class="form-control form-control-sm" id="diachi" name="diachi">
                    </div>
                    <div class="form-group">
                        <label for="sdt">Số điện thoại</label>
                        <input type="number" class="form-control form-control-sm" id="sdt" name="sdt">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Thêm chi nhánh</button>
                </form>
            </div>
        </div>
    </div>

    <script>
        function editNhanVien(IDNhanVien) {
            window.location.href = "updateNhanVien.jsp?IDNhanVien=" + IDNhanVien;
        }
    </script>
</body>
</html>
