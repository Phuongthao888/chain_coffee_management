<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <title>Sign In</title>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h1 class="text-center">Sign In</h1>
                    </div>
                    <div class="card-body">
                        <form method="POST" action="SignupServlet">
                            <div class="form-group">
                                <label for="username">User Name:</label>
                                <input type="text" class="form-control" id="username" name="username">
                            </div>
                            <div class="form-group">
                                <label for="password">Pass Word:</label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>

                            <!-- Thêm các trường thông tin từ nhanvien.jsp -->
                            <div class="form-group">
                                <label for="TenNhanVien">Tên nhân viên:</label>
                                <input type="text" class="form-control" id="TenNhanVien" name="TenNhanVien">
                            </div>
                            <div class="form-group">
                                <label for="NgaySinh">Ngày sinh:</label>
                                <input type="date" class="form-control" id="NgaySinh" name="NgaySinh">
                            </div>
                            <div class="form-group">
                                <label for="SDT">Số điện thoại:</label>
                                <input type="text" class="form-control" id="SDT" name="SDT">
                            </div>
                            <div class="form-group">
                                <label for="User">User:</label>
                                <input type="text" class="form-control" id="User" name="User">
                            </div>
                            <div class="form-group">
                                <label for="ChucVu">Chức vụ:</label>
                                <input type="text" class="form-control" id="ChucVu" name="ChucVu">
                            </div>
                            <!-- Kết thúc phần thêm trường thông tin -->

                            <button type="submit" class="btn btn-primary">Submit</button>
                            <input type="reset" class="btn btn-secondary">
                        </form>
                    </div>
                </div>
                <div class="mt-3">
                    <h4>Thông tin đăng ký của bạn</h4>
                    <h5>${username}</h5>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
