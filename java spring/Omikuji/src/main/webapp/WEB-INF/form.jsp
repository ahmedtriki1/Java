<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Send an Omikuji !</h3>
 	
    <form action='/processForm' method='POST'>
    
    <div>
	<label>Pick any number from 5 to 25 :</label>
    <input name='numbrer'>
    </div>
    
    <div>
	<label>Enter the name of any city:</label>
    <input name='city'>
    </div>
     <div>
	<label>Enter the name of any real person:</label>
    <input name='person'>
    </div>
     <div>
	<label>Enter professional endeavor or hobby:</label>
    <input name='hobby'>
    </div>
     <div>
	<label>Enter any type of living thing:</label>
    <input name='type'>
    </div>
     <div>
	<label>Say something nice to someone:</label>
    <input name='something'>
    </div>
    Send and show a friend
    	<button>Send</button>
    </form>
</body>
</html>