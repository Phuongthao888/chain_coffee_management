<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Drip Cafe - Sign In</title>
    <link rel="stylesheet" href="../css/main.css" />
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
              <a href="index.html" class="logo menu-nav__link">
                <img src="../img/favicon.png" />
                <span class="logo-first">Drip</span>
                <span class="logo-last">Cafe</span>
              </a>
            </li>
            <li class="menu-nav__item">
              <a href="${pageContext.request.contextPath}/customer/sign-in.jsp" class="sign-in menu-nav__link">
                <i class="fa fa-user" aria-hidden="true"></i>
                Sign In
              </a>
              <span class="menu-nav__link" id="slash">/</span>
              <a href="${pageContext.request.contextPath}/customer/sign-up.jsp" class="sign-up menu-nav__link active">
                Sign Up
              </a>
            </li>
            <br />
            <li class="menu-nav__item">
              <a href="${pageContext.request.contextPath}/customer/home.jsp" class="menu-nav__link">
                Home
              </a>
            </li>
            <li class="menu-nav__item">
              <a href="${pageContext.request.contextPath}/customer/menuCUS.jsp" class="menu-nav__link">
                Menu
              </a>
            </li>
            <li class="menu-nav__item">
              <a href="${pageContext.request.contextPath}/customer/services.jsp" class="menu-nav__link">
                Services
              </a>
            </li>
            <li class="menu-nav__item">
              <a href="${pageContext.request.contextPath}/customer/contact.jsp" class="menu-nav__link">
                Contact
              </a>
            </li>
            <li class="menu-nav__item">
              <a href="#!" class="menu-nav__link cart__openBtn">
                <i class="fa fa-cart-plus" aria-hidden="true"></i>
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
          <div class="total">
            <br />
            <br />
            Your Shopping Cart is empty. <br />
            Add items to cart by hovering over/tapping on the images of products
            on the Menu page.
          </div>
        </div>
      </div>
    </header>

    <main>
      <section class="sign-up">
        <div class="pic-area">
          <div class="pic-area-text">
            <div id="login-box">
              <form
                id="login-form"
                name="login-form"
                action="index.html"
                method="post"
              >
                <label>Email: </label> <br />
                <input
                  type="email"
                  name="email"
                  id="emailid"
                  pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"
                  required
                />
                <br />
                <label>Username: </label> <br />
                <input
                  type="text"
                  name="userid"
                  id="userid"
                  pattern="[a-zA-Z0-9]+"
                  required
                />
                <!-- minlength="10" does not work probably bc you need to use the submit button--><br />
                <label>Password: </label> <br />
                <input type="password" name="pswrd" id="pswrd" /><br />
                <br />
              </form>
              <div id="username-display"></div>
              <button class="btn-order" id="sign-up-btn">Sign Up</button>
            </div>
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
          </div>
          <div class="copyright">&copy; Copyright 2022</div>
        </div>
      </section>
    </main>
    <script src="../js/script.js"></script>
    <script
      src="https://kit.fontawesome.com/c057664144.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
