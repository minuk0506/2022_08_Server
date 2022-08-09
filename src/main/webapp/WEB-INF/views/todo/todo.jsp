<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>

<body>

<form:form>
	<input name="username" type="hidden"
		value='<c:out value="${TODO.username}"/>'>
	<input name="todo" placeholder="todo쓰기"
		value="${TODO.todo}">
	<button>TODO기록</button>
</form:form>
<table>
		<tr>
			<td>작성일자</td>
			<td>작성시각</td>
			<td>내용</td>
			<td></td>
		</tr>
		<c:forEach items="${todoList}" var="todo">
			<tr>
				<td>${todo.date}</td>
				<td>${todo.time}</td>
				<td>${todo.todo}</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>