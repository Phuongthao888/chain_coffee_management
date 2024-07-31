<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Drip Cafe - Contact</title>
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
      <section class="contact">
        <div class="pic-area">
          <div class="pic-area-text">
            <h2>Methods to</h2>
            <h1 class="home__name">
              Contact Us
            </h1>
            <h3>One email, phone call, or block away.</h3>
            <div class="sections">
              <div class="sections-section">
                <i class="fas fa-envelope"></i> Email
                <p>Gr7cafe@email.com</p>
              </div>
              <div class="sections-section">
                <i class="fas fa-mobile-alt"></i> Phone
                <p>+1 (541) 741-5527</p>
              </div>
              <div class="sections-section">
                <i class="fas fa-map-marker-alt"></i> Address
                <p>Ho Chi Minh city</p>
              </div>
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
