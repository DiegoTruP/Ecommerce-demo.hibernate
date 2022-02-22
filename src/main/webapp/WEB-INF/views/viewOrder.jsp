<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<h3>Order ID: ${order.getOrderId()}</h3>
<h3>Date: ${order.getDate()}</h3>


 <table class="tableContainer">
    <tr class="top">
    	<th>Product name</th>
    	<th>Product category</th>
    	<th>Price</th>
    	<th>Quantity</th>
    	<th>Total</th>
    </tr>

    
    <c:forEach items="${orderList}" var="prod">
 
    	<tr class="product">
    		<td class="product">${prod.productName}</td>
    		<td class="product">${prod.productCategory}</td>
    		<td class="product">${prod.productPrice}</td>
    		<td class="product">${prod.productQuantity}</td>
    		<td class="product">$${prod.productQuantity * prod.productPrice}</td>
    	</tr>
    	

    </c:forEach>
    
<!--       <tfoot>  </tfoot> -->
        <tr>
        	<td></td>
        	<td></td>
        	<td></td>
        	<td></td>
            <td style="border-top:2px solid; text-align:center;" >$${order.getTotal()}</td>
        </tr>
        
        <tr>
<%--     		<td><form action=/training/back method="get" modelAttribute="user"> --%>
<!--     		<input type="hidden" path="user" value=${user}> -->
<%--     		<input type="submit"  value="Keep buying"></form></td> --%>
    		<td>
    		<form action=/training/orderBack method="get">
    			<input type="hidden" name="userId" value="${userId}">
    			<input type="submit"  value="Keep buying">
    		</form></td>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td>
    		</td>
    		
<%--     		<td><a href="/viewCart?userId=${userId}">View Cart</a> --%>
    	</tr>
    

   
    

    </table>

</body>
</html>