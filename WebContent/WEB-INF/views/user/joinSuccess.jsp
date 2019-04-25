<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jblog.css">
	<title>JBlog</title>
</head>
<body>
	<div class="center-content">
				<!-- header -->
		<c:import url="/WEB-INF/views/includes/menu.jsp"></c:import>
		
		<p class="welcome-message">
			<span> 감사합니다.
				       회원 가입 및 블로그가 성공적으로 만들어 졌습니다.
		    </span>
			<br><br>
			<a href="${pageContext.request.contextPath }/users/loginform">로그인 하기</a>
		</p>
		
	</div>
</body>
</html>
