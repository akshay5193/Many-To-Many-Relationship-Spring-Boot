<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<h1>All Products</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Description</th>
		            <th>Price</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${products}" var="product">
		        <tr>
		            <td><c:out value="${product.name}"/></td>
		            <td><c:out value="${product.description}"/></td>
		            <td><c:out value="${product.price}"/></td>
		            <td><a href="/products/${product.id }"> View </a></td>
<%-- 		            <c:out value=""/> --%>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/products/new">New Product</a>	<br /><br />
		<a href="/">Home</a>	<br /><br />
	</body>
</html>