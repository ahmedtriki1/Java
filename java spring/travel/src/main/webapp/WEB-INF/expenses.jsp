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
   <h1>Save Travels</h1>
   <hr />
   <table class="table">
   <thead>
   <tr>
   <th>Expense</th>
   <th>Vendor</th>
   <th>Amount</th>
   <th>Actions</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${travelsList }" var="onetravel" >
   <tr>
   <td><a href="/expenses/${onetravel.id}">${onetravel.expense}</a></td>
   <td>${onetravel.vendor}</td>
   <td>$ ${onetravel.amount}</td>
   <td>${onetravel.description}</td>
   <td>
   	<a href="/expenses/${onetravel.id }/edit">Edit</a> | 
   	<form action="/expenses/${onetravel.id }" method="post">
   	<input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
   	</form>
   </td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
</div>
<br>
<br>
<br>
<br>
<hr>

<div class="container">
   <h1>Add an expense</h1>
   <hr />
   
   <form:form action="/expenses" method="post" modelAttribute="travel">
   <form:errors class="text-danger" path="*"/>
    <p>
        <a href="/expense/travel.id/show"><form:label path="expense">Expense Name</form:label></a>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:textarea path="vendor"/>
    </p>

    <p>
        <form:label path="amount">Amount</form:label>
        <form:input type="amount" path="amount"/>
    </p>    
     <p>
        <form:label path="description">Description</form:label>
        <form:textarea path="description"/>
    </p>
    <button>Submit</button>
</form:form>    
   </div>
   </body>
   
</html>