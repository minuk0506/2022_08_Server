<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<nav>
		<ul>
			<li><a href="${rootPath}/">Home</a></li>
			<sec:authorize access="isAnonymous()">
				<li><a href="${rootPath}/user/login">로그인</a></li>
				<li><a href="${rootPath}/user/join">회원가입</a></li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="${rootPath}/todo/todo">TODO보기</a></li>
				</sec:authorize>
			</sec:authorize>
		</ul>
	</nav>
	<section class="w3-container w3-padding-16">
		<c:choose>
			<c:when test="${LAYOUT == 'LOGIN' }">
				<%@ include file="/WEB-INF/views/user/login.jsp"%>
			</c:when>
			<c:when test="${LAYOUT == 'JOIN' }">
				<%@ include file="/WEB-INF/views/user/join.jsp"%>
			</c:when>
			<c:when test="${LAYOUT == 'TODO' }">
				<%@ include file="/WEB-INF/views/todo/todo.jsp"%>
			</c:when>


			<c:otherwise>
				<sec:authorize access="isAuthenticated()">
					<sec:authentication property="principal.username" />
					<sec:authentication property="principal.email" />
					<sec:authentication property="principal.realname" />
				</sec:authorize>
			</c:otherwise>
		</c:choose>
	</section>


	<form:form class="logout" action="${rootPath}/logout">
		<button>로그아웃</button>
	</form:form>
</body>
</html>