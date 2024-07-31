<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý nhân viên</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Left column for navigation -->
            <div class="col-md-2">
                <div id="sidebar"></div>
		        <script>
		            // Sử dụng JavaScript để nhúng nội dung từ một trang HTML
		            fetch('./sidebar.jsp')
		                .then(response => response.text())
		                .then(html => {
		                    document.getElementById('sidebar').innerHTML = html;
		                });
		        </script>
            </div>

            <!-- Right column for content -->
            <div class="col-md-9">
                <!-- Content goes here -->
                <h3>Danh sách nhân viên</h3>
                <p class="text-danger">${errorString}</p>

                <form action="<c:url value='/SearchNhanVienServlet' />" method="get" class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" id="searchName" name="searchName" placeholder="Search by Name" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>

                <div class="row" >
                    <c:forEach items="${nhanVienList}" var="nhanVien">
                        <div class="col-md-4">
                            <div class="card mb-3" style="max-height: 300px; min-height: 300px">
                                <div class="card-body">
                                    <h5 class="card-title">${nhanVien.tenNhanVien}</h5>
                                    <div class="row">
                                        <div class="col-6 text-right"><strong>ID Nhân viên:</strong></div>
                                        <div class="col-6">${nhanVien.IDNhanVien}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 text-right"><strong>Ngày sinh:</strong></div>
                                        <div class="col-6">${nhanVien.ngaySinh}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 text-right"><strong>Số điện thoại:</strong></div>
                                        <div class="col-6">${nhanVien.SDT}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 text-right"><strong>User:</strong></div>
                                        <div class="col-6">${nhanVien.user}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 text-right"><strong>Chức vụ:</strong></div>
                                        <div class="col-6">${nhanVien.chucVu}</div>
                                    </div>
                                    <div class="form-inline" style="margin-top: 15px; margin-left: 50%;  transform: translateX(-50%);">
										<!-- Button VIEW -->
										<a data-toggle="modal"
											data-target="#menuDetailModal${status.index}"> <svg
												class="w-6 h-6 text-gray-800 dark:text-white"
												aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
												width="30" height="30" fill="none" viewBox="0 0 24 24">
            <path stroke="currentColor" stroke-width="2"
													d="M21 12c0 1.2-4.03 6-9 6s-9-4.8-9-6c0-1.2 4.03-6 9-6s9 4.8 9 6Z" />
            <path stroke="currentColor" stroke-width="2"
													d="M15 12a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
        </svg>
										</a>

										<!-- Add some spacing -->
										<div style="width: 15px;"></div>

										<!-- Button EDIT -->
										<a
											href="${pageContext.request.contextPath}/UpdateMenuServlet?maMon=${menu.maMon}"
											class="d-inline"> <svg
												class="w-6 h-6 text-gray-800 dark:text-white"
												aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
												width="30" height="30" fill="none" viewBox="0 0 24 24">
            <path stroke="currentColor" stroke-linecap="round"
													stroke-linejoin="round" stroke-width="2"
													d="m14.304 4.844 2.852 2.852M7 7H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-4.5m2.409-9.91a2.017 2.017 0 0 1 0 2.853l-6.844 6.844L8 14l.713-3.565 6.844-6.844a2.015 2.015 0 0 1 2.852 0Z" />
        </svg>
										</a>

										<!-- Add some spacing -->
										<div style="width: 10px;"></div>

										<!-- Button DELETE -->
										<form method="post" action="DeleteMenuServlet"
											class="d-inline">
											<input type="hidden" name="MaMon" value="${menu.maMon}">
											<a href="#"
												onclick="event.preventDefault(); this.closest('form').submit();">
												<svg class="w-6 h-6 text-gray-800 dark:text-white"
													aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
													width="30" height="30" fill="none" viewBox="0 0 24 24">
                <path stroke="currentColor" stroke-linecap="round"
														stroke-linejoin="round" stroke-width="2"
														d="m15 9-6 6m0-6 6 6m6-3a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
            </svg>
											</a>
										</form>
									</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <h3>Thêm nhân viên mới</h3>
                <form method="post" action="AddNhanVienServlet">
                    <div class="form-group">
                        <label for="TenNhanVien">Tên nhân viên</label>
                        <input type="text" class="form-control form-control-sm" id="TenNhanVien" name="TenNhanVien">
                    </div>
                    <div class="form-group">
                        <label for="NgaySinh">Ngày sinh</label>
                        <input type="date" class="form-control form-control-sm" id="NgaySinh" name="NgaySinh">
                    </div>
                    <div class="form-group">
                        <label for="SDT">Số điện thoại</label>
                        <input type="text" class="form-control form-control-sm" id="SDT" name="SDT">
                    </div>
                    <div class="form-group">
                        <label for="User">User</label>
                        <input type="text" class="form-control form-control-sm" id="User" name="User">
                    </div>
                    <div class="form-group">
                        <label for="ChucVu">Chức vụ</label>
                        <input type="text" class="form-control form-control-sm" id="ChucVu" name="ChucVu">
                    </div>
                    <button type="submit" class="btn btn-primary">Thêm nhân viên</button>
                </form>
            </div>
        </div>
    </div>

    <script>
        function editNhanVien(IDNhanVien) {
            window.location.href = "updateNhanVien.jsp?IDNhanVien=" + IDNhanVien;
        }
    </script>
</body>
</html>
