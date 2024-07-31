<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Chi tiết hóa đơn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <style>
        .card {
            border: 1px solid #ccc;
            border-radius: 8px;
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #f8f9fa;
            padding: 10px 15px;
            border-bottom: 1px solid #ccc;
        }
        .card-body {
            padding: 20px;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .total {
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3 class="mt-3">Chi tiết hóa đơn</h3>
            <a href="#" onclick="goBack()" style="color: black; text-decoration: none">
	            <h5>
		            <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
					  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 12H4m12 0-4 4m4-4-4-4m3-4h2a3 3 0 0 1 3 3v10a3 3 0 0 1-3 3h-2"/>
					</svg>
		            Quay lại
	            </h5>
	            
            </a>

			<script>
			    function goBack() {
			        window.history.back();
			    }
			</script>
			            
			            
            <p class="text-danger">${errorString}</p>

            <c:forEach var="hoaDon" items="${hoaDonList}">
                <div class="card">
                    <div class="card-header">
                        <h5 class="mb-0">Mã hóa đơn: ${hoaDon.maHoaDon}</h5>
                        <p class="mb-0"><strong>Ngày tạo hóa đơn:</strong> ${hoaDon.ngayTaoHoaDon}</p>
                        <p class="mb-0"><strong>Tên chi nhánh:</strong> ${hoaDon.tenChiNhanh}</p>
                        <p class="mb-0"><strong>Tên khách hàng:</strong> ${hoaDon.tenKhachHang}</p>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Mã món</th>
                                    <th>Tên món</th>
                                    <th>Đơn giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng đơn giá</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${hoaDon.maMon}</td>
                                    <td>${hoaDon.tenMon}</td>
                                    <td><fmt:formatNumber value="${hoaDon.dongia}" pattern="#,##0"/></td>
                                    <td>${hoaDon.soLuong}</td>
                                    <td><fmt:formatNumber value="${hoaDon.tongBill}" pattern="#,##0"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:forEach>

            <div class="total">
                <h3>Tổng Hóa Đơn:</h3>
                <p>
                    <strong>Tổng Hóa Đơn:</strong>
                    <c:set var="tongTien" value="0" />
                    <c:forEach var="hoaDon" items="${hoaDonList}">
                        <c:set var="tongTien" value="${tongTien + hoaDon.tongBill}" />
                    </c:forEach>
                    <fmt:formatNumber value="${tongTien}" pattern="#,##0"/> VND
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>