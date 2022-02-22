<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

 <style>
    *{
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    body{
      background-color: white;
    }
    div.loginContainer{
      background-color: rgb(233, 233, 233);
      margin: auto;
      width: 400px;
      height: 450px;
      align-items: center;
      align-content: center;
      text-align: center;
    }

    table.tableContainer{
      background-color: transparent;
      width: 300px;
      height: 200px;
      margin: auto;
    }

    tr{
      padding-top: 20px;
      margin-top: 10px;
      margin: auto;
    }
    td{
      padding-top: 20px;
      margin-top: 10px;
      margin: auto;
    }
    img{
      margin: auto;
      padding: auto;
    }

    .whitebutton{
      background: white;
      border-radius: 4px;
      width: 75px;
    }
    .whitebutton:hover{
      border-color: dodgerblue;
      
    }


    </style>
    
    <div class="loginContainer">
    
    <img src="https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png" width="200px">
    
    <form:form action="login" method="post" modelAttribute="credential">


	
	<table class="tableContainer">
	<tr>
		<td>Name</td>
		<td><form:input path="name" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><form:input path="password" /></td>
	</tr>
	<tr>

		<td colspan="2" align="center"><input type="submit" value="Login" class="whitebutton"></td>
	</tr>
	
	
	</table>
	
</form:form>
    
    </div>



	





</body>
</html>