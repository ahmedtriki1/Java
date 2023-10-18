<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>hello world</title>
<link rel="stylesheet" type="text/css" href="/css/style1.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<h1>Fruit Store</h1>
<table>

  <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items = "${fruitList }" var = "oneItem">
  
    <tr>
	<td><c:out value="${oneItem.name }"></c:out></td>
	<td><c:out value="${oneItem.price }"></c:out></td>

    </tr>
   </c:forEach>
    
  </tbody>
  
</table>

</body>
</html>