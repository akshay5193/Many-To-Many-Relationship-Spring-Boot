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
		
		<h1><c:out value="${product.name}"/></h1>
		<p>Description: <c:out value="${product.description}"/></p>
		<p>Price: <c:out value="${product.price}"/></p>
		
		<h3>Categories:</h3>
		
		<ul>
			<c:forEach items="${product.categories}" var="pc">
				<li><c:out value="${pc.name}"/></li>
			</c:forEach>
		</ul>



		<form:form action="/addCategory" method="post" modelAttribute="middleTableObject">
			<form:select path="category" >
			    <c:forEach items="${nonCategories}" var="category">

			    	<option value="${category.id}"> ${category.name}</option>

			    </c:forEach>
			</form:select>
			<form:hidden path="product" value="${product.id }"></form:hidden>
			<input type="submit" value="Add Category"/>
		</form:form>  
	</body>
</html>