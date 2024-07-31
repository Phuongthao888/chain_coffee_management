<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!-- HEADER -->
	<%@include file="/customer/header.jsp" %>
	<!-- END HEADER -->

    <main>
      <section class="sign-in">
        <div class="pic-area">
          <div class="pic-area-text">
            <div id="login-box">
              <form
                id="login-form"
                name="login-form"
                action="index.html"
                method="post"
              >
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
              <button class="btn-order" id="login-btn">Login</button>
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
