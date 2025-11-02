<%-- 
    Document   : adminHome
    Created on : Oct 28, 2025, 2:26:10 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trang quản trị</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        .admin-container {
            max-width: 600px;
            margin: auto;
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        .menu {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        .menu a {
            display: block;
            padding: 12px;
            background-color: #007bff;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
        }
        .menu a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="admin-container">
    <h2>Chào mừng quản trị viên</h2>

    <div class="menu">
        <a href="${pageContext.request.contextPath}/adminCarServlet">Quản lý xe</a>
        <a href="${pageContext.request.contextPath}/userManagement.jsp">Quản lý người dùng</a>
        <a href="${pageContext.request.contextPath}/logoutServlet">Đăng xuất</a>
    </div>
</div>

</body>
</html>
