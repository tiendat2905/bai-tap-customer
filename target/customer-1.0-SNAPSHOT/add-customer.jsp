<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2/2/2021
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Customer</title>

    <style>
        .message{
            color: green;
        }
    </style>
</head>
<body>
<h2>Add Customer</h2>
<p>
    <a href="<c:url value="/"/>">List Customer</a>
    <br>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>

</p>
<form action="addCustomer" method="post">
    <label>Fullname</label><br>
    <input type="text" name="fullname" value="${customer.fullname}"><br>
    <label>Email</label><br>
    <input type="text" name="email" value="${customer.email}"><br>
    <label>Address</label><br>
    <input type="text" name="address" value="${customer.address}"><br>
    <input type="reset" name="Reset" value="Reset">
    <input type="submit" name="Submit" value="Submit"><br>
</form>
</body>
</html>
