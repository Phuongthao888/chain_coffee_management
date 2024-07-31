<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
    integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
    crossorigin="anonymous"></script>
    <link rel="stylesheet" href="login.css">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Đăng Nhập</title>
<style>
	body {
		background: #EBEDF0;
		filter: opacity(50px);
	}
	
	.container {
		display: flex;
		justify-content: center;
		/* Căn giữa theo chiều ngang */
		align-items: center;
		/* Căn giữa theo chiều dọc */
		height: 100vh;
		width: 100%;
	}
	
	.form-control {
		background-color: white;
	}
</style>
</head>
<body>
	<div class="container">
    <div class="form-control">
        <div class="row align-items-center g-lg-5 py-5" style="width: 100%; color: black;">
            <div class="col-lg-6 text-center text-lg-start" style="margin-left: 50px;">
                <h1 class="display-4 fw-bold lh-1 mb-3">Welcome to website</h1>
                <p class="col-lg-10 fs-4">Xin chào! Cảm ơn đã đến với hệ thống quản lý cửa hàng của chúng tôi. Tôi sẽ rất vui được hỗ trợ bạn trong việc quản lý và vận hành cửa hàng một cách hiệu quả.</p>
            </div>
            <div class="col-md-10 mx-auto col-lg-5">
                <form class="p-4 p-md-5 border rounded-3" method="POST" action="${pageContext.request.contextPath}/LoginServlet">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" name="Username" placeholder="name@gmail.com"> <label>Email address</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control" name="Password" placeholder="Password"> <label>Password</label>
                    </div>
                    <div class="checkbox mb-3">
                        <label> <input type="checkbox" value="remember-me"> Remember me </label><br>
                        <a href=#"">Forget password</a>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
                    <hr class="my-4">
                    <small class="text-black">By clicking <a href=#"">Sign up</a>, you agree to the terms of use.</small>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
