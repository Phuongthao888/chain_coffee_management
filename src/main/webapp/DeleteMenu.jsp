<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
bạn có muốn xóa
<form method="post" action="DeleteMenuServlet">
						<input type="hidden" name="MaMon" value="${menu.maMon}">
						<button type="submit">Xóa</button>
					</form>
</body>
</html>