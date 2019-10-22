<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<h1>All Category</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${categories}" var="category">
		        <tr>
		            <td><c:out value="${category.name}"/></td>
		            <td> <a href="/categories/${category.id }">View Products</a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/categories/new">New Category</a><br /><br />
		<a href="/">Home</a>	
		
	</body>
</html>