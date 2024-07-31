<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Drip Cafe - Services</title>
    <link rel="stylesheet" href="./css/main.css" />
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
      <section class="services">
        <div class="pic-area">
          <div class="pic-area-text">
            <h2>Take a Look at Our</h2>
            <h1 class="home__name">
              Amazing Services!
            </h1>
            <h3>Your home away from home.</h3>
            <!-- <button class="btn-order">Order Now!</button> -->
          </div>
        </div>
        <div class="main-area">
          <c:forEach items="${listcusblog}" var="x">
          <div class="section-area">
            <div class="section-B">
              <div class="box-text">
                <h1>${x.title}</h1>
                <p>
                  ${x.description}
                </p>
              </div>
              <div class="box-img">
                <img src="${x.imgurl}" alt="" />
              </div>
            </div>
          </div>
          </c:forEach>

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
      src="https://kit.fontawesome.com/c057664144.js" crossorigin="anonymous"
    ></script>
  </body>
</html>