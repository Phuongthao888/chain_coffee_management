<%@ page import="java.util.List" %>
<%@ page import="Model.HoaDon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lịch sử hóa đơn</title>
    <style>
        /* Thêm CSS tùy chỉnh cho trang */
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Các tập tin CSS khác nếu cần -->
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Left column for navigation -->
        <div class="col-md-3">
            <!-- Thêm các liên kết điều hướng nếu cần -->
        </div>
        <div class="col-md-9">
            <h3>Lịch sử hóa đơn</h3>
            <!-- Hiển thị thông báo lỗi nếu có -->
            <p class="text-danger">${errorString}</p>

            <!-- Danh sách hóa đơn đã qua -->
            <div class="row">
                <%-- Lặp qua danh sách các hóa đơn đã qua --%>
                <c:forEach var="hoaDon" items="${lichSuHoaDon}">
                    <div class="col-md-4">
                        <div class="card mt-3">
                            <div class="card-header">
                                <p class="mb-0"><strong>Ngày tạo hóa đơn:</strong> ${hoaDon.ngayTaoHoaDon}</p><br>
                                Mã hóa đơn: ${hoaDon.maHoaDon}
                            </div>
                            <div class="card-body">
                                <%-- Hiển thị chi tiết các món trong hóa đơn --%>
                                <c:forEach var="mon" items="${hoaDon.danhSachMon}">
                                    <div class="details-row">
                                        <div class="row">
                                            <div class="col-6"><strong>Tên món:</strong></div>
                                            <div class="col-6">${mon.tenMon}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-6"><strong>Đơn giá x Số lượng</strong></div>
                                            <div class="col-6">${mon.donGia} x ${mon.soLuong}</div>
                                        </div>
                                    </div>
                                </c:forEach>
                                <%-- Hiển thị tổng hóa đơn --%>
                                <div class="details-row">
                                    <div class="row">
                                        <div class="col-6"><strong>Tổng Hóa Đơn:</strong></div>
                                        <div class="col-6">${hoaDon.tongBill} VND</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
