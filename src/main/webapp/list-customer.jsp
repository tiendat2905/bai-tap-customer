<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer manage</title>

    <style>
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        th,td{
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h2>Customer</h2>
<p><a href="${pageContext.request.contextPath}/addCustomer">Create Customer</a></p>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="customer" items='${requestScope["customer"]}'>
        <tr>
            <td>${customer.fullname}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href='${pageContext.request.contextPath}/editCustomer?id=${customer.id}'>Edit</a></td>
            <td><a href='${pageContext.request.contextPath}/deleteCustomer?id=${customer.id}'>Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
