<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="./template/nav.jsp"></c:import>

	<div class="container">
		
			<form action="./">
				<select name="lang">
					<option>ko</option>
					<option>en</option>
				</select>
				<button>Change</button>
			</form>
	
		<%-- <h1>
			<spring:message code="hello"></spring:message>
			<spring:message code="hello2" text="No message" var="t"></spring:message>
			<c:if test="${not empty member}">
			<spring:message code="loginMessage" arguments="${member.id},${member.email}" argumentSeparator=","></spring:message>
			</c:if>
		</h1> --%>

		<div class="containter">
			<img alt="rabbit2.png" src="./images/rabbit2.png">
		</div>
		<h1>${t}</h1>
	</div>

</body>
</html>