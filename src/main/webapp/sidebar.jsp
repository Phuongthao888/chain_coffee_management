<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
	crossorigin="anonymous"></script>

<style>
.viewport {
	padding-left: 250px;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}


/* Sidebar Styles */
.sidebar {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 250px;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
 

  /* Apply button styles to sidebar */
  box-shadow: 1px 1px 3px #b5b5b5,
             -1px -1px 3px #ffffff; /* Apply box shadow */
  transition: .4s ease-in-out; /* Inherit transition effect */
}

.sidebar:hover {
  box-shadow: inset 3px 3px 6px #b5b5b5,
              inset -3px -3px 6px #ffffff; /* Add hover effect */
}

.main {
	color: black;
}

z

	.aList {
	text-decoration: none;	
}

/* Updated styles */


.sidebar .nav-link {
	font-weight: bold; /* Bold text for navigation links */
	transition: background-color 0.2s ease-in-out; /* Hover effect */
}

.sidebar .nav-link:hover {
	background-color: #172a37; /* Slightly darken background on hover */
}

.sidebar h3 {
	margin-bottom: 15px; /* Add some space after the heading */
}

/* Add your logo or icon styles here */

/* Media query example for smaller screens */
@media ( max-width : 768px) {
	.sidebar {
		width: 75%; /* Adjust sidebar width for smaller devices */
	}
}

</style>
</head>
<body>


	<!-- MAIN CONTENT -->

	<!-- SIDEBAR -->
	<div class="sidebar">
		<nav class="nav flex-column">
			<br>
			<div class="dropdown" style="margin-left: 20px">
				<h3>Gr7 Coffee</h3>
				<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
					aria-labelledby="dropdownUser1">

					<li><hr class="dropdown-divider"></li>
				</ul>
			</div>
			<hr>
			<a class="nav-link text-dark active aList" aria-current="page" href="index.jsp">TRANG
				CHỦ</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/chinhanhServlet">Quản
				lý chi nhánh</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/MenuServlet">Quản lý
				món nước</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/HoaDonServlet">Quản lý
				hóa đơn</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/NhanVienServlet">Quản
				lý nhân viên</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/KhachHangServlet">Quản
				lý khách hàng</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/NguyenLieuServlet">Quản
				lý nguyên liệu</a><br> <a class="nav-link text-dark aList"
				href="${pageContext.request.contextPath}/showadminblog">Quản lý
				Blogs</a><br> <br>
		</nav>
	</div>
	<!-- END SIDEBAR -->

	<!-- MAIN CONTENT -->
</body>
</html>