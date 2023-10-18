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
    <title></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   <div class="container mt-5">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title mb-4">${book.title }</h2>

						<div class="row">
							<div class="col-md-6">

								<p><c:out value="${user.userName }"/> read ${book.title } by ${book.author } .</p>
								<p>Here are <c:out value="${user.userName }"/>'s thoughts:</p>
                                 <hr/>
                                 <p><strong><c:out value="${book.thoughts }"/></strong></p>
                                 <hr/>
                                 
     <c:if test="${user_id == book.booklover.id }">
   <td>
   	<a href="/books/${book.id }/edit">Edit</a> | 
   	<form action="/books/${book.id }" method="post">
   	<input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
   	</form>
   </td>
   </c:if>
                                 
                                 
                              
</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

