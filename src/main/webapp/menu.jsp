<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Quản lý quán cafe</title>

<style>
.select-wrapper {
	position: relative;
}

/* You can adjust the styles below according to your design needs */
.select-wrapper select {
	width: 100%;
	padding: 0.375rem 1.75rem 0.375rem 0.75rem;
	font-size: 1rem;
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: 0.25rem;
	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.select-wrapper select:focus {
	border-color: #80bdff;
	outline: 0;
	box-shadow: 0 0 0 0.25rem rgba(0, 123, 255, 0.25);
}

.form-label {
	margin-bottom: 0.5rem;
	font-weight: bold;
}
.card-text {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3; /* Số dòng muốn hiển thị */
  -webkit-box-orient: vertical;
}

</style>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
	function toggleAddForm() {
		var addForm = document.getElementById("addForm");
		addForm.style.display = (addForm.style.display === "none" || addForm.style.display === "") ? "block"
				: "none";
	}

	function editMenu(maMon) {
		window.location.href = "updateMenu.jsp?maMon=" + maMon;
	}

	function toggleDetails(IDBill) {
		var details = document.getElementById("details_" + IDBill);
		details.classList.toggle("d-none");
	}

	function removeMonField(button) {
		var monField = button.parentNode;
		monField.parentNode.removeChild(monField);
	}

	function confirmDelete(maHoaDon) {
		var r = confirm("Bạn có chắc muốn xóa hóa đơn có mã: " + maHoaDon + "?");
		if (r == true) {
			// Redirect đến Servlet để xử lý xóa
			window.location.href = "DeleteHoaDonServlet?MaHoaDon=" + maHoaDon;
		}
	}

	function printHoaDon(maHoaDon) {
		// Chuyển hướng tới ViewHoaDonServlet với mã hóa đơn
		window.location.href = "viewHoaDonServlet?MaHoaDon=" + maHoaDon;
	}
	// Hàm để tăng giá trị của MaHoaDon và lưu vào sessionStorage
	function increaseMaHoaDon() {
		var currentMaHoaDon = parseInt(document.getElementById('MaHoaDon').value);
		var newMaHoaDon = currentMaHoaDon + 1;
		document.getElementById('MaHoaDon').value = newMaHoaDon;
		// Lưu giá trị mới vào sessionStorage
		sessionStorage.setItem('currentMaHoaDon', newMaHoaDon);
	}
	// Hàm để giảm giá trị của MaHoaDon và lưu vào sessionStorage
	function DecreaseMaHoaDon() {
		var currentMaHoaDon = parseInt(document.getElementById('MaHoaDon').value);
		var newMaHoaDon = currentMaHoaDon - 1;
		document.getElementById('MaHoaDon').value = newMaHoaDon;
		// Lưu giá trị mới vào sessionStorage
		sessionStorage.setItem('currentMaHoaDon', newMaHoaDon);
	}

	// Hàm để kiểm tra xem có giá trị của MaHoaDon được lưu trữ không, nếu có thì đặt lại trường input
	window.onload = function() {
		var storedMaHoaDon = sessionStorage.getItem('currentMaHoaDon');
		if (storedMaHoaDon) {
			document.getElementById('MaHoaDon').value = storedMaHoaDon;
		}
	};
	const menuDescriptionElement = document.getElementById('menuDescription');
	const menuDescriptionText = menuDescriptionElement.textContent;

	if (menuDescriptionText.length > 50) {
	  menuDescriptionElement.textContent = menuDescriptionText.substring(0, 50) + '...';
	}

</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Left column for navigation -->
			<div class="col-md-2 bg-light text-dark">
				
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

			<!-- Center column for content -->
			<div class="col-md-7" style="margin-top: 10px">
				<h3>Danh sách sản phẩm</h3>
				<p class="text-danger">${errorString}</p>

				<form action="<c:url value='/SearchMenuServlet' />" method="get"
					class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" id="searchName"
						name="searchName" placeholder="Search by Name" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				<br>

				<!-- Nút hoặc liên kết để hiện/ẩn form thêm mới -->
				<!-- Button VIEW -->
				<div class="btn btn-info" style="margin-bottom: 20px">
					<a onclick="toggleAddForm()"> <svg
							class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
							xmlns="http://www.w3.org/2000/svg" width="35" height="35"
							fill="none" viewBox="0 0 24 24">
  <path stroke="currentColor" stroke-linecap="round"
								stroke-linejoin="round" stroke-width="2"
								d="M14 17h6m-3 3v-6M4.857 4h4.286c.473 0 .857.384.857.857v4.286a.857.857 0 0 1-.857.857H4.857A.857.857 0 0 1 4 9.143V4.857C4 4.384 4.384 4 4.857 4Zm10 0h4.286c.473 0 .857.384.857.857v4.286a.857.857 0 0 1-.857.857h-4.286A.857.857 0 0 1 14 9.143V4.857c0-.473.384-.857.857-.857Zm-10 10h4.286c.473 0 .857.384.857.857v4.286a.857.857 0 0 1-.857.857H4.857A.857.857 0 0 1 4 19.143v-4.286c0-.473.384-.857.857-.857Z" />
</svg> Thêm
					</a>
				</div>

				<!-- Form thêm mới được ẩn ban đầu -->
                 <div id="addForm" style="display: none;">
                    <h3>Thêm sản phẩm</h3>
                    <form method="post" action="AddMenuServlet">
                        <div class="form-group">
                            <label for="TenMon">Tên món</label>
                            <input type="text" class="form-control form-control-sm" id="TenMon" name="TenMon">
                        </div>
                        <div class="form-group">
                            <label for="MoTaMon">Mô tả món</label>
                            <input type="text" class="form-control form-control-sm" id="MoTaMon" name="MoTaMon">
                        </div>
                        <div class="form-group">
                            <label for="GiaTien">Giá tiền</label>
                            <input type="text" class="form-control form-control-sm" id="GiaTien" name="GiaTien">
                        </div>
                        <div class="form-group">
                            <label for="HinhAnh">Hình ảnh</label>
                            <input type="text" class="form-control form-control-sm" id="HinhAnh" name="HinhAnh">
                        </div>
                        <div class="form-group">
                            <label for="NguyenLieuCanThiet">Nguyên liệu cần thiết</label>
                            <input type="text" class="form-control form-control-sm" id="NguyenLieuCanThiet" name="NguyenLieuCanThiet">
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
                    </form>
                </div>

				<!-- Danh sách món nước -->
				<div class="row">
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<c:forEach items="${menuList}" var="menu" varStatus="status">
						<div class="col-md-4">
							<div class="card mb-4" style="max-height: 470px; min-height: 470px">
								<img src="${menu.hinhAnh}" class="card-img-top"
									alt="${menu.tenMon}"
									style="max-width: 280px; max-height: 200px; min-height: 200px">
								<div class="card-body">
									<h5 class="card-title">${menu.maMon}-${menu.tenMon}</h5>
									<p class="card-text" id="menuDescription">${menu.moTaMon}</p>
									<p class="card-text">Giá: <fmt:formatNumber value="${menu.giaTien}" pattern="#,##0"/> VND</p>
									<p class="card-text">Nguyên liệu:...</p>
									<div class="form-inline" style="margin-left: 50%;  transform: translateX(-50%);">
										<!-- Button VIEW -->
										<a data-toggle="modal"
											data-target="#menuDetailModal${status.index}"> Xem
										</a>

										<!-- Add some spacing -->
										<div style="width: 10px;"></div>

										<!-- Button EDIT -->
										<a
											href="${pageContext.request.contextPath}/UpdateMenuServlet?maMon=${menu.maMon}"
											class="d-inline"> Sửa 
										</a>

										<!-- Add some spacing -->
										<div style="width: 10px;"></div>

										<!-- Button DELETE -->
										<form method="post" action="DeleteMenuServlet"
											class="d-inline">
											<input type="hidden" name="MaMon" value="${menu.maMon}">
											<a href="#"
												onclick="event.preventDefault(); this.closest('form').submit();">
												Xóa
											</a>
										</form>
									</div>

								</div>
							</div>
						</div>

						<!-- Modal hiển thị chi tiết món -->
						<div class="modal fade" id="menuDetailModal${status.index}"
							tabindex="-1" role="dialog"
							aria-labelledby="menuDetailModalLabel${status.index}"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title"
											id="menuDetailModalLabel${status.index}">Chi tiết món
											${menu.tenMon}</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<!-- Thêm nội dung chi tiết món ở đây -->
										<p>${menu.moTaMon}</p>
										<p>Giá: <fmt:formatNumber value="${menu.giaTien}" pattern="#,##0"/> VND</p>
										<p>Nguyên liệu: ${menu.nguyenLieuCanThiet}</p>
									</div>
								</div>
							</div>
						</div>

						<c:if test="${status.index % 5 == 4 || status.last}">
				</div>
				<div class="row">
					</c:if>
					</c:forEach>
				</div>

			</div>

			<!-- Right column for order -->
			<div class="col-md-2 bg-light" style="width: 25%; margin-top: 10px">
				<h3 class="mb-4">Lập hóa đơn</h3>
				<form method="post"
					action="${pageContext.request.contextPath}/AddHoaDonServlet">
					<fieldset>
						<div class="form-group mb-3">
							<label for="chinhanhID" class="form-label">Mã chi nhánh - Tên chi nhánh</label>
							<div class="select-wrapper">
								<select class="form-select" id="chinhanhID" name="chinhanhID">
									<!-- Populate this dropdown with available khoaModel instances -->
									<c:forEach var="CN" items="${chinhanhList}">
										<option value="${CN.getChinhanhID()}">${CN.getTenchinhanh()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group mb-3">
							<label for="MaHoaDon" class="form-label">Mã hóa đơn</label> <input
								type="number" class="form-control" id="MaHoaDon" name="MaHoaDon"
								value="1" readonly>
						</div>

						<div class="form-group mb-3">
							<label for="MaMon" class="form-label">Mã món - Tên món</label>
							<div class="select-wrapper">
								<select class="form-select" id="MaMon" name="MaMon">
									<!-- Populate this dropdown with available khoaModel instances -->
									<c:forEach var="Menu" items="${menuList}">
										<option value="${Menu.getMaMon()}">${Menu.getTenMon()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group mb-3">
							<label for="IDKhachHang" class="form-label">Mã khách hàng - Tên khách hàng</label>
							<div class="select-wrapper">
								<select class="form-select" id="IDKhachHang" name="IDKhachHang">
									<!-- Populate this dropdown with available khoaModel instances -->
									<c:forEach var="KH" items="${khachHangList}">
										<option value="${KH.getIDKhachHang()}">${KH.getTenKhachHang()}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group mb-3">
							<label for="SoLuong" class="form-label">Số lượng</label> <input
								type="number" class="form-control" id="SoLuong" name="SoLuong">
						</div>
					</fieldset>

					<hr>

					<button type="submit" class="btn btn-primary">Thêm hóa đơn</button>
					<div style="display: flex; justify-content: space-between; align-items: center; margin-top: 2rem">
					    <a href="#" onclick="increaseMaHoaDon()" style="color: black; text-decoration: none; display: flex; align-items: center;">
					        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
							  <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M18 9V4a1 1 0 0 0-1-1H8.914a1 1 0 0 0-.707.293L4.293 7.207A1 1 0 0 0 4 7.914V20a1 1 0 0 0 1 1h4M9 3v4a1 1 0 0 1-1 1H4m11 6v4m-2-2h4m3 0a5 5 0 1 1-10 0 5 5 0 0 1 10 0Z"/>
							</svg>

					        <h6>Hóa đơn mới</h6>
					    </a>
					    
					    <a href="#" onclick="DecreaseMaHoaDon()" style="color: black; text-decoration: none; display: flex; align-items: center;">
					        <svg class="w-6 h-6 mr-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
					            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 12H4m12 0-4 4m4-4-4-4m3-4h2a3 3 0 0 1 3 3v10a3 3 0 0 1-3 3h-2"/>
					        </svg>
					        <h6>Hóa đơn trước</h6>
					    </a>
					</div>

				</form>
			</div>

		</div>
	</div>
</body>
</html>