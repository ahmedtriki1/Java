<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Expense Details</h1>
<a href="/expenses"  type="button">Go back</a>   <hr />
<div class="container">
  
    <p>Expense Name :       ${travel.expense}  </p>
    <p>Expense Description :     ${travel.description} </p>
    <p>Vendor:      ${travel.vendor} </p>
    <p>Amount Spent :     $ ${travel.amount}</p>
  
   
</div>
</body>
</html>