<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Register</title>
		</head>

		<body>

			<style>
			*{
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    body{
      background-color: white;
    }
    div.registerContainer{
      background-color: rgb(233, 233, 233);
      margin: auto;
      width: 400px;
      height: 450px;
      align-items: center;
      align-content: center;
      text-align: center;
    }

    form.tableContainer{
      background-color: transparent;
      width: 300px;
      height: 400px;
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
      width:90px;
    }
    .whitebutton:hover{
      border-color: dodgerblue;
    }


			</style>

			<div class="registerContainer">
			
			<img src="https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png" width="200px">

				<form:form action="saveUser" method="post" modelAttribute="user" class="tableContainer">

					<table>
						<form:hidden path="userId" />

						<tr>
							<td>Name</td>
							<td>
								<form:input path="name" />
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>
								<form:input path="password" />
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>
								<form:input path="emailId" />
							</td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td>
								<form:input path="phoneNo" />
							</td>
						</tr>
						<tr>

							<td colspan="2" align="center"><input type="submit" value="Register" class="whitebutton"></td>
						</tr>


					</table>



				</form:form>

			</div>



		</body>

		</html>