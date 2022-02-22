<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Products</title>
			</head>

			<body>
				<style>
					  *{
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    body{
      background-color: white;
      text-align:center;
    }  
    th{
      padding: 10px;
      border-top-left-radius: 20px;
      border-top-right-radius: 20px;
      background-color: lightgray;
      border: 1px solid lightgray;
    }

    td.top {
      border: 1px solid black;
      padding: 10px;
      text-align: center;
      border-top-left-radius: 20px;
      border-top-right-radius: 20px;
    }

    tr.top{
      background-color: lightgray;
      border-top-left-radius: 20px;
      border-top-right-radius: 20px;
    }

    table.tableContainer{
      
      background-color: transparent;
      padding: 30px;
      border-radius: 20px;
      border-collapse: collapse;
      margin-top: 20px;
      width:80%;
      margin-left:auto;
      margin-right:auto;
    }

    td.product{
      border-bottom: 2px solid gray;
      padding: 20px;
      border-collapse: collapse;
      text-align:center;
    }
				</style>
				<h2 style="color:darkblue;">Products</h2>
				<form action="search" method="get">
					<input type="hidden" name="userId" value="${user}">
					<input type="text" name="productName">
					<input type="submit" value="Search">
				</form>

				<div class="tableContainer">


					<table class="tableContainer">
						<tr class="top">
							<th>Product Name</th>
							<th>Product Category</th>
							<th>Price</th>
							<th>Available Quantity</th>
							<th><th>
						</tr>
	
						<c:forEach items="${productList}" var="prod">
							<form action="addToCart" method="post" modelAttribute="productCart" name="addToCartForm">
								<tr class="product">
									<td class="product">${prod.productName}</td>
									<td class="product">${prod.productCategory}</td>
									<td class="product">${prod.productPrice}</td>
									<td class="product">${prod.productQuantity}</td>
									
									<input path="userId" name="userId" type="hidden" value="${user}">
									<input path="productId" name="productId" type="hidden" value="${prod.productId}">
									<td class="product"><input type="submit" value="add to cart"></td>
								    <%-- <td><input type="text" name="user" value="${user}"></td> --%>
									<!--	<td><input type="hidden" name="bt" value="add to cart"
																	onclick="{document.addToCartForm.product=${prod};document.routeForm.submit();}" /></td> -->
								</tr>
	
							</form>
						</c:forEach>
	
						<tr>
							<td style="margin-top: 20px; padding-top: 20px;"><a href="/training/viewCart/${user}">View Cart</a>
							<td></td>
							<td></td>
							<td></td>
							<td style="margin-top: 20px; padding-top: 20px;"><a href="/training/viewOrders/${user}">View Orders</a></td>
						</tr>
	
					</table>



				</div>

				

			</body>

			</html>