<%--
  Created by IntelliJ IDEA.
  User: lyngo
  Date: 04/12/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<html>
<head>
    <title>Khứa</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/index.jsp">Nét Cỏ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/users">Customers <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/computers">Computers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/products">Services</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
            </li>
        </ul>
    </div>
</nav>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">Rows</th>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">Money</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSachKhach}" var="khach" varStatus="loopStatus">
        <tr>
            <th scope="row">${loopStatus.index + 1}</th>
            <td>${khach.id}</td>
            <td>${khach.name}</td>
            <td>${khach.username}</td>
            <td>${khach.password}</td>
            <td>${khach.money}</td>
            <td><a href="/users?action=edit&id=${khach.id}">Edit</a></td>
            <td><a href="/users?action=delete&id=${khach.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" class="btn btn-primary" style="color: white"><a href="/users?action=create">ADD NEW   </a></button>
</body>
</html>
