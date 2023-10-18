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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
   <h1>Edit an expense</h1>
<a href="/expenses"  type="button">Go back</a>   <hr />
   
   <form:form action="/expenses/${travel.id }/edit" method="post" modelAttribute="travel">
   <input type="hidden" name="_method" value="put"> 
     <form:errors class="text-danger" path="*"/>
    <p>
        <form:label path="expense">Expense Name</form:label>
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
    <button>UPDATE</button>
</form:form>    
   </div>
</body>
</html>