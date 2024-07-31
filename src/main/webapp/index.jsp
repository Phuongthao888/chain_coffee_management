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
    <link rel="stylesheet" href="css/main.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Baloo+2:wght@400;700&family=Marck+Script&display=swap"
      rel="stylesheet"
    />
    <link rel="icon" href="../img/favicon.png" />
</head>
<body>
    <header>
      <div class="second-header">
        <div class="menu-btn">
          <span class="menu-btn__burger"></span>
        </div>

        <nav class="nav">
          <ul class="menu-nav">
            <li class="menu-nav__item">
              <a href="home.jsp" class="logo menu-nav__link">
                <img src="../img/favicon.png" />
                <span class="logo-first">Gr7</span>
                <span class="logo-last">Cafe</span>
              </a>
            </li>
            
          </ul>
        </nav>
      </div>
      <!-- Shopping Cart -->
      <div class="cart-overlay">
        <div class="cart">
          <div class="cart__closeBtn">
            <i class="fas fa-window-close"></i>
          </div>
          <h2>
            <i class="fa fa-cart-arrow-down"></i>
            <span class="span-primary">Shopping</span> Cart
            <i class="fa fa-cart-arrow-down"></i>
          </h2>

          <!-- JS will add items here -->
          <div class="item1-display"></div>
          <div class="item2-display"></div>
          <div class="item3-display"></div>
          <div class="item4-display"></div>
          <div class="item5-display"></div>
          <div class="item6-display"></div>
          <div class="item7-display"></div>
          <div class="item8-display"></div>
          <div class="item9-display"></div>
          <div class="item10-display"></div>
          <div class="item11-display"></div>
          <div class="item12-display"></div>
          <div class="total"></div>
        </div>
      </div>
    </header>
</body>
</html>
    <main>
      <section class="home">
        <div class="pic-area">
          <div class="pic-area-text">
            <h2>Welcome to</h2>
            <h1 class="home__name">
              <span class="logo-first">Gr7</span>
              <span class="logo-last">Cafe</span>
            </h1>
            <h3>Where coffee and comfort come together</h3>
            <form method="GET" action="${pageContext.request.contextPath}/LoginServlet">
            <a>
              <button class="btn-order">Đăng nhập với tư cách Admin</button><br>
            </a>
            </form>
            <a href="customer/home.jsp">
              <button class="btn-order">Tiếp tục với tư cách khách hàng</button>
            </a>
          </div>
        </div>
        
        <footer>
          <div class="icons">
            <a href="#!">
              <i class="fab fa-twitter"></i>
            </a>
            <a href="#!">
              <i class="fab fa-facebook"></i>
            </a>
            <a href="#!">
              <i class="fab fa-instagram"></i>
            </a>
            <a href="#!">
              <i class="fab fa-snapchat-square"></i>
            </a>
          </div>
          <div class="copyright">&copy; Copyright 2022</div>
        </footer>
      </section>
    </main>
    <script src="../js/script.js"></script>
    <script
      src="https://kit.fontawesome.com/c057664144.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
