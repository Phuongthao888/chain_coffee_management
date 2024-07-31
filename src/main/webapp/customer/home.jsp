<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Drip Cafe - Home</title>
<link rel="stylesheet" href="../css/main.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Baloo+2:wght@400;700&family=Marck+Script&display=swap"
	rel="stylesheet" />
<link rel="icon" href="../img/favicon.png" />
</head>
</html>
<body>
	<!-- HEADER -->
	<%@include file="/customer/header.jsp"%>
	<!-- END HEADER -->
	<main>
		<section class="home">
			<div class="pic-area">
				<div class="pic-area-text">
					<h2>Welcome to</h2>
					<h1 class="home__name">
						<span class="logo-first">Gr7</span> <span class="logo-last">Cafe</span>
					</h1>
					<h3>Where coffee and comfort come together</h3>
					<form method="GET"
						action="${pageContext.request.contextPath}/LoginServlet">
						<a>
							<button class="btn-order">Đăng nhập với tư cách Admin</button> <br>
						</a>
					</form>

				</div>
			</div>
			<div class="main-area">
				<div class="section-area">
					<div class="section-A">
						<div class="box-text">
							<h1>Who We Are</h1>
							<p>Chào mừng đến với cửa hàng cà phê, yên bình và ấm cúng
								giữa lòng thành phố nhộn nhịp. Tại đây, chúng tôi tự hào mang
								đến cho khách hàng những tách cà phê được pha chế từ những
								nguyên liệu tươi ngon và chất lượng nhất.</p>
						</div>
						<div class="box-img">
							<img src="../img/who-we-are.jpg" alt="Who We Are" />
						</div>
					</div>
				</div>
				<div class="section-area">
					<div class="section-B">
						<div class="box-text">
							<h1>Our Services</h1>
							<p>Bằng sự tận tâm và cam kết của mình, chúng tôi tự hào mang
								đến cho thành phố những tách cà phê đậm vị, trang nhã và ấm áp
								trong không gian thoải mái của quán. Hãy đến và trải nghiệm
								những tách cà phê tuyệt hảo của chúng tôi ngay hôm nay!</p>
						</div>
						<div class="box-img">
							<img src="../img/services.jpg" alt="Services" />
						</div>
					</div>
				</div>
				<div class="section-area">
					<div class="section-C">
						<div class="box-text">
							<h1>Menu</h1>
							<p>Thực đơn của chúng tôi đảm bảo có cà phê buổi sáng mà bạn
								cần để bắt đầu ngày mới. Từ Caffè Americano cổ điển của chúng
								tôi đến bốn loại Roast hoặc một trong những loại Espresso của
								chúng tôi, bạn sẽ tìm thấy thứ gì đó giúp bạn có được năng lượng
								buổi sáng cần thiết trong khi thưởng thức từng ngụm.</p>
						</div>
						<div class="box-img">
							<img src="../img/menu.jpg" alt="Menu" />
						</div>
					</div>
				</div>
			</div>
			<footer>
				<div class="icons">
					<a href="#!"> <i class="fab fa-twitter"></i>
					</a> <a href="#!"> <i class="fab fa-facebook"></i>
					</a> <a href="#!"> <i class="fab fa-instagram"></i>
					</a> <a href="#!"> <i class="fab fa-snapchat-square"></i>
					</a>
				</div>
				<div class="copyright">&copy; Copyright 2022</div>
			</footer>
		</section>
	</main>
	<script src="../js/script.js"></script>
	<script src="https://kit.fontawesome.com/c057664144.js"
		crossorigin="anonymous"></script>
</body>
</html>