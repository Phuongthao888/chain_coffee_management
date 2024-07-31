<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<style>
	.center-div {
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 800px;
	}
	body {
		background: linear-gradient(45deg, rgba(255, 126, 95, 0.8), #99CCFF);
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/SignupServlet" class="text-neutral-800 relative overflow-hidden flex flex-col justify-around w-96 h-44 border border-neutral-500 rounded-lg bg-neutral-50 p-3 px-6">
			    <div class="container text-center center-div">
				    <div class="row row-cols-2">
				        <div class="col bottom">
				                <div class="card" style="width: 700px;">
				                    <div class="card-body card-color">
				                        <h4> Tên người dùng đã tồn tại, vui lòng đổi tên người dùng khác</h4>
				                        <hr>
				                        <a href="${pageContext.request.contextPath}/SignupServlet" class="btn btn-secondary">Quay lại</a></div>
				                </div>
				         </div>
				    </div>
				</div>
			</form>
</body>
</html>