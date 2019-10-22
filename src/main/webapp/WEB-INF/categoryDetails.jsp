<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<h1>Category: <c:out value="${category.name}"/></h1>

		
		<h3>Products:</h3>
		
		<ul>
			<c:forEach items="${category.products}" var="cp">
				<li><c:out value="${cp.name}"/></li>
			</c:forEach>
		</ul>
		
		
		<form:form action="/addProduct" method="post" modelAttribute="middleTableObj">
			<form:select path="product" >
			    <c:forEach items="${nonProducts}" var="product">

			    	<option value="${product.id}"> ${product.name}</option>

			    </c:forEach>
			</form:select>
			<form:hidden path="category" value="${category.id }"></form:hidden>
			<input type="submit" value="Add Category"/>
		</form:form>
		
	</body>
</html>