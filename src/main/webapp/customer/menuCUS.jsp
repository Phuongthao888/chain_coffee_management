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
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Left column for navigation -->
			<div class="col-md-3 bg-light text-dark">
				<div class="list-group mt-5">
					<a href="customer/home.jsp"
						class="list-group-item list-group-item-action active">Trang
						Chủ</a>
				</div>
			</div>

			<!-- Center column for content -->
			<div class="col-md-7" style="margin-top: 10px">
				<h3>Danh sách món nước</h3>
				<p class="text-danger">${errorString}</p>

				<br>



				<!-- Danh sách món nước -->
				<div class="row">
					<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
					<c:forEach items="${menuCusList}" var="menu" varStatus="status">
						<div class="col-md-4">
							<div class="card mb-4" style="max-height: 470px; min-height: 470px">
								<img src="${menu.hinhAnh}" class="card-img-top"
									alt="${menu.tenMon}"
									style="max-width: 280px; max-height: 200px; min-height: 200px">
								<div class="card-body">
									<h5 class="card-title">${menu.maMon}-${menu.tenMon}</h5>
									<p class="card-text">${menu.moTaMon}</p>
									<p class="card-text">
										Giá:
										<fmt:formatNumber value="${menu.giaTien}" pattern="#,##0" />
										VND
									</p>
									<p class="card-text">Nguyên liệu:...</p>
									<div class="form-inline"
										style="margin-left: 50%; transform: translateX(-50%);">
										<!-- Button VIEW -->
										<a href="#" data-toggle="modal"
											data-target="#menuDetailModal${status.index}"> VIEW </a>

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
										<p>
											Giá:
											<fmt:formatNumber value="${menu.giaTien}" pattern="#,##0" />
											VND
										</p>
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


		</div>
	</div>
</body>
</html>