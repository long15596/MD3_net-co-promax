<%--
  Created by IntelliJ IDEA.
  User: lyngo
  Date: 04/12/2023
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
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
<form method="post">
    <div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="id">ID</span>
            </div>
            <input type="number" class="form-control" placeholder="Id" aria-label="Username" aria-describedby="addon-wrapping" name="id">
        </div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="name">Name</span>
            </div>
            <input type="text" class="form-control" placeholder="Name" aria-label="Username" aria-describedby="addon-wrapping" name="name">
        </div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="price">Price</span>
            </div>
            <input type="number" class="form-control" placeholder="Price" aria-label="Username" aria-describedby="addon-wrapping" name="price">
        </div>
        <button class="btn btn-primary" style="margin-top: 10px; color: white">ADD NEW</button>
    </div>
</form>
</body>
</html>
