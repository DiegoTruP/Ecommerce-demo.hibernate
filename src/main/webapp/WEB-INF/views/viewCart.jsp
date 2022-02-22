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
      width: 80%;
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
    
    <table class="tableContainer">
    <tr class="top">
    	<th>Product name</th>
    	<th>Product category</th>
    	<th>Price</th>
    	<th>Quantity</th>
    	<th>Total</th>
    </tr>

    
    <c:forEach items="${cart}" var="prod">
<!--     <form action="addToCart" method="post" modelAttribute="productCart" name="addToCartForm"> -->
    	<tr class="product">
    		<td class="product">${prod.productName}</td>
    		<td class="product">${prod.productCategory}</td>
    		<td class="product">${prod.productPrice}</td>
    		<td class="product">${prod.productQuantity}</td>
    		<td class="product">${prod.productQuantity * prod.productPrice}</td>

    	</tr>
    	
<!--     </form> -->
    </c:forEach>
    
      <tfoot>
        <tr>
        	<td></td>
        	<td></td>
        	<td></td>
        	<td></td>
            <td style="border-top:2px solid; text-align:center;">${total}</td>
        </tr>
        
        <tr>
    		<td style="margin:auto; padding-top: 20px;">
    		<form action=/training/orderBack method="get">
    			<input type="hidden" name="userId" value="${user}">
    			<input type="submit"  value="Keep buying">
    		</form></td>
    		<td></td>
    		<td></td>
    		<td></td>
<%--     		<td>${user}</td> --%>
    		<td style="margin:auto; padding-top: 20px; text-align:center;">
    		<form action="/training/buy" method="get">
					<input type="hidden" name="userId" value="${user}">
					<input type="submit" value="Buy"  style="width:75px; margin:auto;">
				</form>
    		
    		</td>
    		
<%--     		<td><a href="/viewCart?userId=${userId}">View Cart</a> --%>
    	</tr>
    

    </tfoot>
    

    </table>

</body>
</html>