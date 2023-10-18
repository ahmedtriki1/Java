<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Le JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
<div class="d-flex justify-content-between">
<div>
   <h1>Welcome ${user.userName}</h1>
   <p>Books from everyone's shelves:</p>
   </div>
   <div >
   <div>
   <a href="/books/new">Add a to my shell</a></div>
   <a href="/logout">LOGOUT</a>
   </div>
   </div>

<table class="table table-striped table-bordered">
	<thead>
		<tr>
		<th>ID</th>
			   <th>Title</th>
              <th>Author Name</th>
			<th>Posted BY</th>
			
		</tr>
	</thead>
	<tbody>
		
		<c:forEach items="${booksList }" var="oneBook" >
   <tr>
   <td>${oneBook.id}</td>
   <td><a href="/book/${oneBook.id}">${oneBook.title}</a></td>
   <td>${oneBook.author}</td>
   <td>${oneBook.booklover.userName}</td>


   </tr>
   </c:forEach>
		
		
	</tbody>
</table>
</div>
</body>
</html>